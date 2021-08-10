import javax.naming.ldap.SortControl;

// Constructor to create the Object ChessPlayerArray
public class PlayerList {
	
	
	private ChessPlayers[] chessPlayersArray = new ChessPlayers[15];
	private KaratePlayers[] karatePlayersArray = new KaratePlayers[15];
	private CounterStrikePlayers[] counterStrikePlayersArray = new CounterStrikePlayers[15];
	
	int size = 0;
	
	
	// Method to read chessPlayer List Array
	public void readChessPlayersListFile(String[] lines, String competetion_type) {
		
		for(int i = 0; lines[i] != null;i++) {
			
			String words [] = lines[i].split(", ");
			int intScores [] = new int[5];
			String strScores [] = words[5].split(",");
			
			for(int j = 0; j< strScores.length; j++) {
				intScores[j]= Integer.parseInt(strScores[j]);
				
				
			}
			
			if(competetion_type == "Chess") {
				this.chessPlayersArray[i] = new ChessPlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}else if(competetion_type == "Karate") {
				this.karatePlayersArray[i] = new KaratePlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}else {
				this.counterStrikePlayersArray[i] = new CounterStrikePlayers(competetion_type,
						Integer.parseInt(words[0]),words[1],
						words[2], words[3], words[4], intScores);
			}

		}
		
		

	}
	
	//  Method  to read karate player list
	
	public void readKaratePlayersListFile(String[] lines, String competetion_type) { // passing parameters of competitor_type

		
		for(int i = 0; lines[i] != null;i++) {
			
			String words [] = lines[i].split(", ");
			int intScores [] = new int[5];
			String strScores [] = words[5].split(",");
			
			for(int j = 0; j< strScores.length; j++) {
				intScores[j]= Integer.parseInt(strScores[j]);
				
				
			}
			
			// Here we are using If condition to select the three competiton type 
			
			if(competetion_type == "Chess") {
				this.chessPlayersArray[i] = new ChessPlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}else if(competetion_type == "Karate") {
				this.karatePlayersArray[i] = new KaratePlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}else {
				this.counterStrikePlayersArray[i] = new CounterStrikePlayers(competetion_type,
						Integer.parseInt(words[0]),words[1],
						words[2], words[3], words[4], intScores);
			}

		}
		
		

	}
	
	// Method to read CounterStrikes ListFile 

	public void readCounterStrikesListFile(String[] lines, String competetion_type) {
		
		for(int i = 0; lines[i] != null;i++) {
			
			String words [] = lines[i].split(", ");
			int intScores [] = new int[5];
			String strScores [] = words[5].split(",");
			
			for(int j = 0; j< strScores.length; j++) {
				intScores[j]= Integer.parseInt(strScores[j]);
				
				
			}
			
			if(competetion_type == "Chess") {
				this.chessPlayersArray[i] = new ChessPlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}else if(competetion_type == "Karate") {
				this.karatePlayersArray[i] = new KaratePlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}else {
				this.counterStrikePlayersArray[i] = new CounterStrikePlayers(competetion_type, Integer.parseInt(words[0]),words[1], words[2], words[3], words[4], intScores);
			}

		}
		
		

	}
	
	// Method to get the top chess player report with the help of tool report builder which formates the output file 
	
	public String getTopChessPlayerReport() {


		
		String reportBuilder = "";
		Double topPlayer = 0.0;
		Integer indexPlayer = 0;
		int count = 0;

		for(int i=0; i<this.chessPlayersArray.length;i++) {
			if(chessPlayersArray[i]!=null) {
				
				if(topPlayer< chessPlayersArray[i].getOverAllScore()) {
					topPlayer = chessPlayersArray[i].getOverAllScore();
					indexPlayer = i;
				}
				
			}
			
		}
		
		
		for(int i=0; i<this.chessPlayersArray.length;i++) {
			if(chessPlayersArray[i]!=null) {
				count++;
				
			}
			
		}
		
		reportBuilder += String.format("STATISTICAL\nThere are %d Compitiors\n",count);
		
		if(count!=0) {
			reportBuilder += String.format("The person with the highest score is %s with a score of %.1f.\n", 
					chessPlayersArray[indexPlayer].getCompetitorName().getFullName(),
					chessPlayersArray[indexPlayer].getOverAllScore());
		}
		
		
		return reportBuilder;
		
	}
	
	
	// Method to get the top karate player report with the help of tool report builder which formates the output file
	
	public String getTopKaratePlayerReport() {
	
	String reportBuilder = "";
	Double topPlayer = 0.0;
	Integer indexPlayer = 0;
	int count = 0;

	for(int i=0; i<this.karatePlayersArray.length;i++) {
		if(karatePlayersArray[i]!=null) {
			
			if(topPlayer< karatePlayersArray[i].getOverAllScore()) {
				topPlayer = karatePlayersArray[i].getOverAllScore();
				indexPlayer = i;
			}
			
		}
		
	}
	
	
	for(int i=0; i<this.karatePlayersArray.length;i++) {
		if(karatePlayersArray[i]!=null) {
			count++;
			
		}
		
	}
	
	reportBuilder += String.format("STATISTICAL\nThere are %d Compitiors\n",count);
	
	if(count!=0) {
		reportBuilder += String.format("The person with the highest score is %s with a score of %.1f.\n", 
				karatePlayersArray[indexPlayer].getCompetitorName().getFullName(),
				karatePlayersArray[indexPlayer].getOverAllScore());
	}
	
	
	return reportBuilder;
	
	
}

	// Method to get the top counter strike  player report with the help of tool report builder which formates the output file

	public String getTopCounterStrikePlayerReport() {
		String reportBuilder = "";
		Double topPlayer = 0.0;
		Integer indexPlayer = 0;
		int count = 0;

		for(int i=0; i<this.counterStrikePlayersArray.length;i++) {
			if(counterStrikePlayersArray[i]!=null) {
				
				if(topPlayer< counterStrikePlayersArray[i].getOverAllScore()) {
					topPlayer = counterStrikePlayersArray[i].getOverAllScore();
					indexPlayer = i;
				}
				
			}
			
		}
		
		
		for(int i=0; i<this.counterStrikePlayersArray.length;i++) {
			if(counterStrikePlayersArray[i]!=null) {
				count++;
				
			}
			
		}
		
		reportBuilder += String.format("STATISTICAL\nThere are %d Compitiors\n",count);
		
		if(count!=0) {
			reportBuilder += String.format("The person with the highest score is %s with a score of %.1f.\n", 
					counterStrikePlayersArray[indexPlayer].getCompetitorName().getFullName(),
					counterStrikePlayersArray[indexPlayer].getOverAllScore());
		}
		
		
		return reportBuilder;
	}
	
	
	// Method to get the top chess player detailed report with the help of tool report builder which formates the output file
	public String getChessPlayerDetailsReport() {
		
		String reportBuilder = ""; // Report Builder object 
			
		reportBuilder = String.format("%-40s%-20s%-20s%-20s%-20s%s\n", "Competior","Age","Level","Gender","Scores","Overall"); //  string formating 
				
				for(int i=0; i<this.chessPlayersArray.length;i++) {
					if(chessPlayersArray[i]!=null) {
						reportBuilder += String.format("%-40s%-20s%-20s%-20s%-20s%s\n", 
								chessPlayersArray[i].getCompetitorNumber()+"  "+chessPlayersArray[i].getCompetitorName().getInitials(),
								chessPlayersArray[i].getCompetitorAge(),
								chessPlayersArray[i].getCompetitorLevel(),
								chessPlayersArray[i].getCompetitorGender(),
								chessPlayersArray[i].getCompetitorScoresString().replace(",", " "),
								chessPlayersArray[i].getOverAllScore()
								);
					}
					
				}        
		
		return reportBuilder;
			
		}
	
	
	// Method to get the karate player detailed report with the help of tool report builder which formates the output file
		
	
	public String getKaratePlayerDetailsReport() {
	
	String reportBuilder = ""; // Report Builder object 
		
	reportBuilder = String.format("%-40s%-20s%-20s%-20s%-20s%s\n", "Competior","Age","Level","Gender","Scores","Overall");
			
			for(int i=0; i<this.karatePlayersArray.length;i++) {
				if(karatePlayersArray[i]!=null) {
					reportBuilder += String.format("%-40s%-20s%-20s%-20s%-20s%s\n", 
							karatePlayersArray[i].getCompetitorNumber()+"  "+karatePlayersArray[i].getCompetitorName().getInitials(),
							karatePlayersArray[i].getCompetitorAge(),
							karatePlayersArray[i].getCompetitorLevel(),
							karatePlayersArray[i].getCompetitorGender(),
							karatePlayersArray[i].getCompetitorScoresString().replace(",", " "),
							karatePlayersArray[i].getOverAllScore()
							);
				}
				
			}        
	
	return reportBuilder;
		
	}

	
	// Method to get the counter strike player detailed report with the help of tool report builder which formates the output file
	
    public String getCounterStrikePlayerDetailsReport() {
		
		String reportBuilder = ""; // Report Builder object 
			
		reportBuilder = String.format("%-40s%-20s%-20s%-20s%-20s%s\n", "Competior","Age","Level","Gender","Scores","Overall");
				
				for(int i=0; i<this.chessPlayersArray.length;i++) {
					if(chessPlayersArray[i]!=null) {
						reportBuilder += String.format("%-40s%-20s%-20s%-20s%-20s%s\n", 
								counterStrikePlayersArray[i].getCompetitorNumber()+"  "+counterStrikePlayersArray[i].getCompetitorName().getInitials(),
								counterStrikePlayersArray[i].getCompetitorAge(),
								counterStrikePlayersArray[i].getCompetitorLevel(),
								counterStrikePlayersArray[i].getCompetitorGender(),
								counterStrikePlayersArray[i].getCompetitorScoresString().replace(",", " "),
								counterStrikePlayersArray[i].getOverAllScore()
								);
					}
					
				}        
		
		return reportBuilder;
			
		}

	
    // The method to get the full report of the player where the competitor type is given as an parameter and it return that perticular competitor type
    // This method calls all the above called method to get the report 
	public String getReport(String competitor_type) {
		if (competitor_type == "Chess") {

		String reportBuilder = String.format("%s\n%s",getChessPlayerDetailsReport(),
				 getTopChessPlayerReport()
				);
		
		return reportBuilder;
		} else if (competitor_type == "Karate") {
			String reportBuilder = String.format("%s\n%s",getKaratePlayerDetailsReport(),
					getTopKaratePlayerReport()
					);
			
			return reportBuilder;
			
		}else { 
			String reportBuilder = String.format("%s\n%s",getCounterStrikePlayerDetailsReport(),
					getTopCounterStrikePlayerReport()
					);
			
			return reportBuilder;
			
		}
		
		}

	
	// find the chess player number in the console prompt
	public String findChessPlayerNumber(int ChessPlayerNumber) {
		
		for(int i=0; i<this.chessPlayersArray.length;i++) {
			
			if(chessPlayersArray[i]!=null) {
				
				if(ChessPlayerNumber==chessPlayersArray[i].getCompetitorNumber()) {
					return chessPlayersArray[i].getShortDetails();
					
				 }
				
				}
				
			}
		return "The ID is not Exists";
		  }
	
	// find the karate player number in the console prompt
	public String findKaratePlayerNumber(int KaratePlayerNumber) {
		
		for(int i=0; i<this.karatePlayersArray.length;i++) {
			
			if(karatePlayersArray[i]!=null) {
				
				if(KaratePlayerNumber==karatePlayersArray[i].getCompetitorNumber()) {
					return "The Number Exists";
					
				 }
				
				}
				
			}
		return "The ID is not Exists";
		  }
	
	// find the counter strike player number in the console prompt
	public String findCounterStrikePlayerNumber(int CounterStrikePlayerNumber) {
		
		for(int i=0; i<this.counterStrikePlayersArray.length;i++) {
			
			if(counterStrikePlayersArray[i]!=null) {
				
				if(CounterStrikePlayerNumber==counterStrikePlayersArray[i].getCompetitorNumber()) {
					return "The Number Exists";
					
				 }
				
				}
				
			}
		return "The ID is not Exists";
		  }

		
	}
	
	







