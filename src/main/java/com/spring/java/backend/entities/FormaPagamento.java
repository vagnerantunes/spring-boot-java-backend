package com.spring.java.backend.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_formaPagamento")
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FPG_ID;
	
	
	private String FPG_TIPO_CONTA;
	private String FPG_DESCRICAO;
	private String FPG_TIPO;
	private Integer FPG_QTDPARCELA;
	private Double FPG_PORCENTAGEM;
	private String FPG_FLAG;
	
	public FormaPagamento() {
		super();
	}

	public FormaPagamento(Long fPG_ID, String fPG_TIPO_CONTA, String fPG_DESCRICAO, String fPG_TIPO,
			Integer fPG_QTDPARCELA, Double fPG_PORCENTAGEM, String fPG_FLAG) {
		super();
		FPG_ID = fPG_ID;
		FPG_TIPO_CONTA = fPG_TIPO_CONTA;
		FPG_DESCRICAO = fPG_DESCRICAO;
		FPG_TIPO = fPG_TIPO;
		FPG_QTDPARCELA = fPG_QTDPARCELA;
		FPG_PORCENTAGEM = fPG_PORCENTAGEM;
		FPG_FLAG = fPG_FLAG;
	}
}