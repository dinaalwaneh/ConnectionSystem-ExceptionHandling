package edu.najah.it.capp.asd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.najah.it.capp.exception.BusyExeption;
import edu.najah.it.capp.exception.NoConnAvailableExeption;
import edu.najah.it.capp.exception.UnknownErrorExeption;
import edu.najah.it.capp.exception.ReleasedExeption;
 import edu.najah.it.capp.asd.impl.TFTPAdpter;
import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Constraints;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.impl.ProtocolFactory;
import edu.najah.it.capp.asd.impl.Scp;
import edu.najah.it.capp.asd.impl.Ssh;
import edu.najah.it.capp.asd.impl.Telnet;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.TimeOutExeption;

public class Connection {
	
	
	
	public static Map connections = new HashMap<String, Protocol>();
	//getInstance, createConnection , getConnection 
	public static Protocol getInstance(String connectionType) throws ProtocolException{
		
		int status_busy=0;
		if(status_busy == Constraints.stutusBusy) {
			throw new BusyExeption("Processor is busy, maybe try again");
		}
		if(Constraints.process_time<Constraints.current_sys_time) {
			throw new TimeOutExeption ("Failed to send the data because of a timeout error");
		}
		if(connections.containsKey(connectionType)) {
			System.out.println("Connection is already created!.");
			return (Protocol) connections.get(connectionType);
		} else {
			if(connections.size() >= 3 ) {
				//do not create connection
				System.out.println("Can't create more than 3 connection!!");
				throw new NoConnAvailableExeption ("No connection is available");

			}
			Protocol instance = ProtocolFactory.createProcol(connectionType);
			connections.put(connectionType, instance);
			return instance;
			
		}
	}
	
	public static boolean release(String connectionType) throws ProtocolException {
		
		int sys_status = 400;
		if(Constraints.status==sys_status) {
			throw new UnknownErrorExeption ("Unable to release the connection because of an unknown error ");
		}
		if(Constraints.connectionInUse==1) {
			throw new ReleasedExeption ("Connection is inuse, you can’t release now ");

		}
		if(connections.containsKey(connectionType)) {
			
			try {
				connections.remove(connectionType);
 
			}catch(Exception e) {
				System.out.println("Unexpected Error :: " + e.getMessage());
				throw new ProtocolException("Failed to process " + e.getMessage());
			} finally {
				System.out.println("Releasing the processor");
				ProtocolFactory.createProcol(connectionType).release();
				return true;
			}
			
		}
		
		throw new ReleasedExeption ("Connection is already released ");
		
	}
	public static ArrayList<String> getCurrentConnections() {
		Set<String> keys = connections.keySet();
		
		ArrayList<String> myConnection =  new ArrayList<String>();
		for (String key : keys) {
			myConnection.add(key);
		}
		return myConnection;
		
		
	}

}
