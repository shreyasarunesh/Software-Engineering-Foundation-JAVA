import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// Creating a Manager Class and Objects to handel input and output pf the chessPlayer
public class Manager {
	
	PlayerList playerList = new PlayerList();
	
	// Main function to find the competitor details which calls all the functions in this class
	public static void main(String[] args) {
		   
		
		CompetitionGUI chessplayerCompetitionGUI = new CompetitionGUI("Chess Competition","Chess");
		CompetitionGUI karateplayerCompetitionGUI = new CompetitionGUI("Karate Competition","Chess");
		CompetitionGUI counterstrikeplayerCompetitionGUI = new CompetitionGUI("Counter Strike Competition","Chess");
		chessplayerCompetitionGUI.setVisible(true);
		karateplayerCompetitionGUI.setVisible(true);
		counterstrikeplayerCompetitionGUI.setVisible(true);
		
	}
		
	
	// Function to read a file from the input file of all the player which are given in diffrent files 
 
	public void readFile(String competetion_type) {
		if (competetion_type == "Chess") {
			File inputFileObject = new File("ChessPlayerInput.txt"); // InputFileObject to store the values of the input.txt file
			
			
			try {
				String[] wordLines = new String[20];    // string words lines from text file
				
				Scanner scannerObject = new Scanner(inputFileObject); //Scanner Object to scan the Input File 
				for(int i=0;scannerObject.hasNextLine();i++) {
					wordLines[i]=scannerObject.nextLine();       //looping to restore the next line 
				}
		         playerList.readChessPlayersListFile(wordLines, "Chess");
				
			} catch (FileNotFoundException e) {  // If exceptions print this message
				System.out.println("IOExption Error found"+"1");
			} 
			
		} else if (competetion_type == "Karate") {
			File inputFileObject = new File("KaratePlayerInput.txt"); // InputFileObject to store the values of the input.txt file
			
			
			try {
				String[] wordLines = new String[20];    // string words lines from text file
				
				Scanner scannerObject = new Scanner(inputFileObject); //Scanner Object to scan the Input File 
				for(int i=0;scannerObject.hasNextLine();i++) {
					wordLines[i]=scannerObject.nextLine();       //looping to restore the next line 
				}
				playerList.readKaratePlayersListFile(wordLines, "Katare");
				
			} catch (FileNotFoundException e) {  // If exceptions print this message
				System.out.println("IOExption Error found"+"2");
			} 		
			
			
			
		} else {
	       File inputFileObject = new File("CounterStrikeInput.txt"); // InputFileObject to store the values of the input.txt file
			
			
			try {
				String[] wordLines = new String[20];    // string words lines from text file
				
				Scanner scannerObject = new Scanner(inputFileObject); //Scanner Object to scan the Input File 
				for(int i=0;scannerObject.hasNextLine();i++) {
					wordLines[i]=scannerObject.nextLine();       //looping to restore the next line 
				}
		         playerList.readCounterStrikesListFile(wordLines, "CounterStrike");
				
			} catch (FileNotFoundException e) {  // If exceptions print this message
				System.out.println("IOExption Error found"+"3");
			} 		
			
			
			
		}
		}
		
		

	// Function to write an output.txt file 

	public void writeFile() {

			
		try {
			FileWriter writeFile = new FileWriter("chess_output.txt"); // creating an object to write a file 
			writeFile.write(playerList.getReport("Chess"));
			writeFile.close();
			
		} catch (IOException e) {
			System.out.println("IOExption Error found");
		} 
		
		try {
			FileWriter writeFile = new FileWriter("karate_output.txt"); // creating an object to write a file 
			writeFile.write(playerList.getReport("Karate"));
			writeFile.close();
			
		} catch (IOException e) {
			System.out.println("IOExption Error found");
		} 
		
		try {
			FileWriter writeFile = new FileWriter("counterstrike_output.txt"); // creating an object to write a file 
			writeFile.write(playerList.getReport("CounterStrike"));
			writeFile.close();
			
		} catch (IOException e) {
			System.out.println("IOExption Error found");
		} 
			
				    
    }

	
	// Function to find the chess Player number from the console window 
	public String findChessPlayerNumber(int readInput) {
		System.out.print(this.playerList.findChessPlayerNumber(readInput));
		return(this.playerList.findChessPlayerNumber(readInput));
			
	
		
	}


   public String getFullDetails(String competitorType) {
	 if(competitorType == "Chess") {
		 return(playerList.getChessPlayerDetailsReport());
	 }else if(competitorType == "Karate") {
		 return(playerList.getKaratePlayerDetailsReport());
	 }else {
		 return(playerList.getCounterStrikePlayerDetailsReport());
	 }
	}
	
	

}

