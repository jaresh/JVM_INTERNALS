package jsikora;

public class App {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InterruptedException {
		
		MessageInter s0,s1;

		while (true) {
			s0 = new MessageZ();
			s1 = Service.newInstance();
			System.out.println(s0.message());
			System.out.println(s1.message());

			Thread.sleep(2000);
		}

	}

}
