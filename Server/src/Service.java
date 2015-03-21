import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Service {
	
	
	
	
	
	
	public Service() {
		super();
	}

	
	Boolean terminate=false;

	ServerSocket server = null;
	Socket socket; // Client Socket
	int serverPort = 6789;
	
	PrintWriter out;
	BufferedReader in;
	

	
	public void Execute(){
		
		try {
			// Create a Socket and bind it to a port
			server = new ServerSocket(serverPort);
			System.out.println("Server is up and running...");
			
			// Accept a connection from the client and associate a Socket to this connection
			socket = server.accept();
			// Create the stream of data to be communicated between this server and the client
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			
			int i=1;
			
			String command="noexit";
			// Read the request from the client
			
			
			while((line = in.readLine()) != null)
			{
				System.out.println ("Server has received \"" + line + "\" from the client"); 
				// Reverse the message and send it back to the client,
				out.println(new StringBuilder(line).toString()); 
		         if (line.equals("exit")) 
		             break;
			}
			
			
			
			
			
			
			
			
			// Close all the input and output streams, as well as the sockets
			in.close();
			out.close();
			socket.close();
			server.close();
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		}
		
		
		System.out.println("Service ended execution.");

		
		
	}
	
	
	

	
	
	
	
	
	

	
	
	

	
	
	
	
	
	
	
	
	
	

}