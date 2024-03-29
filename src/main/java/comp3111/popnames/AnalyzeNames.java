package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

/**
 * Aesthetic Class containing helper functions useful for the entire programme
 */
public class AnalyzeNames {

	/**
	 * Constant integer that stores the smallest year available in the dataset.
	 * Current value is 1880.
	 *
	 */
	public static final int LOWER_YEAR = 1880;

	/**
	 * Constant integer that stores the largest year available in the dataset.
	 * Current value is 2019.
	 *
	 */
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

	/**
	 *
	 * This function is used to return the total number of boys or girls born in the specific year.
	 *
	 *
	 * @param year birth of year
	 * @param gender gender of baby
	 * @return total number of boys or girls
	 */
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
				 String n = rec.get(0);
				 if (n.substring(0, 1).equals("\uFEFF")) {
				 	n = n.substring(1);
				 }
	             if (n.equals(name)) {
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
	             	if (oName.substring(0, 1).equals("\uFEFF")) {
	             		oName = oName.substring(1);
					}
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
					String n = rec.get(0);
					if (n.substring(0, 1).equals("\uFEFF")) {
						n = n.substring(1);
					}
		            if (n.equals(name)) {
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

	/**
	 * This is the implementation of the newly and carefully designed NK-T4 Algorithm of Universal Compatibility.
	 * It takes names of parents, year of birth of parents, and an optional vintage year as input.
	 * It returns a String array that contains recommended boy and girl names.
	 *
	 * @param dadName Name of dad
	 * @param momName Name of mom
	 * @param dadYOB Year of birth of dad
	 * @param momYOB Year of birth of mom
	 * @param vintageYear Optional vintage year input
	 * @return Array of String containing one boy name and one girl name
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

	/**
	 *
	 * This is the implementation of the newly and carefully designed NK-T5 Algorithm.
	 * It takes user's name, year of birth, gender, preference and soulmate's gender as input.
	 * It returns the soulmate's name.
	 *
	 * @param iName User's name
	 * @param iGender User's gender
	 * @param iYOB User's year of birth
	 * @param iGenderMate Soulmate's gender
	 * @param iPreference User's preference
	 * @return Soulmate's name
	 */
	 public static String NK_T5(String iName, String iGender, int iYOB, String iGenderMate, String iPreference) {
		 String oName = "";
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

	/**
	 * This is the implementation of the newly and carefully designed NK-T6 Algorithm of Universal Compatibility.
	 * It takes user's name, year of birth, gender and soulmate's name and gender, and user's age preference as input.
	 * The algorithm then considers the frequency and ranking of the names to calculate a score.
	 * It returns a score of compatibility of the user and his/her soulmate.
	 * 
	 * @param iName	User's Name
	 * @param iGender User's Gender
	 * @param iYOB User's Year of Birth
	 * @param iNameMate Soulmate's Name
	 * @param iGenderMate Soulmate's Gender
	 * @param iPreference User's Age Preference
	 * @return
	 */
	 public static int NK_T6(String iName, String iGender, int iYOB, String iNameMate, String iGenderMate, String iPreference) {
		 int oScore = -1;
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

	/**
	 * This is a helper function to parse String inputs for year of birth.
	 * It returns the corresponding year in Integer type.
	 * It returns 0 for out of range integers.
	 * It returns -1 for invalid non-numerical inputs.
	 * It returns -2 for empty inputs.
	 *
	 * @param yob String extracted from text fields
	 * @return Corresponding year in Integer type, or error integers for incorrect inputs
	 */
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

	/**
	 * This is a helper function to parse String inputs for any numerical number which should be greater or equal to 1.
	 * It returns the corresponding number in Integer type.
	 * It returns 0 for out of range input.
	 * It returns -1 for invalid non-numerical inputs.
	 * It returns -2 for empty inputs.
	 *
	 * @param number
	 * @return
	 */
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