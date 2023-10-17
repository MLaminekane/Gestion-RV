package com.mlk.Repository.Core;

import com.mlk.Entities.Person;
import com.mlk.Repository.Bdd.impl.MysqlRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface Database {
    void openConnection();
    void closeConnexion();
    ResultSet executeSelect(String sql);
    int executeUpdate(String sql);
    PreparedStatement getPs();
    PreparedStatement getPs(String sql);
    <T extends Person> MysqlRepo<T> getConnection();

}
