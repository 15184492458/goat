package com.goat.api.designpattern.behavioralmodel.templatemodel.spring;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementCallBack {

    Object doInStatement(Statement statement) throws SQLException;
}
