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
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 11, name = "FOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer forId;

	@Column(length = 45,name = "FOR_NOME")
	private String forNome;
	
	@Column(length = 2, name = "FOR_TIPO")
	private String forTipo;
	
	@Column(length = 14, name = "FOR_CPF_CNPJ")
	private String forCpfCnpj;
	
	@Column(length = 45, name = "FOR_FANTASIA")
	private String forFantasia;
	
	@Column(length = 45, name = "FOR_ENDERECO")
	private String forEndereco;
	
	@Column(length = 14, name = "FOR_CONTATO")
	private String forContato;
	
	@Column(length = 45, name = "FOR_EMAIL")
	private String forEmail;
	
	@Column(length = 2, name = "FOR_FLAG")
	private String forFlag;
	
}