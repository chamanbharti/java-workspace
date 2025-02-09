package arraylist;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// create an empty array list with an initial capacity
	      ArrayList<Integer> arrlist = new ArrayList<Integer>();

	      // use add() method to add elements in the list
	      arrlist.add(15);
	      arrlist.add(20);
	      arrlist.add(25);
	   // this will increase the capacity of the ArrayList to 15 elements
	      //arrlist.ensureCapacity(15);
	      
	   // Trim the arraylist
	      arrlist.trimToSize();
	      
	   // adding element 22 at third position
	      arrlist.add(2,22);
	      arrlist.add(3,30);
	      // let us print all the elements available in list
	      for (Integer number : arrlist) {
	         System.out.println("Number = " + number);
	      }
	      arrlist=null;
	     
	}
}
