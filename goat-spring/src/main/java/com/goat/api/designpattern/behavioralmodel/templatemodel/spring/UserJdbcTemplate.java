package com.goat.api.designpattern.behavioralmodel.templatemodel.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcTemplate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Object query(String sql) throws SQLException {
        class QueryStatementCallBack implements StatementCallBack{
            @Override
            public Object doInStatement(Statement statement) throws SQLException {
                ResultSet result = statement.executeQuery(sql);
                List<User> list = new ArrayList<>();
                while (result.next()){
                    User user = new User();
                    user.setName(result.getString("name"));
                    user.setAge(result.getString("age"));
                    list.add(user);
                }
                return list;
            }
        }
        return jdbcTemplate.query(new QueryStatementCallBack());
    }
}
