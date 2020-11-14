package comp3111.popnames;

import org.apache.commons.csv.*;

import edu.duke.FileResource;

public class Task3 {
	
	public static CSVParser getFileParser(int year)
	{
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}
	
	public static boolean getLargestFall(int startingYear, int endingYear)
	{
		Profile persons[][];
		
		if (startingYear < 1880 || endingYear > 2019 || startingYear >= endingYear)
			return false;
		
		for (int i = startingYear; i <= endingYear; i++)
		{
			for (CSVRecord rec : getFileParser(i))
			{
				Profile a;
			}
		}
		return true;
	}
	
}
