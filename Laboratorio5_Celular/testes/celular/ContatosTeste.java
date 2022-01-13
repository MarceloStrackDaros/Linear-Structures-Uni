package celular;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.MensagensDeErro;
import formatters.MensagemErroFormatter;

public class ContatosTeste {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	Contatos agendaContatos;
	
	@Before
	public void initTeste() {
		agendaContatos = new Contatos();
	}
	

	@Test
	public void deveAdicionarNovoContatoNaLista() {
		int tamanhoOriginalListaContatos = this.agendaContatos.getContatos().size();
				
		RegistroContato novoContato = new RegistroContato("Bel", "99999-9999");
		
		try {
			this.agendaContatos.adicionaNovoContato(novoContato);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		int tamanhoFinalListaContatos = this.agendaContatos.getContatos().size();
		
		assertTrue(tamanhoOriginalListaContatos == (tamanhoFinalListaContatos - 1));
	}
	
	@Test
	public void deveAdicionarNovoContatoNaListaComOsDadosInformados() {
		String nomeContatoEsperado = "Bel";
		String numeroContatoEsperado = "99999-9999";
		
		RegistroContato novoContato = new RegistroContato("Bel", "99999-9999");
		
		try {
			this.agendaContatos.adicionaNovoContato(novoContato);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		RegistroContato contatoRegistrado = this.agendaContatos.getContatos().get(0);
				
		assertEquals(nomeContatoEsperado, contatoRegistrado.getNome());
		assertEquals(numeroContatoEsperado, contatoRegistrado.getNumero());
	}

	@Test
	public void deveRemoverContatoPeloNomeInformado() {
		String nomeContatoQueDeveSerRemovido = "Bel";
		
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
		
		try {
			this.agendaContatos.removeContato(nomeContatoQueDeveSerRemovido);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		boolean contatoNaoExisteMaisNaLista = true;
		
		for (RegistroContato contato : this.agendaContatos.getContatos()) {
			if (contato.getNome().equals(nomeContatoQueDeveSerRemovido)) {
				contatoNaoExisteMaisNaLista = false;
			}
		}
		
		assertTrue(contatoNaoExisteMaisNaLista);
	}
	
	@Test
	public void deveRemoverContatoPeloNumeroInformado() {
		String numeroContatoQueDeveSerRemovido = "99999-9999";
		
		this.preencheListaComContatosFicticios();
		
		try {
			this.agendaContatos.removeContato(numeroContatoQueDeveSerRemovido);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		boolean contatoNaoExisteMaisNaLista = true;
		
		for (RegistroContato contato : this.agendaContatos.getContatos()) {
			if (contato.getNumero().equals(numeroContatoQueDeveSerRemovido)) {
				contatoNaoExisteMaisNaLista = false;
			}
		}
		
		assertTrue(contatoNaoExisteMaisNaLista);
	}
	
	@Test
	public void deveOcorrerUmaExcessaoAoTentarAdicionarContatoInvalido() throws Exception {
		RegistroContato novoContato = new RegistroContato("Bel", "999999999");
		
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.CONTATO_INVALIDO));
		this.agendaContatos.adicionaNovoContato(novoContato);
	}
	
	@Test
	public void deveOcorrerUmaExcessaoAoTentarAdicionarContatoJahExistenteNaLista() throws Exception {
		RegistroContato novoContato = new RegistroContato("Bel", "99999-9999");
		
		try {
			this.agendaContatos.adicionaNovoContato(novoContato);
		}  catch (Exception e) {
			fail(e.getMessage());
		};
		
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.CONTATO_JA_CADASTRADO));
		this.agendaContatos.adicionaNovoContato(novoContato);
	}
	
	@Test
	public void deveOcorrerUmaExcessaoAoTentarRemoverContatoNaoExistenteNaLista() throws Exception {
		this.preencheListaComContatosFicticios();
		
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.CONTATO_NAO_EXISTENTE));
		this.agendaContatos.removeContato("88888-88888");
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
