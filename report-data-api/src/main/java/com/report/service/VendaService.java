package com.report.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.model.Venda;
import com.report.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public List<Venda> listarTodos(){
		return vendaRepository.findAll();
	}
	
	public List<Venda> listarLojasPorNome(String nome){
		return vendaRepository.findByNome(nome);
	}

	public List<Venda> listarPorData(LocalDate data){
		return vendaRepository.findByData(data);
	}

	public List<Venda> listarPorDia(int dia){
		return vendaRepository.findByDay(dia);
	}

	public List<Venda> listarPorMes(int mes){
		return vendaRepository.findByMonth(mes);
	}

	public List<Venda> listarPorAno(int ano){
		return vendaRepository.findByYear(ano);
	}
	
	public List<Venda> listarDataInicialEDataFinal(LocalDate dataInicio, LocalDate dataFinal){		
		return vendaRepository.findByDataStartAndDateEnd(dataInicio, dataFinal);
	}
	
	public Venda adicionar(Venda venda) {
		venda.setDia(venda.getData().getDayOfMonth());
		venda.setMes(venda.getData().getMonthValue());
		venda.setAno(venda.getData().getYear());
		return vendaRepository.save(venda);
	}

	public Venda atualizar(Venda venda) {
		Venda vendaExistente = vendaRepository.save(venda);
		return vendaExistente;
	}

	public Venda listarPorId(Long id) {
		return vendaRepository.findOne(id);
	}

	public void remover(Long id) {
		Venda vendaExistente = vendaRepository.findOne(id);
		Optional.ofNullable(vendaExistente)
		.orElseThrow(() -> new EntityExistsException("Objeto não encontrado"));
		vendaRepository.delete(vendaExistente);
	}




}
