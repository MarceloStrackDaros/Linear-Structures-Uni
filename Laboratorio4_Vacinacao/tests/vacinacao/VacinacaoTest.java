package vacinacao;

import static org.junit.Assert.*;
import org.junit.Test;
import classes.Paciente;
import classes.Vacinacao;
import exceptions.NumeroPacientesInvalidoException;

public class VacinacaoTest { // Como o programa depende de interações com o usuário, foi feito um teste interativo para a classe Vacinação

	private Vacinacao vacinacao;
	private Paciente p1;
	private Paciente p2;
	private Paciente p3;
	private Paciente p4;
	private Paciente p5;
	
	public void instanciaElementos() {
		this.vacinacao = new Vacinacao();
		this.p1 = new Paciente("Lucas", 27);
		this.p2 = new Paciente("Marta", 33);
		this.p3 = new Paciente("José", 96);
		this.p4 = new Paciente("Lucia", 61);
		this.p5 = new Paciente("Amanda", 14);
	}

	@Test
	public void testTamanhoFilaNaoVacinados() {
		instanciaElementos();
		assertEquals(0, vacinacao.getTamanhoFilaNaoVacinados());
		vacinacao.adicionaPacientesNaoVacinados(p1, p2, p3, p4, p5);
		assertEquals(5, vacinacao.getTamanhoFilaNaoVacinados());
	}
	
	@Test
	public void testTamanhoListaVacinados() {
		instanciaElementos();
		assertEquals(0, vacinacao.getTamanhoListaVacinados());
		testAplicaVacinaEmCincoPacientes(p1, p2, p3, p4, p5);
		assertEquals(5, vacinacao.getTamanhoListaVacinados());
	}
	
	public void testAplicaVacinaEmCincoPacientes(Paciente...pacientes) {
		vacinacao.adicionaPacientesNaoVacinados(pacientes);
		System.out.println("\nO teste deve funcionar se for inserido no número 5:");
		assertEquals(5, vacinacao.aplicaVacinas());
	}
	
	@Test
	public void testAplicaVacinaInserindoZeroPacientes() {
		System.out.println("\n- Testando aplicação de vacinas em número de pacientes inválido...\n");
		instanciaElementos();
		vacinacao.adicionaPacientesNaoVacinados(p1, p2, p3, p4, p5);
		System.out.println("\nDigite 0 para testar a exceção e após digite 1 para sair do loop:");
		assertEquals(1, vacinacao.aplicaVacinas());
		System.out.println("\nTeste completo!");
	}
	
	@Test
	public void testAplicaVacinaComNenhumPacienteNaFila() {
		instanciaElementos();
		vacinacao.aplicaVacinas();
		System.out.println("\nTeste completo!");
	}
	
	@Test (expected = NumeroPacientesInvalidoException.class)
	public void testAplicaVacinaEmNumeroDePacientesMaiorQueOTamanhoDaFila() {
		System.out.println("\n- Testando aplicação de vacinas em número de pacientes maior que o número de pacientes na fila...\n");
		instanciaElementos();
		vacinacao.adicionaPacientesNaoVacinados(p1, p2, p3, p4, p5);
		System.out.println("\nDigite um número maior que 5 para testar a exceção:");
		vacinacao.aplicaVacinas();
		System.out.println("\nTeste completo!");
	}
	
	@Test
	public void testAdicionaPacientesNaoVacinados() {
		System.out.println("\n- Testando adição de pacientes não vacinados...");
		System.out.println("Quando pedir o número de pacientes a serem adicionados e a idade do paciente a ser adicionado,\ndigite um número inválido (ex.: 0) para testar a exceção:");
		instanciaElementos();
		vacinacao.mostraPacientesAdicionados(vacinacao.adicionaPacientesNaoVacinados());
	}
	
	@Test (expected = NumeroPacientesInvalidoException.class)
	public void imprimeListaVacinadosComNenhumPacienteVacinado() {
		instanciaElementos();
		vacinacao.imprimeListaVacinados();
	}
	
	@Test (expected = NumeroPacientesInvalidoException.class)
	public void imprimeFilaNaoVacinadosComTodosPacientesVacinados() {
		System.out.println("\n- Testando impressão de pacientes não vacinados com todos os pacientes vacinados até o momento...\n");
		instanciaElementos();
		vacinacao.adicionaPacientesNaoVacinados(p1, p2, p3, p4, p5);
		System.out.println("\nO teste deve funcionar se for inserido no número 5:");
		vacinacao.aplicaVacinas();
		vacinacao.imprimeFilaNaoVacinados();
		System.out.println("\nTeste completo!");
	}
	
	@Test
	public void imprimeFilaNaoVacinadosComCincoPacientesNaoVacinados() {
		System.out.println("\n- Testando impressão de 5 pacientes não vacinados...");
		instanciaElementos();
		vacinacao.adicionaPacientesNaoVacinados(p1, p2, p3, p4, p5);
		vacinacao.imprimeFilaNaoVacinados();
		System.out.println("\nTeste completo!");
	}
}