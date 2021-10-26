package com.spring.java.backend.enums;

public enum PagamentoStatus {
	
	PAGO_TOTAL(1),
	PENDENTE(2),
	PAGO_PARCIAL(3),
	CANCELADO(4);
	
	private int codigo;
	
	private PagamentoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;		
	}
	
	public static PagamentoStatus valueOf(int codigo) {
		for(PagamentoStatus value : PagamentoStatus.values()) {
			if(value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código PagamentoStatus inválido");
	}
}