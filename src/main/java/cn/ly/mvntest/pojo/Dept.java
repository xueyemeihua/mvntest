package cn.ly.mvntest.pojo;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-16:29
 */
public class Dept {
    private int deptno;
    private String dname;
    private String dlocation;

    public Dept() {
    }

    public Dept(int deptno, String dname, String dlocation) {
        this.deptno = deptno;
        this.dname = dname;
        this.dlocation = dlocation;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDlocation() {
        return dlocation;
    }

    public void setDlocation(String dlocation) {
        this.dlocation = dlocation;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dlocation='" + dlocation + '\'' +
                '}';
    }
}
