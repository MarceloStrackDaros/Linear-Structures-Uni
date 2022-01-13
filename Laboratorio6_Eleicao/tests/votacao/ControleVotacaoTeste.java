package votacao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import candidatos.Candidato;
import candidatos.ControleCandidatos;

public class ControleVotacaoTeste {
	
	private ControleVotacao cv;
	
	@Before
	public void init() {
		this.cv = new ControleVotacao();
	}
	
	public Candidato[] instanciaCandidatos() {
		Candidato[] novosCandidatos = {
				new Candidato("Nome", 25, "Partido", "COD-111"),
				new Candidato("Nome1", 30, "Partido1", "COD-112"),
				new Candidato("Nome2", 35, "Partido2", "COD-113")
		};
		return novosCandidatos;
	}
	
	@Test
	public void deveAdicionarCandidatos() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		String candidatosToStringEsperado = "";
		
		for (Candidato c : novosCandidatos) {
			candidatosToStringEsperado += c.toString();
		}
		
		try {
			this.cv.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		String candidatosToStringFinal = "";
		
		for (Candidato c : this.cv.controleCandidatos.getListaCandidatos()) {
			candidatosToStringFinal += c.toString();
		}
		
		assertEquals(candidatosToStringEsperado, candidatosToStringFinal);
	}
	
	@Test (expected = AssertionError.class)
	public void adicionaVotoInvalido() {
		Candidato novoCandidato = new Candidato("Nome", 30, "Partido", "COD-111");
		try {
			this.cv.adicionaVoto(novoCandidato.getNumeroCandidato());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void deveAdicionarVotoParaCandidatoX() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		String codigoCandidatoVotado = "COD-111";
		int nroVotosEsperadoCandidatoVotado = 1;
		
		try {
			this.cv.adicionaCandidatos(novosCandidatos);
			this.cv.adicionaVoto(codigoCandidatoVotado);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		int nroVotosFinalCandidatoVotado = 0;
		
		for (Candidato c : this.cv.controleCandidatos.getListaCandidatos()) {
			if (c.getNumeroCandidato().equals(codigoCandidatoVotado)) {
				nroVotosFinalCandidatoVotado = c.getNumVotos();
			}
		}
		
		assertEquals(nroVotosEsperadoCandidatoVotado, nroVotosFinalCandidatoVotado);
		
	}
	
	@Test
	public void testaCalculoVotacaoPorCandidato() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		this.cv.adicionaCandidatos(novosCandidatos);
		int numVotosTotais = 0;
		
		int repeticoes = 3;
		for (int i = 0; i < 3; i++) {
			try {
				this.cv.adicionaVoto("COD-111");
			} catch (Exception e) {
				fail(e.getMessage());
			}
			numVotosTotais++;
		}
		repeticoes = 2;
		for (int i = 0; i < 2; i++) {
			try {
				this.cv.adicionaVoto("COD-112");
			} catch (Exception e) {
				fail(e.getMessage());
			}
			numVotosTotais++;
		}
		try {
			this.cv.adicionaVoto("COD-113");
		} catch (Exception e) {
			fail(e.getMessage());
		}
		numVotosTotais++;
		
		double resultadoEsperado = numVotosTotais / this.cv.getControleCandidatos().getListaCandidatos().size();
		double mediaCalculada = this.cv.calculaMediaVotacaoPorCandidato();
		
		assertEquals(resultadoEsperado, mediaCalculada, 0.0001);
		
	}

}