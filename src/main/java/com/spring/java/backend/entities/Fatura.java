package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spring.java.backend.enums.PagamentoStatus;

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
@Table(name = "tb_fatura")
public class Fatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11, name = "FAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fatId;
	
	@Column(name = "FAT_DATA_LANCEMENTO")
	private Instant fatDataLancamento;
	
	@Column(name = "FAT_VALOR_TOTAL")
	private Double fatValorTotal;
	
	@Column(name = "FAT_DESCONTO")
	private Double fatDesconto;
	
	@Column(name = "FAT_JUROS")
	private Double fatJuros;
	
	@Column(name = "FAT_VALOR_PAGO")
	private Double fatValorPago;
	
	@Column(name = "FAT_VENCIMENTO")
	private Instant fatVencimento;
	
	@Column(name = "FAT_ATRASO")
	private Integer fatAtraso;
	
	@ManyToOne
	@JoinColumn(name = "FAT_FPG_ID")
	private FormaPagamento fatPagamento;
	
	@Column(name = "FAT_STS_PAG")
	private Integer fatStsPag;

	public PagamentoStatus getFAT_STS_PAG() {
		return PagamentoStatus.valueOf(fatStsPag);
	}

	public void setFAT_STS_PAG(PagamentoStatus fAT_STS_PAG) {
		if(fAT_STS_PAG != null) {
			this.fatStsPag = fAT_STS_PAG.getCodigo();
		}
	}
	
}