package com.report;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportDataApiApplication.class, args);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy 'às' HH:mm:ss", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("O projeto está rodando em " + sdf.format(calendar.getTime()));
		
		LocalDate data = LocalDate.now();
		System.out.println(data.getDayOfMonth());
		System.out.println(data.getMonthValue());
		System.out.println(data.getYear());
		
	}

}

