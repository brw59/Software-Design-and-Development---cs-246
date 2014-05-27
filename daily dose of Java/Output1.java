class Output1 implements Runnable {
    @Override
	public void run() {

	//	Thread t;	
	try {
	for (int i = 0; i < 100; i++)
	    {
		System.out.println(i);
		Thread.sleep(50);
	    }
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}