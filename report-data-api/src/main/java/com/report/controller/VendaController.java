package com.report.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.report.model.Venda;
import com.report.service.VendaService;

@RestController
@RequestMapping("/venda")
@CrossOrigin("${origem-permitida}")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Venda> venda = vendaService.listarTodos();
		return ResponseEntity.ok().body(venda);
	}
	
	@GetMapping("/loja/{nome}")
	public ResponseEntity<?> buscarPorLoja(@PathVariable String nome){
		List<Venda> venda = vendaService.listarLojasPorNome(nome);
		return ResponseEntity.ok(venda);
	}
	
	@GetMapping("/data/{data}")
	public ResponseEntity<?> listarPorData(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data){
		List<Venda> venda = vendaService.listarPorData(data);
		return ResponseEntity.ok().body(venda);
	}
	
	@GetMapping("/dia/{dia}")
	public ResponseEntity<?> listarPorDia(@PathVariable int dia){
		List<Venda> venda = vendaService.listarPorDia(dia);
		return ResponseEntity.ok().body(venda);
	}
	
	@GetMapping("/mes/{mes}")
	public ResponseEntity<?> listarPorMes(@PathVariable int mes){
		List<Venda> venda = vendaService.listarPorMes(mes);
		return ResponseEntity.ok().body(venda);
	}
	
	@GetMapping("/ano/{ano}")
	public ResponseEntity<?> listarPorAno(@PathVariable int ano){
		List<Venda> venda = vendaService.listarPorAno(ano);
		return ResponseEntity.ok().body(venda);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Venda venda = vendaService.listarPorId(id);
		return ResponseEntity.ok().body(venda);
	}
	
	@PostMapping
	public ResponseEntity<Venda> adicionar(@Valid @RequestBody Venda venda){
		vendaService.adicionar(venda);
		return new ResponseEntity<Venda>(venda, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Venda venda){
		venda.setId(id);
		Venda vendaExistente = vendaService.atualizar(venda);
		return new ResponseEntity<Venda>(vendaExistente, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		vendaService.remover(id);
		return new ResponseEntity<Venda>(HttpStatus.NO_CONTENT);
	}

}
