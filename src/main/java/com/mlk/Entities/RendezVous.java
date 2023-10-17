package com.mlk.Entities;
import lombok.*;

import java.sql.ResultSet;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class RendezVous {
    private int id;
    private int idPatient;
    private int idMedecin;
    private Date dateRendezVous;
    private Date heureRendezVous;
    private String statut;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }
    public Date getHeureRendezVous() {
        return heureRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


}
