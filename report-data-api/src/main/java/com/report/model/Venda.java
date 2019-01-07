package com.report.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.report.config.CustomLocalDateTimeSerializer;

@Entity
@Table
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeLoja;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDate data;
	private Double valor;
	private Double valorAnterior;
	private int dia;
	private int mes;
	private int ano;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "venda")
	private List<Loja> lojas = new ArrayList<>();
	
	public Venda() {
		super();
	}

	public Venda(Long id, String nomeLoja, LocalDate data, Double valor, Double valorAnterior, int dia, int mes,
			int ano, List<Loja> lojas) {
		super();
		this.id = id;
		this.nomeLoja = nomeLoja;
		this.data = data;
		this.valor = valor;
		this.valorAnterior = valorAnterior;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.lojas = lojas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(Double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", nomeLoja=" + nomeLoja + ", data=" + data + ", valor=" + valor + ", valorAnterior="
				+ valorAnterior + ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + ", lojas=" + lojas + "]";
	}
}