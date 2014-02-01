package hangman;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hangman.GuessingChar;
 
/**
 * A very simple java swing application. 
 * Contains button and checkbox. Responds
 * to manipulations with these controls by
 * changing text in the main text area.
 * 
 * @author audriusa
 */
public class UI extends JFrame implements ActionListener
{

  /**
   * The button.
   */ 
  JButton AButton = new JButton("A");
  JButton BButton = new JButton("B");
  JButton CButton = new JButton("C");
  JButton DButton = new JButton("D");
  JButton EButton = new JButton("E");
  JButton FButton = new JButton("F");
  JButton GButton = new JButton("G");
  JButton HButton = new JButton("H");
  JButton IButton = new JButton("I");
  JButton JButton = new JButton("J");
  JButton KButton = new JButton("K");
  JButton LButton = new JButton("L");
  JButton MButton = new JButton("M");
  JButton NButton = new JButton("N");
  JButton OButton = new JButton("O");
  JButton PButton = new JButton("P");
  JButton QButton = new JButton("Q");
  JButton RButton = new JButton("R");
  JButton SButton = new JButton("S");
  JButton TButton = new JButton("T");
  JButton UButton = new JButton("U");
  JButton VButton = new JButton("V");
  JButton WButton = new JButton("W");
  JButton XButton = new JButton("X");
  JButton YButton = new JButton("Y");
  JButton ZButton = new JButton("Z");
 
  
  StringBuffer choices;
  static JLabel pictureLabel;
  
  /**
   * The the checkbox.
   */
  //static JCheckBox myCheckBox = new JCheckBox("Check");
 
  /**
   * The text area.
   */
  //static JTextArea myText = new JTextArea("My text");
  static JTextArea myText;
  /**
   * The bottom panel which holds button.
   */ 
  JPanel bottomPanel = new JPanel();
 
  /**
   * The top level panel which holds all.
   */
  JPanel holdAll = new JPanel();
 
  private static UI roundUI = new UI();
  
  /**
   * The constructor.
   */
  public UI()
  {
    bottomPanel.setLayout(new GridBagLayout()); //bottomPanel.setLayout(new FlowLayout())
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy =1;
   // bottomPanel.add(myCheckBox);
    bottomPanel.add(AButton, c);
    c.gridx++;
    bottomPanel.add(BButton, c);
    c.gridx++;
    bottomPanel.add(CButton, c);
    c.gridx++;
    bottomPanel.add(DButton, c);
    c.gridx++;
    bottomPanel.add(EButton, c);
    c.gridx++;
    bottomPanel.add(FButton, c);
    c.gridx++;
    bottomPanel.add(GButton, c);
    c.gridx++;
    bottomPanel.add(HButton, c);
    c.gridx++;
    bottomPanel.add(IButton, c);
    c.gridx++;
    bottomPanel.add(JButton, c);
    c.gridx++;
    bottomPanel.add(KButton, c);
    c.gridx++;
    bottomPanel.add(LButton, c);
    c.gridx++;
    bottomPanel.add(MButton, c);
    c.gridy++;
    c.gridx = c.gridx - 12;
    bottomPanel.add(NButton, c);
    c.gridx++;
    bottomPanel.add(OButton, c);
    c.gridx++;
    bottomPanel.add(PButton, c);
    c.gridx++;
    bottomPanel.add(QButton, c);
    c.gridx++;
    bottomPanel.add(RButton, c);
    c.gridx++;
    bottomPanel.add(SButton, c);
    c.gridx++;
    bottomPanel.add(TButton, c);
    c.gridx++;
    bottomPanel.add(UButton, c);
    c.gridx++;
    bottomPanel.add(VButton, c);
    c.gridx++;
    bottomPanel.add(WButton, c);
    c.gridx++;
    bottomPanel.add(XButton, c);
    c.gridx++;
    bottomPanel.add(YButton, c);
    c.gridx++;
    bottomPanel.add(ZButton, c);
    
    
    
    pictureLabel = new JLabel();
    pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
    //updatePicture();
 
    
    holdAll.setLayout(new BorderLayout());  
    holdAll.add(bottomPanel, BorderLayout.SOUTH);
    
    myText = new JTextArea("My text");
    
    holdAll.add(myText, BorderLayout.WEST);
    holdAll.add(pictureLabel, BorderLayout.EAST);
 
    getContentPane().add(holdAll, BorderLayout.CENTER);
    

    AButton.addActionListener(this);
    BButton.addActionListener(this);
    CButton.addActionListener(this);
    DButton.addActionListener(this);
    EButton.addActionListener(this);
    FButton.addActionListener(this);
    GButton.addActionListener(this);
    HButton.addActionListener(this);
    IButton.addActionListener(this);
    JButton.addActionListener(this);
    KButton.addActionListener(this);
    LButton.addActionListener(this);
    MButton.addActionListener(this);
    NButton.addActionListener(this);
    OButton.addActionListener(this);
    PButton.addActionListener(this);
    QButton.addActionListener(this);
    RButton.addActionListener(this);
    SButton.addActionListener(this);
    TButton.addActionListener(this);
    UButton.addActionListener(this);
    VButton.addActionListener(this);
    WButton.addActionListener(this);
    XButton.addActionListener(this);
    YButton.addActionListener(this);
    ZButton.addActionListener(this);
 //   myCheckBox.addActionListener(this);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  
 
  /**
   * The program    * @param args the program start up parameters, not used.
   */
  public static void createUI() //public static void createUI(String[] args)
  {
    //UI myApplication = new UI();
 
    // Specify where will it appear on the screen:
    getroundUI().setLocation(0, 0);
    getroundUI().setSize(600, 400);
 
    // Show it!
    getroundUI().setVisible(true);
  }
 
  public static UI getroundUI(){
    return roundUI;
  }
  
  
  
  /**
   * Each non abstract class that implements the ActionListener
   * must have this method.
   * 
   * @param e the action event.
   */

 
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == AButton)
    	buttonPressed('A');
    else if (e.getSource() == BButton)
    	buttonPressed('B');
    else if (e.getSource() == CButton)
    	buttonPressed('C');
    else if (e.getSource() == DButton)
    	buttonPressed('D');
    else if (e.getSource() == EButton)
    	buttonPressed('E');
    else if (e.getSource() == FButton)
    	buttonPressed('F');
    else if (e.getSource() == GButton)
    	buttonPressed('G');
    else if (e.getSource() == HButton)
    	buttonPressed('H');
    else if (e.getSource() == IButton)
    	buttonPressed('I');
    else if (e.getSource() == JButton)
    	buttonPressed('J');
    else if (e.getSource() == KButton)
    	buttonPressed('K');
    else if (e.getSource() == LButton)
    	buttonPressed('L');
    else if (e.getSource() == MButton)
    	buttonPressed('M');
    else if (e.getSource() == NButton)
    	buttonPressed('N');
    else if (e.getSource() == OButton)
    	buttonPressed('O');
    else if (e.getSource() == PButton)
    	buttonPressed('P');
    else if (e.getSource() == QButton)
    	buttonPressed('Q');
    else if (e.getSource() == RButton)
    	buttonPressed('R');
    else if (e.getSource() == SButton)
    	buttonPressed('S');
    else if (e.getSource() == TButton)
    	buttonPressed('T');
    else if (e.getSource() == UButton)
    	buttonPressed('U');
    else if (e.getSource() == VButton)
    	buttonPressed('V');
    else if (e.getSource() == WButton)
    	buttonPressed('W');
    else if (e.getSource() == XButton)
    	buttonPressed('X');
    else if (e.getSource() == YButton)
    	buttonPressed('Y');
    else if (e.getSource() == ZButton)
    	buttonPressed('Z');
    else
      myText.setText("E ...?");
    Hangman.oneRoundPart2();
  }
  
  public static void updatePicture() {
      //Get the icon corresponding to the image.
      ImageIcon icon = createImageIcon("/Lives" + Player.getplayerLives() + ".jpg");
      pictureLabel.setIcon(icon);
      pictureLabel.setToolTipText("TESTING");
      if (icon == null) {
          pictureLabel.setText("Missing Image");
      } else {
          pictureLabel.setText(null);
      }
  }

  /** Returns an ImageIcon, or null if the path was invalid. */
  protected static ImageIcon createImageIcon(String path) {
      java.net.URL imgURL = Hangman.class.getResource(path);
      if (imgURL != null) {
          return new ImageIcon(imgURL);
      } else {
          System.err.println("Couldn't find file: " + path);
          return null;
      }
  }
  
  public void buttonPressed(char button){
      myText.setText(button + " button click");
      GuessingChar.setguessChar(button);
      System.out.println(button + " button pressed");
  }

  public void setText(JTextArea text){
	  myText = text;
  }
  public static void displayStatus(){
	  myText.setText("Word to guess: " + Round.getword() + "\n" + 
			  Round.getguessingWord() + "\n" +
			  "Incorrect Guesses: " + Round.getincorrectGuesses() + "\n" +
			  "Lives: " + Player.getplayerLives() + "\n" +
			  "Time Remaining: " + NewThread.getTimeRemaining());	  		
	  updatePicture();
  }
  
}