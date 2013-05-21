/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Michael
 */
//import java.awt.event.ActionEvent;
import java.io.*;//For user input
import java.util.Random; // For random numbers (Can also use import java.util.*;)

//import javax.swing.JTextArea;

import hangman.UI;
import hangman.GuessingChar;

public class Hangman {
	
	private UI myApplication;
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Settings.setInitialValues();
    	//Settings.selectWord();
    	Player user = new Player();
    	user.createPlayer("Mic");
    	

    	
    	
    	UISettings.createUISettings();
    	
    	////New Thread test
        new NewThread(); // create a new thread
        try {
           for(int i = 45; i > 0; i--) {
             System.out.println("Main Thread: " + i);
             UI.displayStatus();
             Thread.sleep(1000);
           }
        } catch (InterruptedException e) {
           System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    	/// New Thread test end

        
 
        //oneRound();
        //System.out.println("Enter 1 to continue playing or anything else to quit");
        //continuePlaying = getUserInput();
    }
    
    public static void oneRound(){
    	Settings.selectWord();
        Round.setword(Settings.getword());
        System.out.println(Settings.getword());     
    	Round.startRound(Round.getword());
    	Player.setplayerLives(6);
    	UI.displayStatus();
        System.out.println(Round.getwordLength());
        System.out.println(Round.getguessingWord());
    }
    
    public static void oneRoundPart2(){
    	boolean alreadyGuessed = false;
    	char guessChar = getGuessChar();
        System.out.println(guessChar);
        Round.setoldcorrectGuesses(Round.getcorrectGuesses());
        for (int i = Round.getwordLength()-1; i > -1; i--){
        	System.out.println("i=" + i);
        	System.out.println("guessChar =" + guessChar);
        	System.out.println(Round.getword().charAt(i));
        	System.out.println(Round.getguessingWord().charAt(2*i));
            if (guessChar == Round.getword().charAt(i)){
            	if (Round.getguessingWord().charAt(2*i)=='_'){
            		Round.setguessingWord(replaceCharAt(Round.getguessingWord(), 2*i, guessChar));
            		Round.setcorrectGuesses(Round.getcorrectGuesses() + 1);
            	}
            	else{
            		alreadyGuessed = true;
            	}
            
            }
        }
        if (Round.getoldcorrectGuesses() == Round.getcorrectGuesses()){
        	for (int i = Round.getincorrectGuesses().length() -1; i > -1; i--){
        		if (Round.getincorrectGuesses().charAt(i) == guessChar){
        			alreadyGuessed = true;
        		}
        	}
        	if (alreadyGuessed == false){
            	Round.setincorrectGuesses(Round.getincorrectGuesses() + guessChar + " ");
            	Player.decreaseplayerLives(1);
        	}
        	else{
            	System.out.println("That Character has already been guessed! guessChar =" + guessChar);
        	}
        }

        UI.displayStatus();
        if (Player.getplayerLives() <= 0){
        	System.out.println("You have been hanged");
        	sleep(1000);
        	UI.getroundUI().setVisible(false);
        	UISettings.getsettingsWindow().setVisible(true);
        }
        else if (Round.getcorrectGuesses() < Round.getwordLength()){
        	//UI.displayStatus();
        	System.out.println("guessingWord: " + Round.getguessingWord());
        	System.out.println("incorrectGuesses: " + Round.getincorrectGuesses());   
        	System.out.println("");
        	System.out.println("Guess a letter");
        }	
        else{
        	sleep(1000);
        	System.out.println("You Guessed the Word");
        	oneRound();
        }	
    }
    
    /*public char getGuessChar(ActionEvent e)
    {
    	char guessChar= ' ';
    	while (guessChar == ' '){
    		if (e.getSource() == UI.AButton){
    	        guessChar = 'A';
    	      }
    	}
    	return guessChar;
      
    }
    */
    
    
    
    public static char getGuessChar() {
	    char guessChar = ' ';
	    //GuessingChar.setguessChar(' ');
	    System.out.println("guess char is ' '");
	    while (guessChar == ' '){
	    	guessChar= GuessingChar.getguessChar();
	    	//System.out.println("while loop running");
	    }
	    GuessingChar.setguessChar(' ');
	    System.out.println("set guess char to ' '");
	    return guessChar;
    }

  /*  
    public static char getGuessChar2() {
    	String guessString = "";
        boolean validInput = false;
        boolean validChar = false;
        String validChars = "abcdefghigklmnopqrstuvwxyz";
        while (!validInput || !validChar){
        	//System.out.println("valid Input =" + validInput + " valid Char = " + validChar);
            guessString = getUserInput();
            try {
            	guessString.charAt(1);
            	System.out.println("You entered more than one letter try again");
            } catch (StringIndexOutOfBoundsException e) {
            	//System.err.println("One value only good StringIndexOutOfBoundsException: " + e.getMessage());
            	validInput = true;
            	//System.out.println("valid input");
            }
            try {
            	guessString.charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
            	System.err.println("You didn't enter anything! Try again");
            	validInput = false;
            	//System.out.println("invalid input");
            }
            for (int i=0; i < 26; i++){
            	if (validChars.charAt(i) == guessString.charAt(0)) {
            		validChar = true;
            		break;
            	}
            }
        	if (validChar == false) {
        		System.out.println("You did not enter a proper letter");
        	}
        }
        char guessChar = guessString.charAt(0);
        return guessChar;
    }
    
*/    
    
    
    
    
    
    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }
   
    
    public static String getUserInput() {
        String name = "Error if I get displayed";
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("What is your name? ");
        try{
            name = reader.readLine();
            System.out.println("You entered " + name);
        }
        catch (IOException ioe){
            System.out.println("error");
        }
        return name;
               
    }
    public static void sleep(int input){
    	try{
    		Thread.sleep(input); // do nothing for 1000 miliseconds (1 second)
    	}
    	catch(InterruptedException e){
    		e.printStackTrace();
    	}
    }
    
}