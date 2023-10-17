package com.mlk.Repository.Core;

import com.mlk.Entities.Person;
import com.mlk.Repository.Bdd.impl.MysqlRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseImpl implements Database {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/gestion_rv";
    private final String user = "root";
    private final String password = "root";
    private Connection conn = null;


    @Override
    public void openConnection() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.printf("Erreur de chargement de driver %s", MySQLImplPatient.class);
        }
    }

    @Override
    public void closeConnexion() {

    }
    @Override
    public ResultSet executeSelect(String sql) {
        return null;
    }

    @Override
    public int executeUpdate(String sql) {
        return 0;
    }

    @Override
    public PreparedStatement getPs() {
        return null;
    }
    @Override
    public PreparedStatement getPs(String sql) {
        try {
            if (conn != null) {
                return conn.prepareStatement(sql);
            } else {
                throw new SQLException("La connexion à la base de données n'est pas établie.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public <T extends Person> MysqlRepo<T> getConnection() {
        return null;
    }
}



