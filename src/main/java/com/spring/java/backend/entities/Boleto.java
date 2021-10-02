package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_boleto")
public class Boleto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long BOL_ID;
	@Getter
	@Setter
	private String BOL_DESCRICAO;
	@Getter
	@Setter
	private Instant BOL_DATA;
	@Getter
	@Setter
	private Double BOL_VALOR;
	@Getter
	@Setter
	private Integer BOL_QTDPARCELAS;
	@Getter
	@Setter
	private String BOL_CONTAPFPJ;
	@Getter
	@Setter
	private String BOL_OBS;
	
	public Boleto() {
		super();
	}

	public Boleto(Long bOL_ID, String bOL_DESCRICAO, Instant bOL_DATA, Double bOL_VALOR, Integer bOL_QTDPARCELAS,
			String bOL_CONTAPFPJ, String bOL_OBS) {
		super();
		BOL_ID = bOL_ID;
		BOL_DESCRICAO = bOL_DESCRICAO;
		BOL_DATA = bOL_DATA;
		BOL_VALOR = bOL_VALOR;
		BOL_QTDPARCELAS = bOL_QTDPARCELAS;
		BOL_CONTAPFPJ = bOL_CONTAPFPJ;
		BOL_OBS = bOL_OBS;
	}			

	
	
}