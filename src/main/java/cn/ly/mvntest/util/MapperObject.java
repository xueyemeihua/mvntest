package cn.ly.mvntest.util;

//对应mapper.xml中的一个mapper元素
public class MapperObject {
    private String id;
    private String returnType;
    private String sql;

    public MapperObject(String id, String returnType, String sql) {
        this.id = id;
        this.returnType = returnType;
        this.sql = sql;
    }

    public MapperObject() {
    }

    @Override
    public String toString() {
        return "MapperObject{" +
                "id='" + id + '\'' +
                ", returnType='" + returnType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
