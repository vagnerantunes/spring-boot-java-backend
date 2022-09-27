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
import com.spring.java.backend.enums.VendaStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11, name = "VEN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venId;

	@Column(name = "VEN_DATA")
	private Instant venData;

	@Column(name = "VEN_VRTOTAL")
	private Double venVrtotal;

	@Column(name = "VEN_VRPAGO")
	private Double venVrpago;

	@Column(name = "VEN_DESCONTO")
	private Double venDesconto;

	@Column(name = "VEN_JUROS")
	private Double venJuros;
	
	//-- inicio atributo e metodos VendaStatus --
	@Column(length = 11, name = "VEN_STS_ORC")
	private Integer venStsOrc;
		
	public VendaStatus getVEN_STS_ORC() {
		return VendaStatus.valueOf(venStsOrc);		
	}
	
	public void setVEN_STS_ORC(VendaStatus vEN_STS_ORC) {
		if(vEN_STS_ORC != null) {
			this.venStsOrc = vEN_STS_ORC.getCodigo();
		}
	}
	
	//-- fim --
	
	//-- inicio atributo e metodos PagamentoStatus --
	@Column(name = "VEN_STS_PAG")
	private Integer venStsPag;
	
	public PagamentoStatus getVEN_STS_PAG() {
		return PagamentoStatus.valueOf(venStsPag);
	}
	
	public void setVEN_STS_PAG(PagamentoStatus vEN_STS_PAG) {
		if(vEN_STS_PAG != null) {
			this.venStsPag = vEN_STS_PAG.getCodigo();
		}		
	}
	//-- fim --
	/*
	@ManyToMany
	@JoinTable(name = "tb_venda_parcela", joinColumns = @JoinColumn(name = "venda_id"),
	inverseJoinColumns = @JoinColumn(name = "parcela_id"))
	private Set<Parcela> venParcelas = new HashSet<>();
	*/
	@ManyToOne
	@JoinColumn(name = "VEN_CLI_ID")
	private Cliente venCliente;
	
	@ManyToOne
	@JoinColumn(name = "VEN_FPG_ID")
	private FormaPagamento venFormaPagamento;
	
	@ManyToOne
	@JoinColumn(name = "VEN_USU_ID")
	private Usuario venUsuario;

	public Venda(Integer vEN_ID, Instant vEN_DATA, Double vEN_VRTOTAL,
			Double vEN_VRPAGO, Double vEN_DESCONTO,Double vEN_JUROS, 
			VendaStatus vEN_STS_ORC, PagamentoStatus vEN_STS_PAG, Cliente clientes,
			FormaPagamento pagamentos, Usuario usuarios) {
		venId = vEN_ID;
		venData = vEN_DATA;
		venVrtotal = vEN_VRTOTAL;
		venVrpago = vEN_VRPAGO;
		venDesconto = vEN_DESCONTO;
		venJuros = vEN_JUROS;
		setVEN_STS_ORC(vEN_STS_ORC);
		setVEN_STS_PAG(vEN_STS_PAG);
		this.venCliente = clientes;
		this.venFormaPagamento = pagamentos;
		this.venUsuario = usuarios;
	}	
	
}