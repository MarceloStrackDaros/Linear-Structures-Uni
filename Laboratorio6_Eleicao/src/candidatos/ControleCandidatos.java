package candidatos;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import comparators.*;
import consts.MensagensDeErro;
import enums.TipoOrdenacao;
import formatters.MensagemDeErroFormatter;
import validators.CandidatoValidator;

public class ControleCandidatos {

	private List<Candidato> candidatos;
	private Comparator<Candidato> comparadorIdadeAsc;
	private Comparator<Candidato> comparadorIdadeDesc;
	private Comparator<Candidato> comparadorVotoAsc;
	private Comparator<Candidato> comparadorVotoDesc;
	private Comparator<Candidato> comparadorPartidoAsc;
	private Comparator<Candidato> comparadorPartidoDesc;
	private Comparator<Candidato> comparadorNomeAsc;
	private Comparator<Candidato> comparadorNomeDesc;
	
	public ControleCandidatos() {
		this.candidatos = new ArrayList<Candidato>();
		this.comparadorIdadeAsc = new ComparadorIdadeAsc();
		this.comparadorIdadeDesc = new ComparadorIdadeDesc();
		this.comparadorVotoAsc = new ComparadorVotosAsc();
		this.comparadorVotoDesc = new ComparadorVotosDesc();
		this.comparadorNomeAsc = new ComparadorNomeAsc();
		this.comparadorNomeDesc = new ComparadorNomeDesc();
		this.comparadorPartidoAsc = new ComparadorPartidoAsc();
		this.comparadorPartidoDesc = new ComparadorPartidoDesc();
	}
	
	public List<Candidato> getListaCandidatos() {
		return this.candidatos;
	}
	
	public void adicionaCandidato(Candidato candidato) throws Exception {
		if (!CandidatoValidator.candidatoEhValido(candidato)) {
			throw new Exception(MensagemDeErroFormatter.formatToMensagemDeErro(MensagensDeErro.CANDIDATO_INVALIDO));
		}
		
		this.candidatos.add(candidato);
	}
	
	public void adicionaCandidatos(Candidato...candidatos) throws Exception {
		for (Candidato candidato : candidatos) {
			if (!CandidatoValidator.candidatoEhValido(candidato)) {
				throw new Exception(MensagemDeErroFormatter.formatToMensagemDeErro(MensagensDeErro.CANDIDATO_INVALIDO));
			}
			
			this.candidatos.add(candidato);
		}
	}

	public String ordenaCandidatos(TipoOrdenacao tipoOrdenacao) throws Exception {
		if (this.candidatos.isEmpty()) {
			throw new Exception(MensagemDeErroFormatter.formatToMensagemDeErro(MensagensDeErro.LISTA_VAZIA));
		}
		
		Comparator<Candidato> comparadorSelecionado = this.getComparator(tipoOrdenacao);		
		Collections.sort(this.candidatos, comparadorSelecionado);
		
		String listaOrdenada = "";
		
		for (Candidato candidato : this.candidatos) {
			listaOrdenada += candidato.toString();
		}
		return listaOrdenada;
	}
	
	private Comparator<Candidato> getComparator(TipoOrdenacao tipoOrdenacao) throws Exception {
		switch(tipoOrdenacao) {
			case IDADE_ASC:
				return this.comparadorIdadeAsc;
			case IDADE_DESC:
				return this.comparadorIdadeDesc;
			case VOTO_ASC:
				return this.comparadorVotoAsc;
			case VOTO_DESC:
				return this.comparadorVotoDesc;
			case PARTIDO_ASC:
				return this.comparadorPartidoAsc;
			case PARTIDO_DESC:
				return this.comparadorPartidoDesc;
			case NOME_ASC:
				return this.comparadorNomeAsc;
			case NOME_DESC:
				return this.comparadorNomeDesc;
			default:
				throw new Exception(MensagemDeErroFormatter.formatToMensagemDeErro(MensagensDeErro.TIPO_ORDENACAO_NAO_EXISTE));
		}
	}
}