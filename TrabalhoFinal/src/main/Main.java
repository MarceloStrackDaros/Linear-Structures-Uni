package main;

import java.io.IOException;
import java.util.Scanner;

import enums.Sexo;
import pessoas.GerenciadorPessoas;
import pessoas.Pessoa;
import reader.Dados;
import formatters.MensagemDeErroFormatter;

public class Main {
	public static void main(String[] args) {
		iniciarPrograma();
	}
	
	public static void iniciarPrograma() {
		GerenciadorPessoas gp = new GerenciadorPessoas();
		int escolha = 0;
		try {
			Dados.leArquivo(gp);
		} catch (Exception e) {
			MensagemDeErroFormatter formatter = new MensagemDeErroFormatter();
			System.out.println(formatter.format(e.getMessage()));
		}
		
		do {
			mostraMenu();
			escolha = leEscolha();
			escolherOpcao(escolha, gp);
		} while (escolha != 3);
		
		
	}
	
	public static void mostraMenu() {
		System.out.println("\n***     MENU     ***");
		System.out.println("[1] - Inserir pessoa");
		System.out.println("[2] - Listar pessoas");
		System.out.println("[3] - Sair\n");
	}
	
	public static int leEscolha() {
		Scanner key = new Scanner(System.in);
		int escolha = key.nextInt();
		
		while(escolha < 1 || escolha > 3) {
			System.out.println("Selecione uma opcao valida.\n");
			escolha = key.nextInt();
		}
		
		return escolha;
	}
	
	public static void escolherOpcao(int escolha, GerenciadorPessoas gp) {
		try {
			switch(escolha) {
				case 1:
					Pessoa novaPessoa = adicionaPessoa();			
					gp.adicionaPessoa(novaPessoa);
					System.out.println("\nPessoa adicionada com sucesso!");
					break;
				case 2:
					System.out.println(gp.listaPessoas());
					break;
				case 3:
					System.out.println("Programa encerrado.");
					Dados.gravaArquivo(gp.getPessoas());
					break;
				default: break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Pessoa adicionaPessoa() throws IOException {
		Scanner key = new Scanner(System.in);
		
		System.out.println("\nInforme o nome da pessoa:");
		String nome = key.nextLine();
		
		System.out.println("\nInforme o sexo da pessoa:\n[1] - Feminino\n[2] - Masculino");
		int sexoEscolhido = key.nextInt();
		Sexo sexo = sexoEscolhido == 1 ? Sexo.FEMININO : Sexo.MASCULINO;
		
		System.out.println("\nInforme a idade da pessoa:");
		int idade = key.nextInt();	
		
		System.out.println("\nInforme o peso da pessoa:");
		String peso = key.next();
		if (peso.contains(",")) {
			peso = peso.replace(',', '.')	;	
		}
		double pesoFormatado = Double.parseDouble(peso);
		
		System.out.println("\nInforme a altura da pessoa (em metros):");
		String altura = key.next();
		if (altura.contains(",")) {
			altura = altura.replace(',', '.')	;	
		}
		double alturaFormatada = Double.parseDouble(altura);
		
		return new Pessoa(nome, sexo, idade, pesoFormatado, alturaFormatada);
	}
}
