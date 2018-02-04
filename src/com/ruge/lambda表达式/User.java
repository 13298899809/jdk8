package com.ruge.lambda表达式;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/4
 * \* Time: 19:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 用户实体类
 * \
 */
public class User {
    private String name;
    private String age;
    private String sale;

    public User() {
    }

    public User(String name, String age, String sale) {
        this.name = name;
        this.age = age;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}