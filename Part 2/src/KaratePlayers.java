import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KaratePlayers extends Competitor{
	
	private String competitionType;
	private Double overAllScore; 
	
	// Constructor for the karate player
	private final Map<String, Double> _KARATEPLAYERS_LEVEL_WEIGHTS = new HashMap<String, Double>();
    private final Map<Integer, Double> _KARATEPLAYERS_SCORE_WEIGHTS = new HashMap<Integer, Double>();
	
	public KaratePlayers(String lcompetitonType, int lcompetitorNumber, String lcompetitorName , String lcompetitorAge, String lcompetitorGender,
			String lcompetitorLevel,int[] lcometitorScoresArray ) {
	super(lcompetitorNumber, lcompetitorName, lcompetitorAge, lcompetitorGender, lcompetitorLevel, lcometitorScoresArray);
	competitionType = lcompetitonType;
	this. getOverAllScore();
	

	this._KARATEPLAYERS_LEVEL_WEIGHTS.put("Class C", 2.00);
	this._KARATEPLAYERS_LEVEL_WEIGHTS.put("Class B", 1.50);
	this._KARATEPLAYERS_LEVEL_WEIGHTS.put("Class A", 1.0);
	
	this._KARATEPLAYERS_SCORE_WEIGHTS.put(5,2.0);
	this._KARATEPLAYERS_SCORE_WEIGHTS.put(4,1.5);
	this._KARATEPLAYERS_SCORE_WEIGHTS.put(3,1.0);
	this._KARATEPLAYERS_SCORE_WEIGHTS.put(2,0.75);
	this._KARATEPLAYERS_SCORE_WEIGHTS.put(1,0.5);
	this._KARATEPLAYERS_SCORE_WEIGHTS.put(0,0.0);
	}
	
	
	// abstract method to calculate the overall score of the chess player 
	// Weighted average of all scores (choose different weights for different scores and levels)
	
	
	@Override
	public Double getOverAllScore() {
		
	Double _KARATEPLAYERS_LEVEL_WEIGHTS = this._KARATEPLAYERS_LEVEL_WEIGHTS.get(competitorLevel);
	this.overAllScore = 0.0;
	if ( _KARATEPLAYERS_LEVEL_WEIGHTS != null ) {
		for(int i = 0; i < 5; i++) {
			if(this.competitorScore[i]!=0) {
				this.overAllScore += (competitorScore[i] * 
						this._KARATEPLAYERS_SCORE_WEIGHTS.get(this.competitorScore[i]) * _KARATEPLAYERS_LEVEL_WEIGHTS);
			}
		}
		
		this.overAllScore /=5;
		this.overAllScore = Math.round(this.overAllScore* 10.0) / 10.0;
	
	}

		return this.overAllScore;          // returns the overall score of that level of player.
	}
	;

	
	public void setOverAllScore(Double overAllScore) { this.overAllScore = overAllScore; }
	
	// get the competition type of this competition
	public String getCompetitionType() { return competitionType; }

	public void setCompetitionType(String competitionType) { this.competitionType = competitionType; }
	
	// get short details of the karate player
	@Override 
	public String getShortDetails() {String shortDetails = String.format("CN %d (%s) has overall score %,.1f.",
			this.getCompetitorNumber(),
			this.getCompetitorName().getInitials(),
			this.getOverAllScore()
			);

	return shortDetails;
		
	} 
	
	// get full details of the karate player
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
		String fullDetails = String.format("%s is an Chess player aged %d having Cometitor number %d.\n"    
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
