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

import com.spring.java.backend.enums.DocumentoStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_compra")
public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long COM_ID;
	@Getter
	@Setter
	private Instant COM_DATA;
	@Getter
	@Setter
	private Double COM_VALORTOTAL;
	@Getter
	@Setter
	private Double COM_DESCONTO;
	@Getter
	@Setter
	private Double COM_JUROS;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "COM_FOR_ID")
	private Fornecedor fornecedor;
	
	@Getter
	@OneToMany(mappedBy = "id.compra")
	private Set<ItemCompra> itemCompras = new HashSet<>();
	
	private Integer COM_STS_DOC;
	
	public Compra() {
		super();
	}

	public Compra(Long cOM_ID, Instant cOM_DATA, Double cOM_VALORTOTAL, Double cOM_DESCONTO, Double cOM_JUROS) {
		super();
		COM_ID = cOM_ID;
		COM_DATA = cOM_DATA;
		COM_VALORTOTAL = cOM_VALORTOTAL;
		COM_DESCONTO = cOM_DESCONTO;
		COM_JUROS = cOM_JUROS;
	}

	public DocumentoStatus getCOM_STS_DOC() {
		return DocumentoStatus.valueOf(COM_STS_DOC);
	}

	public void setCOM_STS_DOC(DocumentoStatus cOM_STS_DOC) {
		if(cOM_STS_DOC != null) {
			this.COM_STS_DOC = cOM_STS_DOC.getCodigo();
		}
	}	
}