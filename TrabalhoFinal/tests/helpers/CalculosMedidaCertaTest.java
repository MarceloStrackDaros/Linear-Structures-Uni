package helpers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.Sexo;
import pessoas.Pessoa;

public class CalculosMedidaCertaTest {

	@Test
	public void testaCalculoIMC() {
		Pessoa pessoa = new Pessoa("Nome", Sexo.FEMININO, 25, 55, 1.70);
		double expectedIMC = pessoa.getPeso() / Math.pow(pessoa.getAltura(), 2);
		
		double calculoIMC = CalculosMedidaCerta.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
		
		assertEquals(expectedIMC, calculoIMC, 0.0001);
	}
	
	@Test
	public void testaCalculoTaxaDeGorduraCorporalSexoFeminino() {
		Pessoa pessoa = new Pessoa("Nome", Sexo.FEMININO, 25, 55, 1.70);
		double expectedTaxaDeGordura = (1.2 * CalculosMedidaCerta.calcularIMC(pessoa.getPeso(), pessoa.getAltura())) + (0.23 * pessoa.getIdade()) - 5.4;
		
		double calculoTaxaDeGordura = CalculosMedidaCerta.calcularTaxaDeGorduraCorporal(pessoa.getIdade(), pessoa.getIMC(), pessoa.getSexo());
		
		assertEquals(expectedTaxaDeGordura, calculoTaxaDeGordura, 0.0001);
	}
	
	@Test
	public void testaCalculoTaxaDeGorduraCorporalSexoMasculino() {
		Pessoa pessoa = new Pessoa("Nome", Sexo.MASCULINO, 30, 95, 1.80);
		double expectedTaxaDeGordura = (1.2 * CalculosMedidaCerta.calcularIMC(pessoa.getPeso(), pessoa.getAltura())) - 10.8 + (0.23 * pessoa.getIdade()) - 5.4;
		
		double calculoTaxaDeGordura = CalculosMedidaCerta.calcularTaxaDeGorduraCorporal(pessoa.getIdade(), pessoa.getIMC(), pessoa.getSexo());
		
		assertEquals(expectedTaxaDeGordura, calculoTaxaDeGordura, 0.0001);
	}
	
	@Test
	public void testaCalculoPesoIdealFeminino() {
		Pessoa pessoa = new Pessoa("Nome", Sexo.FEMININO, 25, 55, 1.70);
		double expectedPesoIdeal = (((pessoa.getAltura() * 100) - 100) - (((pessoa.getAltura() * 100) - 150) / 2));
		
		double calculoPesoIdeal = CalculosMedidaCerta.calcularPesoIdeal(pessoa.getAltura(), pessoa.getSexo());
		
		assertEquals(expectedPesoIdeal, calculoPesoIdeal, 0.0001);
	}
	
	@Test
	public void testaCalculoPesoIdealMasculino() {
		Pessoa pessoa = new Pessoa("Nome", Sexo.MASCULINO, 30, 95, 1.80);
		double expectedPesoIdeal = (((pessoa.getAltura() * 100) - 100) - (((pessoa.getAltura() * 100) - 150) / 4));
		
		double calculoPesoIdeal = CalculosMedidaCerta.calcularPesoIdeal(pessoa.getAltura(), pessoa.getSexo());
		
		assertEquals(expectedPesoIdeal, calculoPesoIdeal, 0.0001);
	}
}