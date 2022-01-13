package pessoas;

import java.util.ArrayList;
import java.util.List;

import constantes.MensagensDeErro;
import formatters.MensagemDeErroFormatter;

public class GerenciadorPessoas {
	private List<Pessoa> pessoas;
	private MensagemDeErroFormatter erroFormatter = new MensagemDeErroFormatter();
	
	public GerenciadorPessoas() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}
	
	public Pessoa adicionaPessoa(Pessoa pessoa) throws Exception {
		if (pessoa == null || !this.pessoaEhValida(pessoa)) {
			throw new Exception(erroFormatter.format(MensagensDeErro.OBJETO_INVALIDO));
		}
		
		this.pessoas.add(pessoa);
		return pessoa;
	}
	
	public String listaPessoas() throws Exception {
		if (this.getPessoas().isEmpty()) {
			throw new Exception(erroFormatter.format(MensagensDeErro.LISTA_VAZIA));
		}
		
		String pessoasToString = "\n___________________________";
		
		for (Pessoa pessoa : this.getPessoas()) {
			pessoasToString += pessoa.toString();
		}
		
		pessoasToString += "___________________________\n";
		return pessoasToString;
	}
	
	private boolean pessoaEhValida(Pessoa pessoa) {
		return (pessoa.getAltura() > 0
				&& pessoa.getIdade() > 0
				&& !pessoa.getNome().isEmpty()
				&& pessoa.getPeso() > 0
				&& pessoa.getSexo() != null);
	}

}
