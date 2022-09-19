package com.eleicoes.eleicoes.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "eleicao")
public class Eleicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ele_id")
    private int id;

    @Column(name = "ele_tipo")
    private String tipo;

    @Column(name = "ele_ano")
    private int ano;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @OneToMany(mappedBy = "eleicao")
    private List<Voto> votos;

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}
