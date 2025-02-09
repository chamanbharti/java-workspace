package exception.ways;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
///https://stackify.com/best-practices-exceptions-java/
///https://dzone.com/articles/9-best-practices-to-handle-exceptions-in-java
public class HowToHandleException1 {

	public static void main(String[] args) {
		
		/*
		FileReader file;
		try {
			file = new FileReader("D:\\MAVEN Command.txt");
			file.read();
			file.close();
		} catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
		
		*/
		
		/*
		FileReader file = null;
		try {
			file = new FileReader("D:\\MAVEN Command.txt");
			file.read();
		} catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }finally {
	        	try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
        
        */
		
		/*
		//using throws
		try {
			fileReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 */
		
		//using  throw
		/*
		try {
			  invalidate(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		//	  invalidate(12);
		
		//User-Defined Exceptions
	}
	/*
	private static void invalidate(int amount) throws Exception {
		if(amount < 500) {
			throw new Exception("Amount not sufficient");
		}
		
	}
	*/
	/*
	private static void invalidate(int amount) throws RuntimeException {
		if(amount < 500) {
			throw new RuntimeException("Amount not sufficient");
		}
		
	}
	*/

	/*
	private static void fileReader() throws IOException{
		FileReader file = new FileReader("D:\\MAVEN Command.txt");
			file.read();
			file.close();
		} 
	 */
}
