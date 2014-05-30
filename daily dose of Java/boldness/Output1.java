class Output1 implements Runnable {
    @Override
	public void run() {

	//	Thread t;	
	try {
		Thread.sleep(300);
		for (int i = 0; i <= 20; i++)
		    {
				System.out.println(i);
				Thread.sleep(50);
	    	}
		} catch (Exception e) {
	    	System.out.println(e.getMessage());
		}
    }
}