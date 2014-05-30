import javafx.application.Platform;

class Threads implements Runnable {
	public boolean isFinished = false;
//	Thread thread;
    public static void main(String[] args) {
    	new Threads().run();
    }

    @Override
    public void run() {
		thread = new Thread(new Output1());
		thread.start();

		try {
	    	for (int i = 0; i <= 20 && !isFinished; i++)
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
//			threadList2.getItems().remove(thread.getName());
			stage.setTitle("Popcorn Popping on the Apricot Tree!");
		}
	
		isFinished = true;
//		runnable.terminate();
//		thread.join();
 	   });
	}
}