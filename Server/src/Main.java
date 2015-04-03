import java.io.*;
import java.net.*;
import java.sql.SQLException;

public class Main 
{
	public static void main(String[] args) throws SQLException 
	{
		
		
		Service service= new Service();
		

		while (service.terminate!=true){
			
			service.Execute();

					
		}
				
		
	}

}
