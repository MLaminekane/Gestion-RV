package com.mlk.Repository.Bdd.impl;

import com.mlk.Entities.Medecin;
import com.mlk.Repository.Bdd.MedecinRepository;
import com.mlk.Repository.Core.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedecinRepoImpl extends BaseRepoImpl<Medecin> implements MedecinRepository {
    public MedecinRepoImpl(Database database) {
        super(database, "person");
    }

    @Override
    protected void setAdditionalParameters(PreparedStatement ps, Medecin data) {
        try {
            ps.setString(2, data.getSpecialite());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
