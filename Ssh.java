package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.BusyExeption;
import edu.najah.it.capp.exception.TimeOutExeption;
import edu.najah.it.capp.exception.NoConnAvailableExeption;
import edu.najah.it.capp.exception.TimeOutExeption;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.BusyExeption;
import edu.najah.it.capp.exception.ProtocolException;
public class Ssh implements Protocol {

private static Protocol instance;
	
	
	private Ssh() {
		System.out.println("Creating a new SSH insatnce");
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Ssh();
		}
		return instance;
	}
	@Override
	public boolean release() {
		instance = null;
		return true;
	}

	@Override
	public void send(String message) throws ProtocolException {
		
		int status_busy = 0;
		System.out.println(instance);
		if(status_busy == Constraints.stutusBusy) {
			throw new BusyExeption("Processor is busy, maybe try again");
		}
		if(Constraints.process_time<Constraints.current_sys_time) {
			throw new TimeOutExeption ("Failed to send the data because of a timeout error");
		}
		if( instance == null) {
			System.out.print(false);
			throw new edu.najah.it.capp.exception.NoConnAvailableExeption ("No connection is available");

		}
		
		try {
			System.out.println("Sending message from SSH :: " + message);
		}catch(Exception e) {
			System.out.println("Unexpected Error :: " + e.getMessage());
			throw new ProtocolException("Failed to process the data" + e.getMessage());
		} finally {
			System.out.println("sending is done");
			instance.release();
		}

	}

}
