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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spring.java.backend.enums.PagamentoStatus;
import com.spring.java.backend.enums.VendaStatus;

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
	
	//-- inicio atributo e metodos VendaStatus --
	private Integer VEN_STS_ORC;
		
	public VendaStatus getVEN_STS_ORC() {
		return VendaStatus.valueOf(VEN_STS_ORC);		
	}
	
	public void setVEN_STS_ORC(VendaStatus vEN_STS_ORC) {
		if(vEN_STS_ORC != null) {
			this.VEN_STS_ORC = vEN_STS_ORC.getCodigo();
		}
	}
	//-- fim --
	
	//-- inicio atributo e metodos PagamentoStatus --
	private Integer VEN_STS_PAG;
	
	public PagamentoStatus getVEN_STS_PAG() {
		return PagamentoStatus.valueOf(VEN_STS_PAG);
	}
	
	public void setVEN_STS_PAG(PagamentoStatus vEN_STS_PAG) {
		if(vEN_STS_PAG != null) {
			this.VEN_STS_PAG = vEN_STS_PAG.getCodigo();
		}		
	}
	//-- fim --
	
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
	
	@Getter
	@OneToMany(mappedBy = "id.venda")
	private Set<ItemVenda> itemVendas = new HashSet<>();
	
	public Venda() {		
	}

	public Venda(Long vEN_ID, Instant vEN_DATA, Double vEN_VRTOTAL, Double vEN_VRPAGO, Double vEN_DESCONTO,
			Double vEN_JUROS, VendaStatus vEN_STS_ORC, PagamentoStatus vEN_STS_PAG, Cliente clientes,
			FormaPagamento pagamentos, Usuario usuarios) {
		super();
		VEN_ID = vEN_ID;
		VEN_DATA = vEN_DATA;
		VEN_VRTOTAL = vEN_VRTOTAL;
		VEN_VRPAGO = vEN_VRPAGO;
		VEN_DESCONTO = vEN_DESCONTO;
		VEN_JUROS = vEN_JUROS;
		setVEN_STS_ORC(vEN_STS_ORC);
		setVEN_STS_PAG(vEN_STS_PAG);
		this.clientes = clientes;
		this.pagamentos = pagamentos;
		this.usuarios = usuarios;
	}	
	
}