package com.mlk.Entities;
import lombok.*;
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Medecin extends Person{
    private String type;
    private String specialite ;
    public Medecin(int id, String nomComplet) {
        super(id, nomComplet);
    }
    public Medecin(String nomComplet, String type, String specialite) {
        super(nomComplet);
        this.type = "Medecin";
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }
}
