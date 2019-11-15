package Automation;

public abstract class Instrument {

	abstract void display(String args);
	public static int myint= 2;
	
	public static void main(String[] args) {
		
		Instrument i;
		
		try{
			i = new Piano();
			i.display(args[0]);
			i = new Guitar();
			i.display(args[1]);
		}
		catch(NumberFormatException e) {
			System.out.println("Enter valid interger value");
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Enter a value");
		}
		
		display2(); //Static method call without instance of class 
	}
	
	static void display2() {
		myint = myint + 2 ;
		System.out.println("Instrument is playing tin tan tin" + myint);
		
	}
}

class Piano extends Instrument{

	@Override
	void display(String args) {
		System.out.println("Piano is playing tan tan tan " + args);
}
}

class Guitar extends Instrument{

	@Override
	void display(String args) {

		System.out.println("Guitar is playing tin tan tin " + args);

}
}