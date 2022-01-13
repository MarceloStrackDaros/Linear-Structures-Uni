package celular;

import java.util.ArrayList;

import enums.MensagensDeErro;
import formatters.MensagemErroFormatter;
import helpers.GerenciadorRegistro;

public class Chamadas {
	private ArrayList<RegistroNumero> chamadas;
	
	public Chamadas() {
		this.chamadas = new ArrayList<RegistroNumero>();
	}
	
	public ArrayList<RegistroNumero> getChamadas() {
		return this.chamadas;
	}
	
	public void adicionaNovaChamada(ArrayList<RegistroContato> contatos, RegistroNumero chamada) throws Exception {
		if (!GerenciadorRegistro.registroEhValido(chamada)) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.REGISTRO_INVALIDO));
		}
		
		RegistroContato registro = GerenciadorRegistro.registroJaEhContato(contatos, chamada.getNumero(), true);

		if (registro != null) {
			this.chamadas.add(registro);
		} else {
			this.chamadas.add(chamada);
		}
	}
	
	public void deletarChamadas() throws Exception {
		if(this.chamadas.size() == 0) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.LISTA_VAZIA));
		}
		
		this.chamadas = new ArrayList<RegistroNumero>();
	}
	
	public void atualizaChamadas(RegistroNumero registroAtualizado) {
		for(RegistroNumero registro : this.chamadas) {
			if (registro.getNumero().contentEquals(registroAtualizado.getNumero())) {
				RegistroNumero novoRegistro = null;
				int index = this.chamadas.indexOf(registro);		
				
				if (GerenciadorRegistro.tipoRegistroEhContato(registroAtualizado)) {
					RegistroContato novoRegistroContato = (RegistroContato) registroAtualizado;
					novoRegistro = new RegistroContato(novoRegistroContato.getNome(), novoRegistroContato.getNumero());
				} else {
					novoRegistro = new RegistroNumero(registroAtualizado.getNumero());
				}
				
				this.chamadas.set(index, novoRegistro);		
			}
		}
	}
	
	public String listaChamadas() throws Exception {
		if (this.chamadas.isEmpty()) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.LISTA_VAZIA));
		}
		String chamadasToString = "\n______________________________\nCHAMADAS NÃO ATENDIDAS\n";
		
		for (RegistroNumero registro : this.chamadas) {
			if (GerenciadorRegistro.tipoRegistroEhContato(registro)) {
				RegistroContato registroContato = (RegistroContato) registro;
				chamadasToString += registroContato.toString();
			} else {
				chamadasToString += registro.toString();
			}
		}
		
		chamadasToString += "\n______________________________";
		return chamadasToString;
	}
	
}
