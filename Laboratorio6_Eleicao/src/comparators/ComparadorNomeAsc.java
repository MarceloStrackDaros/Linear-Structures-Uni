package comparators;

import candidatos.Candidato;

public class ComparadorNomeAsc extends ComparadorCandidato {

	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		return candidato1.getNome().compareTo(candidato2.getNome());
	}
}
