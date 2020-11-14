package comp3111.popnames;

public class Profile {
    private int yearOfBirth;
    private String gender;
    private String name;
    private int rank;
    private int freq;

    // Profile class constructor with name
    Profile(int yearOfBirth, String gender, String name) {
        // initialize instance attributes
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;

        this.freq = -1;     // yet to implement function to find frequency

        this.rank = AnalyzeNames.getRank(yearOfBirth, name, gender);
    }

    // Profile class constructor with rank
    Profile(int yearOfBirth, String gender, int rank) {
        // initialize instance attributes
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.rank = rank;

        this.freq = -1;     // yet to implement function to find frequency

        this.name = AnalyzeNames.getName(yearOfBirth, rank, gender);
    }

    String getName() { return name; }

    String getGender() { return gender; }

    int getYearOfBirth() { return yearOfBirth; }

    int getRank() { return rank; }

    int getFreq() { return freq; }

}
