package edu.najah.it.capp.exception;

public class InuseExeption extends ProtocolException {

	public InuseExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[InuseExeption :: ] " +message ;
		
	}
}
