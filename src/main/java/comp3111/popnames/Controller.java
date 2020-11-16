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
    private ToggleGroup T11;

    @FXML
    private Tab tabReport3;

    @FXML
    private ToggleGroup T111;
    
    @FXML
    private TextField textfieldendingingYearR3;
    
    @FXML
    private TextField textfieldstartingYearR3;

    @FXML
    private Tab tabApp1;

    @FXML
    private Tab tabApp2;

    @FXML
    private Tab tabApp3;

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

        int N = Integer.parseInt(textfieldR1TopN.getText());
        RadioButton rb1 = (RadioButton)(T1.getSelectedToggle());
        String gender = rb1.getText();
        // String gender = "Male";
        gender = gender.substring(0,1);
        int first_year = Integer.parseInt(textfieldR1FirstYear.getText());
        int last_year = Integer.parseInt(textfieldR1LastYear.getText());

        // create profiles
        /*
        Profile[][] people = new Profile[last_year - first_year + 1][N];
        for (int i = first_year; i <= last_year; ++i) {
            for (int j = 0; j < N; ++j) {
                people[i - first_year][N] = new Profile(i, j + 1, gender);
            }
        }
        */

        // store into string
        String s = Integer.toString(N);
        s += gender;
        s += Integer.toString(first_year);
        s += Integer.toString(last_year);

        textAreaConsole.setText(s);
    }


    /**
     * Task 2: Popularity of Name
     * To be triggered by the "REPORT" button on the "Reporting 2" Tab
     *
     */
    @FXML
    void reporting2() {
        textAreaConsole.setText("Task 2 not yet ready ah");
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
        int starting_year = Integer.parseInt(textfieldstartingYearR3.getText());
        int ending_year = Integer.parseInt(textfieldendingingYearR3.getText());
    	
        // Boundary Case
    	if (starting_year < 1880 || ending_year > 2019 || starting_year >= ending_year)
		{
			textAreaConsole.setText("Invalid Input.");
			return;
		}
    	
    	// Initialize persons HashMap && names_appeared List
    	Map<String, Integer> lowest_rank_persons = new HashMap<String, Integer>();
    	Map<String, Integer> largest_rank_persons = new HashMap<String, Integer>();
    	Map<String, Integer> lowest_year_persons = new HashMap<String, Integer>();
    	Map<String, Integer> largest_year_persons = new HashMap<String, Integer>();
    	List<String> names_appeared = new ArrayList<String>();
    	for (int i = starting_year; i <= ending_year; i++)
    	{
    		int rank = 1;
    		for (CSVRecord rec : AnalyzeNames.getFileParser(i))
    		{
    			if (rec.get(1).equals(gender))
    			{
    				if (!names_appeared.contains(rec.get(0)))
    				{
    					lowest_rank_persons.put(rec.get(0), rank);
    					lowest_year_persons.put(rec.get(0), i);
    					largest_rank_persons.put(rec.get(0), rank);
    					largest_year_persons.put(rec.get(0), i);
    					names_appeared.add(rec.get(0));
    				}
    				else
    				{
    					if (rank < lowest_rank_persons.get(rec.get(0)))
    					{
    						lowest_rank_persons.put(rec.get(0), rank);
    						lowest_year_persons.put(rec.get(0), i);
    					}
    					else if (rank > largest_rank_persons.get(rec.get(0)))
    					{
        					largest_rank_persons.put(rec.get(0), rank);
        					largest_year_persons.put(rec.get(0), i);
    					}
    				}
    				rank++;
    			}
    		}
    	}
    	
    	String name_rise = "";
    	String name_fall = "";
    	int largest_rise = 1;
    	int largest_fall = -1;
    	int rank_rise1 = -1, rank_rise2 = -1, rank_fall1 = -1, rank_fall2 = -1;
    	
    	
    	for (String names : names_appeared)
    	{
    		int rank1, rank2, diff;
    		if (lowest_year_persons.get(names) < largest_year_persons.get(names))
    		{
    			rank1 = lowest_rank_persons.get(names);
    			rank2 = largest_rank_persons.get(names);
    			diff = rank2 - rank1;
    			if (diff > largest_fall)
    		}
    	}
    	
//    	for (CSVRecord rec : AnalyzeNames.getFileParser(starting_year))
//    	{
//    		if (rec.get(1).equals(gender))
//    		{
//    			String name = rec.get(0);
//    			lowest_persons.put(name, starting_year_rank);
//    			names_appeared.add(name);
//    			starting_year_rank++;
//    		}
//    	}
//    	for (CSVRecord rec : AnalyzeNames.getFileParser(ending_year))
//    	{
//    		if (rec.get(1).equals(gender))
//    		{
//    			String name = rec.get(0);
//    			largest_persons.put(name, ending_year_rank);
//    			if (!names_appeared.contains(name))
//    				names_appeared.add(name);
//    			ending_year_rank++;
//    		}
//    	}
//    	
//    	// note: need to think about special case where no rise
//    	// Identifying the names with largest rise/fall
//		int largest_rise = -1;
//		int largest_fall = 1;
//		String name_rise = "";
//		String name_fall = "";
//		int rank_rise1 = -1, rank_rise2 = -1, rank_fall1 = -1, rank_fall2 = -1;
//		int rank1, rank2;
//    	for (String name : names_appeared)
//    	{
//    		rank1 = lowest_persons.containsKey(name) ? lowest_persons.get(name) : starting_year_rank;
//    		rank2 = largest_persons.containsKey(name) ? largest_persons.get(name) : ending_year_rank;
//    		int diff = rank1 - rank2;
//    		if (diff > largest_rise)
//    		{
//    			largest_rise = diff;
//    			name_rise = name;
//    			rank_rise1 = rank1;
//    			rank_rise2 = rank2;
//    		}
//    		else if (diff < largest_fall)
//    		{
//    			largest_fall = diff;
//    			name_fall = name;
//    			rank_fall1 = rank1;
//    			rank_fall2 = rank2;
//    		}
//    	}
//    	
//    	// Printing Output
//    	String year_rise1 = Integer.toString(starting_year);
//    	String year_rise2 = Integer.toString(ending_year);
//    	String year_fall1 = Integer.toString(starting_year);
//    	String year_fall2 = Integer.toString(ending_year);
        
        String s = name_rise + " is found to have shown the largest rise in popularity from rank " + rank_rise1;
        s += " in year " + year_rise1 + " to rank " + rank_rise2;
        s += " in year " + year_rise2 + ".\nOn the other hand,\n";
        s += name_fall  + " is found to have shown the largest fall in popularity from rank " + rank_fall1;
        s += " in year " + year_fall1 + " to rank " + rank_fall2;
        s += " in year " + year_fall2 + ".";

    	textAreaConsole.setText(s);
    }

    /**
     * Task 4: Recommendation on Names for Newborn Babies
     * To be triggered by the "OUTPUT" button on the "Application 1" Tab
     *
     */
    @FXML
    void application1() {
        textAreaConsole.setText("Task 4 not yet ready ah");
    }

    /**
     * Task 5: Prediction on Names for Compatible Pairs
     * To be triggered by the "OUTPUT" button on the "Application 2" Tab
     *
     */
    @FXML
    void application2() {
        textAreaConsole.setText("Task 5 not yet ready ah");
    }

    /**
     * Task 6: Prediction on Scores for Compatible Pairs
     * To be triggered by the "OUTPUT" button on the "Application 3" Tab
     *
     */
    @FXML
    void application3() {
        textAreaConsole.setText("Task 6 not yet ready ah");
    }


}

