package hangman;

public class Player {
	static String playerName;
	static int playerLives;
	static int playerScore;
	
	public static void setplayerName(String input){
		playerName = input;
	}
	public static void setplayerLives(int input){
		playerLives = input;
		//UI.updatePicture();
	}
	public static void setplayerScore(int input){
		playerScore = input;
	}
	public static String getplayerName(){
		  return playerName;
	}	
	public static int getplayerLives(){
		  return playerLives;
	}
	public static int getplayerScore(){
		  return playerScore;
	}
	
	
	  public void createPlayer(String playerName){
	    //Player currentPlayer = new Player();
	    Player.playerName = playerName;
	    Player.playerLives = 6;
	    Player.playerScore = 0;
	  }
	  
	  public static void decreaseplayerLives(int amount){
		  setplayerLives(getplayerLives() - amount);
	  }
}
