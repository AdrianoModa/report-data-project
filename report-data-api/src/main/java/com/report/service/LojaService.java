package com.report.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.model.Loja;
import com.report.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public List<Loja> listarTodos(){
		return lojaRepository.findAll();
	}
	
	public List<Long> quantidadeDeLojas(String nome) {
		return lojaRepository.countByNome(nome);
	}
	
	public Loja adicionar(Loja loja) {
		return lojaRepository.save(loja);
	}
	
	public Loja atualizar(Loja loja) {
		Loja lojaExistente = lojaRepository.save(loja);
		return lojaExistente;
	}
	
	public Loja listarPorId(Long id) {
		return lojaRepository.findOne(id);
	}
	
	public void remover(Long id) {
		Loja lojaExistente = lojaRepository.findOne(id);
		Optional.ofNullable(lojaExistente)
		.orElseThrow(() -> new EntityExistsException("Objeto não encontrado"));
		lojaRepository.delete(lojaExistente);
	}
}