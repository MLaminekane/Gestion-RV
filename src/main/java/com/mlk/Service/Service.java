package com.mlk.Service;

import java.util.ArrayList;

public interface Service<M> {
    int  add(M data);
    ArrayList<M> getAll();
    int update(M data);
    M show(int id);
    int remove(int id);
    int[] remove(int[] ids);
}
