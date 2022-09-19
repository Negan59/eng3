package com.eleicoes.eleicoes.repository;

import com.eleicoes.eleicoes.model.Partido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PartidoDAO extends JpaRepository<Partido, Long> {
    @Query(value="SELECT * FROM partido p WHERE p.par_nome LIKE %:filtro%",nativeQuery=true)
    List <Partido> findWithFilter(@Param("filtro") String filtro);
}
