package ordenacao;

import exceptions.EmptyListException;
import superClasses.ArrayComTroca;

public class ArraySelect extends ArrayComTroca {

	public ArraySelect(int tamanhoArray) {
		super(tamanhoArray);
	}

	@Override
	public void sort() throws Exception {
		if (this.numeroElementos == 0) {
			throw new EmptyListException();
		}
		
		int fora, dentro, minimo;

		for (fora = 0; fora < numeroElementos - 1; fora++) {
			minimo = fora;
			for (dentro = fora + 1; dentro < numeroElementos; dentro++) {
				if (array[dentro] < array[minimo])
					minimo = dentro;
			}
			troca(fora, minimo);
		}
	}

}
