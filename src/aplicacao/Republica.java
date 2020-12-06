package aplicacao;

// Imports usados

import javax.swing.JOptionPane;
import java.util.ArrayList;

// Imports das classes do projeto

import entidades.Despesas;
import entidades.Pessoa;
import entidades.Categoria;
import restricoes.DadosPessoaisIncompletosException;
import entidades.Subcategoria;
import restricoes.RendimentoInvalidoException;

// Main

public class Republica {
	
	public static void main(String[] args) {
		
		// Vari�veis e Arraylists
		
		int i = 0; // Var�avel de condi��o do menu principal
		int j = 0; // Var�avel de condi��o das op��es
		
		ArrayList<Pessoa> p = new ArrayList<Pessoa>(); // Cole��o de objetos da classe Pessoa
		
		// Menu principal
		
		do {
		
			JOptionPane.showMessageDialog(null, "----------DIVIS�O DAS DESPESAS DE UMA REP�BLICA----------\n\nOl�, o que pretende fazer?\n"
			+ "1) Cadastrar pessoa...\n2) Cadastrar despesa...\n3) Cadastrar categoria...\n4) Sair do programa...");
			String respostaOpcao = JOptionPane.showInputDialog("");
			int rO = Integer.parseInt(respostaOpcao);
			i = rO ;
			
			// Op��es
			
			switch(rO) {
				// Cadastrar pessoa
				case 1:
					
					boolean cadastro;
					
					cadastro = false;
					
					do {
					do {
						
						JOptionPane.showMessageDialog(null, "CADASTRAR PESSOA");
						JOptionPane.showMessageDialog(null, "Por favor, informe os dados a seguir...");
						String nomePessoa = JOptionPane.showInputDialog("Nome completo da pessoa: ");
						String emailPessoa = JOptionPane.showInputDialog("Email completo da pessoa: ");
						String rendimentoPessoa = JOptionPane.showInputDialog("Rendimento da pessoa: "); 
						double rP = Double.parseDouble(rendimentoPessoa);
							
						try {
							
							p.add(new Pessoa(nomePessoa, emailPessoa, rP));
							
							int ultimoObjeto = p.size()-1;
							
							if ((nomePessoa == null || nomePessoa.isEmpty())||(emailPessoa == null || emailPessoa.isEmpty())|| (rendimentoPessoa == null ||
							rendimentoPessoa.isEmpty())) {
								p.remove(ultimoObjeto);
								throw new DadosPessoaisIncompletosException("Alguns dados n�o foram inseridos.");
							}else if(rP < 0) {
								p.remove(ultimoObjeto);
								throw new RendimentoInvalidoException("N�o � poss�vel inserir valores negativos.");
							}else {
								JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
								JOptionPane.showMessageDialog(null, "N�mero de cadastros efetuados: " +p.size());
								cadastro = true;
							}
	
						}catch(DadosPessoaisIncompletosException | RendimentoInvalidoException e) {
							String msg = e.getMessage() + " Exce��o capturada!";
							JOptionPane.showMessageDialog(null, msg);
							e.printStackTrace();
						}
					
					}while(cadastro==false);
					
					String opcaoNova = JOptionPane.showInputDialog("Deseja cadastrar outra pessoa ou retornar ao menu "
					+ "principal?\n\n1) Cadadastrar outra pessoa...\n2) Retornar ao menu principal...");
					int oN = Integer.parseInt(opcaoNova);
					j = oN;
					
					}while(j==1);
							
				break;
					
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
					JOptionPane.showMessageDialog(null, "Encerrando o programa...");
				break;
			}
		}while(i!=4);
		
	}
	
}