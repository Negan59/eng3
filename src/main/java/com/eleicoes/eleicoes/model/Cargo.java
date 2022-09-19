package com.eleicoes.eleicoes.model;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private int id;

    @Column(name = "car_descr")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ca_id")
    private Candidato candidato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}