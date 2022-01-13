package formatters;

import interfaces.IFormatter;

public class MensagemDeErroFormatter implements IFormatter {

	@Override
	public String format(String mensagem) {
		String resultado = "\n***     ATEN��O     ***\n"
				+ mensagem
				+ "\n***********************\n";
		return resultado;
	}

}
