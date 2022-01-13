package helpers;

import java.util.regex.Pattern;

public class ValidadorNumeroRegistro {
	private static final Pattern pattern = Pattern.compile("((\\([0-9]{1,5}\\)|[0-9]{0,5}){0,1}\\s{0,1}([0-9]){3}-([0-9]){4}){0,1}(\\s{0,1}local\\s(\\([0-9]{1,4}\\)|[0-9]{1,4})){0,1}");
	
	public static boolean numeroEhValido(String numero) {
		return pattern.matcher(numero).matches();
	}
}
