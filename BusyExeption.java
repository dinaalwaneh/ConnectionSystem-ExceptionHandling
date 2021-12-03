package edu.najah.it.capp.exception;

public class BusyExeption extends ProtocolException {

	public BusyExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[BusyExeption :: ] " +message ;
		
	}

}
