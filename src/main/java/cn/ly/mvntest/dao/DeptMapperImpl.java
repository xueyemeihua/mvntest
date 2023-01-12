package cn.ly.mvntest.dao;

import cn.ly.mvntest.mapper.DeptMapper;
import cn.ly.mvntest.pojo.Dept;
import cn.ly.mvntest.util.XmlUtil;

import java.util.List;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-16:31
 */
public class DeptMapperImpl extends BaseDao<Dept> implements DeptMapper {
    @Override
    public Dept getDeptByDeptno(int deptno) {
        return super.getOne(XmlUtil.mapperMap.get("deptMapper.getDeptByDeptno").getSql(),deptno);
    }

    @Override
    public List<Dept> getDepts() {
        return getAll(XmlUtil.mapperMap.get("deptMapper.getDepts").getSql());
    }

}
