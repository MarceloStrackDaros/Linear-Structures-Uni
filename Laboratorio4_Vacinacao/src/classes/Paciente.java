package classes;

public class Paciente {

	private String nome;
	private int idade;
	
	public Paciente(String nome, int idade) {
		this.setNome(nome);
		this.setIdade(idade);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}