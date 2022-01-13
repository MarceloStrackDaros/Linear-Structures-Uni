package votacao;

import java.util.Scanner;
import candidatos.Candidato;
import enums.TipoOrdenacao;

public class Menu {

	private Scanner key;
	private ControleVotacao votacao;
	
	public Menu() {
		this.key = new Scanner(System.in);
		this.votacao = new ControleVotacao();
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("Bem vindo(a) �s elei��es!");
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public void iniciarEleicoes(Candidato...candidatos) {
		this.votacao.adicionaCandidatos(candidatos);
		int escolha = 0;
		
		do {
			this.mostrarOpcoes();	
			escolha = this.verificaEscolha();
			this.escolherOpcao(escolha);
		} while (escolha != 8);
	}
	
	public void mostrarOpcoes() {
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("De acordo com o menu abaixo, digite o n�mero do que deseja fazer:");
		System.out.println("\n1 - Votar em um candidato");
		System.out.println("2 - Listar candidatos em ordem de idade crescente");
		System.out.println("3 - Listar candidatos em ordem de idade decrescente.");
		System.out.println("4 - Listar candidatos em ordem de votos crescente.");
		System.out.println("5 - Listar candidatos em ordem de votos decrescente.");
		System.out.println("6 - Mostrar total de votos computados.");
		System.out.println("7 - Mostrar m�dia de vota��o recebida pelos candidatos.");
		System.out.println("8 - Encerrar vota��o.");
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public int verificaEscolha() {
		int digito = key.nextInt();
		while (digito < 1 || digito > 8) {
			System.out.println("Por favor, digite um n�mero v�lido");
			digito = key.nextInt();
		}
		return digito;
	}
	
	public void escolherOpcao(int escolha) {
		
		switch (escolha) {
		
			case 1: {
				System.out.println("Informe o candidato que deseja votar (pelo c�digo):\n");
				String candidato = key.next();
				
				try {
					this.votacao.adicionaVoto(candidato);	
					System.out.println("\nVoto contabilizado com sucesso!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				
				this.votacao.imprimeListaOrdenada(TipoOrdenacao.IDADE_ASC);
				break;
			}
			case 3: {
				this.votacao.imprimeListaOrdenada(TipoOrdenacao.IDADE_DESC);
				break;
			}
			case 4: {
				this.votacao.imprimeListaOrdenada(TipoOrdenacao.VOTO_ASC);
				break;
			}
			case 5: {
				this.votacao.imprimeListaOrdenada(TipoOrdenacao.VOTO_DESC);
				break;
			}
			case 6: {
				System.out.println("\nTOTAL DE VOTOS: " + this.votacao.getNumVotosTotais());
				break;
			}
			case 7: {
				System.out.println("\nM�DIA GERAL DE VOTOS: " + this.votacao.calculaMediaVotacaoPorCandidato());
				break;
			}
			case 8: {
				System.out.println("Vota��o encerrada");
				this.votacao.imprimeListaOrdenada(TipoOrdenacao.VOTO_DESC);
			}
			default: break;
		}
	}
}