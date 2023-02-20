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
}
