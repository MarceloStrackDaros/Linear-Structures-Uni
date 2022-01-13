package comparators;

import candidatos.Candidato;

public class ComparadorIdadeAsc extends ComparadorCandidato {

	@Override
	public int compare(Candidato candidato1, Candidato candidato2) {
		
		if (candidato1.getIdade() < candidato2.getIdade()) {
			return -1;
		}
		if (candidato1.getIdade() > candidato2.getIdade()) {
			return 1;
		}
		return 0;
	}
}
