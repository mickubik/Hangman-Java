package hangman;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
 
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UISettings extends JFrame implements ActionListener, ItemListener{
	
	
	
    JCheckBox fourLetterWordButton = new JCheckBox("Allow 4 Letter Words");
    JCheckBox fiveLetterWordButton = new JCheckBox("Allow 5 Letter Words");
	JButton StartButton = new JButton("Start");
	static JTextArea myText = new JTextArea("Hello Player");
	JPanel bottomPanel = new JPanel();
	JPanel holdAll = new JPanel();
	
	private static UISettings settingsWindow = new UISettings();
	
	public static UISettings getsettingsWindow(){
	    return settingsWindow;
	}
	
	public UISettings(){
		bottomPanel.setLayout(new GridBagLayout()); //bottomPanel.setLayout(new FlowLayout())
	    GridBagConstraints c = new GridBagConstraints();
	    c.gridx = 1;
	    c.gridy = 1;
	    bottomPanel.add(fourLetterWordButton, c);
	    c.gridx = 1;
	    c.gridy = 2;
	    bottomPanel.add(fiveLetterWordButton, c);
	    c.gridx = 1;
	    c.gridy = 3;
	    bottomPanel.add(StartButton, c);
	    

	    holdAll.setLayout(new BorderLayout());  
	    holdAll.add(bottomPanel, BorderLayout.CENTER);
	    holdAll.add(myText, BorderLayout.NORTH);
	 
	    getContentPane().add(holdAll, BorderLayout.CENTER);
	    
	    StartButton.addActionListener(this);
	    fourLetterWordButton.addItemListener(this);
	    fiveLetterWordButton.addItemListener(this);
	    
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void createUISettings(){
	   // UISettings myApplication = new UISettings();
	    
	    // Specify where will it appear on the screen:
		getsettingsWindow().setLocation(100, 100);
		getsettingsWindow().setSize(600, 400);
	 
	    // Show it!
		getsettingsWindow().setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
	    if (e.getSource() == StartButton && aCheckboxIsChecked()){
	    	myText.setText(" Hiiiiii!");
	    	setVisible(false);
	    	Settings.selectWord();
	    	UI.createUI();
	    	Hangman.oneRound();
	    }
	    else{
	    	//TODO, add error message saying that no checkboxes were selected
	    }

	}
	
	public boolean aCheckboxIsChecked(){
		if (fourLetterWordButton.isSelected()){
			return true;
		}
		if (fiveLetterWordButton.isSelected()){
			return true;
		}
		return false;
	}
	
	public void itemStateChanged(ItemEvent e){
	    Object source = e.getItemSelectable();
	    if (source == fourLetterWordButton){
	    	Settings.setallowFourLetters(!Settings.getallowFourLetters());
	    	Settings.setallowedLetter(4, !Settings.getallowedLetter(4));
	    }
	    if (source == fiveLetterWordButton){
	    	Settings.setallowFiveLetters(!Settings.getallowFiveLetters());
	    	Settings.setallowedLetter(5, !Settings.getallowedLetter(5));
	    }
	}
	
	  public void setText(JTextArea text){
		  myText = text;
	  }
	
}
