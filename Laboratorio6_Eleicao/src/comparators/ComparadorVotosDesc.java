package comparators;

import candidatos.Candidato;

public class ComparadorVotosDesc extends ComparadorCandidato {

	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		if (candidato1.getNumVotos() > candidato2.getNumVotos()) {
			return -1;
		}
		
		if (candidato1.getNumVotos() < candidato2.getNumVotos()) {
			return 1;
		}
		
		return 0;
	}

}
