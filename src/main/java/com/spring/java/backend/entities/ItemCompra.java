package com.spring.java.backend.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.java.backend.entities.pk.ItemCompraPK;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_itemCompra")
public class ItemCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemCompraPK id = new ItemCompraPK();

	@Getter
	@Setter
	private Double ITC_QTD;

	@Getter
	@Setter
	private Double ITC_PRECO;

	public ItemCompra() {

	}

	public ItemCompra(Compra compra, Produto produto, Double iTC_QTD, Double iTC_PRECO) {
		super();
		id.setCompra(compra);
		id.setProduto(produto);
		ITC_QTD = iTC_QTD;
		ITC_PRECO = iTC_PRECO;
	}

	@JsonIgnore
	public Compra getCompra() {
		return id.getCompra();
	}

	public void setCompra(Compra compra) {
		id.setCompra(compra);
	}

	@JsonIgnore
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ITC_PRECO == null) ? 0 : ITC_PRECO.hashCode());
		result = prime * result + ((ITC_QTD == null) ? 0 : ITC_QTD.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		if (ITC_PRECO == null) {
			if (other.ITC_PRECO != null)
				return false;
		} else if (!ITC_PRECO.equals(other.ITC_PRECO))
			return false;
		if (ITC_QTD == null) {
			if (other.ITC_QTD != null)
				return false;
		} else if (!ITC_QTD.equals(other.ITC_QTD))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}