public class Test {

	public static void main(String[] args) {
		
		int[] Points = {0, 3, 4, 5, 2};
		String Level = "Class A";
		
		ChessPlayer chessPlayer = new ChessPlayer(100 , "Shreyas Arunesh", 23, Level, "M", Points);
		
		System.out.println(chessPlayer.getChessPlayerNumber());
		System.out.println(chessPlayer.getChessPlayerName().getFullName());
		System.out.println(chessPlayer.getChessPlayerAge());
		System.out.println(chessPlayer.getChessPlayerGender());
		System.out.println(chessPlayer.getChessPlayerLevel());
		System.out.println(chessPlayer.getFullDetails());
		System.out.println(chessPlayer.getOverAllScoreArray());
		System.out.println(chessPlayer.getShortDetails());
		System.out.println();
		
		
		
		int[] Points_2 = {4, 4, 4, 4, 4};
		chessPlayer.setChessPlayerNumber(101);
		chessPlayer.setChessPlayerAge(30);
		chessPlayer.setChessPlayerGender("F");
		chessPlayer.setChessPlayerLevel("Class C");
		chessPlayer.setChessPlayerScoresArray(Points_2);
		chessPlayer.setChessPlayerName("Arunesh Shreyas");
		
		System.out.println(chessPlayer.getChessPlayerNumber());
		System.out.println(chessPlayer.getChessPlayerName().getFullName());
		System.out.println(chessPlayer.getChessPlayerAge());
		System.out.println(chessPlayer.getChessPlayerGender());
		System.out.println(chessPlayer.getChessPlayerLevel());
		System.out.println(chessPlayer.getFullDetails());
		System.out.println(chessPlayer.getOverAllScoreArray());
		System.out.println(chessPlayer.getShortDetails());
		System.out.println();
		
		
		
		int[] Points_3 = {2, 2, 2, 2, 2};
		chessPlayer.setChessPlayerNumber(102);
		chessPlayer.setChessPlayerAge(40);
		chessPlayer.setChessPlayerGender("M");
		chessPlayer.setChessPlayerLevel("Class A");
		chessPlayer.setChessPlayerScoresArray(Points_3);
		chessPlayer.setChessPlayerName("Shreyas Gowda");
				
		System.out.println(chessPlayer.getChessPlayerNumber());
		System.out.println(chessPlayer.getChessPlayerName().getFullName());
		System.out.println(chessPlayer.getChessPlayerAge());
		System.out.println(chessPlayer.getChessPlayerGender());
		System.out.println(chessPlayer.getChessPlayerLevel());
		System.out.println(chessPlayer.getFullDetails());
		System.out.println(chessPlayer.getOverAllScoreArray());
		System.out.println(chessPlayer.getShortDetails());
		System.out.println();
		
		
		
		int[] Points_4 = {2, 4, 3, 5, 1};
		chessPlayer.setChessPlayerNumber(103);
		chessPlayer.setChessPlayerAge(50);
		chessPlayer.setChessPlayerGender("L");
		chessPlayer.setChessPlayerLevel("Class C");
		chessPlayer.setChessPlayerScoresArray(Points_4);
		chessPlayer.setChessPlayerName("Gowda Shreyas");
		System.out.println();
		
		System.out.println(chessPlayer.getChessPlayerNumber());
		System.out.println(chessPlayer.getChessPlayerName().getFullName());
		System.out.println(chessPlayer.getChessPlayerAge());
		System.out.println(chessPlayer.getChessPlayerGender());
		System.out.println(chessPlayer.getChessPlayerLevel());
		System.out.println(chessPlayer.getFullDetails());
		System.out.println(chessPlayer.getOverAllScoreArray());
		System.out.println(chessPlayer.getShortDetails());
		System.out.println();
		
		
		// TODO Auto-generated method stub


		ChessPlayerList chessPlayerList = new ChessPlayerList();
		Manager manager = new Manager();
		
		//manager.readFile();
		//manager.writeFile();
		//manager.main();
	}

}
