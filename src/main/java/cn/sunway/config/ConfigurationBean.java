package cn.sunway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 通过ConfigurationProperties 绑定属性
 * @author sunw
 * @date 2023/2/16
 */
@ConfigurationProperties(prefix = "cn.sunway.config")
@Configuration
@Validated
public class ConfigurationBean {
    @NotBlank(message = "name不能为空")
    private String name;
    @NotNull(message = "age不能为空")
    private Integer age;
    private List<String> habits;
    private Map<String, Float> scores;

    @Override
    public String toString() {
        return "ConfigurationBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", habits=" + habits +
                ", scores=" + scores +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHabits() {
        return habits;
    }

    public void setHabits(List<String> habits) {
        this.habits = habits;
    }

    public Map<String, Float> getScores() {
        return scores;
    }

    public void setScores(Map<String, Float> scores) {
        this.scores = scores;
    }
}
