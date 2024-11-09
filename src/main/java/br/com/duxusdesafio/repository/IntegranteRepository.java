package br.com.duxusdesafio.repository;

import br.com.duxusdesafio.model.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

    @Query(value = "SELECT i "
            + "FROM Integrante i "
            + "WHERE i.nome like '%:nome%'")
    Integrante findByNome(@Param("nome") String nome);




}
