import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class ListOfProfiles {
	
	public String getListOfProfiles(){
		
		
		databaseConnection ListOfProfiles=new databaseConnection("");
		
		
		ListOfProfiles.query="SELECT * FROM ascurra_445.profiles";
		ResultSet resultSet=ListOfProfiles.executeSelectStatement();
		
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
			listOfProfiles=listOfProfiles.concat("<div>Alias: <a href=\"http://localhost:8080/"+ (String) alias.get(i)+"-Twibbles/\">"+ (String) alias.get(i)+"</a> </div>");
			listOfProfiles=listOfProfiles.concat("<div>Location: "+(String) location.get(i)+"</div>");
			listOfProfiles=listOfProfiles.concat("<div>Interest: "+(String) interests.get(i)+"</div>");
			listOfProfiles=listOfProfiles.concat("<div>Date Of Joining Twibbler: "+(String) dateOfJoining.get(i)+"</div></div>");

			listOfProfiles=listOfProfiles.concat("<div>Date Of Profile Creation: "+(String) dateOfPostingProfile.get(i)+"</div></div>");
			listOfProfiles=listOfProfiles.concat("<div><div>"+"------------------"+"</div>");

			
		}
		
		

		
		return listOfProfiles;
		
		
		
		
	}

}
