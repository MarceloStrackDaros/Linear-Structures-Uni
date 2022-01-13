package exceptions;

public class ListMaxLimitExceededException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListMaxLimitExceededException() {
		super("O limite do array foi atingido.");
	}
}
