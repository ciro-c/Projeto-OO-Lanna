package aplicacao;

// Imports usados

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// Imports das classes do projeto

import entidades.Despesas;
import entidades.Pessoa;
import restricoes.DadosPessoaisIncompletosException;
import restricoes.RendimentoInvalidoException;
import restricoes.DespesaInvalidaException;
import restricoes.CategoriaInvalidaException;
import restricoes.ValorDespesaInvalidaException;

// Main

public class Republica {
	
	public static String trocaVirgula(String frase) {
		StringBuilder stringBuilder = new StringBuilder(frase);
		if(frase.lastIndexOf(",")!=-1) {
        stringBuilder.insert(frase.lastIndexOf(",")+1, ".");
        stringBuilder.deleteCharAt(frase.lastIndexOf(","));
        return stringBuilder.toString();
        }else {
        	return frase;
        }
	}
		
	public static void main(String[] args) {
		
		// Variveis e Arraylists
		
		int i = 0; // Varavel de condio do menu principal
		int j = 0; // Varavel de condio das opes
		
		ArrayList<Pessoa> p = new ArrayList<Pessoa>(); // Coleo de objetos da classe Pessoa
		ArrayList<Despesas> list = new ArrayList<>();
		// Menu principal
		
		do {
		
			JOptionPane.showMessageDialog(null, "----------DIVISO DAS DESPESAS DE UMA REPBLICA----------\n\nOlá, o que pretende fazer?\n"
			+ "1) Cadastrar pessoa.\n2) Cadastrar despesa.\n3) Despesas cadastradas.\n4) Pessoas cadastradas. \n5) Gerar relatorio\n6) Sair do Programa");
			String respostaOpcao = JOptionPane.showInputDialog("Digite o nº da opção desejada");
			int rO = Integer.parseInt(respostaOpcao);
			i = rO ;
			
			// Opes
			
			switch(rO) {

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
																
								if ((nomePessoa == null || nomePessoa.isEmpty()) ||
								    (emailPessoa == null || emailPessoa.isEmpty()) ||
								    (rendimentoPessoa == null || rendimentoPessoa.isEmpty())) 
								{
									
									throw new DadosPessoaisIncompletosException("Alguns dados não foram inseridos.");
								
								}else if(Double.parseDouble(rendimentoPessoa) < 0) 
								{
									throw new RendimentoInvalidoException("Não é possível inserir valores negativos.");
								
								}else if(!rendimentoPessoa.matches("^(\\d+(\\.\\d{0,2})?|\\.?\\d{1,2})$"))
								{
								
									throw new NumberFormatException("Não é possível inserir caracteres especiais ou letras.");
								
								}else {
									p.add(new Pessoa(nomePessoa, emailPessoa, rendimentoPessoa));
									JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
									JOptionPane.showMessageDialog(null, "Número de cadastros efetuados: " +p.size());
									cadastroUm = true;
								}

		
							}catch(DadosPessoaisIncompletosException | RendimentoInvalidoException e) {
								String msg = e.getMessage() + " Exceção capturada!";
								JOptionPane.showMessageDialog(null, msg);
								e.printStackTrace();
							}catch(NumberFormatException e) {
								String msg = e.getMessage() + " Exceção capturada!";
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
				
	
				case 2:
					String descricaoSubcategoria = "";
					String registro = JOptionPane.showInputDialog("Digite a quantidade de despesas existentes: "); 
					int k = Integer.parseInt(registro);

					
					for(int m=0; m<k; m++) {
						
						JOptionPane.showMessageDialog(null, "Despesa #" + (m+1) + ": ");
						String descricaoDespesa = JOptionPane.showInputDialog("Nome da despesa: Ex.(CAESB, CEB, Net..)");
						String descricaoCategoria = JOptionPane.showInputDialog("Digite o nome da categoria. Ex.(Água, Luz, Telefonia e comunicações..)");
						String valor = JOptionPane.showInputDialog("Digite o valor da despesa: "); 
						double val = Double.parseDouble(valor);
						int sub = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma subcategoria?", "Continua", JOptionPane.YES_NO_OPTION);
											
						if(sub == JOptionPane.YES_OPTION) {
							descricaoSubcategoria = JOptionPane.showInputDialog("Digite o nome da subcategoria relacionada a despesa.");
						}
						try {
							
							if ((descricaoDespesa == null || descricaoDespesa.isEmpty()) || (valor == null ||valor.isEmpty())) {
								
								throw new DespesaInvalidaException("Alguns dados nao foram inseridos na despesa.");
							
							}else if(Integer.parseInt(valor) < 0) {
							
								throw new ValorDespesaInvalidaException("No  possvel inserir valores negativos.");
							
							}else if ( (descricaoCategoria == null || descricaoCategoria.isEmpty()) ) {
							
								throw new CategoriaInvalidaException("Nome da categoria nao inserido");
							
							}else {
							
								list.add(new Despesas(descricaoDespesa,val));
								int ultimaDespesa = list.size()-1;
								list.get(ultimaDespesa).cadastrarCategoria(descricaoCategoria);
								list.get(ultimaDespesa).categoria.cadastrarSubcategoria(descricaoSubcategoria);
								JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
								JOptionPane.showMessageDialog(null, "Nmero de cadastros efetuados: " +list.size());
							}
							
						} catch( ValorDespesaInvalidaException | DespesaInvalidaException | CategoriaInvalidaException e) {
							String msg = e.getMessage() + " Exceo capturada!";
							JOptionPane.showMessageDialog(null, msg);
							e.printStackTrace();
						}
					}
				break;

				case 3:
					JOptionPane.showMessageDialog(null, "Quantidade de despesas cadastradas:" + list.size());
					String desp = JOptionPane.showInputDialog("Digite a despesa que deseja procurar: "); 
					
					
					/*Object[] itens = {};
					for(int n=0; i<list.size(); i++) {
						itens.add();
					} 
					
					Object selectedValue = JOptionPane.showInputDialog(null, "Escolha um item", "Opçao", JOptionPane.INFORMATION_MESSAGE, null,
					itens, itens [0]); //}*/

					
				break;
				case 4:
					JOptionPane.showMessageDialog(null, "Quantidade de despesas cadastradas:" + p.size());
				break;
				
				case 5:
					ArrayList<String> nomePessoa = new ArrayList<String>();
					ArrayList<Double> rendaPessoa = new ArrayList<Double>();
					Calendar calendario =  Calendar.getInstance();
					JOptionPane.showMessageDialog(null, "Gerar relatorio");
										
					int mesRelatorio = calendario.get(Calendar.MONTH);
					int anoRelatorio = calendario.get(Calendar.YEAR);
					String nomeDespesas = "despesas";
					double somaDespesas = 0.0;
					double somaRenda = 0.0;
					
					nomeDespesas = nomeDespesas +"_"+ mesRelatorio +"_"+ anoRelatorio +".txt";
					
					
					try {
						
					      
						File arquivoDespesas = new File(nomeDespesas);
						File arquivoAlunos = new File("alunos.txt");
						
						if (!arquivoAlunos.exists()) {
							JOptionPane.showMessageDialog(null, "Por Favor cadastre uma pessoa antes.");
							break;
						}else if(!arquivoDespesas.exists()) {
							JOptionPane.showMessageDialog(null, "Por Favor cadastre uma despesa antes.");
							break;
						}else {
		
							Scanner leitorAlunos = new Scanner(arquivoAlunos);
						      while (leitorAlunos.hasNextLine()) {
						    	
						        String infoAlunos = leitorAlunos.nextLine();
						        System.out.println(infoAlunos);
						        nomePessoa.add(infoAlunos.substring(0,infoAlunos.indexOf(";")));
						        String temp = infoAlunos.substring(infoAlunos.lastIndexOf(";")+1);
						        temp = trocaVirgula(temp);
						        rendaPessoa.add(Double.parseDouble(temp));
						        somaRenda = somaRenda + Double.parseDouble(temp);
						      }
						      leitorAlunos.close();

						      Scanner leitorDespesas = new Scanner(arquivoDespesas);
						      while (leitorDespesas.hasNextLine()) {
						        String infoDespesas = leitorDespesas.nextLine();
						        String temp = infoDespesas.substring(infoDespesas.lastIndexOf(";")+1);
						        somaDespesas = somaDespesas + Double.parseDouble(trocaVirgula(temp));
						      }
						      leitorDespesas.close();
						      
						}
					    
					    
					}catch( IOException e) {
						System.out.println("An error occurred.");	
						e.printStackTrace();
					}
					
					String tipoRelatorio = JOptionPane.showInputDialog("Quer gerar um relatorio com regra:\n 1)Igualitaria\n 2)Proporcional ");
					double resultado;
					int controle = 0;
					DecimalFormat decimal = new DecimalFormat("#.##");
					decimal.setRoundingMode(RoundingMode.UP);
					if(Integer.parseInt(tipoRelatorio) == 1) {
						System.out.println(nomePessoa.size());
					resultado = (double)	somaDespesas/nomePessoa.size();
					JOptionPane.showMessageDialog(null, "Cada pessoa tem que pagar R$ "+ decimal.format(resultado));
						
					}else if(Integer.parseInt(tipoRelatorio) == 2) {
					while(controle < nomePessoa.size()) {
						resultado = somaDespesas*rendaPessoa.get(controle)/somaRenda;
						JOptionPane.showMessageDialog(null,nomePessoa.get(controle) +" vai pagar R$ "+decimal.format(resultado)+"\n Pagina "+(controle+1)+ "/"+nomePessoa.size() );
						controle++;
					}	
						
					}else {
						JOptionPane.showMessageDialog(null, "Voltando ao menu");
					}
					
				break;
				
				case 6:
					JOptionPane.showMessageDialog(null, "Encerrando o programa...");
				break;
			}
		}while(i!=6);
		
		/*public static boolean hasDespesa(List<Despesas> list, String descricaoDespesa) {
			Despesas empl = list.stream().filter(x -> x.getDescricaoDespesas() == descricaoDespesas).findFirst().orElse(null));
			return empl != null;
		}*/
	}
	
}