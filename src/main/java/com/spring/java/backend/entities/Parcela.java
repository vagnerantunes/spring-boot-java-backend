package com.spring.java.backend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.java.backend.enums.PagamentoStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_parcela")
public class Parcela implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long PVD_ID;

	@Getter
	@Setter
	private Integer PVD_PARCELA;

	@Getter
	@Setter
	private Double PVD_VRPARCELA;

	@Getter
	@Setter
	private Double PVD_VRPAGO;

	@Getter
	@Setter
	private Instant PVD_DTVENCIMENTO;

	@Getter
	@Setter
	private Integer PVD_ATRASO;

	private Integer PVD_STS_SITU;

	@Getter
	@JsonIgnore
	@ManyToMany(mappedBy = "parcelas")
	private Set<Venda> pedidos = new HashSet<>();

	public Parcela() {
		super();
	}

	public Parcela(Long pVD_ID, Integer pVD_PARCELA, Double pVD_VRPARCELA, Double pVD_VRPAGO, Instant pVD_DTVENCIMENTO,
			Integer pVD_ATRASO, PagamentoStatus pVD_STS_SITU) {
		super();
		PVD_ID = pVD_ID;
		PVD_PARCELA = pVD_PARCELA;
		PVD_VRPARCELA = pVD_VRPARCELA;
		PVD_VRPAGO = pVD_VRPAGO;
		PVD_DTVENCIMENTO = pVD_DTVENCIMENTO;
		PVD_ATRASO = pVD_ATRASO;
		setPVD_STS_SITU(pVD_STS_SITU);
	}

	public PagamentoStatus getPVD_STS_SITU() {
		return PagamentoStatus.valueOf(PVD_STS_SITU);
	}

	public void setPVD_STS_SITU(PagamentoStatus pVD_STS_SITU) {
		if (pVD_STS_SITU != null) {
			this.PVD_STS_SITU = pVD_STS_SITU.getCodigo();
		}
	}
}