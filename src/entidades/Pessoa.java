package entidades;

public class Pessoa {
	
	//Atributos
	
	private String nome;
	private String email;
	private String rendimento;
	
	private boolean cadastro;
	
	public Pessoa(String nome, String email, String rendimento) {
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
	
	public String getRendimento() {
		return this.rendimento;
	}
	
	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}
	
	public boolean cadastrarPessoa() {
		/*Retornar .txt*/
		return cadastro;
	}
}
