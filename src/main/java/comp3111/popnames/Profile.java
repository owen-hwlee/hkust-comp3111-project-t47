package comp3111.popnames;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class Profile {
	
    private int yearOfBirth;
    private String gender;
    private String name;
    private int rank;
    private int freq;
    
    // Helper function
	public static CSVParser getFileParser(int year) {
	     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
	     return fr.getCSVParser(false);
	}

    // Profile class constructor with name
    Profile(int yearOfBirth, String gender, String name) {
        // initialize instance attributes
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        
        // initialize freq
        boolean found = false;
	    int oFreq = 0;
	    for (CSVRecord rec : getFileParser(yearOfBirth)) {
	        if (rec.get(1).equals(gender)) {
	            if (rec.get(0).equals(name)) {
	            	found = true;
	            	oFreq = Integer.parseInt(rec.get(2));
	             	break;
	            }
	        }
	    }
	    if (found)
	    	this.freq = oFreq;
	    else
	    	this.freq = -1;

        this.rank = AnalyzeNames.getRank(yearOfBirth, name, gender);
    }

    // Profile class constructor with rank
    Profile(int yearOfBirth, String gender, int rank) {
        // initialize instance attributes
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.rank = rank;

        // initialize freq
        boolean found = false;
	    int oFreq = 0;
	    int currentRank = 0;
	    for (CSVRecord rec : getFileParser(yearOfBirth)) {
	        if (rec.get(1).equals(gender)) {
	        	currentRank++;
	            if (currentRank == rank) {
	            	found = true;
	            	oFreq = Integer.parseInt(rec.get(2));
	             	break;
	            }
	        }
	    }
	    if (found)
	    	this.freq = oFreq;
	    else
	    	this.freq = -1;

        this.name = AnalyzeNames.getName(yearOfBirth, rank, gender);
    }

    String getName() { return name; }

    String getGender() { return gender; }

    int getYearOfBirth() { return yearOfBirth; }

    int getRank() { return rank; }

    int getFreq() { return freq; }

}
