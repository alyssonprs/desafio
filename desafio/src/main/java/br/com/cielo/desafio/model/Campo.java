package br.com.cielo.desafio.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private Integer linha;
	private Integer coluna;
	private Integer valor;
	
	private List<Campo> vizinhosIguais = new ArrayList<Campo>();

	public Boolean isVizinhoIgual(Campo vizinho) {
		boolean linhaElegivel = this.diferencaElegivel(this.getLinha(), vizinho.getLinha());
		boolean colunaElegivel = this.diferencaElegivel(this.getColuna(), vizinho.getColuna());
		boolean mesmoValor = this.getValor().compareTo(vizinho.getValor()) == 0;
		
		if(linhaElegivel && colunaElegivel && mesmoValor) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private Boolean diferencaElegivel(Integer valor1, Integer valor2) {
		int diferencaLinha = valor1.intValue() - valor2.intValue();
		if(diferencaLinha < 0) {
			diferencaLinha *= -1;
		}
		return diferencaLinha < 2;
	}
	
	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Integer getColuna() {
		return coluna;
	}

	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public List<Campo> getVizinhosIguais() {
		return vizinhosIguais;
	}

	public void setVizinhosIguais(List<Campo> vizinhosIguais) {
		this.vizinhosIguais = vizinhosIguais;
	}

	@Override
	public String toString() {
		if(valor == null) {
			return "";
		}
		return valor.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coluna == null) ? 0 : coluna.hashCode());
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Campo other = (Campo) obj;
		if (coluna == null) {
			if (other.coluna != null)
				return false;
		} else if (!coluna.equals(other.coluna))
			return false;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
}
