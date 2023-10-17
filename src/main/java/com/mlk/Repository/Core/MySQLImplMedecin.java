package com.mlk.Repository.Core;

import java.sql.*;

public class MySQLImplMedecin extends DatabaseImpl {
    private final String TABLE_NAME = "person";
    private final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " (nomComplet, type, specialite, antecedent) VALUES (?, 'medecin', ?, NULL)";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/gestion_rv";
    private final String user = "root";
    private final String password = "root";
    private Connection conn = null;
    private PreparedStatement ps;
    @Override
    public PreparedStatement getPs() {
        try {
            if (conn != null) {
                return conn.prepareStatement(SQL_INSERT);
            } else {
                throw new SQLException("La connexion à la base de données n'est pas établie.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

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
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur de Fermeture de connexion");
            }
        }
    }

    @Override
    public ResultSet executeSelect(String sql) {
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Erreur de execution request");
        }
        return rs;
    }

    @Override
    public int executeUpdate(String sql) {
        int nbrLigne=0; try {
            ps=conn.prepareStatement(sql);
            nbrLigne=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur de execution request");
        }
        return nbrLigne;
    }
}

