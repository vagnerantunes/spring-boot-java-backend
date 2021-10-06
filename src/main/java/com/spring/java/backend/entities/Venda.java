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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long VEN_ID;

	@Getter
	@Setter
	private Instant VEN_DATA;

	@Getter
	@Setter
	private Double VEN_VRTOTAL;

	@Getter
	@Setter
	private Double VEN_VRPAGO;

	@Getter
	@Setter
	private Double VEN_DESCONTO;

	@Getter
	@Setter
	private Double VEN_JUROS;
	
	@Getter
	@ManyToMany
	@JoinTable(name = "tb_venda_parcela", joinColumns = @JoinColumn(name = "venda_id"),
	inverseJoinColumns = @JoinColumn(name = "parcela_id"))
	private Set<Parcela> parcelas = new HashSet<>();
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "VEN_CLI_ID")
	private Cliente clientes;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "VEN_FPG_ID")
	private FormaPagamento pagamentos;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "VEN_USU_ID")
	private Usuario usuarios;
	
	public Venda() {
	}

	public Venda(Long vEN_ID, Instant vEN_DATA, Double vEN_VRTOTAL, Double vEN_VRPAGO, Double vEN_DESCONTO,
			Double vEN_JUROS, Integer vEN_STS_PAG, Integer vEN_STS_ORC) {
		super();
		VEN_ID = vEN_ID;
		VEN_DATA = vEN_DATA;
		VEN_VRTOTAL = vEN_VRTOTAL;
		VEN_VRPAGO = vEN_VRPAGO;
		VEN_DESCONTO = vEN_DESCONTO;
		VEN_JUROS = vEN_JUROS;
	}

}
