package edu.najah.it.capp.exception;

public class TimeOutExeption extends ProtocolException {

	public TimeOutExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[TimeOutExeption :: ] " +message ;
		
	}

}
