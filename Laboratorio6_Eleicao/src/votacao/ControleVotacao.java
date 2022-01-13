package votacao;

import candidatos.*;
import consts.MensagensDeErro;
import enums.TipoOrdenacao;
import formatters.MensagemDeErroFormatter;
import validators.CandidatoValidator;

public class ControleVotacao {

	private int numVotosTotais;
	protected ControleCandidatos controleCandidatos;
	
	public ControleVotacao() {
		this.controleCandidatos = new ControleCandidatos();
	}
	
	public int getNumVotosTotais() {
		return this.numVotosTotais;
	}
	
	public ControleCandidatos getControleCandidatos() {
		return this.controleCandidatos;
	}
	
	public void adicionaCandidatos(Candidato...candidatos) {
		try {
			this.controleCandidatos.adicionaCandidatos(candidatos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionaVoto(String numeroCandidato) throws Exception {
		Candidato candidato = this.getCandidatoPeloCodigo(numeroCandidato);
		
		if (!this.controleCandidatos.getListaCandidatos().contains(candidato)) {
			throw new Exception(MensagemDeErroFormatter.formatToMensagemDeErro(MensagensDeErro.CANDIDATO_INVALIDO));
		}
		for (Candidato c : this.controleCandidatos.getListaCandidatos()) {
			if (c.equals(candidato)) {
				c.incrementaNumVotos();
				this.numVotosTotais++;
				break;
			}
		}
	}
	
	private Candidato getCandidatoPeloCodigo(String numeroCandidato) {
		Candidato candidato = null;
		
		for (Candidato c : this.controleCandidatos.getListaCandidatos()) {
			if (c.getNumeroCandidato().equals(numeroCandidato)) {
				candidato = c;
				break;
			}
		}
		
		return candidato;
	}

	public double calculaMediaVotacaoPorCandidato() {
		return this.numVotosTotais / this.controleCandidatos.getListaCandidatos().size();
	}
	
	public void imprimeListaOrdenada(TipoOrdenacao ordenacao) {
		
		String listaOrdenada = "";
		try {
			listaOrdenada = this.controleCandidatos.ordenaCandidatos(ordenacao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(listaOrdenada);
	}
}