package hangman;

import java.util.Random; // For random numbers (Can also use import java.util.*;)

public class Settings {
	static boolean continuePlaying;
	static String[] wordFourLetters;
    static String[] wordFiveLetters;
    static String numberOfLetters;
    static String word;
    static boolean allowFourLetters;
    static boolean allowFiveLetters;
    static boolean[] allowedLetters = {false,false,false,false,false,false};
	
    
    public static void setcontinuePlaying (boolean input){
    	continuePlaying = input;
    }
    public static void setwordFourLetters (String[] input){
    	wordFourLetters = input;
    }
    public static void setwordFiveLetters (String[] input){
    	wordFiveLetters = input;
    }
    public static void setnumberOfLetters (String input){
    	numberOfLetters = input;
    }
    public static void setword (String input){
    	word = input;
    }
    public static void setallowFourLetters (boolean input){
    	allowFourLetters = input;
    }    
    public static void setallowFiveLetters (boolean input){
    	allowFiveLetters = input;
    }
    public static void setallowedLetters (boolean[] input){
    	allowedLetters = input;
    }
	public static void setallowedLetter(int index, boolean allowed){
		boolean[] allowedLetters = getallowedLetters();
		allowedLetters[index] = allowed;
		setallowedLetters(allowedLetters);
	}
    
	public static boolean getcontinuePlaying(){
		  return continuePlaying;
	}	
	public static String[] getwordFourLetters(){
		System.out.println("WordFourLEtters: " + wordFourLetters);
		  return wordFourLetters;
	}	
	public static String[] getwordFiveLetters(){
		System.out.println("WordFiveLEtters: " + wordFiveLetters);
		  return wordFiveLetters;
	}	
	public static String getnumberOfLetters(){
		  return numberOfLetters;
	}	
	public static String getword(){
		  return word;
	}	
	public static boolean getallowFourLetters(){
		  return allowFourLetters;
	}		
	public static boolean getallowFiveLetters(){
		  return allowFiveLetters;
	}	
	public static boolean[] getallowedLetters(){
		  return allowedLetters;
	}	
	public static boolean getallowedLetter(int index){
		return getallowedLetters()[index];
	}
    
	public static void setInitialValues(){
		String[] wordFourLetters = {"TENT", "MICE", "CARS", "SONG", "LIFE"};
		String[] wordFiveLetters = { "TENTS", "MOUSE", "TRUCK", "MUSIC", "LIVES" };
		setcontinuePlaying(true);
		setwordFourLetters( wordFourLetters );
	    setwordFiveLetters( wordFiveLetters);
	    setnumberOfLetters("");
	    setallowFourLetters(false);
	    setallowFiveLetters(false);
	    //setallowedLetters({false, false, false, false, false, false});
	}

	public static void selectWord(){
		Random generator = new Random();
		int randomWordSelector = generator.nextInt(5);
		int randomWordLengthSelector;
		int wordLength = 0;
		int count = 0;
		for (int i = 0; i < allowedLetters.length; i++){
			if (allowedLetters[i] == true)
				count++;
		}
		if (count == 0)
	        System.out.println("ERROR NO BOXES SELECTED *****************");
		randomWordLengthSelector = generator.nextInt(count);
		while (randomWordLengthSelector >= 0){
			wordLength++;
			if (allowedLetters[wordLength] == true)
				randomWordLengthSelector--;
		}
		if (wordLength == 4)
			setword(wordFourLetters[randomWordSelector]);	
		else if (wordLength == 5)
			setword(wordFiveLetters[randomWordSelector]);	
		else
			System.out.println("ERROR Invalid Word Length chosen: " + wordLength);	
	}
}
