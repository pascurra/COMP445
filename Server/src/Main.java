import java.io.*;
import java.net.*;
import java.sql.SQLException;

public class Main 
{
	public static void main(String[] args) throws SQLException 
	{
			
		Service service= new Service();
		Thread newThread = new Thread(service,"Service Threads");
		while (service.terminate!=true){
			newThread.start();
						
		}
	}

}