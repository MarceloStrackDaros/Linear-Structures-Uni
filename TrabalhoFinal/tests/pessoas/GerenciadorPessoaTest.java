package pessoas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.Sexo;

public class GerenciadorPessoaTest {
	
	private GerenciadorPessoas gp;
	
	@Before
	public void begin() {
		this.gp = new GerenciadorPessoas();
	}
	
	public void adicionaPessoa(Pessoa pessoa) {
		try {
			this.gp.adicionaPessoa(pessoa);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected = AssertionError.class)
	public void adicionaPessoaNula() {
		Pessoa novaPessoa = new Pessoa("Nome", Sexo.FEMININO, 25, 55, 1.70);
		novaPessoa = null;
		
		try {
			this.gp.adicionaPessoa(novaPessoa);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void adicionaUmaPessoa() {
		Pessoa novaPessoa = new Pessoa("nome", Sexo.FEMININO, 25, 55, 1.70);
		int tamanhoEsperadoListaPessoas = 1;
		
		try {
			this.gp.adicionaPessoa(novaPessoa);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(tamanhoEsperadoListaPessoas, this.gp.getPessoas().size());
	}
	
	@Test (expected = AssertionError.class)
	public void listaPessoasComListaVazia() {
		try {
			this.gp.listaPessoas();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void listaTresPessoasNaLista() {
		Pessoa pessoa1 = new Pessoa("Nome", Sexo.FEMININO, 25, 55, 1.70);
		Pessoa pessoa2 = new Pessoa("Nome1", Sexo.MASCULINO, 30, 61, 1.68);
		Pessoa pessoa3 = new Pessoa("Nome2", Sexo.FEMININO, 35, 90, 1.74);
		
		this.adicionaPessoa(pessoa1);
		this.adicionaPessoa(pessoa2);
		this.adicionaPessoa(pessoa3);
		
		String listaEsperada = "\n___________________________" + pessoa1.toString() + pessoa2.toString() + pessoa3.toString() +
							   "___________________________\n";
		String listaPessoas = "";
		
		try {
			listaPessoas = this.gp.listaPessoas();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(listaEsperada, listaPessoas);
	}
}