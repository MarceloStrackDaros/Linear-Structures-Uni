package comparators;

import candidatos.Candidato;

public class ComparadorNomeDesc extends ComparadorCandidato {

	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		return (candidato1.getNome().compareTo(candidato2.getNome()) * -1);
	}
}
