package entidades;

public class Pessoa {
	
	//Atributos
	
	private String nome;
	private String email;
	private double rendimento;
	
	private boolean cadastro;
	
	//Métodos
	
	public Pessoa(String nome, String email, double rendimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.rendimento = rendimento;
	}
	
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
	
	
	public boolean cadastrarPessoa() {
		/*Retornar .txt*/
		return cadastro;
	}
}