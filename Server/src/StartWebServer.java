import java.io.IOException;


public class StartWebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
ListOfClients listOfClients=new ListOfClients();

String htmlcontent=listOfClients.getListOfClients();

WebServer webServer= new WebServer("<p>"+htmlcontent+"</p>");



		while (webServer.terminate!=true){
			
			try {
				webServer.renderHtml();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}
		
	}

}
