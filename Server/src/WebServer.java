import java.io.*;
import java.net.*;
// Implementing the Runnable interface, the runnable object is passed to the Thread constructor
// How to use: Run your server, then type http://localhost:55555/ in the address bar of your browser

public class WebServer {

	String htmlContent;
	String request;
	Boolean terminate = false;
	Socket clientSocket = null;
	ServerSocket serverSocket = null;


	public WebServer(String htmlContent) {

		this.htmlContent = htmlContent;
		

	}

	public void listenToRequest() throws IOException {
		try {
			serverSocket = new ServerSocket(8080);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 8080.");
			System.exit(1);
		}

		try {
			clientSocket = serverSocket.accept();

			if (clientSocket != null)
				System.out.println("Connected");

		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}		
		DataInputStream din = new DataInputStream(clientSocket.getInputStream());
		request = din.readLine().trim();
		request = request.substring(4);
		if (request.contains(" ")) {
			int i = request.indexOf(" ");
			request = request.substring(0, i);
			System.out.println(request);

		}
		
		
	}
		
		
	public void renderHTML() throws IOException {

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
	
		out.println("HTTP/1.1 200 OK");
		out.println("Content-Type: text/html");
		out.println("\r\n");
		out.println(this.htmlContent);
		out.flush();

		out.close();

		clientSocket.close();
		serverSocket.close();
		
		
	}
	}


