package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;

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
@Table(name = "tb_boleto")
public class Boleto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "BOL_ID")
	private Integer bolId;
	@Column(length = 45, name = "BOL_DESCRICAO")
	private String bolDescricao;
	@Column(name = "BOL_DATA")
	private Instant bolData;
	@Column(name = "BOL_VALOR")
	private Double bolValor;
	@Column(name = "BOL_QTD_PARCELAS")
	private Integer bolQtdParcelas;
	@Column(length = 14, name = "BOL_CONTA_PFPJ")
	private String bolContaPFPJ;
	@Column(length = 45, name = "BOL_OBS")
	private String bolObs;
	
}