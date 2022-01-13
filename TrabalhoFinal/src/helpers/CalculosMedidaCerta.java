package helpers;

import constantes.VariaveisDasFormulas;
import enums.Sexo;
import pessoas.Pessoa;

public class CalculosMedidaCerta {
	
	public static double[] chamaCalculos(Pessoa pessoa) {
		double IMC = calcularIMC(pessoa.getPeso(), pessoa.getAltura());
		double taxaDeGorduraCorporal = calcularTaxaDeGorduraCorporal(pessoa.getIdade(), IMC, pessoa.getSexo());
		double pesoIdeal = calcularPesoIdeal(pessoa.getAltura(), pessoa.getSexo());
		
		double[] resultados = {IMC, taxaDeGorduraCorporal, pesoIdeal};
		
		return resultados;
	}
	
	public static double calcularIMC(double peso, double altura) {
		return peso / Math.pow(altura, 2);
	}
	
	public static double calcularTaxaDeGorduraCorporal(int idade, double IMC, Sexo sexo) {
		int S = sexo.equals(Sexo.MASCULINO)
				? VariaveisDasFormulas.S_HOMEM
				: VariaveisDasFormulas.S_MULHER;
		
		return (1.2 * IMC) - (10.8 * S) + (0.23 * idade) - 5.4;
	}
	
	public static double calcularPesoIdeal(double altura, Sexo sexo) {
		int K = sexo.equals(Sexo.MASCULINO)
				? VariaveisDasFormulas.K_HOMEM
				: VariaveisDasFormulas.K_MULHER;
				
		return (((altura * 100) - 100) - (((altura * 100) - 150) / K));
	}
}
