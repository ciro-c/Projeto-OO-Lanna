package entidades;

public class Pessoa {
	
	//Atributos
	
	private String nome;
	private String email;
	private double rendimento;
	
	private boolean cadastro;
	
	//M�todos
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getRendimento() {
		return this.rendimento;
	}
	
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
	boolean cadastrarPessoa() {
		/*Retornar .txt*/
		return cadastro;
	}
}
