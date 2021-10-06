package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CLI_ID;
	@Getter
	@Setter
	private String CLI_NOME;
	@Getter
	@Setter
	private String CLI_TIPO;
	@Getter
	@Setter
	private String CLI_CPFCNPJ;
	@Getter
	@Setter
	private Instant CLI_DATANASCIMENTO;
	@Getter
	@Setter
	private String CLI_CONTATO;
	@Getter
	@Setter
	private String CLI_EMAIL;
	@Getter
	@Setter
	private String CLI_RAZAOSOCIAL;
	@Getter
	@Setter
	private String CLI_NOMEFANTASIA;
	@Getter
	@Setter
	private String CLI_ENDERECO;
	@Getter
	@Setter
	private String CLI_SEGMENTO;
	@Getter
	@Setter
	private String CLI_FLAG;
	
	@Getter
	@JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<Venda> vendas = new ArrayList<>();
	
	public Cliente() {
		super();
	}

	public Cliente(Long cLI_ID, String cLI_NOME, String cLI_TIPO, String cLI_CPFCNPJ, Instant cLI_DATANASCIMENTO,
			String cLI_CONTATO, String cLI_EMAIL, String cLI_RAZAOSOCIAL, String cLI_NOMEFANTASIA, String cLI_ENDERECO,
			String cLI_SEGMENTO, String cLI_FLAG) {
		super();
		CLI_ID = cLI_ID;
		CLI_NOME = cLI_NOME;
		CLI_TIPO = cLI_TIPO;
		CLI_CPFCNPJ = cLI_CPFCNPJ;
		CLI_DATANASCIMENTO = cLI_DATANASCIMENTO;
		CLI_CONTATO = cLI_CONTATO;
		CLI_EMAIL = cLI_EMAIL;
		CLI_RAZAOSOCIAL = cLI_RAZAOSOCIAL;
		CLI_NOMEFANTASIA = cLI_NOMEFANTASIA;
		CLI_ENDERECO = cLI_ENDERECO;
		CLI_SEGMENTO = cLI_SEGMENTO;
		CLI_FLAG = cLI_FLAG;
	}
}