import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;











import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;







import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;
import org.xml.sax.InputSource;



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
			
			//String command="noexit";
			// Read the request from the client
			String xml="";
			
			
			while((line = in.readLine()) != null)
			{
				System.out.println ("Server has received \"" + line + "\" from the client"); 
				// Reverse the message and send it back to the client,
				out.println(new StringBuilder(line).toString());
				xml=line;
		         if (line.equals("exit")) 
		             break;
			}
			
			Document doc=null;
			
			//Demarshall
			
			
			
			
			try {
				doc=loadXML(xml);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			

			String command = doc.getElementsByTagName("command").item(0).getTextContent();
			
			
			System.out.println("The command to execute is: " + command);		
			
			//create query object
			databaseConnection registerQuery=new databaseConnection("");

			
			
			
			
			
			
			//String Command="Deregister";
			
			
			// Menu 3 , 3
			if (command.equals("Deregister")){
				String alias = doc.getElementsByTagName("alias").item(0).getTextContent();
				System.out.println("The alias to delete is: " + alias);		

				//query db to delete
				
				//create one object for the conection

				
				//Example to delete alias paolo2015
				registerQuery.query="DELETE FROM ascurra_445.clients WHERE alias=\"paolo2015\";";
				registerQuery.ExecuteUpdate();
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			// Menu 1.1
			if (command.equals("Register")){
				String email="paolo@";
				String alias="paolo";
				String time="";
				
				// How to grab the input from user stored in JSON?
				
				//Write to database
				

				databaseConnection registerQuery=new databaseConnection("INSERT INTO clients (alias, email, registrationDate) VALUES (" + alias + ", " + email + ", " + time + ");");
				ResultSet result=registerQuery.Query();

				//Paolo says: Needs to be updated like 3.3
		//		databaseConnection registerQuery=new databaseConnection("INSERT INTO...");
		//		ResultSet result=registerQuery.Query();

				
				
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
	
	
	

	
	
	
	
	
	
	public static Document loadXML(String xml) throws Exception
	{
	   DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
	   DocumentBuilder bldr = fctr.newDocumentBuilder();
	   InputSource insrc = new InputSource(new StringReader(xml));
	   return bldr.parse(insrc);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	

}
