package com.mlk.Service;

import com.mlk.Entities.RendezVous;

import java.util.ArrayList;

public interface RvRepository {
    int insert(RendezVous data);
    int update(RendezVous data);
    ArrayList<RendezVous> getAll();
    RendezVous show(int id);
    int remove(int id);
    int[] remove(int[] ids);
}
