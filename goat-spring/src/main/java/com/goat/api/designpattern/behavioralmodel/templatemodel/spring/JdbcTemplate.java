package com.goat.api.designpattern.behavioralmodel.templatemodel.spring;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring中的模板方法和callback结合使用
 */
public abstract class JdbcTemplate {
    Connection connection = null;

    Statement  statement = null;

    ResultSet resultSet = null;

    private Object result;

    public Object query(StatementCallBack action){
        return execute(action);
    }

    public final Object execute(StatementCallBack action) {
        try {
            connection = getConnection();
            statement = (PreparedStatement) connection.createStatement();
            result = action.doInStatement(statement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource();
        }
        return result;
    }

    private void releaseResource(){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
