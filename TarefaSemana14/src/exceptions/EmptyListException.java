package exceptions;

public class EmptyListException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyListException() {
		super("N�o existem elementos cadastrados na lista ainda.");
	}
}
