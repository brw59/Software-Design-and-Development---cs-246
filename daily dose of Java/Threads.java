class Threads {
    public static void main(String[] args) {
	Thread output1 = new Thread(new Output1());
	output1.start();

	try {
	    for (int i = 0; i < 100; i++)
		{
		    System.out.println(i);
		    Thread.sleep(100);
		}
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}