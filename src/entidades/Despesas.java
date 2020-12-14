package entidades;

import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;


public class Despesas {

	
	private String descricaoDespesas;
	private double valor;
	private int mes;
	private int ano;
	public Categoria categoria;
	
	public Despesas(String descricaoDespesas, double valor) {
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

	public int getAno() {
		return ano;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getMes() {
		return mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	
	public void cadastrarCategoria(String descricaoCategoria) {
		FileWriter arq;
		PrintWriter gravarArq;
		BufferedWriter bw; 
		Calendar calendario =  Calendar.getInstance();

		mes = calendario.get(Calendar.MONTH);
		ano = calendario.get(Calendar.YEAR);
		categoria = new Categoria(descricaoCategoria);
		
		String nomeArquivo = "despesas";
		nomeArquivo = nomeArquivo + "_" + mes + "_"  + ano + ".txt" ;
		
		try {
			File myFile = new File(nomeArquivo);
			
			if (!myFile.exists()) {
				arq = new FileWriter(myFile);
				System.out.println("Criou Despesa");
			} else {
				arq = new FileWriter(myFile,true);
				System.out.println("entrou em despesa");
			}
			
			bw = new BufferedWriter(arq);
		    gravarArq = new PrintWriter(bw);
		    gravarArq.printf("%S;%S;%f\n", descricaoDespesas, categoria.getDescricaoCategoria(), valor);
		    gravarArq.close();
			System.out.println("Cadastrou");

		} catch (IOException e) {
			System.out.println("An error occurred.");	
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
