package act21.csv;

import java.io.FileReader;
import com.opencsv.CSVReader;

public class ReadCSVExample {
	public static void main(String[] args) {
		CSVReader reader = null;
		try {
				//parsing a CSV file into CSVReader class constructor  
				reader = new CSVReader(new FileReader("D:\\act21/employee.csv"));
				String[] nextLine;
				//reads one line at a time  
				while ((nextLine = reader.readNext()) != null) {
					for (String token : nextLine) {
						System.out.print(token);
					}
					System.out.print("\n");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
