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
		
		// Vari�veis e Arraylists
		
		int i = 0; // Var�avel de condi��o do menu principal
		int j = 0; // Var�avel de condi��o das op��es
		
		ArrayList<Pessoa> p = new ArrayList<Pessoa>(); // Cole��o de objetos da classe Pessoa
		
		// Menu principal
		
		do {
		
			JOptionPane.showMessageDialog(null, "----------DIVIS�O DAS DESPESAS DE UMA REP�BLICA----------\n\nOl�, o que deseja fazer?\n"
			+ "1) Cadastrar pessoa...\n2) Cadastrar despesa...\n3) Cadastrar categoria...\n4) Sair do programa...");
			String respostaOpcao = JOptionPane.showInputDialog("");
			int rO = Integer.parseInt(respostaOpcao);
			i = rO ;
			
			// Op��es
			
			switch(rO) {
				// Cadastrar pessoa
				case 1:
					
					String opcaoPessoa = JOptionPane.showInputDialog ("Deseja cadastrar uma pessoa ou retornar ao menu "
							+ "principal? \n1) Cadastrar...\n2) Retornar ao menu principal...");
					int oP = Integer.parseInt(opcaoPessoa);
					j = oP;	
					
					if(j==1) {
						do{
							
							JOptionPane.showMessageDialog(null, "Voc� escolheu a primeira op��o!");
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
							
							JOptionPane.showMessageDialog(null, "N�mero de cadastros efetuados: " +p.size());
							
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
					JOptionPane.showMessageDialog(null, "Op��o 2");
				break;
				// Cadastrar categoria
				case 3:
					JOptionPane.showMessageDialog(null, "Op��o 3");
				break;
				// Sair do programa
				case 4:
					JOptionPane.showMessageDialog(null, "Op��o 4");
				break;
			}
		}while(i!=4);
		
	}
	
}