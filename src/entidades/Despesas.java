package entidades;

public class Despesas {

	//Atributos
	
	private String descricaoDespesa;
	private Double valor;
	private String categoria;

	public Despesas(){
	}

	public Despesas(String descricaoDespesa, Double valor, String categoria) {
		this.descricaoDespesa = descricaoDespesa;
		this.valor = valor;
		this.categoria = categoria;
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
	
	
}
