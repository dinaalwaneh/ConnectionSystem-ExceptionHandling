# Ass7

Add explactions for your solution in part 1 and 2 :

In the first part, I added an Exception to the realeas() and send() and getInstance() functions based on :

    I create 6 exception (BusyExeption , InuseExeption , NoConnAvailableExeption ,ProtocolException , ReleasedExeption , TimeOutExeption , UnknownErrorExeption) which extend from ProtocolException 
 Release method:
a. Connection is already released :
   insted of return false if the connection is not available i throw this exception :
      		throw new ReleasedExeption ("Connection is already released ");
   
b. Unable to release the connection because of an unknown error
       I put if statment 
       
    int sys_status = 400;
		if(Constraints.status==sys_status) {
			throw new UnknownErrorExeption ("Unable to release the connection because of an unknown error ");
		}
    
    or add catch in the end witch represent general exception :
        catch(Exception e) {
				System.out.println("Unexpected Error :: " + e.getMessage());
				throw new ProtocolException("Failed to process " + e.getMessage());
			}
c. Connection is inuse, you can’t release now :
    i declar connection statuse variable to chick if the connection is in use or not if yes then throw exeption will appear :
    if(Constraints.connectionInUse==1) {
			throw new ReleasedExeption ("Connection is inuse, you can’t release now ")
		}

send method
a. No connection is available :
    i check the protocol value :
    if it is equal null then i add NoConnAvailableExeption .
    if( instance == null) {
	 
			throw new NoConnAvailableExeption ("No connection is available");

		}
b. Failed to send the data because of a timeout error. 
      I create to varables process_time and current_sys_time if the system take time more than prosecc time i add TimeOutExeption exception .
      if(Constraints.process_time<Constraints.current_sys_time) {
			throw new TimeOutExeption ("Failed to send the data because of a timeout error");
		}
c. System is too busy now :
      i create status_busy = 0; thats mean that the system is not busy and stutusBusy =1 thats mean the system is busy and comparing them is the system is busy I add       BusyExeption .
    	int status_busy = 1;
 		if(status_busy == Constraints.stutusBusy) {
			throw new BusyExeption("Processor is busy, maybe try again");
		}
    
 and finallay  make sure the connection is always released after it is no longer needed  :
 finally {
			System.out.println("sending is done");
			instance.release();
		}
    
 part 2 :
 
    i put info logger to display the protocols witch i send it to getinstance function and the time sleep and the protocols witch i want to release them and How many times will while loop spin .
    i put error  logger for each exception and debug logger to see the reson of warning .
    i put warning logger in while loop to see for user "Be aware that an error can occur at any time".
     
 
 
 
 
 
 
 4.Explain why the logger uses a singleton design pattern :
 
having multiple logger class instances leads to more complex implementation, as the instances have to work together to manage the actual resource
The main problem is where the actual log is persisted.
having more than one instance  may result in a garbled .
and If we are writing on a filesystem we may have garbled  result in a file.
In the sense that depending on buffering and other low-level mechanisms messages from one write may end up mixed with messages (or parts of messages) from others.  
