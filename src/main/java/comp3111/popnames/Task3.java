package comp3111.popnames;

import org.apache.commons.csv.*;

import edu.duke.FileResource;

public class Task3 {
	
	public static CSVParser getFileParser(int year)
	{
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}
	
}
