package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

public class AnalyzeNames {

	public static final int LOWER_YEAR = 1880;
	public static final int UPPER_YEAR = 2019;

	public static CSVParser getFileParser(int year) {
     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
     return fr.getCSVParser(false);
	}
 
	
	public static String getSummary(int year) {
		String oReport = "";	
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int totalNames = 0;
		int uniqueBoys = 0;
		int uniqueGirls = 0;
		
		oReport = String.format("Summary (Year of %d):\n", year);
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			totalNames += 1;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				uniqueBoys++;
			}
			else {
				totalGirls += numBorn;
				uniqueGirls++;
			}
		}
		
		oReport += String.format("Total Births = %,d\n", totalBirths);
		oReport += String.format("***Baby Girls = %,d\n", totalGirls);
		oReport += String.format("***Baby Boys = %,d\n", totalBoys);
		
		oReport += String.format("Total Number of Unique Names = %,d\n", totalNames);
		oReport += String.format("***Unique Names (baby girls) = %,d\n", uniqueGirls);
		oReport += String.format("***Unique Names (baby boys) = %,d\n", uniqueBoys);
		
		return oReport;
	}
	
	public static int getTotalByGender(int year, String gender) {
		
		
		int totalBoys = 0;
		int totalGirls = 0;
				
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));			
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		
		if (gender.equals("M")) {
			
			return totalBoys;
		} 
		else if (gender.equals("F")) {
			return totalGirls;
		}
		return 0;
	}
	 public static int getRank(int year, String name, String gender) {
	     boolean found = false;
	     int oRank = 0;
	     int rank = 1;
	     for (CSVRecord rec : getFileParser(year)) {
	         // Increment rank if gender matches param
	         if (rec.get(1).equals(gender)) {
	             // Return rank if name matches param
	             if (rec.get(0).equals(name)) {
	             	found = true;
	             	oRank = rank;
	             	break;
	             }
	             rank++;
	         }
	     }
	     if (found)
	     	return oRank;
	     else
	     	return -1;
	 }
	 
 
	 public static String getName(int year, int rank, String gender) {
	 	boolean found = false;
	     String oName = "";
	     int currentRank = 0;
	     
	     // For every name entry in the CSV file
	     for (CSVRecord rec : getFileParser(year)) {
	         // Get its rank if gender matches param
	         if (rec.get(1).equals(gender)) {
	             // Get the name whose rank matches param
	         	currentRank++;
	            if (currentRank == rank) {
	             	found = true;
	             	oName = rec.get(0);
	                break;
	            }
	         }
	     }     
	     if (found)
	     	return oName;
	     else
	     	return "information on the name at the specified rank is not available";
	 }
	 
	 public static int getFreq(int yearOfBirth, String name, String gender)
	 {
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
		    	return oFreq;
		    else
		    	return -1;
	 }
	 
	 public static int getFreq(int yearOfBirth, int rank, String gender)
	 {
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
	     	return oFreq;
	     else
	     	return -1;
	 }

	 /*
	 public static String[] NK_T4(String dadName, String momName, int dadYOB, int momYOB) {
		 // overloaded function: set vintageYear = 2019 by default
		 return NK_T4(dadName, momName, dadYOB, momYOB, 2019);
	 }
	 */

	 public static String[] NK_T4(String dadName, String momName, int dadYOB, int momYOB, int vintageYear) {
		 String[] kidNames = new String[2];		// kidNames[0] = boyName, kidNames[1] = girlName

		 int dadRank = getRank(dadYOB, dadName, "M");
		 if (dadRank == -1) {
		 	dadRank = 1;
		 }
		 int momRank = getRank(momYOB, momName, "F");
		 if (momRank == -1) {
		 	momRank = 1;
		 }
		 kidNames[0] = getName(vintageYear, dadRank, "M");
		 kidNames[1] = getName(vintageYear, momRank, "F");

		 return kidNames;
	 }

	 public static String NK_T5(String iName, String iGender, int iYOB, String iGenderMate, String iPreference) {
		 String oName = "";
		 // TODO
		 int oRank;
		 int oYOB = 0;
//		 oRank = this.getRank()
		 oRank = getRank(iYOB,iName,iGender);
		 if (oRank == -1) {
			 oRank = 1;
		 }
		 if (iPreference.equals("Younger")) {
			 oYOB = iYOB+1;
		 }
		 else if (iPreference.equals("Older")) {
			 oYOB = iYOB-1;
		 }
		 oName = getName(oYOB,oRank,iGenderMate);
		 if (oName.equals("information on the name at the specified rank is not available")) {
			 oName = getName(oYOB,1,iGenderMate);
		 }
		 return oName;
	 }

	 public static int NK_T6(String iName, String iGender, int iYOB, String iNameMate, String iGenderMate, String iPreference) {
		 int oScore = -1;
		 // TODO
		 double oRank, oRankMate;
		 int oYOB;
		 oRank = getRank(iYOB, iName, iGender);
		 if (oRank == -1)
			 oRank = 1;
		 if (iPreference.equals("Younger"))
			 oYOB = iYOB + 1;
		 else
			 oYOB = iYOB - 1;
		 oRankMate = getRank(oYOB, iNameMate, iGenderMate);
		 if (oRankMate == -1)
			 oRankMate = 1;
		 
		 double x = Math.abs(oRank - oRankMate)/oRank;
		 x = (1-x)*100;
		 oScore = (int) x;
		 
		 oScore = Math.abs(oScore) % 101;				// customized algorithm which is more realistic
		 return oScore;
	 }

	 public static int returnYear(String yob) {
		 try {
		 	 int year = Integer.parseInt(yob);
		 	 if (year < LOWER_YEAR || year > UPPER_YEAR) {
		 	 	 return 0;		// return 0 for out of range input
			 }
		 	 return year;		// return corresponding year in Integer type
		 } catch (Exception e) {
		 	 if (yob.equals("")) return -2;		// return -2 for empty input
		 	 return -1;		// return -1 for invalid input
		 }
	 }

	 public static int returnNumber(String number) {
	 	try {
	 		int n = Integer.parseInt(number);
	 		if (n < 1) {
	 			return 0;		// return 0 for out of range input
			}
	 		return n;		// return corresponding number in Integer type
		} catch (Exception e) {
	 		if (number.equals("")) return -2;	// return -2 for empty input
			return -1;		// return -1 for invalid input
		}
	 }

}