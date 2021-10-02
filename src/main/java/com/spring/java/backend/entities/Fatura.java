package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_fatura")
public class Fatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long FAT_ID;
	@Getter
	@Setter
	private Instant FAT_DATALANCEMENTO;
	@Getter
	@Setter
	private Double FAT_VALORTOTAL;
	@Getter
	@Setter
	private Double FAT_DESCONTO;
	@Getter
	@Setter
	private Double FAT_JUROS;
	@Getter
	@Setter
	private Double FAT_VALORPAGO;
	@Getter
	@Setter
	private Instant FAT_VENCIMENTO;
	@Getter
	@Setter
	private Integer FATA_ATRASO;
	
	public Fatura() {
		super();
	}

	public Fatura(Long fAT_ID, Instant fAT_DATALANCEMENTO, Double fAT_VALORTOTAL, Double fAT_DESCONTO, Double fAT_JUROS,
			Double fAT_VALORPAGO, Instant fAT_VENCIMENTO, Integer fATA_ATRASO) {
		super();
		FAT_ID = fAT_ID;
		FAT_DATALANCEMENTO = fAT_DATALANCEMENTO;
		FAT_VALORTOTAL = fAT_VALORTOTAL;
		FAT_DESCONTO = fAT_DESCONTO;
		FAT_JUROS = fAT_JUROS;
		FAT_VALORPAGO = fAT_VALORPAGO;
		FAT_VENCIMENTO = fAT_VENCIMENTO;
		FATA_ATRASO = fATA_ATRASO;
	}
	
}