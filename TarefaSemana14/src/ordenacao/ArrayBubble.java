package ordenacao;

import superClasses.ArrayComTroca;

public class ArrayBubble extends ArrayComTroca {

	public ArrayBubble(int tamanhoArray) {
		super(tamanhoArray);
	}

	@Override
	public void sort() throws Exception {
		if (this.numeroElementos == 0) {
			throw new Exception("Não existem elementos cadastrados na lista ainda.");
		}
		
		int fora, dentro;

		for (fora = this.numeroElementos - 1; fora > 1; fora--)
			for (dentro = 0; dentro < fora; dentro++)
				if (this.array[dentro] > this.array[dentro + 1])
					troca(dentro, dentro + 1);	
	}
}
