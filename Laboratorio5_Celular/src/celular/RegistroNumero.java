package celular;

import formatters.RegistroFormatter;
import interfaces.Registro;

public class RegistroNumero implements Registro {
	private String numero;
	
	public RegistroNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	@Override
	public String toString() {
		return RegistroFormatter.formatToRegistro(null, this.getNumero());
	}
}
