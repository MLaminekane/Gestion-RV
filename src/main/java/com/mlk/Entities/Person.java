package com.mlk.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Person {
    protected int id;
    protected String nomComplet;
    protected static int nbr;
    public Person (int id, String nomComplet){
        this.id = id;
        this.nomComplet = nomComplet;
    }
    public Person(String nomComplet ){
        this.nomComplet = nomComplet;
    }
    public String getNomComplet() {
        return nomComplet;
    }

    public int getId() {
        return id;
    }
}
