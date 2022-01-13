package main;

import java.util.ArrayList;
import java.util.Scanner;

import celular.Chamadas;
import celular.Contatos;
import celular.RegistroContato;
import celular.RegistroNumero;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int escolha = 0;
		
		Contatos agendaContatos = new Contatos();
		Chamadas agendaChamadas = new Chamadas();
		
		do {
			mostrarMenu();
			escolha = key.nextInt();
			
			switch(escolha) {
				case 1: {
					chamaCadastroContato(agendaContatos, agendaChamadas, key);
					break;
				}
				case 2: {
					chamaExclusaoContato(agendaContatos, agendaChamadas, key);
					break;
				}
				case 3: {
					chamaCadastroChamada(agendaContatos.getContatos(), agendaChamadas, key);
					break;
				}
				case 4: {
					chamaListagemContatos(agendaContatos);
					break;
				}
				case 5: {
					chamaListagemChamadas(agendaChamadas);
					break;
				}
				case 6: {
					chamaExclusaoChamadas(agendaChamadas, key);
					break;
				}
				case 7: {
					System.out.println("Agenda encerrada.\nAté mais!");
				}
				default: break;
			}
		} while(escolha != 7);
		
	}
	
	public static void chamaCadastroContato(Contatos agendaContatos, Chamadas agendaChamadas, Scanner key) {		
		try {
			System.out.println("Informe o nome do novo Contato\n");
			String nome = key.next();
			
			System.out.println("Informe o número do novo Contato\n");
			String numero = key.next();
			
			RegistroContato novoContato = new RegistroContato(nome, numero);
			agendaContatos.adicionaNovoContato(novoContato);
			agendaChamadas.atualizaChamadas(novoContato);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void chamaExclusaoContato(Contatos agendaContatos, Chamadas agendaChamadas, Scanner key) {
		try {
			System.out.println("Informe o número ou nome do contato que você deseja excluir\n");
			String contato = key.next();
			
			RegistroContato contatoExcluido = agendaContatos.removeContato(contato);
			agendaChamadas.atualizaChamadas(new RegistroNumero(contatoExcluido.getNumero()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void chamaCadastroChamada(ArrayList<RegistroContato> contatos, Chamadas agendaChamadas, Scanner key) {
		try {
			System.out.println("Informe o número da nova Chamada não Atendida\n");
			String numero = key.next();
			
			RegistroNumero chamada = new RegistroNumero(numero);
			agendaChamadas.adicionaNovaChamada(contatos, chamada);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void chamaListagemContatos(Contatos agendaContatos) {
		try {
			System.out.println(agendaContatos.listaContatos());			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void chamaListagemChamadas(Chamadas agendaChamadas) {
		try {
			System.out.println(agendaChamadas.listaChamadas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void chamaExclusaoChamadas(Chamadas agendaChamadas, Scanner key) {
		try {
			System.out.println("Você tem certeja que deseja limpar sua caixa postal?\n[1] - Sim\n[2] - Não");
			int resposta = key.nextInt();
			if (resposta == 1) {
				agendaChamadas.deletarChamadas();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void mostrarMenu() {
		System.out.println(
				"\n[1] Cadastrar contato"
				+ "\n[2] Remover contato"
				+ "\n[3] Cadastrar chamada não atendida"
				+ "\n[4] Listar contatos cadastrados"
				+ "\n[5] Mostrar lista de chamadas não atendidas"
				+ "\n[6] Excluir todas as chamadas não atendidas"
				+ "\n[7] Sair"
				);
	}
}
