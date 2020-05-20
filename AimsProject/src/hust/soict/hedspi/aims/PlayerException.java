package hust.soict.hedspi.aims;

public class PlayerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PlayerException(String msg) {
		super(msg);
	}
	public PlayerException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
