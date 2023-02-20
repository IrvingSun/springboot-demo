package cn.sunway.bean;

/**
 * @author sunw
 * @date 2023/2/20
 */
public class User {
    private String username;
    private Integer age;
    private String desc;

    public User() {
        this.username = "测试用户";
        this.age = 10;
        this.desc = "测试描述";
    }

    @Override
    public String toString() {
        return "[" + username + "," + age
                + "," + desc + "]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
