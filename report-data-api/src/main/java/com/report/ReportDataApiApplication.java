package com.report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.report.model.Venda;
import com.report.repository.VendaRepository;

@SpringBootApplication
public class ReportDataApiApplication {
	
	@Autowired
	public static VendaRepository vendaRepository;
	
	public Iterator<Venda> tamanhoValores() {
		Iterator<Venda> tamanho = vendaRepository.findAll().iterator();
		return tamanho;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReportDataApiApplication.class, args);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy 'às' HH:mm:ss", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("O projeto está rodando em " + sdf.format(calendar.getTime()));
		
	}

}

