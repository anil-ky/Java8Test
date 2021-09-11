package io.lamda.learning;

public class LamdaExpressions {
	
	public static void doGreeting(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {

		//HelloWorldGreeting greeting = new HelloWorldGreeting();
		//doGreeting(greeting);
		
		/*
		 * Greeting greeting = new Greeting() {
		 * @Override public void perform() { System.out.println("Hello World!!!"); } };
		 * doGreeting(greeting);
		 */
		

		Greeting myLamdaFunction = () -> System.out.println("Hello World!");
		doGreeting(myLamdaFunction);
		doGreeting(() -> System.out.println("Hello New World!!"));
		myLamdaFunction.perform();
	}

}