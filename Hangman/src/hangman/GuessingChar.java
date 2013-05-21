package hangman;



public class GuessingChar {
	static char guessChar = 'C';
	
	public static void setguessChar(char input){
		  guessChar = input;
	}
	public static char getguessChar(){
		  return guessChar;
	}
}