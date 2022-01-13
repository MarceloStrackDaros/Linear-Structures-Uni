package classes;

import interfaces.FilaNaoVacinados;
import interfaces.ListaVacinados;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;
import comparators.ComparadorPorIdade;
import helpers.VerificacaoDeDigitos;
import exceptions.DigitoInvalidoException;
import exceptions.NumeroPacientesInvalidoException;

public class Vacinacao implements FilaNaoVacinados, ListaVacinados {

	private Queue<Paciente> filaNaoVacinados;
	private List<Paciente> listaVacinados;
	private Comparator<Paciente> comparadorPorIdade;
	private Scanner key;
	
	public Vacinacao() {
		this.comparadorPorIdade = new ComparadorPorIdade();
		this.filaNaoVacinados = new PriorityQueue<Paciente>(this.comparadorPorIdade);
		this.listaVacinados = new ArrayList<Paciente>();
		this.key = new Scanner(System.in);
	}

	@Override
	public int getTamanhoFilaNaoVacinados() {
		return this.filaNaoVacinados.size();
	}
	
	@Override
	public int getTamanhoListaVacinados() {
		return this.listaVacinados.size();
	}
	
	public List<Paciente> adicionaPacientesNaoVacinados(Paciente...pacientes) {
		List<Paciente> listaPacientesAdicionados = new ArrayList<>();
		System.out.println("Adicionando pacientes na fila de vacinação...");
		for (Paciente p : pacientes) {
			this.filaNaoVacinados.add(p);
			listaPacientesAdicionados.add(p);
		}
		return listaPacientesAdicionados;
	}
	
	@Override
	public List<Paciente> adicionaPacientesNaoVacinados() {
		
		System.out.println("Adicionando pacientes na fila de vacinação...");
		
		String nome;
		int idade = 0;
		boolean validacao = true;
		System.out.println("Digite quantos pacientes serão adicionados à fila:");
		int numPacientes = VerificacaoDeDigitos.validarDigito(3);
		List<Paciente> pacientes = new ArrayList<>();
		
		for (int i = 0; i < numPacientes; i++) {
			
			System.out.printf("\nDigite o nome do %dº paciente a ser adicionado:", i+1);
			nome = key.next();
			System.out.println("Digite a idade do paciente:");
			idade = VerificacaoDeDigitos.validarDigito(1);
			if (idade > 0) {
				Paciente p = new Paciente(nome, idade);
				pacientes.add(p);
			}
		}
		
		for (Paciente p : pacientes) {
			this.filaNaoVacinados.add(p);
		}
		return pacientes;
	}
	
	public void mostraPacientesAdicionados(List<Paciente> pacientes) {
		for (Paciente p : pacientes) {
			System.out.printf("\nPaciente %s (%d anos) foi adicionado(a) à fila.", p.getNome(), p.getIdade());
		}
		System.out.println();
	}

	public int aplicaVacinas() throws NumeroPacientesInvalidoException {
		
		if (this.getTamanhoFilaNaoVacinados() == 0) {
			System.out.println("Até o momento todos os pacientes foram vacinados, portanto nenhuma vacina foi aplicada.");
		}
		else {
			int numPacientes = 0;
			System.out.println("Digite quantos pacientes serão vacinados:");
			numPacientes = VerificacaoDeDigitos.validarDigito(3);
			
			if (numPacientes > this.getTamanhoFilaNaoVacinados()) {
				throw new NumeroPacientesInvalidoException("Erro: existem apenas " + this.getTamanhoFilaNaoVacinados() + " paciente(s) não vacinado(s) na fila, portanto o número inserido é inválido.\nTente novamente.");
			}
			for (int i = 0; i < numPacientes; i++) {
				System.out.printf("\nAplicando vacina...");
				Paciente vacinado = this.filaNaoVacinados.poll();
				System.out.printf("\nPaciente %s de %d anos foi vacinado(a)!", vacinado.getNome(), vacinado.getIdade());
				this.listaVacinados.add(vacinado);
			}
			System.out.println();
		}
		return this.getTamanhoListaVacinados();
	}
	
	@Override
	public void imprimeFilaNaoVacinados() throws NumeroPacientesInvalidoException {
		
		if (this.getTamanhoFilaNaoVacinados() == 0) {
			throw new NumeroPacientesInvalidoException("Até o momento todos os pacientes foram vacinados!");
		}
		System.out.printf("Fila de pacientes esperando pela vacina (%d pessoa(s)):\n", this.getTamanhoFilaNaoVacinados());
		
		Queue<Paciente> copiaFilaNaoVacinados = new PriorityQueue<Paciente>(this.filaNaoVacinados);
		Paciente pacienteNaoVacinado;
		
		while (copiaFilaNaoVacinados.size() != 0) {
			pacienteNaoVacinado = copiaFilaNaoVacinados.remove();
			System.out.printf("\n%s, %d anos", pacienteNaoVacinado.getNome(), pacienteNaoVacinado.getIdade());
		}
		System.out.println();
	}
	
	@Override
	public void imprimeListaVacinados() throws NumeroPacientesInvalidoException {
		
		if (this.getTamanhoListaVacinados() == 0) {
			throw new NumeroPacientesInvalidoException("Nenhum paciente foi vacinado até o momento.");
		}
		System.out.printf("Lista dos pacientes vacinados (%d pessoa(s)):\n", this.getTamanhoListaVacinados());
		
		for (Paciente p : this.listaVacinados) {
			System.out.printf("\n%s, %d anos", p.getNome(), p.getIdade());
		}
		System.out.println();
	}
}