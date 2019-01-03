package com.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.report.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
	
	List<Long> countByNome(String nome);

}
