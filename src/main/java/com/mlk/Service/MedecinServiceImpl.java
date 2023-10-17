package com.mlk.Service;

import com.mlk.Entities.Medecin;
import com.mlk.Repository.Bdd.MedecinRepository;
import com.mlk.Repository.Repo.Repository;
import java.util.ArrayList;

public class MedecinServiceImpl implements MedecinService {
    private Repository<Medecin> medecinRepository;

    public MedecinServiceImpl(Repository<Medecin> medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public int add(Medecin data) {
        return medecinRepository.insert(data);
    }

    @Override
    public ArrayList<Medecin> getAll() {
        return medecinRepository.findAll();
    }

    @Override
    public int update(Medecin data) {
        return medecinRepository.update(data);
    }

    @Override
    public Medecin show(int id) {
        return medecinRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return medecinRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete = new int[ids.length];
        int n = 0;
        for (int id : ids) {
            if (medecinRepository.delete(id) == 0) {
                idsNotDelete[n++] = id;
            }
        }
        return idsNotDelete;
    }
}
