package edu.najah.it.capp.exception;

public class NoConnAvailableExeption extends ProtocolException {

	public NoConnAvailableExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return   "[NoConnAvailableExeption :: ] " +message;
		
	}

}
