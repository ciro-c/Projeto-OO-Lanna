package entidades;

public class Pessoa {
	
	private String nome;
	private String email;
	private double rendimentos;
	
	public Pessoa(String nome, String email, double rendimentos) {
		super();
		this.nome = nome;
		this.email = email;
		this.rendimentos = rendimentos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(double rendimentos) {
		this.rendimentos = rendimentos;
	}

	public void cadastrarPessoa() {
		
	}
}
