package entidades;

public class Despesas {

	//Atributos
	
	private String descricaoDespesa;
	private String valor;
	
	private String categoria;
	
	//Métodos
	
	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}
	
	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	String criarCategoria() {
		return categoria;
	}
	
}
