package comp3111.popnames;

/**
 * // TODO: Ryan Javadoc
 */
public class Profile {
	
	// DATA MEMBERS
	
    private int yearOfBirth;
    private String gender;
    private String name;
    private int rank;
    private int freq;
    
    // MEMBER FUNCTIONS
    
    // Constructors

    /**
     * Profile Class Constructor with NAME
     *
     * @param yearOfBirth
     * @param gender
     * @param name
     */
    Profile(int yearOfBirth, String gender, String name) {
        // initialize instance attributes
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.freq = AnalyzeNames.getFreq(yearOfBirth, name, gender);
        this.rank = AnalyzeNames.getRank(yearOfBirth, name, gender);
    }

    /**
     * Profile Class Constructor with RANK
     *
     * @param yearOfBirth
     * @param gender
     * @param rank
     */
    Profile(int yearOfBirth, String gender, int rank) {
        // initialize instance attributes
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.rank = rank;
        this.freq = AnalyzeNames.getFreq(yearOfBirth, rank, gender);
        this.name = AnalyzeNames.getName(yearOfBirth, rank, gender);
    }

    
    // Access Functions
    
    String getName() { return name; }

    String getGender() { return gender; }

    int getYearOfBirth() { return yearOfBirth; }

    int getRank() { return rank; }

    int getFreq() { return freq; }

}
