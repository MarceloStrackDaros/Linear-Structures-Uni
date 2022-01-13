package comparators;

import java.util.Comparator;

import celular.RegistroContato;

public class ComparadorPorNome implements Comparator<RegistroContato> {

	@Override
	public int compare(RegistroContato registroContato1, RegistroContato registroContato2) {		
		return registroContato1.getNome().compareTo(registroContato2.getNome());
	}

}
