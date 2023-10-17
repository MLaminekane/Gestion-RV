package com.mlk.Service;

import com.mlk.Entities.RendezVous;

import java.util.ArrayList;

public class RvServiceImpl implements RvService {
    private RvRepository rvRepository;

    public RvServiceImpl(RvRepository rvRepository) {
        this.rvRepository = rvRepository;
    }

    @Override
    public int add(RendezVous data) {
        return rvRepository.insert(data);
    }

    @Override
    public int add(Object data) {
        return 0;
    }

    @Override
    public ArrayList<RendezVous> getAll() {
        return rvRepository.getAll();
    }

    @Override
    public int update(Object data) {
        return 0;
    }


    @Override
    public RendezVous show(int id) {
        return rvRepository.show(id);
    }

    @Override
    public int remove(int id) {
        return rvRepository.remove(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return rvRepository.remove(ids);
    }
}
