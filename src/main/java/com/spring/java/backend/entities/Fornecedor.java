package com.spring.java.backend.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FOR_ID;

	@Getter
	@Setter
	private String FOR_NOME;
	@Getter
	@Setter
	private String FOR_TIPO;
	@Getter
	@Setter
	private String FOR_CPF_CNPJ;
	@Getter
	@Setter
	private String FOR_FANTASIA;
	@Getter
	@Setter
	private String FOR_ENDERECO;
	@Getter
	@Setter
	private String FOR_CONTATO;
	@Getter
	@Setter
	private String FOR_EMAIL;
	@Getter
	@Setter
	private String FOR_FLAG;

	public Fornecedor() {
		super();
	}

	public Fornecedor(Long fOR_ID, String fOR_NOME, String fOR_TIPO, String fOR_CPF_CNPJ, String fOR_FANTASIA,
			String fOR_ENDERECO, String fOR_CONTATO, String fOR_EMAIL, String fOR_FLAG) {
		super();
		FOR_ID = fOR_ID;
		FOR_NOME = fOR_NOME;
		FOR_TIPO = fOR_TIPO;
		FOR_CPF_CNPJ = fOR_CPF_CNPJ;
		FOR_FANTASIA = fOR_FANTASIA;
		FOR_ENDERECO = fOR_ENDERECO;
		FOR_CONTATO = fOR_CONTATO;
		FOR_EMAIL = fOR_EMAIL;
		FOR_FLAG = fOR_FLAG;
	}	
}