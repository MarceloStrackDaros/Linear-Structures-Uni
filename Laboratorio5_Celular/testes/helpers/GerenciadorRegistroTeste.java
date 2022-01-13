package helpers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import celular.Chamadas;
import celular.Contatos;
import celular.RegistroContato;
import celular.RegistroNumero;

public class GerenciadorRegistroTeste {
	
	Contatos agendaContatos;
	
	@Before
	public void initTeste() {
		agendaContatos = new Contatos();
	}

	@Test
	public void registroNumeroDeveSerValido() {
		RegistroNumero registro = new RegistroNumero("99999-9999");
		
		boolean registroEhValido = GerenciadorRegistro.registroEhValido(registro);
		
		assertTrue(registroEhValido);
	}
	
	@Test
	public void registroContatoDeveSerValido() {
		RegistroContato registro = new RegistroContato("Bel", "99999-9999");
		
		boolean registroEhValido = GerenciadorRegistro.registroEhValido(registro);
		
		assertTrue(registroEhValido);
	}
	
	@Test
	public void registroDeveSerDoTipoRegistroContato() {
		RegistroNumero registro = new RegistroContato("Bel", "99999-9999");
		
		boolean registroEhValido = GerenciadorRegistro.tipoRegistroEhContato(registro);
		
		assertTrue(registroEhValido);
	}
	
	@Test
	public void registroNumeroDeveJahExistirNaListaDeContatosVirificadoPorNumero() {
		this.preencheListaComContatosFicticios();
		String numeroRegistroEsperado = "99999-9999";
		RegistroContato registroContato = GerenciadorRegistro.registroJaEhContato(this.agendaContatos.getContatos(), numeroRegistroEsperado, true);
		
		assertEquals(numeroRegistroEsperado, registroContato.getNumero());
	}
	
	@Test
	public void registroNumeroDeveJahExistirNaListaDeContatosVirificadoPorNome() {
		this.preencheListaComContatosFicticios();
		String nomeRegistroEsperado = "Bel";
		RegistroContato registroContato = GerenciadorRegistro.registroJaEhContato(this.agendaContatos.getContatos(), nomeRegistroEsperado, false);
		
		assertEquals(nomeRegistroEsperado, registroContato.getNome());
	}
	
	@Test
	public void registroNumeroDeveSerInvalido() {
		RegistroNumero registro = new RegistroNumero("999999999");
		
		boolean registroEhValido = GerenciadorRegistro.registroEhValido(registro);
		
		assertFalse(registroEhValido);
	}
	
	@Test
	public void registroContatoDeveSerInvalidoPorNome() {
		RegistroContato registro = new RegistroContato("", "99999-9999");
		
		boolean registroEhValido = GerenciadorRegistro.registroEhValido(registro);
		
		assertFalse(registroEhValido);
	}
	
	@Test
	public void registroContatoDeveSerInvalidoPorNumero() {
		RegistroContato registro = new RegistroContato("Bel", "999999999");
		
		boolean registroEhValido = GerenciadorRegistro.registroEhValido(registro);
		
		assertFalse(registroEhValido);
	}
	
	@Test
	public void registroDeveSerDoTipoRegistroNumero() {
		RegistroNumero registro = new RegistroNumero("99999-9999");
		
		boolean registroEhValido = GerenciadorRegistro.tipoRegistroEhContato(registro);
		
		assertFalse(registroEhValido);
	}
	
	@Test
	public void registroNumeroNaoDeveExistirNaListaDeContatosVirificadoPorNumero() {
		this.preencheListaComContatosFicticios();
		String numeroRegistro = "99999-9989";
		RegistroContato registroContato = GerenciadorRegistro.registroJaEhContato(this.agendaContatos.getContatos(), numeroRegistro, true);
		
		assertEquals(null, registroContato);
	}
	
	@Test
	public void registroNumeroNaoDeveExistirNaListaDeContatosVirificadoPorNome() {
		this.preencheListaComContatosFicticios();
		String nomeRegistro = "Ana";
		RegistroContato registroContato = GerenciadorRegistro.registroJaEhContato(this.agendaContatos.getContatos(), nomeRegistro, false);
		
		assertEquals(null, registroContato);
	}
	
	private void preencheListaComContatosFicticios() {
		RegistroContato[] novosContatos = {
			new RegistroContato("Bel", "99999-9999"),
			new RegistroContato("Valeria", "99999-9998"),
			new RegistroContato("Marco", "99999-9997")
		};
		
		for (int i = 0; i < 3; i++) {
			try {
				this.agendaContatos.adicionaNovoContato(novosContatos[i]);
			} catch (Exception e) {
				fail(e.getMessage());
			}
		}
	}

}
