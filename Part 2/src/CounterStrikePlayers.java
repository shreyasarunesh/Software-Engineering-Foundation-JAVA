import java.util.Arrays;

public class CounterStrikePlayers extends Competitor{
	private String competitionType; 
	private Double overAllScore; 
	
	// Constructor for the chess player
	
	public CounterStrikePlayers(String lcompetitonType, int lcompetitorNumber, String lcompetitorName , String lcompetitorAge, String lcompetitorLevel, String lcompetitorGender,
						int[] lcometitorScoresArray ) {
		
		super(lcompetitorNumber, lcompetitorName, lcompetitorAge, lcompetitorGender, lcompetitorLevel, lcometitorScoresArray);

		competitionType = lcompetitonType;
		this. getOverAllScore();
	}
	
	// abstract method to calculate the overall score of the chess player 
	// Average of top n scores where n is the level number
	@Override
	public Double getOverAllScore() {

		
		int[] lScoreArray= this.getCompetitorScoresArray();  // Assigning the array score value to the Variable
		Arrays.sort(lScoreArray);                              // Method "Sort"  is used to arrange the array scores of a player in the ascending order
		overAllScore = 0.0 ;                                     
		for (int i = 1; i<= 3; i++) {
			overAllScore += lScoreArray[i];
		}
		
		overAllScore /= 3;
		return this.overAllScore;          // returns the overall score of that level of player.
	};

	// methord to set overall score
	public void setOverAllScore(Double overAllScore) { this.overAllScore = overAllScore; }
	
	public String getCompetitionType() { return competitionType; }

	public void setCompetitionType(String competitionType) { this.competitionType = competitionType; }
	
	// Method to calculate the short details of the player 
	@Override 
	public String getShortDetails() {String shortDetails = String.format("CN %d (%s) has overall score %,.1f.",

			this.getCompetitorNumber(),
			this.getCompetitorName().getInitials(),
			this.getOverAllScore()
			);

	return shortDetails;
		
	} 
	

	// Method to calculate the full details of the competitor using the concept of string formating 
	 
	
	@Override
	public  String getFullDetails() {
		int[] lScoreArray = getCompetitorScoresArray();
		String lScoreArrayString = "";                

		for(int i = 0; i< lScoreArray.length; i++) {
			if(i !=4) {
				lScoreArrayString+=lScoreArray[i]+",";
			}else {
				lScoreArrayString+=lScoreArray[i];
			}

		}		
		String fullDetails = String.format("%s is an Counter Strike player aged %d having Cometitor number %d.\n"    
				+ "%s is a %s player and has awarded with these scores : %s\n" 
				+ "This gives an Overall Score of %,.1f.",
				getCompetitorName().getFullName(),
				getCompetitorAge(),
				getCompetitorNumber(),
				getCompetitorName().getFirstName(),
			    getCompetitorScoresArray(), 
				lScoreArrayString,
				getOverAllScore());

		return fullDetails;
	}
	
}




//import java.util.Arrays;
//
//public class CounterStrikePlayers extends Competitor{
//	
//	private String competitionType;
//	private Double overAllScore; 
//	
//	// Constructor for the counter Strike player
//	public CounterStrikePlayers(String lcompetitonType, int lcompetitorNumber, String lcompetitorName , String lcompetitorAge, String lcompetitorGender,
//			String lcompetitorLevel,int[] lcometitorScoresArray ) {
//	super(lcompetitorNumber, lcompetitorName, lcompetitorAge, lcompetitorGender, lcompetitorLevel, lcometitorScoresArray);
//	competitionType = lcompetitonType;
//	this. getOverAllScore();
//	}
//	
//	
//	// get the competition type of this competition
//	public String getCompetitionType() { return competitionType; }
//
//	public void setCompetitionType(String competitionType) { this.competitionType = competitionType; }
//
//	// abstract method to calculate the overall score of the chess player 
//	//  Average of scores disregarding the highest and lowest score.
// 
//
//	@Override
//	public Double getOverAllScore() {
//
//		
//		int[] lScoreArray= this.getCompetitorScoresArray();  // Assigning the array score value to the Variable
//		Arrays.sort(lScoreArray);                              // Method "Sort"  is used to arrange the array scores of a player in the ascending order
//		overAllScore = 0.0 ;                                     
//		for (int i = 1; i<= 3; i++) {
//			overAllScore += lScoreArray[i];
//		}
//		
//		overAllScore /= 3;
//		return this.overAllScore;          // returns the overall score of that level of player.
//	};
//	
//	// get short details of the counter strike player
//	@Override 
//	public String getShortDetails() {String shortDetails = String.format("CN %d (%s) has overall score %,.1f.",
//			this.getCompetitorNumber(),
//			this.getCompetitorName().getInitials(),
//			this.getOverAllScore()
//			);
//
//	return shortDetails;
//		
//	} 
//	
//	// get  full details of the counter strike player
//	@Override
//	public  String getFullDetails() {
//		int[] lScoreArray = getCompetitorScoresArray();
//		String lScoreArrayString = "";                
//
//		for(int i = 0; i< lScoreArray.length; i++) {
//			if(i !=4) {
//				lScoreArrayString+=lScoreArray[i]+",";
//			}else {
//				lScoreArrayString+=lScoreArray[i];
//			}
//
//		}		
//		String fullDetails = String.format("%s is an Chess player aged %d having Cometitor number %d.\n"    
//				+ "%s is a %s player and has awarded with these scores : %s\n" 
//				+ "This gives an Overall Score of %,.1f.",
//				getCompetitorName().getFullName(),
//				getCompetitorAge(),
//				getCompetitorNumber(),
//				getCompetitorName().getFirstName(),
//			    getCompetitorScoresArray(), 
//				lScoreArrayString,
//				getOverAllScore());
//
//		return fullDetails;
//	}
//	
//
//
//}