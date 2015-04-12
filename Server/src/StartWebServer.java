import java.io.IOException;

public class StartWebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebServer webServer = new WebServer("");

		while (webServer.terminate != true) {

			try {
				webServer.listenToRequest();

				//show all profiles
				if (webServer.request.equals("/AllProfiles")) {
					ListOfProfiles listOfProfiles = new ListOfProfiles();
					webServer.htmlContent = listOfProfiles.getListOfProfiles();
				}

				
				//show individual user
				else if (webServer.request.contains("-Twibbles")) {
					System.out.println("Displaying userprofile");

					
					int clienAliasIndex = webServer.request.indexOf("-");
					String clienAlias = webServer.request.substring(1, clienAliasIndex);
					System.out.println(clienAlias);
					
					showUserProfile showUserProfile = new showUserProfile(clienAlias);
					webServer.htmlContent = showUserProfile.showProfile();
					
					

				}

				webServer.renderHTML();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
