package hangman;

public class Round{
	/*Constants*/
	public static final int TIME_PER_ROUND = 60;
	/*End Constants*/
	
	static String word;
	static String incorrectGuesses;
	static int wordLength;
	static int correctGuesses;
	static int oldcorrectGuesses;
	static String guessingWord;
	
	public static void setword(String input){
		word = input;
	}
	public static void setincorrectGuesses(String input){
		incorrectGuesses = input;
	}
	public static void setwordLength(int input){
		wordLength = input;
	}
	public static void setcorrectGuesses(int input){
		correctGuesses = input;
	}	
	public static void setoldcorrectGuesses(int input){
		oldcorrectGuesses = input;
	}
	public static void setguessingWord(String input){
		guessingWord = input;
	}
	public static void setinitialguessingWord(){
		String guessingWord = "";
		for (int i = getwordLength() - 1; i > -1; i--){
			guessingWord += "_ ";
		}
		setguessingWord(guessingWord);
	}
	
	
	public static String getword(){
		  return word;
	}	
	public static String getincorrectGuesses(){
		  return incorrectGuesses;
	}
	public static int getwordLength(){
		  return wordLength;
	}
	public static int getcorrectGuesses(){
		  return correctGuesses;
	}
	public static int getoldcorrectGuesses(){
		  return oldcorrectGuesses;
	}
	public static String getguessingWord(){
		  return guessingWord;
	}

	
	public static void startRound(String word){
		setword (word);
		setincorrectGuesses("");
		setwordLength((getword()).length());
		setcorrectGuesses(0);
		setinitialguessingWord();
		NewThread.setTimeRemaining(TIME_PER_ROUND);
	}
}
