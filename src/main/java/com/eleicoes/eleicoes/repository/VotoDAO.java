package com.eleicoes.eleicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eleicoes.eleicoes.model.Voto;

public interface VotoDAO extends JpaRepository<Voto, Long> {

}
