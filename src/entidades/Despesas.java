package entidades;

public class Despesas {

	//Atributos
	
	private String descricaoDespesa;
	private double valor;
	
	private String categoria;
	
	//Métodos
	
	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}
	
	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	String criarCategoria() {
		return categoria;
	}
	
}
