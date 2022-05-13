package com.loja;

public class Produto {

	private String nome;
	private int unidadeCompra;
	private String descricao;
	private double qtdPrevisoMes;
	private double precoMaxComprado;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getUnidadeCompra() {
		return unidadeCompra;
	}
	public void setUnidadeCompra(int unidadeCompra) {
		this.unidadeCompra = unidadeCompra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getQtdPrevisoMes() {
		return qtdPrevisoMes;
	}
	public void setQtdPrevisoMes(double qtdPrevisoMes) {
		this.qtdPrevisoMes = qtdPrevisoMes;
	}
	public double getPrecoMaxComprado() {
		return precoMaxComprado;
	}
	public void setPrecoMaxComprado(double precoMaxComprado) {
		this.precoMaxComprado = precoMaxComprado;
	}
	
}
