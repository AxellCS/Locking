package com.pp2;

//Creacion de locking
//permite tener control sobre los hilos
public class App {

	private static int counter = 0;
	
	//synchronized sincroniza los hilos
	//Creacion del metodo increment() 
	public static synchronized void increment() {
		++counter;
	}
	
	//Creacion del metodo process()
	public static void process() {
		
		//Creacion del objto t1
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; ++i)
					//Invocacion de metodo increment()
					increment();
			}
		});

		//Creacion del objeto t2
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; ++i)
					//Invocacion de metodo increment()
					increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			//join() une los hilos
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		//Invocacion del metodo process()
		process();
		System.out.println(counter);
		
	}
}

