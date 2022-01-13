package celular;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import enums.MensagensDeErro;
import formatters.MensagemErroFormatter;

public class ChamadasTeste {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	Chamadas agendaChamadas;
	Contatos agendaContatos;
	
	Class classeRegistroNumero;
	Class classeRegistroContato;
	
	@Before
	public void initTeste() {
		agendaChamadas = new Chamadas();
		agendaContatos = new Contatos();
		classeRegistroNumero = new RegistroNumero("00000-0000").getClass();
		classeRegistroContato = new RegistroContato("RegistroContato", "00000-0000").getClass();
	}
	
	@Test
	public void deveAdicionarNovoRegistroNaLista() {
		int tamanhoOriginalListaRegistros = this.agendaChamadas.getChamadas().size();
				
		RegistroNumero novoRegistro = new RegistroNumero("99999-9999");
		
		try {
			this.agendaChamadas.adicionaNovaChamada(this.agendaContatos.getContatos(), novoRegistro);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		int tamanhoFinalListaRegistros = this.agendaChamadas.getChamadas().size();
		
		assertTrue(tamanhoOriginalListaRegistros == (tamanhoFinalListaRegistros - 1));
	}
	
	@Test
	public void deveAdicionarNovoRegistroNaListaComOsDadosInformados() {
		String numeroRegistroEsperado = "99999-9999";
		
		RegistroNumero novoRegistro = new RegistroNumero("99999-9999");
		
		try {
			this.agendaChamadas.adicionaNovaChamada(this.agendaContatos.getContatos(), novoRegistro);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		RegistroNumero chamadaRegistrada = this.agendaChamadas.getChamadas().get(0);
				
		assertEquals(numeroRegistroEsperado, chamadaRegistrada.getNumero());
	}
	
	@Test
	public void deveRemoverTodosOsRegistrosDeChamadas() {
		this.preencheListaComRegistrosFicticios();
				
		try {
			this.agendaChamadas.deletarChamadas();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		int tamanhoFinalListaRegistros = this.agendaChamadas.getChamadas().size();
		
		assertTrue(0 == tamanhoFinalListaRegistros);
	}
	
	@Test
	public void deveAtualizarRegistroDeRegistroNumeroParaRegistroContato() {
		
		RegistroNumero novoRegistro = new RegistroNumero("99999-9999");
		Class classeNovoRegistro = null;
		Class classeNovoRegistroAtualizado = null;
		
		try {
			this.agendaChamadas.adicionaNovaChamada(this.agendaContatos.getContatos(), novoRegistro);
			classeNovoRegistro = this.agendaChamadas.getChamadas().get(0).getClass();
			RegistroContato novoContato = new RegistroContato("Bel", "99999-9999");
			this.agendaChamadas.atualizaChamadas(novoContato);
			classeNovoRegistroAtualizado = this.agendaChamadas.getChamadas().get(0).getClass();
		} catch (Exception e) {
			fail(e.getMessage());
		};
			
		assertEquals(classeRegistroNumero, classeNovoRegistro);
		assertEquals(classeRegistroContato, classeNovoRegistroAtualizado);	
	}
	
	@Test
	public void deveAtualizarRegistroDeRegistroContatoParaRegistroNumero() {		
		this.preencheListaComContatosFicticios();
		RegistroNumero novoRegistro = new RegistroNumero("99999-9999");
		Class classeNovoRegistro = null;
		Class classeNovoRegistroAtualizado = null;
		
		try {
			this.agendaChamadas.adicionaNovaChamada(this.agendaContatos.getContatos(), novoRegistro);
			classeNovoRegistro = this.agendaChamadas.getChamadas().get(0).getClass();
			this.agendaContatos.removeContato(novoRegistro.getNumero());
			this.agendaChamadas.atualizaChamadas(novoRegistro);
			classeNovoRegistroAtualizado = this.agendaChamadas.getChamadas().get(0).getClass();
		} catch (Exception e) {
			fail(e.getMessage());
		};
			
		assertEquals(classeRegistroContato, classeNovoRegistro);
		assertEquals(classeRegistroNumero, classeNovoRegistroAtualizado);	
	}
	
	@Test
	public void deveOcorrerExceptionAoTentarAdicionarRegistroInvalido() throws Exception {
		RegistroNumero novoRegistro = new RegistroNumero("999999999");
		
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.REGISTRO_INVALIDO));
		this.agendaChamadas.adicionaNovaChamada(this.agendaContatos.getContatos(), novoRegistro);
	}
	
	@Test 
	public void deveOcorrerExceptionAoTentarDeletarChamadasComAListaVazia() throws Exception {
		
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage(MensagemErroFormatter.formatToMensagemDeErro(MensagensDeErro.LISTA_VAZIA));
		this.agendaChamadas.deletarChamadas();
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
	
	private void preencheListaComRegistrosFicticios() {
		RegistroNumero[] novosRegistros = {
			new RegistroNumero("99999-9989"),
			new RegistroNumero("99999-9988"),
			new RegistroNumero("99999-9987")
		};
		
		for (int i = 0; i < 3; i++) {
			try {
				this.agendaChamadas.adicionaNovaChamada(this.agendaContatos.getContatos(), novosRegistros[i]);
			} catch (Exception e) {
				fail(e.getMessage());
			}
		}
	}

}
