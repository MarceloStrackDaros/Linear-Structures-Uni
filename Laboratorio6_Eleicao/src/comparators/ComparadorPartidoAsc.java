package comparators;

import candidatos.Candidato;

public class ComparadorPartidoAsc extends ComparadorCandidato {

	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		return candidato1.getPartido().compareTo(candidato2.getPartido());
	}
}
