import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import org.w3c.dom.Document;

public class Message 
{
	String hostname;	
	int serverPort;
	Scanner input = new Scanner(System.in);
	//static String ServerIP = "localhost";
	ArrayList<Integer> arl = new ArrayList<Integer>();

	String JSONCommand;

	
	public Message( String hostname, int serverPort, String JSONCommand) {
		super();
		this.serverPort = serverPort;
		this.hostname = hostname;
		this.JSONCommand= JSONCommand;
	}

	// Needs developed still so don't use this one for now, use send() for multithreading purposes!
	public void SendAndReceive() {
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
			
			int j = 1;
			
			//	while(line != null)
			//	{
					// Send the line to the server: Put the input line on the output stream
					out.println(line);
					System.out.println("CLIENT: Sent \"" + line + "\" to the server");
					// Receive response from the server: Read the response from input stream
					System.out.println("Which twibble would you like to delete?");
					while((line = in.readLine()) !=null) {

					System.out.println("CLIENT: Received \"" + in.readLine() + "\" from the server");
					
					// From earlier attempt
					//arl.add(j);
					//j++;
					System.out.print("> " );
					}
					
					// From earlier attempt
					/**
					System.out.println("Please enter Twibble ID to delete: ");
					int twibbleID = input.nextInt();
					for (int i: arl) {
						System.out.println(i); // Just to see output
						if(twibbleID == i) {
						String JSONCommand =
	
						"<ExecuteCommand><command>Twibble Delete</command><twibbleID>"
								+ twibbleID + "</twibbleID></ExecuteCommand>";
						
						
						Message message = new Message(hostname, 6789, JSONCommand);
						message.send();
						System.out.println("Do we make it here?");
						}
					}
	*/
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
			
			

			
		//	while(line != null)
		//	{
				// Send the line to the server: Put the input line on the output stream
				out.println(line);
				System.out.println("CLIENT: Sent \"" + line + "\" to the server");
				// Receive response from the server: Read the response from input stream
				
				System.out.println("CLIENT: Received \"" + in.readLine() + "\" from the server");
				//System.out.println("CLIENT: Received \"" + in.readLine() + "\" from the server");
				
				

				
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
