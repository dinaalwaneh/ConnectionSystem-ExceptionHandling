package edu.najah.it.capp.exception;

public class ReleasedExeption extends ProtocolException {

	public ReleasedExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		String message = super.getMessage();
		return "[ReleasedExeption :: ] " +message ;
		
	}
}
