package aplicacao;

// Imports usados

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

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
		
		// Variveis e Arraylists
		
		int i = 0; // Varavel de condio do menu principal
		int j = 0; // Varavel de condio das opes
		
		ArrayList<Pessoa> p = new ArrayList<Pessoa>(); // Coleo de objetos da classe Pessoa
		
		// Menu principal
		
		do {
		
			JOptionPane.showMessageDialog(null, "----------DIVISO DAS DESPESAS DE UMA REPBLICA----------\n\nOl, o que pretende fazer?\n"
			+ "1) Cadastrar pessoa...\n2) Cadastrar despesa...\n3) Cadastrar categoria...\n4) Sair do programa...");
			String respostaOpcao = JOptionPane.showInputDialog("Digite o nº da opção desejada");
			int rO = Integer.parseInt(respostaOpcao);
			i = rO ;
			
			// Opes
			
			switch(rO) {
				// Cadastrar pessoa
				case 1:
					
					boolean cadastroUm;
					
					cadastroUm = false;
					
					do {
						do {
							
							JOptionPane.showMessageDialog(null, "CADASTRAR PESSOA");
							JOptionPane.showMessageDialog(null, "Por favor, informe os dados a seguir...");
							String nomePessoa = JOptionPane.showInputDialog("Nome completo da pessoa: ");
							String emailPessoa = JOptionPane.showInputDialog("Email completo da pessoa: ");
							String rendimentoPessoa = JOptionPane.showInputDialog("Rendimento da pessoa: "); 
								
							try {
								
								p.add(new Pessoa(nomePessoa, emailPessoa, rendimentoPessoa));
								
								int ultimoObjeto = p.size()-1;
								
								if ((nomePessoa == null || nomePessoa.isEmpty()) || (emailPessoa == null || emailPessoa.isEmpty())|| (rendimentoPessoa == null ||
								rendimentoPessoa.isEmpty())) {
									p.remove(ultimoObjeto);
									throw new DadosPessoaisIncompletosException("Alguns dados no foram inseridos.");
								}else if(Integer.parseInt(rendimentoPessoa) < 0) {
									p.remove(ultimoObjeto);
									throw new RendimentoInvalidoException("No  possvel inserir valores negativos.");
								}else {
									JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
									JOptionPane.showMessageDialog(null, "Nmero de cadastros efetuados: " +p.size());
									cadastroUm = true;
								}
		
							}catch(DadosPessoaisIncompletosException | RendimentoInvalidoException e) {
								String msg = e.getMessage() + " Exceo capturada!";
								JOptionPane.showMessageDialog(null, msg);
								e.printStackTrace();
							}
						
						}while(cadastroUm == false);
						
						String opcaoNova = JOptionPane.showInputDialog("Deseja cadastrar outra pessoa ou retornar ao menu "
						+ "principal?\n\n1) Cadadastrar outra pessoa...\n2) Retornar ao menu principal...");
						int oN = Integer.parseInt(opcaoNova);
						j = oN;
					
					}while(j==1);
							
				break;
				
				// Cadastrar despesa	
				case 2:
					List<Despesas> list = new ArrayList<>();
						
					String registro = JOptionPane.showInputDialog("Digite a quantidade de despesas existentes: "); 
					int k = Integer.parseInt(registro);
					
					for(int m=0; m<k; m++) {
						JOptionPane.showMessageDialog(null, "Despesa #" + (m+1) + ": ");
						String descricaoDespesa = JOptionPane.showInputDialog("Nome da despesa: Ex.(CAESB, CEB, Net..)");
						String descricaoCategoria = JOptionPane.showInputDialog("Digite o nome da categoria. Ex.(Água, Luz, Telefonia e comunicações..)");
						int sub = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma subcategoria?", "Continua", JOptionPane.YES_NO_OPTION);
						
						if(sub == JOptionPane.YES_OPTION) {
							String descricaoSubcategoria = JOptionPane.showInputDialog("Digite o nome da subcategoria relacionada a despesa.");
						}
						
						String valor = JOptionPane.showInputDialog("Digite o valor da despesa: "); 
						int val = Integer.parseInt(valor);
					}
				break;
				// Cadastrar categoria
				case 3:
					JOptionPane.showMessageDialog(null, "Opo 3");
				break;
				// Sair do programa
				case 4:
					JOptionPane.showMessageDialog(null, "Encerrando o programa...");
				break;
			}
		}while(i!=4);
		
	}
	
}