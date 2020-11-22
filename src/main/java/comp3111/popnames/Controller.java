/**
 * Building on the sample skeleton for 'ui.fxml' Controller Class generated by SceneBuilder
 */
package comp3111.popnames;

import org.apache.commons.csv.CSVRecord;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class Controller {

    @FXML
    private Tab tabTaskZero;

    @FXML
    private TextField textfieldNameF;

    @FXML
    private TextField textfieldYear;

    @FXML
    private Button buttonRankM;

    @FXML
    private TextField textfieldNameM;

    @FXML
    private Button buttonRankF;

    @FXML
    private Button buttonTopM;

    @FXML
    private Button buttonTopF;

    @FXML
    private Button buttonSummary;
    
    @FXML
    private Tab tabReport1;

    @FXML
    private TextField textfieldR1TopN;
    
    @FXML
    private ToggleGroup T1;

    @FXML
    private TextField textfieldR1FirstYear;

    @FXML
    private TextField textfieldR1LastYear;

    @FXML
    private Tab tabReport2;
    @FXML
    private TextField textfieldR2Name;
    
    @FXML
    private TextField textfieldR2FirstYear;

    @FXML
    private TextField textfieldR2LastYear;
    
    @FXML
    private ToggleGroup T11;

    @FXML
    private Tab tabReport3;

    @FXML
    private ToggleGroup T111;
    
    @FXML
    private TextField y1R3;
    
    @FXML
    private TextField y2R3;

    @FXML
    private Tab tabApp1;

    @FXML
    private TextField textfieldA1dadName;

    @FXML
    private TextField textfieldA1momName;

    @FXML
    private TextField textfieldA1dadYOB;

    @FXML
    private TextField textfieldA1momYOB;

    @FXML
    private TextField textfieldA1vintageYear;

    @FXML
    private Tab tabApp2;

    @FXML
    private TextField textfieldA2iName;

    @FXML
    private TextField textfieldA2iYOB;

    @FXML
    private ToggleGroup T5_1;

    @FXML
    private ToggleGroup T5_2;

    @FXML
    private ToggleGroup T5_3;

    @FXML
    private Tab tabApp3;

    @FXML
    private TextField textfieldA3iName;

    @FXML
    private TextField textfieldA3iYOB;

    @FXML
    private ToggleGroup T6_1;

    @FXML
    private TextField textfieldA3iNameMate;

    @FXML
    private ToggleGroup T6_2;

    @FXML
    private ToggleGroup T6_3;

    @FXML
    private TextArea textAreaConsole;
    

    /**
     *  Task Zero
     *  To be triggered by the "Summary" button on the Task Zero Tab 
     *  
     */
    @FXML
    void doSummary() {
    	int year = Integer.parseInt(textfieldYear.getText());
    	String oReport = AnalyzeNames.getSummary(year);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rank (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRankF() {
    	String oReport = "";
    	String iNameF = textfieldNameF.getText();
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	int oRank = AnalyzeNames.getRank(iYear, iNameF, "F");
    	if (oRank == -1)
    		oReport = String.format("The name %s (female) has not been ranked in the year %d.\n", iNameF, iYear);
    	else
    		oReport = String.format("Rank of %s (female) in year %d is #%d.\n", iNameF, iYear, oRank);
    	textAreaConsole.setText(oReport);
    }

  
    /**
     *  Task Zero
     *  To be triggered by the "Rank (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doRankM() {
    	String oReport = "";
    	String iNameM = textfieldNameM.getText();
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	int oRank = AnalyzeNames.getRank(iYear, iNameM, "M");
    	if (oRank == -1)
    		oReport = String.format("The name %s (male) has not been ranked in the year %d.\n", iNameM, iYear);
    	else
    		oReport = String.format("Rank of %s (male) in year %d is #%d.\n", iNameM, iYear, oRank);
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (female)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopF() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
    	textAreaConsole.setText(oReport);
    }


    /**
     *  Task Zero
     *  To be triggered by the "Top 5 (male)" button on the Task Zero Tab
     *  
     */
    @FXML
    void doTopM() {
    	String oReport = "";
    	final int topN = 5;
    	int iYear = Integer.parseInt(textfieldYear.getText());
    	oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
    	for (int i=1; i<=topN; i++)
    		oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
    	textAreaConsole.setText(oReport);
    }


    /**
     * Task 1: Top Names for Birth
     * To be triggered by the "REPORT" button on the "Reporting 1" Tab
     *
     */
    @FXML
    void reporting1() {

        // parse data from UI

        int n = Integer.parseInt(textfieldR1TopN.getText());
        RadioButton rb1 = (RadioButton)(T1.getSelectedToggle());
        String g = rb1.getText();
        // String gender = "Male";
        String gender = g.substring(0,1);
        int first_year = Integer.parseInt(textfieldR1FirstYear.getText());
        int last_year = Integer.parseInt(textfieldR1LastYear.getText());

        // create profiles

        Profile[][] people = new Profile[last_year - first_year + 1][n];
        for (int i = first_year; i <= last_year; ++i) {
            for (int j = 1; j <= n; ++j) {
                people[i - first_year][j - 1] = new Profile(i, gender, j);
            }
        }

        // store into string

        /*
        String s = "This is a report detailing top ";
        s += Integer.toString(n);
        s += " ";
        if (gender.equals("M")) s += "male";
        else s += "female";
        s += " names of birth from ";
        s += Integer.toString(first_year);
        s += " to ";
        s += Integer.toString(last_year);
        s += ".\n\n";
        */

        // summary of results

        int k = -1;

        String[] names = new String[last_year - first_year + 1];
        int[] freq = new int[names.length];
        for (int i = first_year; i <= last_year; ++i) {
            for (int j = 0; j < freq.length; ++j) {
                if (people[i - first_year][0].getName().equals(names[j])) {
                    ++freq[j];
                    break;
                }
                else if (freq[j] == 0) {
                    freq[j] = 1;
                    names[j] = people[i - first_year][0].getName();
                    break;
                }
            }
        }
        int index = 0;      // find index and values of the most frequent top spot name
        for (int i = 0; i < freq.length; ++i) {
            if (k < freq[i]) {
                k = freq[i];
                index = i;
            }
            else if (freq[i] == 0) {
                break;
            }
        }

        /*
        for (int i = 0; i < freq.length; ++i) {
            System.out.print(names[i]);
            System.out.print(freq[i]);
        }
        */

        String s = String.format("Over the period %d to %d, %s for %s has hold the top spot most often for a total of %d times.\n\n",
                                    first_year, last_year, names[index], gender.equals("M")? "males": "females", k);

        // TODO: consider case where there are more than one most frequent item

        // detailed results

        /*
        for (int i = first_year; i <= last_year; ++i) {
            s += "For year ";
            s += Integer.toString(i);
            s += ":\n";
            for (int j = 1; j <= n; ++j) {
                s += Integer.toString(j);
                s += ".\tName: ";
                s += String.format("%1$-15s", people[i - first_year][j - 1].getName());
                s += "Frequency: ";
                s += Integer.toString(people[i - first_year][j - 1].getFreq());
                s += "\n";
                // s += Boolean.toString(people[i - first_year][j - 1].getName().equals("Emma"));
            }
            s += "\n";
        }
        */

        s += "Detailed results: (in table form)\nYear ";
        for (int i = 1; i <= n; ++i) {
            s += String.format("| Top %1$-7d", i);
        }
        for (int i = first_year; i <= last_year; ++i) {
            s += "\n-----";
            for (int j = 0; j < n; ++j) {
                s += "+------------";
            }
            s += String.format("\n%d ", i);
            for (int j = 0; j < n; ++j) {
                s += String.format("| %1$-11s", people[i - first_year][j].getName());
            }
        }

        textAreaConsole.setText(s);
    }


    /**
     * Task 2: Popularity of Name
     * To be triggered by the "REPORT" button on the "Reporting 2" Tab
     *
     */
    @FXML
    void reporting2() {
    	String N = textfieldR2Name.getText();
    	if (N.equals("")) {
    		textAreaConsole.setText("Please input a name");
    		return;
    	}
        RadioButton rb2 = (RadioButton)(T11.getSelectedToggle());
        String gender = rb2.getText();
        
        gender = gender.substring(0,1);
        if (textfieldR2FirstYear.getText().equals("") || textfieldR2LastYear.getText().equals("")) {
        	textAreaConsole.setText("Please input the year");
        	return;
        }
        double temp = Double.parseDouble(textfieldR2FirstYear.getText());
        double temp1 = Double.parseDouble(textfieldR2LastYear.getText());
        if (temp%1 !=0 || temp1%1 !=0) {
        	textAreaConsole.setText("Please input an integer for the period of the year");
        	return;
        }
        int first_year = Integer.parseInt(textfieldR2FirstYear.getText());
        int last_year = Integer.parseInt(textfieldR2LastYear.getText());

        if ( first_year<1880 || last_year>2019 ) {
        	textAreaConsole.setText("Please input year within the range");
        	return;
        }
        
        if ( first_year > last_year) {
        	textAreaConsole.setText("first year should be greater than last year");
        	return;
        }
       
        Profile[] ranks = new Profile[last_year - first_year + 1];
        for (int i = first_year; i <= last_year; ++i) {
        	ranks[i - first_year] = new Profile(i, gender, N);  
        }

        String s = String.format("The popularity of %s over the period %d to %d.\n\n",
        		N,first_year, last_year);

        s += "Detailed results: (in table form)\nYear ";
        s += String.format("| %1$-11s", "Rank");
        s += String.format("| %1$-11s", "Count");
        s += String.format("| %1$-11s", "Percentage");
        
        
        for (int i = 0; i <= last_year-first_year; ++i) {
            s += "\n-----";
            for (int j = 0; j < 3; ++j) {
                s += "+------------";
            }
            s += String.format("\n%d ", i+first_year);
            
            if (ranks[i].getRank() == -1) {
            	s += String.format("| %1$-11s", "None");
            }
            else {
            	s += String.format("| %1$-11d", ranks[i].getRank());
            }
            if (ranks[i].getFreq() == -1) {
            	s += String.format("| %1$-11d", 0);
            }
            else {
            	s += String.format("| %1$-11d", ranks[i].getFreq());
            }
            String percent = String.format("%.2f",((double)((double)ranks[i].getFreq()*100/(double)AnalyzeNames.getTotalByGender(i+first_year, gender))));
            if (percent.equals("-0.00")) {
            	s += String.format("| %1$-11s", "0.00%");   
            }
            else {
            	s += String.format("| %1$-11s", (percent+"%"));   
            }
        }   
        textAreaConsole.setText(s);
    }


    /**
     * Task 3: Trend in Popularity of Names
     * To be triggered by the "REPORT" button on the "Reporting 3" Tab
     *
     */
    @FXML
    void reporting3() {
        // Parse Data from UI
        RadioButton rb = (RadioButton)(T111.getSelectedToggle());
        String gender = rb.getText();

        gender = gender.substring(0,1);
        int starting_year = Integer.parseInt(y1R3.getText());
        int ending_year = Integer.parseInt(y2R3.getText());
    	
        // Boundary Case
    	if (starting_year < 1880 || ending_year > 2019 || starting_year >= ending_year)
		{
			textAreaConsole.setText("Invalid Input.");
			return;
		}
    	
    	// initialize a map and a list
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	List<String> names_appeared = new ArrayList<String>();
    	for (int i = starting_year; i <= ending_year; i++)
    	{
    		int rank = 1;
    		for (CSVRecord rec : AnalyzeNames.getFileParser(i))
    		{
    			if (rec.get(1).equals(gender))
    			{
    				if (!names_appeared.contains(rec.get(0)))
    					names_appeared.add(rec.get(0));
    				String key = rec.get(0) + "#" + Integer.toString(i);
    				map.put(key, rank);
    				rank++;
    			}
    		}
    	}
    	
    	// finding largest_rise and largest_fall
    	String name_rise = "";
    	String name_fall = "";
    	int rank_rise1 = -1, rank_rise2 = -1, rank_fall1 = -1, rank_fall2 = -1;
    	int year_rise1 = -1, year_rise2 = -1, year_fall1 = -1, year_fall2 = -1;
    	
    	int largest_rise = -1;
    	int largest_fall = 1;
    	int p, q, rank1, rank2;
    	String key_p, key_q;
    	for (String name : names_appeared)
    	{
    		p = starting_year;
    		while (p < ending_year)
    		{
    			key_p = name + "#" + Integer.toString(p);
        		if (!map.containsKey(key_p))
        		{
        			p++;
        			continue;
        		}
        		q = p + 1;
        		key_q = name + "#" + Integer.toString(q);
        		while (q <= ending_year && !map.containsKey(key_q))
        		{
        			q++;
        			key_q = name + "#" + Integer.toString(q);
        		}
        		if (q > ending_year)
        			break;
        		
        		rank1 = map.get(key_p);
        		rank2 = map.get(key_q);
        		if (rank1 - rank2 > largest_rise)
        		{
        			largest_rise = rank1 - rank2;
        			name_rise = name;
        			rank_rise1 = rank1;
        			rank_rise2 = rank2;
        			year_rise1 = p;
        			year_rise2 = q;
        		}
        		if (rank1 - rank2 < largest_fall)
        		{
        			largest_fall = rank1 - rank2;
        			name_fall = name;
        			rank_fall1 = rank1;
        			rank_fall2 = rank2;
        			year_fall1 = p;
        			year_fall2 = q;
        		}
        		p = q;
    		}
    	}
        
        String s = name_rise + " is found to have shown the largest rise in popularity from rank " + rank_rise1;
        s += " in year " + year_rise1 + " to rank " + rank_rise2;
        s += " in year " + year_rise2 + ".\nOn the other hand,\n";
        s += name_fall  + " is found to have shown the largest fall in popularity from rank " + rank_fall1;
        s += " in year " + year_fall1 + " to rank " + rank_fall2;
        s += " in year " + year_fall2 + ".\n\n";

        s += "Detailed results: (in table form)\n";
        s += "-----------------------------------------------------------------------------------------------\n";
        s += String.format("| %1$-15s", "Name");
        s += String.format("| %1$-13s%2$-10s", "Lowest Rank", "[in year]");
        s += String.format("| %1$-13s%2$-10s", "Highest Rank", "[in year]");
        s += String.format("| %1$-25s", "Trend");
        s += String.format("|\n| %1$-15s", name_rise);
        s += String.format("| %1$-13s%2$-10s", rank_rise1, "[in " + year_rise1 + "]");
        s += String.format("| %1$-13s%2$-10s", rank_rise2, "[in " + year_rise2 + "]");
        s += String.format("| %1$-25s", "rank up" + " " + "(" + rank_rise1 + " - " + rank_rise2 + ")");
        s += String.format("|\n| %1$-15s", name_fall);
        s += String.format("| %1$-13s%2$-10s", rank_fall1, "[in " + year_fall1 + "]");
        s += String.format("| %1$-13s%2$-10s", rank_fall2, "[in " + year_fall2 + "]");
        s += String.format("| %1$-25s", "rank down" + " " + "(" + rank_fall1 + " - " + rank_fall2 + ")");
        s += "|\n-----------------------------------------------------------------------------------------------\n";
    	textAreaConsole.setText(s);
    }

    /**
     * Task 4: Recommendation on Names for Newborn Babies
     * To be triggered by the "OUTPUT" button on the "Application 1" Tab
     *
     */
    @FXML
    void application1() {
        // set vintageYear to 2019 if no input
        String dadName = textfieldA1dadName.getText();
        String momName = textfieldA1momName.getText();
        int dadYOB = Integer.parseInt(textfieldA1dadYOB.getText());
        int momYOB = Integer.parseInt(textfieldA1momYOB.getText());
        int vintageYear = 2019;
        if (!textfieldA1vintageYear.getText().equals("")){
            vintageYear = Integer.parseInt(textfieldA1vintageYear.getText());
        }

        // run the NK-T4 algorithm
        String[] kidNames = AnalyzeNames.NK_T4(dadName, momName, dadYOB, momYOB, vintageYear);

        // parse the data into words and load it into String
        String s = String.format("Recommended male name: %s\nRecommended female name: %s", kidNames[0], kidNames[1]);

        textAreaConsole.setText(s);
    }

    /**
     * Task 5: Prediction on Names for Compatible Pairs
     * To be triggered by the "OUTPUT" button on the "Application 2" Tab
     *
     */
    @FXML
    void application2() {
        String iName = textfieldA2iName.getText();
        if (iName.equals("")) {
        	textAreaConsole.setText("Please input your name");
    		return;
        }
        if (textfieldA2iYOB.getText().equals("")) {
        	textAreaConsole.setText("Please input your year of birth");
    		return;
        }
        double temp = Double.parseDouble(textfieldA2iYOB.getText());
        if (temp%1 !=0) {
        	textAreaConsole.setText("Please input an integer for the year of birth");
        	return;
        }
        int iYOB = Integer.parseInt(textfieldA2iYOB.getText());
        if(iYOB>2018 || iYOB<1881) {
        	textAreaConsole.setText("Can only calculate year of birth from 1881 to 2018");
    		return;
        }
        if (T5_1.getSelectedToggle() == null) {
        	textAreaConsole.setText("Please input your gender");
    		return;
        }
        RadioButton rb5 = (RadioButton)(T5_1.getSelectedToggle());
        String iGender = rb5.getText().substring(0, 1);
        if (T5_2.getSelectedToggle() == null) {
        	textAreaConsole.setText("Please input your soulmate's gender");
    		return;
        }
        rb5 = (RadioButton)(T5_2.getSelectedToggle());
        String iGenderMate = rb5.getText().substring(0, 1);
        if (T5_3.getSelectedToggle() == null) {
        	textAreaConsole.setText("Please input your preference");
    		return;
        }
        rb5 = (RadioButton)(T5_3.getSelectedToggle());
        String iPreference = rb5.getText();

        String oName = AnalyzeNames.NK_T5(iName, iGender, iYOB, iGenderMate, iPreference);

        // TODO

        textAreaConsole.setText("The soulmate name will be "+ oName);
    }

    /**
     * Task 6: Prediction on Scores for Compatible Pairs
     * To be triggered by the "OUTPUT" button on the "Application 3" Tab
     *
     */
    @FXML
    void application3() {
        String iName = textfieldA3iName.getText();
        int iYOB = Integer.parseInt(textfieldA3iYOB.getText());
        RadioButton rb6 = (RadioButton)(T6_1.getSelectedToggle());
        String iGender = rb6.getText().substring(0, 1);
        String iNameMate = textfieldA3iNameMate.getText();
        rb6 = (RadioButton)(T6_2.getSelectedToggle());
        String iGenderMate = rb6.getText().substring(0, 1);
        rb6 = (RadioButton)(T6_3.getSelectedToggle());
        String iPreference = rb6.getText();

        int oScore = AnalyzeNames.NK_T6(iName, iGender, iYOB, iNameMate, iGenderMate, iPreference);

        // TODO
        
    	if (iYOB < 1880 || iYOB > 2019)
		{
			textAreaConsole.setText("Invalid Input.");
			return;
		}
    	if (iName.isBlank() || iNameMate.isBlank())
    	{
			textAreaConsole.setText("Invalid Input.");
			return;
    	}
        
        String s = String.format("Score of Compatibility = %s", oScore);
        
        textAreaConsole.setText(s+"%");
    }

}

