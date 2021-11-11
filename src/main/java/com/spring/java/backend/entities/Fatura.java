package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spring.java.backend.enums.PagamentoStatus;

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
	private Integer FAT_ATRASO;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "FAT_FPG_ID")
	private FormaPagamento pagamentos;
	
	private Integer FAT_STS_PAG;
	
	@Getter
	@OneToMany(mappedBy = "id.fatura")
	private Set<ParcelaBoleto> parcelaBoletos = new HashSet<>();
	
	public Fatura() {
		super();
	}

	public Fatura(Long fAT_ID, Instant fAT_DATALANCEMENTO, Double fAT_VALORTOTAL, Double fAT_DESCONTO, Double fAT_JUROS,
			Double fAT_VALORPAGO, Instant fAT_VENCIMENTO, Integer fAT_ATRASO, FormaPagamento pagamentos,
			PagamentoStatus fAT_STS_PAG) {
		super();
		FAT_ID = fAT_ID;
		FAT_DATALANCEMENTO = fAT_DATALANCEMENTO;
		FAT_VALORTOTAL = fAT_VALORTOTAL;
		FAT_DESCONTO = fAT_DESCONTO;
		FAT_JUROS = fAT_JUROS;
		FAT_VALORPAGO = fAT_VALORPAGO;
		FAT_VENCIMENTO = fAT_VENCIMENTO;
		FAT_ATRASO = fAT_ATRASO;
		this.pagamentos = pagamentos;
		setFAT_STS_PAG(fAT_STS_PAG);
	}

	public PagamentoStatus getFAT_STS_PAG() {
		return PagamentoStatus.valueOf(FAT_STS_PAG);
	}

	public void setFAT_STS_PAG(PagamentoStatus fAT_STS_PAG) {
		if(fAT_STS_PAG != null) {
			this.FAT_STS_PAG = fAT_STS_PAG.getCodigo();
		}
	}

	
	
}