package com.mlk.Repository.Repo.cls;

import com.mlk.Entities.Person;
import com.mlk.Repository.Repo.Repository;

import java.util.ArrayList;

public class Table<T extends Person> implements Repository<T> {
    private  ArrayList<T> tables = new ArrayList<>();

    @Override
    public int insert(T data) {
        tables.add(data);
        return 1;
    }

    @Override
    public int update(T data) {
        int pos=indexOf(data.getId());
        if(pos!=-1){
            tables.set(pos, data) ;
            return 1;
        }
        return 0;
    }

    @Override
    public ArrayList<T> findAll() {return tables;}

    @Override
    public T findByID(int id) {
        int pos = indexOf(id);
        if (pos != -1) {
            return tables.get(pos);
        }
        return null;
    }

    @Override
    public int delete(int id) {
        int pos = indexOf(id);
        if (pos != -1) {
            tables.remove(pos);
            return 1;
        }
        return 0;
    }


    @Override
    public int indexOf(int id) {
        int pos=0;
        for (T cat : tables) {
            if(cat.getId()==id){
                return pos;
            }
            pos++;
        }
        return -1;
    }
}
