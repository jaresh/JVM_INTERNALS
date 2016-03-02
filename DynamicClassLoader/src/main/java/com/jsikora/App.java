package com.jsikora;

public class App {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InterruptedException {
		
		MessageInter s0;

		while (true) {
			s0 = Service.newInstance();
			System.out.println(s0.message());

			Thread.sleep(2000);
		}

	}

}
