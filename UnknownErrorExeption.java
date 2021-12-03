package edu.najah.it.capp.exception;

public class UnknownErrorExeption extends ProtocolException {

	public UnknownErrorExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[UnknownErrorExeption :: ] " +message ;
		
	}

}
