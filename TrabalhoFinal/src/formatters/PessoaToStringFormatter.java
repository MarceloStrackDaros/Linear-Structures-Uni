package formatters;

import interfaces.IFormatter;

public class PessoaToStringFormatter implements IFormatter {

	@Override
	public String format(String mensagem) {
		String resultado = "\n--------------------------------\n"
				+ mensagem
				+ "\n--------------------------------\n";
		return resultado;
	}

}
