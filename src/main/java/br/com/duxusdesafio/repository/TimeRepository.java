package br.com.duxusdesafio.repository;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {


    @Query("SELECT i " +
            " FROM Time i " +
            " WHERE i.data = :data")
    Time findByData(@Param("data") LocalDate data);


}
