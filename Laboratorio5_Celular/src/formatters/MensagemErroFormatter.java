package formatters;

public class MensagemErroFormatter {
	public static String formatToMensagemDeErro(String mensagem) {
		String mensagemFormatada = "\n********** ********** **********\n";
		mensagemFormatada += "\n" + mensagem;
		mensagemFormatada += "\n********** ********** **********\n";
		
		return mensagemFormatada;
	}
}
