import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// Creating a Manager Class and Objects to handel input and output pf the chessPlayer
public class Manager {
	ChessPlayerList chessPlayerList = new ChessPlayerList();
	
	// Function to read a file from the input.txt file 
	// input.txt file is created with chessPlayer values in that 
public void readFile() {
		
		File inputFileObject = new File("input.txt"); // InputFileObject to store the values of the input.txt file
		
		
		try {
			String[] wordLines = new String[20];    // string words lines from text file
			
			Scanner scannerObject = new Scanner(inputFileObject); //Scanner Object to scan the Input File 
			for(int i=0;scannerObject.hasNextLine();i++) {
				wordLines[i]=scannerObject.nextLine();       //looping to restore the next line 
			}
			chessPlayerList.readChessPlayerListFile(wordLines);
			
		} catch (FileNotFoundException e) {  // If exceptions print this message
			System.out.println("IOExption Error found");
		} 
		
			    
	}
	// Function to write an output file 

	public void writeFile() {
			
		try {
			FileWriter writeFile = new FileWriter("output.txt"); // creating an object to write a file 
			writeFile.write(chessPlayerList.getReport());
			writeFile.close();
			
		} catch (IOException e) {
			System.out.println("IOExption Error found");
		} 
			
				    
    }
	
	// Function to find the chess Player number by scanning the input from the User.
	// If player is found it return the Printing output value
	public void findChessPlayerNumber(Scanner readInput) {
		
		System.out.print("Please enter the Chess Player Number: ");
		try {
			
			Integer chessPlayerId = Integer.parseInt(readInput.nextLine()); 
			System.out.println(this.chessPlayerList.findChessPlayerNumber(chessPlayerId));
			
		}
		
		catch(NumberFormatException e) {
			System.out.println("The Player with this Number is Not Found\n Please check Number entered");
		}
		
	}
	
	// create a manager class to input the file from the user and return the values by calling the respective methods
	public static void main(String[] args) {
		   
		Manager manager = new Manager();
		Scanner readInput = new Scanner(System.in);
		while(true) {
			System.out.println("\nHello, Greetings of the day!!!\n\n  Please Enter your Choice:\n1. Read the complete Report\n2. Generate a Complete Output Report\n"
					+ "3. Check Chess Player Number\n4. Exit");
			String options = readInput.nextLine();
			
			if(Integer.parseInt(options)==1) {
				manager.readFile();                   // Calling the function to return the readFile 
				System.out.println("Files are Read");
			}else if(Integer.parseInt(options)==2) {
				manager.writeFile();                  // Calling the function to return the write File
				System.out.println("Files are Written to output file, Check the output.txt file");
			}else if(Integer.parseInt(options)==3) {
				manager.findChessPlayerNumber(readInput);		// Get input from the user and compare with the available chess Player number 	 	
			}else {
				System.out.println("Thank you, Have a nice day!!!");
				readInput.close();
				return; 
			}
		}
		

	}
}

