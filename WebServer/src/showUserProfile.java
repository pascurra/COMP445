import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class showUserProfile {

	String client;

	public showUserProfile(String client) {
		super();
		this.client = client;
	}

	
	public String showProfile(){	
		
		
		String contentToReturn="";		
		
		databaseConnection ListOfClients=new databaseConnection("");		
		
		ListOfClients.query="SELECT * FROM ascurra_445.clients where alias='"+client+"'";
		ResultSet resultSetClients=ListOfClients.executeSelectStatement();
		
	      ArrayList idusers = new ArrayList();		
	      ArrayList aliasClients = new ArrayList();		
	      ArrayList email = new ArrayList();		
	      ArrayList registrationDate = new ArrayList();		

	      
	      
		try {
			while (resultSetClients.next()) {

				idusers.add(resultSetClients.getInt("idusers"));
				aliasClients.add(resultSetClients.getString("alias"));
				email.add(resultSetClients.getString("email"));
				registrationDate.add(resultSetClients.getString("registrationDate"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String listOfclients="";
		
		for (int i=0;i< aliasClients.size();i++){
			listOfclients=listOfclients.concat("<div><div>Client id: "+idusers.get(i).toString()+"</div>");
			listOfclients=listOfclients.concat("<div>Client alias: "+ (String) aliasClients.get(i)+"</div>");
			listOfclients=listOfclients.concat("<div>Client email: "+(String) email.get(i)+"</div>");
			listOfclients=listOfclients.concat("<div>Registration Date: "+(String) registrationDate.get(i)+"</div></div>");

			
		}
		
		contentToReturn=contentToReturn.concat(listOfclients);		
		
		databaseConnection userProfile=new databaseConnection("");		
		
		userProfile.query="SELECT * FROM ascurra_445.profiles where alias='"+client+"'";
		ResultSet resultSet=userProfile.executeSelectStatement();
		
	      ArrayList idProfiles = new ArrayList();		
	      ArrayList alias = new ArrayList();		
	      ArrayList location = new ArrayList();		
	      ArrayList interests = new ArrayList();		
	      ArrayList dateOfJoining = new ArrayList();		
	      ArrayList dateOfPostingProfile = new ArrayList();		

	      
	      
		try {
			while (resultSet.next()) {

				idProfiles.add(resultSet.getInt("idprofiles"));
				alias.add(resultSet.getString("alias"));
				location.add(resultSet.getString("location"));
				interests.add(resultSet.getString("interests"));
				dateOfJoining.add(resultSet.getString("dateOfJoining"));
				dateOfPostingProfile.add(resultSet.getString("dateOfPostingProfile"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		String listOfProfiles="";
		
		for (int i=0;i< alias.size();i++){
			
			listOfProfiles=listOfProfiles.concat("<div><div>"+"Profile:"+"</div>");

			listOfProfiles=listOfProfiles.concat("<div><div>Id: "+idProfiles.get(i).toString()+"</div>");
			listOfProfiles=listOfProfiles.concat("<div>Alias: "+ (String) alias.get(i)+"</div>");
			listOfProfiles=listOfProfiles.concat("<div>Location: "+(String) location.get(i)+"</div>");
			listOfProfiles=listOfProfiles.concat("<div>Interest: "+(String) interests.get(i)+"</div>");
			listOfProfiles=listOfProfiles.concat("<div>Date Of Joining Twibbler: "+(String) dateOfJoining.get(i)+"</div></div>");

			listOfProfiles=listOfProfiles.concat("<div>Date Of Profile Creation: "+(String) dateOfPostingProfile.get(i)+"</div></div>");
			listOfProfiles=listOfProfiles.concat("<div><div>"+"------------------"+"</div>");

			
		}
		
		if (alias.size()==0){
			
			listOfProfiles="* No Profile for this User.</br>";
		}
		
		
		
		ListOfTwibbles ListOfTwibbles=new ListOfTwibbles(client);
		String listOfTwibbles = ListOfTwibbles.getListOfTwibbles();
		contentToReturn=contentToReturn.concat(listOfProfiles);
		contentToReturn=contentToReturn.concat(listOfTwibbles);
		
		return contentToReturn;		
		
	}

}
