package celular;

import formatters.RegistroFormatter;

public class RegistroContato extends RegistroNumero {
	private String nome;
	
	public RegistroContato(String nome, String numero) {
		super(numero);
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return RegistroFormatter.formatToRegistro(this.getNome(), this.getNumero());
	}
}
