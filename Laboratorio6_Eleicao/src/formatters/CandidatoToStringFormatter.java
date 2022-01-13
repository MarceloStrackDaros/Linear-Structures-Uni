package formatters;

import interfaces.IFormatter;

public class CandidatoToStringFormatter implements IFormatter {

	@Override
	public String format(String message) {
		String resultado = "\n----------------------------\n";
		resultado += message;
		resultado += "\n----------------------------\n";
		return resultado;
	}

}
