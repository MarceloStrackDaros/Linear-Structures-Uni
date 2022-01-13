package helpers;

import java.util.ArrayList;

import celular.RegistroNumero;
import celular.RegistroContato;

public class GerenciadorRegistro {
	private static RegistroNumero registroContato = new RegistroContato("", "");
	
	public static boolean registroEhValido(RegistroNumero contato) {
		boolean numeroEhValido = ValidadorNumeroRegistro.numeroEhValido(contato.getNumero());
				
		if (!tipoRegistroEhContato(contato)) {
			return numeroEhValido;
		}
		
		if (tipoRegistroEhContato(contato)) {
			RegistroContato contatoToRegistroContato = (RegistroContato) contato;
			return numeroEhValido && contatoToRegistroContato.getNome() != null && !contatoToRegistroContato.getNome().isEmpty();
		}
		
		return false;
	}
	
	public static boolean tipoRegistroEhContato(RegistroNumero registro) {
		return registro.getClass().equals(registroContato.getClass());
	}
		
	public static RegistroContato registroJaEhContato(ArrayList<RegistroContato> contatos, String contatoInfo, boolean isNumero) {
		
		RegistroContato contatoResultado = null;
		
		for(RegistroContato contato : contatos) {
			if ((isNumero && contato.getNumero().equals(contatoInfo))
				|| (!isNumero && contato.getNome().contentEquals(contatoInfo))) {
				contatoResultado = contato;
				break;
			}
			
		}
		
		return contatoResultado;
	}
}
