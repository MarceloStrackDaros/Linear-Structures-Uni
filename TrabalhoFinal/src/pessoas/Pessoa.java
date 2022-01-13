package pessoas;

import constantes.FaixasPeso;
import enums.Sexo;
import formatters.PessoaToStringFormatter;
import helpers.CalculosMedidaCerta;

public class Pessoa {
	private static long codigo;
	private long codigoPessoa;
	private String nome;
	private Sexo sexo;
	private int idade;
	private double peso;
	private double altura;
	private double IMC;
	private double pesoIdeal;
	private double taxaDeGorduraCorporal;
	private String classificacaoIMC;
	
	public Pessoa(String nome, Sexo sexo, int idade, double peso, double altura) {
		codigo++;
		this.codigoPessoa = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		this.setResultadosCalculosMedidaCerta();
		this.setClassificacaoIMC();
	}

	public long getCodigoPessoa() {
		return this.codigoPessoa;
	}

	public void setCodigoPessoa(long codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getIMC() {
		return this.IMC;
	}
	
	public double getPesoIdeal() {
		return this.pesoIdeal;
	}
	
	public double getTaxaDeGorduraCorporal() {
		return this.taxaDeGorduraCorporal;
	}
	
	public void setResultadosCalculosMedidaCerta() {
		double[] resultados = CalculosMedidaCerta.chamaCalculos(this);
		
		this.IMC = resultados[0];
		this.taxaDeGorduraCorporal = resultados[1];
		this.pesoIdeal = resultados[2];
	}
	
	public void setClassificacaoIMC() {
		double IMC = this.getIMC();
		double minimo = 0;
		double maximo = 0;
		
		switch(this.getSexo()) {
			case FEMININO:
				minimo = FaixasPeso.M_MINIMO;
				maximo = FaixasPeso.M_MAXIMO;
				break;
			case MASCULINO:
				minimo = FaixasPeso.H_MINIMO;
				maximo = FaixasPeso.H_MAXIMO;
				break;
			default: break;
		}
		
		if (IMC < minimo)
			this.classificacaoIMC = FaixasPeso.ABAIXO_DO_PESO;
		
		if (IMC >= minimo && IMC <= maximo)
			this.classificacaoIMC = FaixasPeso.IDEAL;
		
		if (IMC > maximo)
			this.classificacaoIMC = FaixasPeso.OBESO;
	}
	
	public String getClassificacaoIMC() {
		return this.classificacaoIMC;
	}
	
	private double getIMCFormated() {
		return Math.floor(this.getIMC());
	}
	
	private double getPesoIdealFormated() {
		return Math.floor(this.getPesoIdeal());
	}
	
	private double getTaxaDeGorduraFormated() {
		return Math.floor(this.getTaxaDeGorduraCorporal());
	}
	
	@Override
	public String toString() {
		String pessoa = "CODIGO: " + this.getCodigoPessoa()
		+ "\nNOME: " + this.getNome()
		+ "\nSEXO: " + this.getSexo().name()
		+ "\nIDADE: " + this.getIdade()
		+ "\nPESO: " + this.getPeso()
		+ "\nALTURA: " + this.getAltura()
		+ "\nIMC: " + this.getIMCFormated() + "kg/m2 - (" + this.getClassificacaoIMC() + ")"
		+ "\nPESO IDEAL: " + this.getPesoIdealFormated() + "kg"
		+ "\nTAXA DE GORDURA CORPORAL: " + this.getTaxaDeGorduraFormated() + "%";
		
		PessoaToStringFormatter formatter = new PessoaToStringFormatter();
		
		return formatter.format(pessoa);
	}
}
