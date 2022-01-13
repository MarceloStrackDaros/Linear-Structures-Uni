package formatters;

public class RegistroFormatter {
	public static String formatToRegistro(String nome, String numero) {
		String registroFormatado = "\n------------------------------\n";
		registroFormatado += "NOME: " + (nome != null ? nome : "Nro Desconhecido");
		registroFormatado += "\nNUMERO: " + numero;
		registroFormatado += "\n------------------------------\n";
		
		return registroFormatado;
	}
}
