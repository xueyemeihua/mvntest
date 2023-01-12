package cn.ly.mvntest.pojo;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-18:09
 */
public class Tuser {
    private int tid;
    private String tname;
    private String tpwd;
    private String tphone;
    private int tage;

    public Tuser() {
    }

    public Tuser(String tname, String tpwd, String tphone, int tage) {
        this.tname = tname;
        this.tpwd = tpwd;
        this.tphone = tphone;
        this.tage = tage;
    }

    public Tuser(int tid, String tname, String tpwd, String tphone, int tage) {
        this.tid = tid;
        this.tname = tname;
        this.tpwd = tpwd;
        this.tphone = tphone;
        this.tage = tage;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    @Override
    public String toString() {
        return "Test{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tpwd='" + tpwd + '\'' +
                ", tphone='" + tphone + '\'' +
                ", tage=" + tage +
                '}';
    }
}
