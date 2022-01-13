package comparators;

import java.util.Comparator;
import classes.Paciente;

public class ComparadorPorIdade implements Comparator<Paciente> {

	@Override
	public int compare(Paciente p1, Paciente p2) {
		
		if (p1.getIdade() > p2.getIdade()) {
			return -1;
		}
		if (p1.getIdade() < p2.getIdade()) {
			return 1;
		}
		return 0;
	}
}
