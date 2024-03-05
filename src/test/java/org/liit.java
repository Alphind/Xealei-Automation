package org;

public class liit {

	public static void main(String[] args) {
		
		String inputMoreThan14Char = "1234567.1236";
		CharSequence subSequence = inputMoreThan14Char.subSequence(0,inputMoreThan14Char.length()-1);
		
	    System.out.println(subSequence.toString());
	    int length = subSequence.toString().length();
	    System.out.println(length);
	
	if(length==11) {
		System.out.println("Total No of Char is - "+length);
	} else {
		System.out.println("More Than 14 Character");
	}
	}
}
