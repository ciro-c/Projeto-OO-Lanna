package aplicacao;

// Imports usados

import javax.swing.JOptionPane;
import java.util.ArrayList;

// Imports das classes do projeto

import entidades.Despesas;
import entidades.Pessoa;
import entidades.Categoria;
import entidades.Subcategoria;

// Main

public class Republica {
	
	public static void main(String[] args) {
		
		// Variáveis e Arraylists
		
		int i = 0; // Varíavel de condição do menu principal
		int j = 0; // Varíavel de condição das opções
		
		ArrayList<Pessoa> p = new ArrayList<Pessoa>(); // Coleção de objetos da classe Pessoa
		
		// Menu principal
		
		do {
		
			JOptionPane.showMessageDialog(null, "----------DIVISÃO DAS DESPESAS DE UMA REPÚBLICA----------\n\nOlá, o que deseja fazer?\n"
			+ "1) Cadastrar pessoa...\n2) Cadastrar despesa...\n3) Cadastrar categoria...\n4) Sair do programa...");
			String respostaOpcao = JOptionPane.showInputDialog("");
			int rO = Integer.parseInt(respostaOpcao);
			i = rO ;
			
			// Opções
			
			switch(rO) {
				// Cadastrar pessoa
				case 1:
					
					String opcaoPessoa = JOptionPane.showInputDialog ("Deseja cadastrar uma pessoa ou retornar ao menu "
							+ "principal? \n1) Cadastrar...\n2) Retornar ao menu principal...");
					int oP = Integer.parseInt(opcaoPessoa);
					j = oP;	
					
					if(j==1) {
						do{
							
							JOptionPane.showMessageDialog(null, "Você escolheu a primeira opção!");
							JOptionPane.showMessageDialog(null, "CADASTRAR PESSOA");
							JOptionPane.showMessageDialog(null, "Por favor, informe os dados a seguir...");
							String nomePessoa = JOptionPane.showInputDialog("Nome completo da pessoa: ");
							String emailPessoa = JOptionPane.showInputDialog("Email completo da pessoa: ");
							String rendimentoPessoa = JOptionPane.showInputDialog("Rendimento da pessoa: "); 
							double rP = Double.parseDouble(rendimentoPessoa);
							
							p.add(new Pessoa(nomePessoa, emailPessoa, rP));
							
							/*try {
								p.add(new Pessoa(nomePessoa, emailPessoa, rP));
							}catch (DadosPessoaisIncompletos) {
								
							}*/
							
							JOptionPane.showMessageDialog(null, "Número de cadastros efetuados: " +p.size());
							
							String opcaoNova = JOptionPane.showInputDialog("Deseja cadastrar outra pessoa ou retornar ao menu "
							+ "principal?\n\n1) Cadadastrar outra pessoa...\n2) Retornar ao menu principal...");
							int oN = Integer.parseInt(opcaoNova);
							j = oN;
							
						}while(j==1);
					}else {
						break;
					}
					
				// Cadastrar despesa
				case 2:
					JOptionPane.showMessageDialog(null, "Opção 2");
				break;
				// Cadastrar categoria
				case 3:
					JOptionPane.showMessageDialog(null, "Opção 3");
				break;
				// Sair do programa
				case 4:
					JOptionPane.showMessageDialog(null, "Opção 4");
				break;
			}
		}while(i!=4);
		
	}
	
}