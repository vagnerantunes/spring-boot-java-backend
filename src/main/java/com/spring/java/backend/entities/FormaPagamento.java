package com.spring.java.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_formaPagamento")
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 11, name = "FAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fpgId;
	
	@Column(length = 2, name = "FPG_TIPO_CONTA")
	private String fpgTipoConta;
	
	@Column(length = 45, name = "FPG_DESCRICAO")
	private String fpgDescricao;
	
	@Column(length = 20, name = "FPG_TIPO")
	private String fpgTipo;
	
	@Column(name = "FPG_QTD_PARCELA")
	private Integer fpgQtdParcela;
	
	@Column(name = "FPG_PORCENTAGEM")
	private Double fpgPorcentagem;
	
	@Column(length = 1, name = "FPG_FLAG")
	private String fpgFlag;
	
}