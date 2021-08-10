//Basics 6
public class Name {
  private String firstName;
  private String middleName;
  private String lastName;
  
  public Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
  }
  
  public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
}
  
  public Name (String fullName) {
	  int spacePos1 = fullName.indexOf(' ');
	  firstName = fullName.substring(0, spacePos1);
	  int spacePos2 = fullName.lastIndexOf(' ');
	  if (spacePos1 == spacePos2)
		  middleName = "";
	  else 
		  middleName = fullName.substring(spacePos1+1, spacePos2);
	  lastName = fullName.substring(spacePos2 + 1);
  }
  
  public String getFirstName() {return firstName; }
  public String getMiddleName() { return middleName; }
  public String getLastName() {return lastName; }
  
  public void setFirstName(String fn) {
	  firstName = fn;
  }
  public void setMiddleName(String mn) {
	   middleName = mn;
  }
  public void setLastName(String ln) {
	  lastName = ln;
  }
  
  public String getFirstAndLastName() {
		return firstName + " " + lastName;
  }
  
  public String getLastCommaFirst() {
		return lastName + ", "+ firstName;
  }
  

  
  public String getFullName() {
	  String result = firstName + " ";
	  if (!middleName.equals("")) {
		  result += middleName + " ";
	  }
	  result += lastName;
	  return result;	  
  }
  
  public String getInitials() {
		if(middleName =="") {
			return String.format("%s%s",firstName.charAt(0) , lastName.charAt(0));

		}
		else {
			return String.format("%s%s%s",firstName.charAt(0) , middleName.charAt(0) , lastName.charAt(0));
		}
  }
  
}
 


