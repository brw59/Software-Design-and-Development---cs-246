import javafx.application.Platform;

class Threads extends Thread { //implements Runnable {

//	public boolean isFinished = false;
	Thread thread;

    public static void main(String[] args) {
    	new Threads().run();
    }

    @Override
    public void run() {
		thread = new Thread(new Output1());
		thread.start();

		try {
	    	for (int i = 0; i <= 100 && Boldness.getInstance().shouldCurrentThreadBeRunning(); i++)
			{
		    	System.out.println(i);
		    	Thread.sleep(100);
			}
		} catch (Exception e) {
	   		System.out.println(e.getMessage());
		}

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Boldness.getInstance().getStage().setTitle("Popcorn Popping on the Apricot Tree!");
			}
 		});

		try {
		Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("No sleepy for you...zzzz");
		}

 		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Boldness.getInstance().getStage().setTitle("Glory, Glory, Hallelujah!");
			}
 		});
	}
}