import java.io.*;
import java.net.*;

public class Main 
{
	public static void main(String[] args) 
	{
		
		
		Service service= new Service();
		

		while (service.terminate!=true){
			
			service.Execute();

			
			
		}
		
		
		

		
		
	}

}
