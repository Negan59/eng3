package com.eleicoes.eleicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eleicoes.eleicoes.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM usuario u WHERE u.usu_login LIKE %:filtro%", nativeQuery = true)
    List<Usuario> findWithFilter(@Param("filtro") String filtro);
}
