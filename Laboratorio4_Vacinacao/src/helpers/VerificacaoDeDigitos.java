package helpers;

import java.util.Scanner;
import exceptions.DigitoInvalidoException;

public abstract class VerificacaoDeDigitos {
	
	private static int digito = 0;
	
	public static int validarDigito(int numero) {

		Scanner key = new Scanner(System.in);
		boolean validacao = false;
		
		do {
			try {
				digito = key.nextInt();
				digito = verificarDigito(numero);
				validacao = true;
			} catch (DigitoInvalidoException e) {
				System.out.print(e.getMessage());
			}
		} while (!validacao);
		return digito;
	}

	public static int verificarDigito(int escolha) throws DigitoInvalidoException {

		switch (escolha) {
				
			case 0: { // método opções em Menu
				if (digito < 1 || digito > 5) {
					throw new DigitoInvalidoException("Erro: por favor, digite um número válido.\n");
				}
				break;
			}
			case 1: { // método adicionaPacientesNaoVacinados() em Vacinacao -> verifica a idade inserida
				if (digito == 0 || digito < 0) {
					throw new DigitoInvalidoException("Erro: número inválido, tente novamente.");
				}
				break;				
			}
			case 2: { // método escolherOpcoes() em Menu
				if (digito != 0 && digito != 1) {
					throw new DigitoInvalidoException("Erro: por favor, digite um número válido.");
				}
				break;
			}
			case 3: { // outros casos que necessitam dígito > 1
				if (digito == 0 || digito < 0) {
					throw new DigitoInvalidoException("Erro: número inválido, tente novamente.");
				}
				break;	
			}
			default: break;
		}
		return digito;
	}
}