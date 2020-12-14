package entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class Pessoa {
	
	private String nome;
	private String email;
	private String rendimentos;
	
	public Pessoa(String nome, String email, String rendimentos) {
		this.nome = nome;
		this.email = email;
		this.rendimentos = rendimentos;
		
		FileWriter arq;
		PrintWriter gravarArq;
		BufferedWriter bw; 
		
		try {
			File meuArquivo = new File("alunos.txt");
			
			if (!meuArquivo.exists()) {
				arq = new FileWriter(meuArquivo);
			} else {
				arq = new FileWriter(meuArquivo,true);
			}
			
			bw = new BufferedWriter(arq);
		    gravarArq = new PrintWriter(bw);
		    gravarArq.printf("%S;%S;%S%n", nome, email, rendimentos);
		    gravarArq.close();
		     
		} catch (IOException e) {
			System.out.println("An error occurred.");	
			e.printStackTrace();
		}
		
		
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

}
