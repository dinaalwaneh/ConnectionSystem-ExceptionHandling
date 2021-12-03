package edu.najah.it.capp.asd;


import edu.najah.it.capp.exception.*;
import edu.najah.it.capp.exception.BusyExeption;
import edu.najah.it.capp.exception.NoConnAvailableExeption;
import edu.najah.it.capp.exception.TimeOutExeption;
import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.logger.Logger;
 


public class Demo {

	public static void main(String[] args) throws ProtocolException,ReleasedExeption ,UnknownErrorExeption, ass4.UnknownErrorExeption, ass4.ReleasedExeption, TimeOutExeption{
 
					int numOfTryyy = 5;
					Protocol ssh2 = null;
					 while(numOfTryyy>0) {
						 try{
							    ssh2 = Connection.getInstance(ConnectionType.SSH);
							    
								Logger.getInstance().logInfo("getInstance protocol parameter is : " + ConnectionType.SSH);
								Protocol telnet = Connection.getInstance(ConnectionType.TELNET);
								Logger.getInstance().logInfo("getInstance protocol parameter is : " + ConnectionType.TELNET);

								Protocol scp = Connection.getInstance(ConnectionType.SCP);
								Logger.getInstance().logInfo("getInstance protocol parameter is : " + ConnectionType.SCP);

								ssh2 = Connection.getInstance(ConnectionType.SSH);
								Logger.getInstance().logInfo("getInstance protocol parameter is : " + ConnectionType.SSH);

								Protocol ftp = Connection.getInstance(ConnectionType.FTP);
								Logger.getInstance().logInfo("getInstance protocol parameter is : " + ConnectionType.FTP);

								//Logger.getInstance().logWarning("Can't create more than 3 connection!!");
							
								
								}catch(NoConnAvailableExeption e){
									//System.out.println("this is the connection process message:: "+e.getMessage() );
									Logger.getInstance().logError("This is a warning message "+e.getMessage());
									e.printStackTrace();
									break;
								}catch(TimeOutExeption e){
									Logger.getInstance().logError("This is a warning message "+e.getMessage());
									e.printStackTrace();
									break;
								}catch(BusyExeption e){
									Logger.getInstance().logError("This is a warning message "+e.getMessage());
									e.printStackTrace();
									numOfTryyy--;
									sleap(500L);
									Logger.getInstance().logWarning("Be aware that an error can occur at any time");

								}catch(ProtocolException e){
									Logger.getInstance().logError("This is a warning message "+e.getMessage());
									e.printStackTrace();
									break;
								}
					 }
					int numOfTryy =5;
		      
					while(numOfTryy>0) {	
				 		try{
				 			
				 			
							Connection.release(ConnectionType.SSH);
							Logger.getInstance().logInfo("getInstance protocol parameter is : " + ConnectionType.SSH);

							Connection.release(ConnectionType.SSH);
							
						}catch(ReleasedExeption e){
							Logger.getInstance().logError("This is a warning message "+e.getMessage());							e.printStackTrace();
							break;
							
						}catch(InuseExeption e){
							Logger.getInstance().logError("This is a warning message "+e.getMessage());	
							e.printStackTrace();
							
 							numOfTryy--;
							sleap(500L);
							Logger.getInstance().logWarning("Be aware that an error can occur at any time");
						}catch(UnknownErrorExeption e){
							Logger.getInstance().logError("This is a warning message "+e.getMessage());							e.printStackTrace();
							 break;
						}catch(ProtocolException e){
							Logger.getInstance().logError("This is a warning message "+e.getMessage());							e.printStackTrace();
							break;
						}
				 		 
					}
				 System.out.println(Connection.getCurrentConnections());
				 
				 int numOfTry = 5;
					Logger.getInstance().logInfo("number of  : " + numOfTry);

				while(numOfTry>5) {
					 try {
					 ssh2.send("sss");
				 }
				 catch(NoConnAvailableExeption e){
					 Logger.getInstance().logError("This is a warning message "+e.getMessage());
					 e.printStackTrace();
						break;
					}catch(TimeOutExeption e){
						Logger.getInstance().logError("This is a warning message "+e.getMessage());	
					    e.printStackTrace();
						numOfTry--;

						sleap(500L); 
						Logger.getInstance().logWarning("Be aware that an error can occur at any time");
					}catch(BusyExeption e){
						Logger.getInstance().logError("This is a warning message "+e.getMessage());						 
						e.printStackTrace();
						break;
					}catch(ProtocolException e){
						Logger.getInstance().logError("This is a warning message "+e.getMessage());						 
						e.printStackTrace();
						break;
					} 
				 }
				}
				
				
			 		 
				 
			
	
	
			private static void sleap(Long timeOut) {
				Logger.getInstance().logInfo("timeOut = : " + timeOut);

				try {
					Thread.sleep(timeOut);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	}	
		
	}


