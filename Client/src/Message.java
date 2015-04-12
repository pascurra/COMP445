import java.net.*;
import java.io.*;

public class Message 
{
	String hostname;	
	int serverPort;

	String JSONCommand;

	
	public Message( String hostname, int serverPort, String JSONCommand) {
		super();
		this.serverPort = serverPort;
		this.hostname = hostname;
		this.JSONCommand= JSONCommand;
	}

	// Needs developed still...
	public void SendAndRecieve() {
		Socket socket = null; // Also known as ClientSocket
		
		PrintWriter out;
		BufferedReader in;
		BufferedReader userInput;
	
		try {
			// Create a Socket and bind it to a port
			//serverPort = 6789;  specified in the message
			InetAddress host = InetAddress.getByName(hostname);
			socket = new Socket(host, serverPort);
			// Create the stream of data to be communicated between this client and the server
			out = new PrintWriter(socket.getOutputStream(), true); 
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   // userInput = new BufferedReader(new InputStreamReader(System.in));
			String line=JSONCommand;
			
			System.out.print("> " );
		
		
		
			//	while(line != null)
		//	{
				// Send the line to the server: Put the input line on the output stream
				out.println(line);
				System.out.println("Sent \"" + line + "\" to the server");
				// Receive response from the server: Read the response from input stream
				System.out.println("Received \"" + in.readLine() + "\" from the server");
				System.out.print("> " );
			//	if(line.equals("exit"))
		//			break;
	//		}
			
			
			// Close all the input and output streams, as well as the socket
			out.close();
			in.close();
		//	userInput.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		}
}

	
	public void send()
	{
		Socket socket = null; // Also known as ClientSocket
		
		PrintWriter out;
		BufferedReader in;
		BufferedReader userInput;
		
		try {
			// Create a Socket and bind it to a port
			//serverPort = 6789;  specified in the message
			InetAddress host = InetAddress.getByName(hostname);
			socket = new Socket(host, serverPort);
			// Create the stream of data to be communicated between this client and the server
			out = new PrintWriter(socket.getOutputStream(), true); 
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   // userInput = new BufferedReader(new InputStreamReader(System.in));
			String line=JSONCommand;
			
			System.out.print("> " );
			
			
			
		//	while(line != null)
		//	{
				// Send the line to the server: Put the input line on the output stream
				out.println(line);
				System.out.println("CLIENT: Sent \"" + line + "\" to the server");
				// Receive response from the server: Read the response from input stream
				System.out.println("CLIENT: Received \"" + in.readLine() + "\" from the server");
				System.out.print("> " );
			//	if(line.equals("exit"))
		//			break;
	//		}
			
			
			
			
			
			// Close all the input and output streams, as well as the socket
			out.close();
			in.close();
		//	userInput.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			System.out.println("CLIENT: UnknownHostException:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("CLIENT: IOException:" + e.getMessage());
		}
	}
}
