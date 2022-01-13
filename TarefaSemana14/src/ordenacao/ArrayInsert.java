package ordenacao;

import superClasses.Array;

public class ArrayInsert extends Array {

	public ArrayInsert(int tamanhoArray) {
		super(tamanhoArray);
	}

	@Override
	public void sort() throws Exception {
		if (this.numeroElementos == 0) {
			throw new Exception("Não existem elementos cadastrados na lista ainda.");
		}
		
		int dentro, fora;

		for (fora = 1; fora < numeroElementos; fora++) {
			long temp = array[fora];
			dentro = fora;
			while (dentro > 0 && array[dentro - 1] >= temp) {
				array[dentro] = array[dentro - 1]; 
				--dentro; 
			}
			array[dentro] = temp; 
		}
	}

}
