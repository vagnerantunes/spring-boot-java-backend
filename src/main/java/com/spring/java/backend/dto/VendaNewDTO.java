package com.spring.java.backend.dto;

import java.io.Serializable;
import java.time.Instant;

import com.spring.java.backend.enums.PagamentoStatus;
import com.spring.java.backend.enums.VendaStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Instant venData;

	private Double venVrtotal;

	private Double venVrpago;

	private Double venDesconto;

	private Double venJuros;
	
	//-- inicio atributo e metodos VendaStatus --
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
	
	private Integer venCliente;
	
	private Integer venFormaPagamento;
	
	private Integer venUsuario;

}
