package com.eleicoes.eleicoes.model;

import javax.persistence.*;

@Entity
@Table(name = "votos")
public class Voto {
    @Id
    @Column(name = "vot_id")
    private int id;

    @Column(name = "vot_total")
    private int total;

    @ManyToOne
    @JoinColumn(name = "ca_id", referencedColumnName = "ca_id")
    Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "ele_id", referencedColumnName = "ele_id")
    Eleicao eleicao;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Eleicao getEleicao() {
        return eleicao;
    }

    public void setEleicao(Eleicao eleicao) {
        this.eleicao = eleicao;
    }

    // não pode fazer os gets e sets das colunas chaves estrangeiras
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
