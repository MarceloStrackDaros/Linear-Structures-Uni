package celular;

import java.util.ArrayList;
import java.util.Collections;

import enums.MensagensDeErro;
import formatters.MensagemErroFormatter;
import helpers.GerenciadorRegistro;
import helpers.ValidadorNumeroRegistro;
import comparators.ComparadorPorNome;

public class Contatos {
	private ArrayList<RegistroContato> contatos;
	
	public Contatos() {
		this.contatos = new ArrayList<RegistroContato>();
	}
	
	public ArrayList<RegistroContato> getContatos() {
		return this.contatos;
	}
	
	public void adicionaNovoContato(RegistroContato contato) throws Exception {
		if(!GerenciadorRegistro.registroEhValido(contato)) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.CONTATO_INVALIDO));
		}
		
		if(GerenciadorRegistro.registroJaEhContato(this.contatos, contato.getNumero(), true) != null) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.CONTATO_JA_CADASTRADO));
		}

		this.contatos.add(contato);
	}
	
	public RegistroContato removeContato(String contatoInfo) throws Exception {
		boolean ehNumeroValido = ValidadorNumeroRegistro.numeroEhValido(contatoInfo);
		
		if (GerenciadorRegistro.registroJaEhContato(this.contatos, contatoInfo, ehNumeroValido) == null) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.CONTATO_NAO_EXISTENTE));
		}
		
		RegistroContato contatoParaRemover = null;
		
		for(RegistroContato contato : this.contatos) {
			if ((ehNumeroValido && contato.getNumero().equals(contatoInfo))
				|| (!ehNumeroValido && contato.getNome().contentEquals(contatoInfo))) {
				contatoParaRemover = contato;
				break;
			}
		}
		
		this.contatos.remove(contatoParaRemover);
		return contatoParaRemover;
	}
	
	public String listaContatos() throws Exception {
		if (this.contatos.isEmpty()) {
			throw new Exception(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.LISTA_VAZIA));
		}
		
		Collections.sort(this.contatos, new ComparadorPorNome());
		String listaOrdenada = "\n______________________________\nCONTATOS\n";
		
		for(RegistroContato contato : this.contatos) {
			listaOrdenada += contato.toString();
		}
		
		listaOrdenada += "\n______________________________";
		
		return listaOrdenada;
	}
}
