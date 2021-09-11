package io.lamda.learning;

public class TypeInterfaceExample {

	public static void main(String[] args) {
		
		StringLengthLamda strLamda = str -> str + ": " + str.length();
		System.out.println(strLamda.getLength("Anil Kumar"));
		printLamda(strLamda, "Anil Yellamandala");
		printLamda(str -> str + ": " + str.length(), "Anil Kumar Yellamandala");
		
		MathFactory factory = (a, b) -> a + b;
		
		System.out.println(factory.add(10, 90));
		System.out.println(factory.add(3, 4));
	}
	
	public static void printLamda(StringLengthLamda strLamda, String name) {
		System.out.println(strLamda.getLength(name));
	}

}

interface StringLengthLamda {
	String getLength(String s);
}

interface MathFactory {
	int add(int one, int two);
}