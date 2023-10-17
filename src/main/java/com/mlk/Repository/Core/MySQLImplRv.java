package com.mlk.Repository.Core;

import com.mlk.Entities.Person;
import com.mlk.Entities.RendezVous;
import com.mlk.Repository.Bdd.impl.MysqlRepo;
import com.mlk.Service.RvRepository;

import java.sql.*;
import java.util.ArrayList;

public class MySQLImplRv implements RvRepository, Database {
    private final String TABLE_NAME = "rendezvous";
    private final String SQL_INSERT = "INSERT INTO"+ TABLE_NAME +" (`id`, `DateRendezVous`, `statut`, `idMed`, `idPat`) VALUES (NULL, NULL, NULL, '', '')\n";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/gestion_rv";
    private final String user = "root";
    private final String password = "root";
    private Connection conn = null;
    private PreparedStatement ps;

    @Override
    public int insert(RendezVous data) {
        openConnection();
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " (idPatient, idMedecin, date, heure, statut) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = getPs();
            ps.setInt(1, data.getIdPatient());
            ps.setInt(2, data.getIdMedecin());
            ps.setDate(3, new java.sql.Date(data.getDateRendezVous().getTime()));
            ps.setTime(4, new java.sql.Time(data.getHeureRendezVous().getTime()));
            ps.setString(5, data.getStatut());

            int rowCount = ps.executeUpdate();
            ps.close();
            closeConnexion();

            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

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
    public PreparedStatement getPs(String sql) {
        return null;
    }

    @Override
    public <T extends Person> MysqlRepo<T> getConnection() {
        return null;
    }

    public void openConnection() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.printf("Erreur de chargement de driver %s", MySQLImplPatient.class);
        }
    }

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
        return null;
    }

    @Override
    public int executeUpdate(String sql) {
        return 0;
    }
    @Override
    public ArrayList<RendezVous> getAll() {
        return new ArrayList<>();
    }
    @Override
    public int update(RendezVous data) {
        return 0;
    }
    @Override
    public RendezVous show(int id) {
        return null;
    }
    @Override
    public int remove(int id) {
        return 0;
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }

}
