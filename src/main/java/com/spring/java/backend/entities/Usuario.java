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
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 11, nullable = false, name = "USU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuId;
	
	@Column(length = 45, nullable = false, name = "USU_NOME")
	private String usuNome;
	
	@Column(length = 1, nullable = false,  name = "USU_FLAG")
	private String usuFlag;
	
	@Column(length = 15, nullable = false,  name = "USU_SENHA")
	private String usuSenha;

}