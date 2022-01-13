package candidatos;

import formatters.CandidatoToStringFormatter;

public class Candidato {

	private String nome;
	private int idade;
	private String partido;
	private int numVotos;
	private String numeroCandidato;
	
	public Candidato(String nome, int idade, String partido, String numeroCandidato) {
		this.nome = nome;
		this.setIdade(idade);
		this.setPartido(partido);
		this.numVotos = 0;
		this.numeroCandidato = numeroCandidato;
	}

	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getNumVotos() {
		return numVotos;
	}

	public void incrementaNumVotos() {
		this.numVotos++;
	}
	
	public String getNumeroCandidato() {
		return this.numeroCandidato;
	}
	
	@Override
	public String toString() {
		String candidato = "CODIGO: " + this.getNumeroCandidato()
			+ "\nNOME: " + this.getNome()
			+ "\nPARTIDO: " + this.getPartido()
			+ "\nIDADE: " + this.getIdade()
			+ "\nVOTOS: " + this.getNumVotos();
		
		CandidatoToStringFormatter formatter = new CandidatoToStringFormatter();
		
		return formatter.format(candidato);
	}

}