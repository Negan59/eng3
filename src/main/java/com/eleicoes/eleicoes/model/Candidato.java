package com.eleicoes.eleicoes.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue
    @Column(name = "ca_id")
    private Long id;

    @Column(name = "ca_numero")
    private int numero;

    @Column(name = "ca_nome")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToOne
    @JoinColumn(name = "par_id", nullable = false)
    private Partido partido;

    @OneToMany(mappedBy = "candidato")
    private List<Cargo> cargos;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Candidato(Long id, int numero, String nome, Partido partido) {
        super();
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.partido = partido;
    }

    public Candidato() {
        this(0L, 0, "", null);
    }

    // gets e sets omitidos
}
