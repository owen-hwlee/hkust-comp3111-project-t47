/**
 * Building on the sample skeleton for 'ui.fxml' Controller Class generated by SceneBuilder
 */
package comp3111.popnames;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private RadioButton toggleButtonMR3;
    
    @FXML
    private RadioButton toggleButtonFR3;
    
    @FXML
    private TextField textfieldendingingYearR3;
    
    @FXML
    private TextField textfieldstartingYearR3;

    @FXML
    private ToggleGroup T111;

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
        textAreaConsole.setText("Task 3 not yet ready ah");
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

