package superClasses;

public abstract class ArrayComTroca extends Array {

	public ArrayComTroca(int tamanhoArray) {
		super(tamanhoArray);
	}

	protected void troca(int elemento1, int elemento2) {
		long temp = array[elemento1];
		array[elemento1] = array[elemento2];
		array[elemento2] = temp;
	}
}
