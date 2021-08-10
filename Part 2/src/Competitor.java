public abstract class Competitor {
	
	// Declaring Instance Variables for the class ChessPlayer
	private int competitorNumber; 			 // Unique Player Number
	private Name competitorName;			// Player name
	private String competitorAge;			// Player age
	private String competitorGender; 		// Player Gender (Eg : Male, Female, Other ))
	protected String competitorLevel;		// Player Level (Eg: Class A , Class B, Class C
	protected int competitorScore[] = new int[5];  // Array of scores gained by a chess player in 5 rounds of game.
	
	
	// Constructor to create objects of the Chess Player
		// Assigning local values to the instance variables
	
	public Competitor(int lcompetitorNumber, String lcompetitorName , String lcompetitorAge, String lcompetitorGender, String lcompetitorLevel, int[] lcompetitorScores) {
		

		competitorNumber = lcompetitorNumber;
		competitorName   = new Name (lcompetitorName);		// Creating an local object for the class Name
		competitorAge    = lcompetitorAge;
		competitorGender = lcompetitorGender; 
		competitorLevel  = lcompetitorLevel;
		competitorScore = lcompetitorScores;
           
}

	public int getCompetitorNumber() { return competitorNumber; }
	
	public void setCompetitorNumber( int competitorNumber) { this.competitorNumber = competitorNumber;}

	public Name getCompetitorName() { return competitorName;}

	public void setCompetitorName(Name competitorName) { this.competitorName = competitorName; }

	public String getCompetitorAge() { return competitorAge; }

	public void setCompetitorAge(String competitorAge) { this.competitorAge = competitorAge; }

	public String getCompetitorGender() { return competitorGender; }

	public void setCompetitorGender(String competitorGender) { this.competitorGender = competitorGender; }
	
    public int[] getCompetitorScoresArray() { return competitorScore; }
	
	public void setCompetitorScoresArray(int[] ChessPlayerScores) { this.competitorScore = ChessPlayerScores; }
	
	public String getCompetitorLevel() { return competitorLevel;}
	
	public String getCompetitorScoresString() {
		
		
		String Player_ScoresString = "";
		
		for(int i = 0; i< 5; i++) {
			if(i !=4) {
			 Player_ScoresString+=this.competitorScore[i]+",";
			}else {
				Player_ScoresString+=this.competitorScore[i];
			}
		}
		
		return Player_ScoresString;
	}
	
	/**
	 * @param PlayerLevel the PlayerLevel to set
	 * @values Level 1 : Class c
	 *         Level 2 : Class B
	 * 	       Level 3 : Class A
	 */
	// Return the level of the player.(Eg: Class A , Class B, Class C)
	
	
	public void setChessPlayerLevel(String ChessPlayerLevel) {
		this.competitorLevel = ChessPlayerLevel; }
	
	
	public abstract String getShortDetails() ;
	
	public abstract String getFullDetails() ;
	
	public abstract Double getOverAllScore();
	
}


