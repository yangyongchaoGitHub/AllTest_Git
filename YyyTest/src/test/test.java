package test;

abstract class test {
	
	Thread test;
	public int init(){
		test = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						System.out.println("test init");
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		return 0;
	}
	
	public void exec() {
		test.start();
	}

}
