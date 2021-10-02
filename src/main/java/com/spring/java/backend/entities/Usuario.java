package com.spring.java.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long USU_ID;
	
	@Column(length = 45, nullable = false)
	@Getter
	@Setter
	private String USU_NOME;
	
	@Column(length = 1, nullable = false)
	@Getter
	@Setter
	private String USU_FLAG;
	
	@Column(length = 15, nullable = false)
	@Getter
	@Setter
	private String USU_SENHA;		

	public Usuario() {
		super();
	}

	public Usuario(Long uSU_ID, String uSU_NOME, String uSU_FLAG, String uSU_SENHA) {
		super();
		USU_ID = uSU_ID;
		USU_NOME = uSU_NOME;
		USU_FLAG = uSU_FLAG;
		USU_SENHA = uSU_SENHA;
	}	
}