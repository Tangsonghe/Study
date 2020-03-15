package com.gp.adapters.passport.third.model;

import lombok.Data;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 21:51
 */
@Data
public class User {
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
