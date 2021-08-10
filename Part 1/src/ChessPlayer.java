import java.util.Arrays;

public class ChessPlayer {
	
	// Declaring Instance Variables for the class ChessPlayer
	
	private int ChessPlayerNumber;                       // Unique Player Number
	private Name ChessPlayerName;                        // Player name
	private int ChessPlayerAge;                          // Player age
	private String ChessPlayerLevel;                     // Player Level (Eg: Class A , Class B, Class C)
	private String ChessPlayerGender;                    // Player Gender (Eg : Male, Female, Other ) 
	private int [] ChessPlayerScoresArray = new int [5];  // Array of scores gained by a chess player in 5 rounds of game.
	private Double overAllScore;                           // Overall score which can be a floating number (Eg: 4.6)
	
	// Constructor to create objects of the Chess Player
	// Assigning local values to the instance variables 
	
	public ChessPlayer(int lChessPlayerNumber, String lChessPlayerName , int lChessPlayerAge, String lChessPlayerLevel , String lChessPlayerGender, int[] lcometitorScoresArray) {
		ChessPlayerNumber      = lChessPlayerNumber;           
		ChessPlayerName        = new Name(lChessPlayerName);   // Creating an local object for the class Name
		ChessPlayerAge         = lChessPlayerAge;
		ChessPlayerGender      = lChessPlayerGender;			
		ChessPlayerLevel       = lChessPlayerLevel;
		ChessPlayerScoresArray = lcometitorScoresArray;
		this.getOverAllScoreArray();
		
		
		}

	/**
	 * @return the ChessPlayerNumber
	 */
	public int getChessPlayerNumber() { 
		return ChessPlayerNumber;
	}

	/**
	 * @param ChessPlayerNumber the ChessPlayerNumber to set
	 */
	public void setChessPlayerNumber(int ChessPlayerNumber) {
		this.ChessPlayerNumber = ChessPlayerNumber;
	}

	/**
	 * @return the ChessPlayerName
	 */
	public Name getChessPlayerName() {
		return ChessPlayerName;
	}

	/**
	 * @param ChessPlayerName the ChessPlayerName to set
	 */
	public void setChessPlayerName(String ChessPlayerName) {
		this.ChessPlayerName = new Name(ChessPlayerName);
	}

	/**
	 * @return the ChessPlayerAge
	 */
	public int getChessPlayerAge() {
		return ChessPlayerAge;
	}

	/**
	 * @param ChessPlayerAge the ChessPlayerAge to set
	 */
	public void setChessPlayerAge(int ChessPlayerAge) {this.ChessPlayerAge = ChessPlayerAge;}

	/**
	 * @return the ChessPlayerLevel
	 */
	public String getChessPlayerLevel() {return ChessPlayerLevel;}

	/**
	 * @param ChessPlayerLevel the ChessPlayerLevel to set
	 * @values Level 1 : Class c
	 *         Level 2 : Class B
	 * 	       Level 3 : Class A
	 */
	// Return the level of the Chess player.(Eg: Class A , Class B, Class C)
	public void setChessPlayerLevel(String ChessPlayerLevel) {
		this.ChessPlayerLevel = ChessPlayerLevel;
	}

	/**
	 * @return the ChessPlayerGender
	 */
	public String getChessPlayerGender() {
		return ChessPlayerGender;
	}

	/**
	 * @param ChessPlayerGender the ChessPlayerGender to set
	 */
	public void setChessPlayerGender(String ChessPlayerGender) {
		this.ChessPlayerGender = ChessPlayerGender;
	}

	/**
	 * @return the ChessPlayerScores
	 */
	public int[] getChessPlayerScoresArray() {
		return ChessPlayerScoresArray;
	}

	/**
	 * @param ChessPlayerScores the ChessPlayerScores to set
	 */
	public void setChessPlayerScoresArray(int[] ChessPlayerScores) {
		this.ChessPlayerScoresArray = ChessPlayerScores;
	}

	
	// Return the calculated Overall Score 
	// The logic is that the increment of the Chess Players Overallscores should decrease as his level increases. 
	// This is done by calculating the average of the top N scores of the chessplayer for that particular level. 
	
	public Double getOverAllScoreArray() {
		int[] lScoreArray= this.getChessPlayerScoresArray();  // Assigning the array score value to the Variable
		Arrays.sort(lScoreArray);                              // Method "Sort"  is used to arrange the array scores of a player in the ascending order
		double avg = 0 ;                                       // Initializing avg to "0"
	if(getChessPlayerLevel().contentEquals("Class C")){                   // If condition to check the level of the chess Player 
		avg  = lScoreArray[lScoreArray.length-1];               // Calculating avg of top "N" Array scores for a Class C player. 

	}
	else if(getChessPlayerLevel().contentEquals("Class B")){
		avg = (lScoreArray[lScoreArray.length- 1] + lScoreArray[lScoreArray.length- 2]) / 2.0 ;  // Calculating avg of top "N" Array scores for a Class B player. 

	}
	else if(getChessPlayerLevel().contentEquals("Class A")){
		avg = (lScoreArray[lScoreArray.length- 1] + lScoreArray[lScoreArray.length- 2] + lScoreArray[lScoreArray.length- 3] )/ 3.0 ; // Calculating avg of top "N" Array scores for a Class A player. 

	}
	
	return this.overAllScore = avg;          // returns the overall score of that level of player.
}

	/**
	 * @param overAllScore the overAllScore to set
	 */
	public void setOverAllScoreArray(double overAllScore) {
		this.overAllScore = overAllScore;
	}

	// Creating an Array of type String for the Scores of the chessPlayers 
	// String formating i.e "%s" to return the full details of the ChessPlayer.
	public String getFullDetails() {
		int[] lScoreArray = getChessPlayerScoresArray();
	    String lScoreArrayString = "";                
		
		for(int i = 0; i< lScoreArray.length; i++) {
			if(i !=4) {
				lScoreArrayString+=lScoreArray[i]+",";
			}else {
				lScoreArrayString+=lScoreArray[i];
			}
			    
		}		
		String fullDetails = String.format("%s is an Chess player aged %d having Cometitor number %d.\n"    
				+ "%s is a %s player and has awarded with these scores : %s\n" 
				+ "This gives an Overall Score of %,.1f.",
				getChessPlayerName().getFullName(),
				getChessPlayerAge(),
				getChessPlayerNumber(),
				getChessPlayerName().getFirstName(),
				getChessPlayerLevel(),
				lScoreArrayString,
				getOverAllScoreArray());
				
		return fullDetails;
								
	}
	
	// This method i.e String formating "%s" to return the short details of the ChessPlayer.
	
	public String getShortDetails() {
		String shortDetails = String.format("CN %d (%s) has overall score %,.1f.",
				this.getChessPlayerNumber(),
				this.ChessPlayerName.getInitials(),
				this.getOverAllScoreArray()
				);
		
		return shortDetails;
	}
	
	
		// This returns the ChessPlayer_score String as the scores are entered in array		
		public String getChessPlayer_ScoresString() {
			
		
			String chessPlayer_ScoresString = "";
			for(int i = 0; i< 5; i++) {
				if(i !=4) {
				 chessPlayer_ScoresString+=this.ChessPlayerScoresArray[i]+",";
				}else {
					chessPlayer_ScoresString+=this.ChessPlayerScoresArray[i];
				}
			}
			
			return chessPlayer_ScoresString;		

		
	
		
  }
	
	
	public class Name {            // The code is from the lecture notes 
		 private String firstName;
		 private String middleName;
		 private String lastName;

		 //constructor to create object with a first and last name
		 public Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
		 }

		 //constructor to create object with first, middle and last name
		 //if there isn't a middle name, that parameter could be an empty
		//String
		 public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
		}
		 //constructor to create name from full name
		 //in the format first name then space then last name
		 //or first name then space then middle name then space then last name
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

		 //returns the first name
		 public String getFirstName() {return firstName; }
		 //returns the last name
		 public String getLastName() {return lastName; }

		 //change the last name to the value provided in the parameter
		 public void setLastName(String ln) {
		 lastName = ln;
		 }

		 //returns the first name then a space then the last name
		 public String getFirstAndLastName() {
		return firstName + " " + lastName;
		 }

		 //returns the last name followed by a comma and a space
		 // then the first name
		 public String getLastCommaFirst() {
		return lastName + ", "+ firstName;
		 }

		 //returns the full name		
		 //either first name then space then last name
		 //or first name then space then middle name then space
		 // and then last name
		 public String getFullName() {
		 String result = firstName + " ";
		 if (!middleName.equals("")) {
		 result += middleName + " ";
		 }
		 result += lastName;
		 return result;
		}
		 
		 
		 // This method return the  Initials of the Chess PLayer 
		public String getInitials() {
			if(middleName =="") {
				return String.format("%s%s",firstName.charAt(0) , lastName.charAt(0));
				
			}
			else {
			return String.format("%s%s%s",firstName.charAt(0) , middleName.charAt(0) , lastName.charAt(0));
		}
	}

	}
}

