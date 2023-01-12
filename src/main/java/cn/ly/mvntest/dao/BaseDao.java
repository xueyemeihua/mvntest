package cn.ly.mvntest.dao;

import cn.ly.mvntest.util.Constants;
import cn.ly.mvntest.util.XmlUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet resultSet;
    private Class<T> clazz;

    public BaseDao() {
        ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pType.getActualTypeArguments()[0];
        System.out.println(clazz);
    }

    //获取的一个T对象
    public T getOne(String sql,Object... params) {
        ResultSet rs = executeQuery(sql, params);
        T t = null;
        //封装结果成T对象
        try {
            //获得结果集的元数据对象
            ResultSetMetaData metaData = rs.getMetaData();
            //获得结果的列数
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                //反射创建对象
                t = (T)clazz.newInstance();
                //遍历每一列
                for (int i = 0; i < columnCount; i++) {
                    Object colVal = rs.getObject(i + 1);
                    //使用反射设置属性值
                    //还需要知道该列的列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //通过反射设置属性
                    Field field = clazz.getDeclaredField(columnLabel);
                    //打开权限
                    field.setAccessible(true);
                    field.set(t,colVal);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return t;
    }

    public List<T> getAll(String sql,Object... params) {
        ResultSet rs = executeQuery(sql, params);
        T t = null;
        List<T> list = new ArrayList<T>();
        //封装结果成T对象并存入集合
        try {
            //获得结果集的元数据对象
            ResultSetMetaData metaData = rs.getMetaData();
            //获得结果的列数
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                //反射创建对象
                t = clazz.newInstance();
                //遍历每一列
                for (int i = 0; i < columnCount; i++) {
                    Object colVal = rs.getObject(i + 1);
                    //使用反射设置属性值
                    //还需要知道该列的列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //通过反射设置属性
                    Field field = clazz.getDeclaredField(columnLabel);
                    //打开权限
                    field.setAccessible(true);
                    field.set(t,colVal);
                }
                list.add(t);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    //通用查询
    public ResultSet executeQuery(String sql,Object... params){
        try {
            getConnection();
            //创建statement
            //预编译sql语句 固定sql语句的结构
            ps = connection.prepareStatement(sql);
            //设置参数
            //设置参数
            if(params!=null){
                for (int i = 0; i <params.length ; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            //执行sql语句并获得查询结果
            resultSet = ps.executeQuery();

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //通用增删改
    //sql 要执行的sql语句
    //对应的sql语句的参数 Object... params
    //params可以填0个或者多个
    public int executeUpdate(String sql,Object... params){

        int re = -1;
        try {
            //获得连接
            getConnection();
            //创建statement
            ps = connection.prepareStatement(sql);
            //设置参数
            if(params!=null){
                for (int i = 0; i <params.length ; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }

            //增删改操作
            //re 返回值 是影响的行数
            re = ps.executeUpdate();
            System.out.println("影响的行数:"+re);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }

        return re;
    }

    //获得连接
    public void getConnection(){
        //加载驱动
        try {
            Class.forName(XmlUtil.dataSourceMap.get(Constants.DRIVER));
            //获得连接
            connection = DriverManager.getConnection(XmlUtil.dataSourceMap.get(Constants.URL),
                    XmlUtil.dataSourceMap.get(Constants.NAME), XmlUtil.dataSourceMap.get(Constants.PASSWORD));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //关闭连接
    public void closeAll(){
        try {
            //后开的先关
            if(resultSet!=null)
                resultSet.close();
            if(ps!=null)
                ps.close();
            if(connection!=null)
                connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
