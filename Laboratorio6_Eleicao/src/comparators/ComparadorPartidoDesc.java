package comparators;

import candidatos.Candidato;

public class ComparadorPartidoDesc extends ComparadorCandidato {

	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		return (candidato1.getPartido().compareTo(candidato2.getPartido()) * -1);
	}
}
