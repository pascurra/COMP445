import java.io.*;
import java.net.*;
// Implementing the Runnable interface, the runnable object is passed to the Thread constructor
// How to use: Run your server, then type http://localhost:55555/ in the address bar of your browser

public class Server 
{
		   
	public static void main(String[] args) throws InterruptedException, IOException
	{
	     ServerSocket serverSocket = null;
	       try {
	             serverSocket = new ServerSocket(55555); 
	           } catch (IOException e) 
	           {
	             System.err.println("Could not listen on port: 55555.");
	             System.exit(1);
	       }

	       Socket clientSocket = null; 
	       try {
	            clientSocket = serverSocket.accept();

	            if(clientSocket != null)                
	                System.out.println("Connected");

	       } catch (IOException e) {
	             System.err.println("Accept failed.");
	             System.exit(1);
	      }

	     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());


	    out.println("HTTP/1.1 200 OK");
	    out.println("Content-Type: text/html");
	    out.println("\r\n");
	    out.println("<p> Hello world </p>");
	    out.flush();

	    out.close();

	    clientSocket.close();
	    serverSocket.close();
	}

}
