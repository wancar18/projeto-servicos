package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class VeiculoWanderson {
	
	private Long id;
	private String cliente;
	private String servico;
	private int quantidade;
	private double valorUnit;
	private Date dataServ;
	
	public double getVlTotal() {
		return (quantidade * valorUnit);
	}
	
	public VeiculoWanderson() {
	
	}

	public VeiculoWanderson(Long id, String cliente, String servico, int quantidade, double valorUnit, Date dataServ) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.quantidade = quantidade;
		this.valorUnit = valorUnit;
		this.dataServ = dataServ;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Date getDataServ() {
		return dataServ;
	}

	public void setDataServ(Date dataServ) {
		this.dataServ = dataServ;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		VeiculoWanderson other = (VeiculoWanderson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}


