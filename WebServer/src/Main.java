import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebServer webServer = new WebServer("");

		while (webServer.terminate != true) {

			try {
				webServer.listenToRequest();

				// show all profiles
				if (webServer.request.equals("/AllProfiles")) {
					ListOfProfiles listOfProfiles = new ListOfProfiles();
					webServer.htmlContent = listOfProfiles.getListOfProfiles();
				}

				// show individual user
				else if (webServer.request.contains("-Twibbles")) {
					System.out.println("Displaying userprofile");

					int clienAliasIndex = webServer.request.indexOf("-");
					String clienAlias = webServer.request.substring(1,
							clienAliasIndex);
					System.out.println(clienAlias);

					showUserProfile showUserProfile = new showUserProfile(
							clienAlias);
					webServer.htmlContent = showUserProfile.showProfile();

				}

				else if (webServer.request.equals("/")) {
					System.out.println("Displaying main page");

					String mainMenu = "";
					mainMenu = mainMenu.concat("<div><div>"
							+ "Welcome to Twibbler!" + "</div>");

					mainMenu = mainMenu
							.concat("<div>Go To:  <a href=\"http://localhost:8080/AllProfiles\">All Profiles</a> </div>");

					mainMenu = mainMenu.concat("<div><div>"
							+ "------------------" + "</div>");

					webServer.htmlContent = mainMenu;

				}

				webServer.renderHTML();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
