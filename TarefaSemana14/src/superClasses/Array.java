package superClasses;

import exceptions.EmptyListException;
import exceptions.ListMaxLimitExceededException;
import interfaces.IArray;

public abstract class Array implements IArray {
	protected long[] array;
	protected int numeroElementos;
	
	public Array(int tamanhoArray) {
		array = new long[tamanhoArray];
		numeroElementos = 0;
	}
	
	public void insere(long valor) throws Exception {
		if (this.numeroElementos >= this.array.length) {
			throw new ListMaxLimitExceededException();
		}
		
		this.array[this.numeroElementos] = valor;
		this.numeroElementos++;
	}
	
	public void mostra() throws Exception {
		if (this.numeroElementos == 0) {
			throw new EmptyListException();
		}
		for (int j = 0; j < numeroElementos; j++)
			System.out.print(array[j] + " ");
		System.out.println("");
	}
}
