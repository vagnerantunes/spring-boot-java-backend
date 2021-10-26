package com.spring.java.backend.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.java.backend.entities.Boleto;
import com.spring.java.backend.entities.Fatura;

import lombok.Data;

@Embeddable
@Data
public class ParcelaBoletoPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "fatura_id")
	private Fatura fatura;
	
	@ManyToOne
	@JoinColumn(name = "boleto_id")
	private Boleto boleto;
	
	
}
