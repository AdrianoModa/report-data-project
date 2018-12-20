package com.report.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.report.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	List<Venda> findByData(Calendar data);
	
	@Query("FROM Venda v WHERE v.dia = ?1")
	List<Venda> findByDay(int dia);
	
	@Query("FROM Venda v WHERE v.mes = ?1")
	List<Venda> findByMouth(int mes);
	
	@Query("FROM Venda v WHERE v.ano = ?1")
	List<Venda> findByYear(int ano);

}
