package br.com.turma.modelo;

public class Produto {
public Produto() {
		
	}
private Integer codigo;
public Integer getCodigo() {
	return codigo;
}



public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}
private String produtos;
private Double valor;



public String getProdutos() {
	return produtos;
}



public void setProdutos(String produto) {
	this.produtos = produto;
}



public Double getValor() {
	return valor;
}



public void setValor(Double valor) {
	this.valor = valor;
}
public Produto(String produto, Double valor) {
	super();
	this.produtos=produto;
	this.valor=valor;
}




	
}

