package com.report.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.model.Loja;
import com.report.service.LojaService;

@RestController
@RequestMapping("/loja")
@CrossOrigin("${origem-permitida}")
public class LojaController {
	
	@Autowired
	private LojaService lojaService;
	
	@GetMapping
	public List<Loja> listar(){
		return lojaService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Loja loja = lojaService.listarPorId(id);
		return ResponseEntity.ok(loja);
	}
	
	@GetMapping("/{nome}")
	public List<Long> numeroDeLojas(@PathVariable String nome) {		
		return lojaService.quantidadeDeLojas(nome);
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@Valid @RequestBody Loja loja){
		lojaService.adicionar(loja);
		return new ResponseEntity<Loja>(loja, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, Loja loja){
		loja.setId(id);
		Loja lojaExistente = lojaService.atualizar(loja);
		return new ResponseEntity<Loja>(lojaExistente, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id){
		lojaService.remover(id);
		return new ResponseEntity<Loja>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
