package com.mlk.Service;

import com.mlk.Entities.Patient;
import com.mlk.Entities.Person;
import com.mlk.Repository.Repo.Repository;

import java.util.ArrayList;

public class PersonServiceImpl implements PersonService {
    private Repository<Patient> patientRepository;
    public PersonServiceImpl(Repository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public int add(Patient data) {
        return patientRepository.insert(data);
    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public int update(Patient data) {
        return patientRepository.update(data);
    }

    @Override
    public Patient show(int id) {
        return patientRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return patientRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int n=0;
        for (int id = 0; id < ids.length; id++) {
            if (patientRepository.delete(id)==0) {
                idsNotDelete[n++]=id;

            }
        }
        return idsNotDelete;
    }


}
