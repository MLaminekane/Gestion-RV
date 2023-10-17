package com.mlk.Repository.Bdd.impl;

import com.mlk.Entities.Patient;
import com.mlk.Repository.Bdd.PatientRepository;
import com.mlk.Repository.Core.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientRepoImpl extends BaseRepoImpl<Patient> implements PatientRepository {
    public PatientRepoImpl(Database database) {
        super(database, "person");
    }

    @Override
    protected void setAdditionalParameters(PreparedStatement ps, Patient data) {
        try {
            String antecedentString = String.join(", ", data.getAntecedents());
            ps.setString(2, antecedentString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}