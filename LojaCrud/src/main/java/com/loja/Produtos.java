package com.loja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Produtos {

private static List<Produto> lista = new ArrayList<>();
	
	static {
		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Tenis Air Jordan 1");
		produto.setDescricao("1 tenis a ser usado por Michael Jordan");
		produto.setPrecoMaxComprado(1000);
		produto.setQtdPrevisoMes(400);
		produto.setUnidadeCompra(600);
		Produto produto2 = new Produto();
		produto2.setId(2);
		produto2.setNome("Smartphone Samsung S22");
		produto2.setDescricao("8gb RAM / 256GB");
		produto2.setPrecoMaxComprado(6000);
		produto2.setQtdPrevisoMes(10000);
		produto2.setUnidadeCompra(5000);
		lista.add(produto);
		lista.add(produto2);
	}

	public void adiciona(Produto empresa) {
		this.lista.add(empresa);
	}
	
	public List<Produto> getProduto(){
		return this.lista;
	}
	
	public Produto getProdutoById(int id) {
		for (Produto prod : lista) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}
	
	public void removeProduto(int id) {
		Iterator<Produto> it = lista.iterator();
		
		while(it.hasNext()) {
			Produto prod = it.next();
			
			if(prod.getId() == id) {
				it.remove();
			}
		}
	}
	
}
