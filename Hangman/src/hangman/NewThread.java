package hangman;

// Create a new thread.
class NewThread implements Runnable {
   Thread t;
   static int timeRemaining;
   
   NewThread() {
      // Create a new, second thread
      t = new Thread(this, "Time Remaining Thread");
      System.out.println("Time Remaining: " + t);
      t.start(); // Start the thread
   }
   
	public static void setTimeRemaining(int input){
		timeRemaining = input;
	}
	public static int getTimeRemaining(){
		  return timeRemaining;
	}
   
   // This is the entry point for the second thread.
   public void run() {
      try {
         for (timeRemaining = 60; timeRemaining > 0; timeRemaining--){
            System.out.println("Time Remaining: " + timeRemaining);
            // Let the thread sleep for a while.
            Thread.sleep(1000);
         }
         UI.displayStatus();
         	System.out.println("Time has Expired. \nYou have been hanged");
         	Hangman.sleep(1000);
         	UI.getroundUI().setVisible(false);
         	UISettings.getsettingsWindow().setVisible(true);
     } catch (InterruptedException e) {
         System.out.println("Time Remaining Thread interrupted.");
     }
     System.out.println("Exiting time remaining thread thread.");
   }
}