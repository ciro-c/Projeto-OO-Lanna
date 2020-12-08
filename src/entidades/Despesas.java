package entidades;

import java.util.Date;

public class Despesas {

	
	private String descricaoDespesas;
	private double valor;
	private Date data;
	public Categoria categoria;
	
	public Despesas(String descricaoDespesas, double valor) {

		super();
		this.descricaoDespesas = descricaoDespesas;
		this.valor = valor;
	}
	
	public String getDescricaoDespesas() {
		return descricaoDespesas;
	}

	public void setDescricaoDespesas(String descricaoDespesas) {
		this.descricaoDespesas = descricaoDespesas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void imprimirRelatorioDespesas() {
		
	}
	
	public void cadastrarCategoria(String descricaoCategoria) {
		categoria = new Categoria(descricaoCategoria);

	}
	
	
	
}
