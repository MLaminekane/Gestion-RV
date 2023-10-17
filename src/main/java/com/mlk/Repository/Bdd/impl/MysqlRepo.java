package com.mlk.Repository.Bdd.impl;

import com.mlk.Entities.Person;
import com.mlk.Repository.Repo.Repository;

import java.sql.*;

public abstract class MysqlRepo<T extends Person> implements Repository {
    private Connection conn;
    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_rv", "root", "root");
        return conn;
    }
    protected PreparedStatement prepareStatement(Connection conn, String sql, Object... params) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }


    protected int executeUpdate(Connection conn, PreparedStatement statement) throws SQLException {
        return statement.executeUpdate();
    }
    protected void closeConnection(Connection conn, PreparedStatement statement) throws SQLException{
        conn.close();
        statement.close();
    }
    protected void closeConnection(Connection conn, PreparedStatement statement, ResultSet resultSet) throws SQLException{
        conn.close();
        statement.close();
        resultSet.close();
    }

}
