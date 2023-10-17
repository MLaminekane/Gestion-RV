package com.mlk.Repository.Bdd.impl;

import com.mlk.Entities.Person;
import com.mlk.Repository.Core.Database;
import com.mlk.Repository.Repo.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseRepoImpl<T extends Person> implements Repository<T> {
    private Database database;
    private String tableName;

    public BaseRepoImpl(Database database, String tableName) {
        this.database = database;
        this.tableName = tableName;
    }
    @Override
    public int insert(T data) {
        int nbrLigne = 0;
        try {
            database.openConnection();
            PreparedStatement ps = database.getPs();
            ps.setString(1, data.getNomComplet());
            setAdditionalParameters(ps, data);
            nbrLigne = ps.executeUpdate();
            ps.close();
            database.closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbrLigne;
    }
    protected void setAdditionalParameters(PreparedStatement ps, T data) {

    }

    @Override
    public int update(T data) {
        return 0;
    }

    @Override
    public ArrayList<T> findAll() {
        return null;
    }

    @Override
    public T findByID(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int indexOf(int id) {
        return 0;
    }
}