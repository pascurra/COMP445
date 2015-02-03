
import java.io.*;
import java.net.*;
public class socketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
							
		//Host Server Definition
		String host = "localhost";
		//Port Definition
		int port = 19999;
		
		StringBuffer instr = new StringBuffer();
		String TimeStamp;
		System.out.println("SocketClient initialized");
				
		try {
		      /** Obtain an address object of the server */
		      InetAddress address = InetAddress.getByName(host);
		      /** Establish a socket connection */
		      Socket connection = new Socket(address, port);
		      /** Instantiate a BufferedOutputStream object */
		      BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
		      /** Instantiate an OutputStreamWriter object with the optional character
	           * encoding.
	           */
	          OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
	          

	          TimeStamp = new java.util.Date().toString();
	          String process = "Calling the Socket Server on "+ host + " port " + port +
	              " at " + TimeStamp +  (char) 13;

	          /** Write across the socket connection and flush the buffer */
	          osw.write(process);
	          osw.flush();
		          
		}
		
		catch(IOException a){
			System.out.println("IO Exception "+a);
		}
		
	
	}

}