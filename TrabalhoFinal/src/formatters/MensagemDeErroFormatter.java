package formatters;

import interfaces.IFormatter;

public class MensagemDeErroFormatter implements IFormatter {

	@Override
	public String format(String mensagem) {
		String resultado = "\n***     ATENÇÃO     ***\n"
				+ mensagem
				+ "\n***********************\n";
		return resultado;
	}

}
