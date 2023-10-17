package com.mlk.Service;

import com.mlk.Entities.RendezVous;
import com.mlk.Repository.Core.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RvRepoImpl implements RvRepository {
    private Database database;

    public RvRepoImpl(Database database) {
        this.database = database;
    }

    @Override
    public int insert(RendezVous data) {
        int nbrLigne = 0;
        try {
            database.openConnection();
            String sql = "INSERT INTO rendezvous (idPatient, idMedecin, dateRendezVous, statut) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = database.getPs(sql);
            ps.setInt(1, data.getIdPatient());
            ps.setInt(2, data.getIdMedecin());
            ps.setDate(3, new java.sql.Date(data.getDateRendezVous().getTime()));
            ps.setString(4, data.getStatut());
            nbrLigne = ps.executeUpdate();
            ps.close();
            database.closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbrLigne;
    }

    @Override
    public int update(RendezVous data) {
        return 0;
    }

    @Override
    public ArrayList<RendezVous> getAll() {
        return null;
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
