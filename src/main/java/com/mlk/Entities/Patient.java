package com.mlk.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Patient extends Person {
    private List<String> antecedent;
    private String type;

    public Patient(String nomComplet) {
        super(nomComplet);
        antecedent = new ArrayList<>();
    }

    public Patient(String nomComplet, List<String> antecedents, String type) {
        super(nomComplet);
        this.antecedent = antecedents;
    }


    public List<String> getAntecedents() {
        return antecedent;
    }

    public void setAntecedents(List<String> antecedent) {
        this.antecedent = antecedent;
    }

    public Patient(String nomComplet, String type) {
        super(nomComplet);
        this.type = type;
        antecedent = new ArrayList<>();
    }

    public String getType() {
        return type;
    }
}
