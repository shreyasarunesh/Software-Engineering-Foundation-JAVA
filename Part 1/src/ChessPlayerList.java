
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
       // Constructor to create the Object ChessPlayerArray
public class ChessPlayerList {
	private ChessPlayer[] chessPlayerArray = new ChessPlayer[15];
	int size = 0;
	
	
	// Method to read chessPlayer List Array
	public void readChessPlayerListFile(String[] lines) {
		
		for(int i = 0; lines[i] != null;i++) {
			
			String words [] = lines[i].split(", ");
			int intScores [] = new int[5];
			String strScores [] = words[5].split(",");
			
			for(int j = 0; j< strScores.length; j++) {
				intScores[j]= Integer.parseInt(strScores[j]);
				
				
			}
			
			this.chessPlayerArray[i] = new ChessPlayer(
					Integer.parseInt(words[0]),words[1],
					Integer.parseInt(words[2]), words[3], words[4], intScores);
		}
		
		

	}

	// Method to get ChessPlayer Full detailed report 
	// Calling multiple reports in the String Formating such as ChessPlayerNumber, ChessPlayerAge, ChessPlayerLevel,
	//ChessPlayerGender,getChessPlayer_ScoresString,getChessPlayer_ScoresString, getOverAllScoreArray
	public String getChessPlayerDetailsReport() {
		
		String reportBuilder = ""; // Report Builder object 
			
		reportBuilder = String.format("%-40s%-20s%-20s%-20s%-20s%s\n", "Competior","Age","Level","Gender","Scores","Overall");
				
				for(int i=0; i<this.chessPlayerArray.length;i++) {
					if(chessPlayerArray[i]!=null) {
						reportBuilder += String.format("%-40s%-20s%-20s%-20s%-20s%s\n", 
								chessPlayerArray[i].getChessPlayerNumber()+"  "+chessPlayerArray[i].getChessPlayerName().getFullName(),
								chessPlayerArray[i].getChessPlayerAge(),
								chessPlayerArray[i].getChessPlayerLevel(),
								chessPlayerArray[i].getChessPlayerGender(),
								chessPlayerArray[i].getChessPlayer_ScoresString().replace(",", " "),
								chessPlayerArray[i].getOverAllScoreArray()
								);
					}
					
				}
				
				reportBuilder +=String.format("\n","");           
				for(int i=0; i<this.chessPlayerArray.length;i++) {
					if(chessPlayerArray[i]!=null) {
						reportBuilder += String.format("Full Details for %d:\n%s\n", 
								chessPlayerArray[i].getChessPlayerNumber(),chessPlayerArray[i].getFullDetails());
						
						
					}
					
				}
		
				for(int i=0; i<this.chessPlayerArray.length;i++) {
					if(chessPlayerArray[i]!=null) {
						reportBuilder += String.format("Short Details for %d:\n%s\n", 
								chessPlayerArray[i].getChessPlayerNumber(),chessPlayerArray[i].getShortDetails());
						
					}
					
				}
		
		return reportBuilder;
			
		}
 // Method to get the full report of the Chess player 
	public String getReport() {
			String reportBuilder = String.format("%s\n%s\n%s",getChessPlayerDetailsReport(),
					 getTopChessPlayerReport(),getChessPlayerFrequencyReport() 
					);
			
			return reportBuilder;
			
			
		
	}
	// Method to get the frequency of the ChessPlayer Report   
	public String getChessPlayerFrequencyReport() {
		
		String reportBuilder = "";
		Integer[] scoreFrequency = {0,0,0,0,0};
			
		for(int i=0; i<this.chessPlayerArray.length;i++) {
			if(chessPlayerArray[i]!=null) {
				switch(chessPlayerArray[i].getOverAllScoreArray().intValue()){
				case 1: scoreFrequency[0]++; break;
				case 2: scoreFrequency[1]++; break;
				case 3: scoreFrequency[2]++; break;
				case 4: scoreFrequency[3]++; break;
				case 5: scoreFrequency[4]++; break;
				}
				
			}
			
		}
		
		reportBuilder = String.format("The following individual scores were awarded:\n"
				+ "%-10s\t%-5d%-5d%-5d%-5d%-5d\n","Scores:",1,2,3,4,5);
		reportBuilder+="Frequency:\t";
		for(int i=0; i<scoreFrequency.length;i++) {
			reportBuilder+=String.format("%-5d",scoreFrequency[i]);
		}
		
		return reportBuilder;
			
		}
	
	
 // Method to get find the chessPlayer Number
	public String findChessPlayerNumber(int ChessPlayerNumber) {
		
		for(int i=0; i<this.chessPlayerArray.length;i++) {
			
			if(chessPlayerArray[i]!=null) {
				
				if(ChessPlayerNumber==chessPlayerArray[i].getChessPlayerNumber()) {
					return "The Number Exists";
					
				 }
				
				}
				
			}
		return "The ID is not Exists";
		  }
		
// Method to get the top chess Player Report.
public String getTopChessPlayerReport() {
		
		String reportBuilder = "";
		Double topChessPlayer = 0.0;
		Integer indexChessPlayer = 0;
		int count = 0;
		for(int i=0; i<this.chessPlayerArray.length;i++) {
			if(chessPlayerArray[i]!=null) {
				
				if(topChessPlayer< chessPlayerArray[i].getOverAllScoreArray()) {
					topChessPlayer = chessPlayerArray[i].getOverAllScoreArray();
					indexChessPlayer = i;
				}
				
			}
			
		}
		
		
		for(int i=0; i<this.chessPlayerArray.length;i++) {
			if(chessPlayerArray[i]!=null) {
				count++;
				
			}
			
		}
		
		reportBuilder += String.format("STATISTICAL\nThere are %d Compitiors\n",count);
		
		if(count!=0) {
			reportBuilder += String.format("The person with the highest score is %s with a score of %.1f.\n", 
					chessPlayerArray[indexChessPlayer].getChessPlayerName().getFullName(),
					chessPlayerArray[indexChessPlayer].getOverAllScoreArray());
		}
		
		
		return reportBuilder;
		
	}
		
}
