package entidades;

public class Pessoa {
	
	private String nome;
	private String email;
	private String rendimentos;
	
	public Pessoa(String nome, String email, String rendimentos) {
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

	public String getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(String rendimentos) {
		this.rendimentos = rendimentos;
	}

	public void cadastrarPessoa() {
		
	}
}
