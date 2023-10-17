package com.mlk.Repository.Repo;

import com.mlk.Entities.Person;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public interface Repository<T extends Person> {
    int insert(T data);

    int update(T data);

    ArrayList<T> findAll();

    T findByID (int id);

    int delete (int id);

    int indexOf (int id);

}
