package exception.ways;

public class InputChecker {
	
	 	private int minLength;
	    private int maxLength;

	    public InputChecker(int minLength, int maxLength) {
	        this.minLength=minLength;
	        this.maxLength=maxLength;
	    }
	    
	    public void checkStringLength(String input) throws InvalidLengthException{
	    	int strLength = input.length();
	    	if(strLength < minLength) {
	    		throw new InvalidLengthException(strLength, "Input should have minimum "+minLength+" characters");
	    	}
	    	else if (strLength > maxLength){
	            throw new InvalidLengthException(strLength, "Input should have maximum "+maxLength+" character");
	        }
	    }
	public static void main(String[] args) {
		InputChecker ic = new InputChecker(2, 7);
		try {
			ic.checkStringLength("longer than the maximum length");
		} catch (InvalidLengthException e) {
			e.printStackTrace();
		}
		
	}
}
