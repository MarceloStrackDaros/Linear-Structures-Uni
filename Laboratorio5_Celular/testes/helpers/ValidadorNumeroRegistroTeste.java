package helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidadorNumeroRegistroTeste {

	@Test
	public void numeroDeveSerValido() {
		String numero = "99999-9999";		
		boolean numeroEhValido = ValidadorNumeroRegistro.numeroEhValido(numero);
		
		assertTrue(numeroEhValido);
	}
	
	@Test
	public void numeroDeveSerInvalido() {
		String numero = "999999999";		
		boolean numeroEhValido = ValidadorNumeroRegistro.numeroEhValido(numero);
		
		assertFalse(numeroEhValido);
	}

}
