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

import com.spring.java.backend.enums.DocumentoStatus;

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
@Table(name = "tb_compra")
public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 11, name = "COM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comId;
	
	@Column(name = "COM_DATA")
	private Instant comData;
	
	@Column(name = "COM_VALOR_TOTAL")
	private Double comValorTotal;
	
	@Column(name = "COM_DESCONTO")
	private Double comDesconto;
	
	@Column(name = "COM_JUROS")
	private Double comJuros;
		
	@ManyToOne
	@JoinColumn(name = "COM_FOR_ID")
	private Fornecedor comFornecedor;
	
	@Column(name = "COM_STS_DOC")
	private Integer comStsDoc;

	public DocumentoStatus getCOM_STS_DOC() {
		return DocumentoStatus.valueOf(comStsDoc);
	}

	public void setCOM_STS_DOC(DocumentoStatus cOM_STS_DOC) {
		if(cOM_STS_DOC != null) {
			this.comStsDoc = cOM_STS_DOC.getCodigo();
		}
	}	
}