package candidatos;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.TipoOrdenacao;
import votacao.ControleVotacao;

public class ControleCandidatoTeste {
	
	private ControleCandidatos cc;
	private ControleVotacao cv;
	
	@Before
	public void init() {
		this.cc = new ControleCandidatos();
	}
	
	public Candidato[] instanciaCandidatos() {
		Candidato[] novosCandidatos = {
				new Candidato("Nome", 25, "Partido", "COD-111"),
				new Candidato("Nome1", 30, "Partido1", "COD-112"),
				new Candidato("Nome2", 35, "Partido2", "COD-113")
		};
		return novosCandidatos;
	}
	
	public void adicionaVotos(int numVotos, Candidato candidato) {
		for (int i = 0; i < numVotos; i++) {
			try {
				this.cv.adicionaVoto(candidato.getNumeroCandidato());
			} catch (Exception e) {
				fail(e.getMessage());
			}
		}
	}
	
	@Test (expected = AssertionError.class)
	public void adicionaCandidatoInvalido() {
		Candidato novoCandidato = new Candidato("", 40, "", "");
		try {
			this.cc.adicionaCandidato(novoCandidato);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected = AssertionError.class)
	public void adicionaVariosCandidatosInvalidos() {
		Candidato[] novosCandidatos = {
				new Candidato("", 29, "", ""),
				new Candidato("", 43, "", ""),
				new Candidato("", 56, "", "")
		};
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void deveAdicionarNovoCandidatoALista() {
		Candidato novoCandidato = new Candidato("Nome", 30, "Partido", "COD-111");
		int tamanhoFinalEsperadoParaLista = 1;
		
		try {
			this.cc.adicionaCandidato(novoCandidato);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		int tamanhoFinalListaCandidatos = this.cc.getListaCandidatos().size();
		assertTrue(tamanhoFinalEsperadoParaLista == tamanhoFinalListaCandidatos);
		assertEquals(novoCandidato.toString(), cc.getListaCandidatos().get(0).toString());
	}
	
	@Test
	public void deveAdicionarListaDeNovosCandidatosALista() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		int tamanhoFinalEsperadoParaLista = 3;
		String candidatosToStringEsperado = "";
		
		for (Candidato c : novosCandidatos) {
			candidatosToStringEsperado += c.toString();
		}
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		String candidatosToStringFinal = "";
		
		for (Candidato c : this.cc.getListaCandidatos()) {
			candidatosToStringFinal += c.toString();
		}
		
		int tamanhoFinalListaCandidatos = this.cc.getListaCandidatos().size();
		assertTrue(tamanhoFinalEsperadoParaLista == tamanhoFinalListaCandidatos);
		assertEquals(candidatosToStringEsperado, candidatosToStringFinal);
	}
	
	@Test (expected = AssertionError.class)
	public void testaOrdenacaoSemCandidatos() {
		try {
			this.cc.ordenaCandidatos(TipoOrdenacao.IDADE_ASC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void ordenaIdadeAsc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		String candidatosEmOrdenacaoEsperada = novosCandidatos[0].toString() + novosCandidatos[1] + novosCandidatos[2];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cc.ordenaCandidatos(TipoOrdenacao.IDADE_ASC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaIdadeDesc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		String candidatosEmOrdenacaoEsperada = novosCandidatos[2].toString() + novosCandidatos[1] + novosCandidatos[0];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cc.ordenaCandidatos(TipoOrdenacao.IDADE_DESC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaVotoAsc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		this.cv = new ControleVotacao();
		this.cv.adicionaCandidatos(novosCandidatos);
		
		this.adicionaVotos(3, novosCandidatos[0]);
		this.adicionaVotos(8, novosCandidatos[1]);
		this.adicionaVotos(5, novosCandidatos[2]);

		String candidatosEmOrdenacaoEsperada = novosCandidatos[0].toString() + novosCandidatos[2] + novosCandidatos[1];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cv.getControleCandidatos().ordenaCandidatos(TipoOrdenacao.VOTO_ASC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaVotoDesc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		this.cv = new ControleVotacao();
		this.cv.adicionaCandidatos(novosCandidatos);
		
		this.adicionaVotos(3, novosCandidatos[0]);
		this.adicionaVotos(8, novosCandidatos[1]);
		this.adicionaVotos(5, novosCandidatos[2]);

		String candidatosEmOrdenacaoEsperada = novosCandidatos[1].toString() + novosCandidatos[2] + novosCandidatos[0];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cv.getControleCandidatos().ordenaCandidatos(TipoOrdenacao.VOTO_DESC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaPartidoAsc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		String candidatosEmOrdenacaoEsperada = novosCandidatos[0].toString() + novosCandidatos[1] + novosCandidatos[2];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cc.ordenaCandidatos(TipoOrdenacao.PARTIDO_ASC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaPartidoDesc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		String candidatosEmOrdenacaoEsperada = novosCandidatos[2].toString() + novosCandidatos[1] + novosCandidatos[0];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cc.ordenaCandidatos(TipoOrdenacao.PARTIDO_DESC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaNomeAsc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		String candidatosEmOrdenacaoEsperada = novosCandidatos[0].toString() + novosCandidatos[1] + novosCandidatos[2];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cc.ordenaCandidatos(TipoOrdenacao.NOME_ASC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
	
	@Test
	public void ordenaNomeDesc() {
		Candidato[] novosCandidatos = this.instanciaCandidatos();
		
		try {
			this.cc.adicionaCandidatos(novosCandidatos);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		String candidatosEmOrdenacaoEsperada = novosCandidatos[2].toString() + novosCandidatos[1] + novosCandidatos[0];
		String candidatosOrdenados = "";
		
		try {
			candidatosOrdenados = this.cc.ordenaCandidatos(TipoOrdenacao.NOME_DESC);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(candidatosEmOrdenacaoEsperada, candidatosOrdenados);
	}
}