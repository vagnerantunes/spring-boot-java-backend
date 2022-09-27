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
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11, name = "CLI_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cliId;
	
	@Column(length = 45, name = "CLI_NOME")
	private String cliNome;
	
	//pf ou pj
	@Column(length = 2, name = "CLI_TIPO")
	private String cliTipo;
	
	@Column(length = 14, name = "CLI_CPF_CNPJ")
	private String cliCpfCnpj;
	
	@Column(name = "CLI_DATA_NASCIMENTO")
	private Instant cliDataNascimento;
	
	@Column(length = 14, name = "CLI_CONTATO")
	private String cliContato;
	
	@Column(length = 45, name = "CLI_EMAIL")
	private String cliEmail;
	
	@Column(length = 45, name = "CLI_RAZAO_SOCIAL")
	private String cliRazaoSocial;
	
	@Column(length = 45, name = "CLI_NOME_FANTASIA")
	private String cliNomeFantasia;
	
	@Column(length = 45, name = "CLI_ENDERECO")
	private String cliEndereco;
	
	@Column(length = 45, name = "CLI_SEGMENTO")
	private String cliSegmento;
	
	@Column(length = 1, name = "CLI_FLAG")
	private String cliFlag;

}