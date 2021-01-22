package com.goat.api.designpattern.behavioralmodel.templatemodel.spring;

import java.sql.SQLException;

public class TestClass {

    public static void main(String[] args) {
        UserJdbcTemplate userJdbcTemplate = new UserJdbcTemplate();
        try {
            User user = (User)userJdbcTemplate.query("select * from user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
