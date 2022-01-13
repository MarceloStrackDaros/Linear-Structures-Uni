package menu;

import java.util.Scanner;
import classes.Paciente;
import classes.Vacinacao;
import exceptions.NumeroPacientesInvalidoException;
import helpers.VerificacaoDeDigitos;

public class Menu {

	private Vacinacao vacinacao;
	private Scanner key;
	
	public Menu() {
		this.vacinacao = new Vacinacao();
		this.key = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Bem-vindo ao processo de vacinação!");
		System.out.println("A seguir os 10 primeiros pacientes serão adicionados na fila de vacinação.");
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public void iniciarProcessoVacinacao(Paciente...pacientes) {
		vacinacao.mostraPacientesAdicionados(vacinacao.adicionaPacientesNaoVacinados(pacientes));
		this.opcoes();
	}
	
	public void opcoes() {
		
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("De acordo com o menu abaixo, digite o número do que deseja fazer:");
		System.out.println("\n1 - Ver fila de pacientes não vacinados.");
		System.out.println("2 - Ver lista de pacientes já vacinados.");
		System.out.println("3 - Adicionar pacientes não vacinados na fila de vacinação.");
		System.out.println("4 - Aplicar vacina(s).");
		System.out.println("5 - Encerrar processo.");
		System.out.println("----------------------------------------------------------------\n");
		
		int digito = VerificacaoDeDigitos.validarDigito(0);
		this.escolherOpcoes(digito);			
	}
	
	public void escolherOpcoes(int numero) {
		
		int numPacientes = 0;
		int digito = 0;
		
		switch (numero) {
			
			case 1: {
				try {
					vacinacao.imprimeFilaNaoVacinados();
				} catch (NumeroPacientesInvalidoException e) {
					System.out.println(e.getMessage());				
				}
				break;
			}
			case 2: {
				try {
					vacinacao.imprimeListaVacinados();;
				} catch (NumeroPacientesInvalidoException e) {
					System.out.println(e.getMessage());					
				}
				break;
			}
			case 3: {
				vacinacao.mostraPacientesAdicionados(vacinacao.adicionaPacientesNaoVacinados());
				break;
			}
			case 4: {
				boolean validacao = false;
				do { 
					try {
						vacinacao.aplicaVacinas();
						validacao = true;
					} catch (NumeroPacientesInvalidoException e) {
						System.out.println(e.getMessage());
					}
				} while (!validacao);
				break;
			}
			case 5: {
				
				numPacientes = vacinacao.getTamanhoFilaNaoVacinados();
				
				if (numPacientes != 0) {
					System.out.printf("\nA fila de pacientes esperando pela vacina ainda contém %d pessoa(s).\nDigite 1 se deseja cancelar o processo de vacinação mesmo assim ou 0 para retomar o processo.", numPacientes);
					digito = VerificacaoDeDigitos.validarDigito(2);
					if (digito == 1) {
						System.out.printf("Processo de vacinação encerrado, obrigado por utilizar o nosso sistema!");
					}
				}
				else {
					System.out.printf("Obrigado por utilizar o processo de vacinação! Todos os pacientes foram vacinados.");
					digito = 1;
				}
				break;
			}
			default: break;
		}
		
		if (digito == 0) {
			this.opcoes();
		}
	}

}