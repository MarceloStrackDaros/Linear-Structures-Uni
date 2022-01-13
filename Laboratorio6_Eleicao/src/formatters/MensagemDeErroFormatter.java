package formatters;

public class MensagemDeErroFormatter {

	public static String formatToMensagemDeErro(String mensagem) {
		String mensagemErro = "\n***    ATENÇÃO    ***\n";
		mensagemErro += mensagem;
		mensagemErro += "\n******************\n";
		
		return mensagemErro;
	}
}
