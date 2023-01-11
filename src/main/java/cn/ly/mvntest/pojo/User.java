package cn.ly.mvntest.pojo;

public class User {
    private Integer uid;
    private String username;
    private String pwd;
    private String uname;
    private Integer age;
    private String address;
    private String phone;

    public User() {
    }

    public User(Integer uid, String username, String pwd, String uname, Integer age, String address, String phone) {
        this.uid = uid;
        this.username = username;
        this.pwd = pwd;
        this.uname = uname;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
