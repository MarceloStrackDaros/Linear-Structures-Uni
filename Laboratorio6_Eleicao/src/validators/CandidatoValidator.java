package validators;

import candidatos.Candidato;

public class CandidatoValidator {
	public static boolean candidatoEhValido(Candidato candidato) {
		return (
				atributoCandidatoEhValido(candidato.getNome())
				&& atributoCandidatoEhValido(candidato.getPartido())
				&& atributoCandidatoEhValido((candidato.getIdade() + ""))
		);
	}
	
	public static boolean atributoCandidatoEhValido(String info) {
		return !info.isEmpty() && info != null;
	}
}
