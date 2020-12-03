package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
//import org.w3c.dom.Text;

public class JavaFXTest extends ApplicationTest {

	private Scene s;
	private TextArea t;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Popular Names");
   		stage.show();
   		s = scene;
		t = (TextArea)s.lookup("#textAreaConsole");
	}

    
	@Test
	public void testButtonRankTrue() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankM");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	
	@Test
	public void testButtonRankFalse() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankF");
		//sleep(1000);
		String s2 = t.getText();
		assertFalse(s1.equals(s2));
	}
	
	
	@Test
	public void testTextAreaConsole() {	
		t.setText("David");
		String s = t.getText();
		assertTrue(s.equals("David"));
	}

	@Test
	public void testButtonR1() {
		clickOn("#tabReport1");
		// default value
		clickOn("#buttonR1");
		String s1 = t.getText();
		String s2 = "Over the period 1941 to 1945, James for males has hold the top spot most often for a total of 5 times.\n" +
				"\n" +
				"Detailed results: (in table form)\n" +
				"Year | Top 1      | Top 2      | Top 3      | Top 4      | Top 5      | Top 6      | Top 7      | Top 8      | Top 9      | Top 10     \n" +
				"-----+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------\n" +
				"1941 | James      | Robert     | John       | William    | Richard    | Charles    | David      | Thomas     | Ronald     | Donald     \n" +
				"-----+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------\n" +
				"1942 | James      | Robert     | John       | William    | Richard    | David      | Charles    | Thomas     | Ronald     | Donald     \n" +
				"-----+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------\n" +
				"1943 | James      | Robert     | John       | William    | Richard    | David      | Charles    | Thomas     | Ronald     | Michael    \n" +
				"-----+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------\n" +
				"1944 | James      | Robert     | John       | William    | Richard    | David      | Charles    | Thomas     | Michael    | Ronald     \n" +
				"-----+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------\n" +
				"1945 | James      | Robert     | John       | William    | Richard    | David      | Charles    | Thomas     | Michael    | Ronald     ";
		assertTrue(s1.equals(s2));

		// check different values

		/*
		 * t = (TextArea)s.lookup("#textAreaConsole");
		 */

		// Case: Top N = 0
		TextField tf = (TextField)s.lookup("#textfieldR1n");
		tf.setText("0");
		clickOn("#buttonR1");
		s1 = t.getText();
		s2 = "Invalid input range! Please enter a valid positive integer for N (N >= 1).";
		assertTrue(s1.equals(s2));

		// Case: y1 is empty
		tf.setText("5");
		tf = (TextField)s.lookup("#textfieldR1y1");
		tf.setText("");
		clickOn("#buttonR1");
		s1 = t.getText();
		s2 = "Empty input! Please enter a valid positive integer for first year (1880 - 2019).";
		assertTrue(s1.equals(s2));

		// Case: y1 is out of range
		tf.setText("2020");
		clickOn("#buttonR1");
		s1 = t.getText();
		s2 = "Invalid input range! Please enter a valid year for first year (1880 - 2019).";
		assertTrue(s1.equals(s2));

		// Case: y1 > y2
		tf.setText("1950");
		clickOn("#buttonR1");
		s1 = t.getText();
		s2 = "First year should be strictly smaller than last year!";
		assertTrue(s1.equals(s2));
		
	}

	@Test
	public void testButtonR2() {
		
		clickOn("#tabReport2");
		// default value
		
		clickOn("#buttonR2");
		
		String s1 = t.getText();

//
		String s2 = "The popularity of Ryan over the period 1999 to 2000.\n" +
				"\n" +
				"Detailed results: (in table form)\n" +
				"Year | Rank       | Count      | Percentage \n" +
				"-----+------------+------------+------------\n" +
				"1999 | 12         | 21008      | 1.09%      \n" +
				"-----+------------+------------+------------\n" +
				"2000 | 13         | 20263      | 1.03%      " ;
//				
		assertTrue(s1.equals(s2));

//		// check different values
//
//		/*
//		 * t = (TextArea)s.lookup("#textAreaConsole");
//		 */
//
		// Case: Empty name
		TextField tf = (TextField)s.lookup("#textfieldR2Name");
		tf.setText("");
		clickOn("#buttonR2");
		s1 = t.getText();
		s2 = "Please input a name";
		assertTrue(s1.equals(s2));

		// Case: y1 is empty
		tf.setText("5");
		tf = (TextField)s.lookup("#textfieldR2FirstYear");
		tf.setText("");
		clickOn("#buttonR2");
		s1 = t.getText();
		s2 = "Please input the year";
		assertTrue(s1.equals(s2));

		// Case: y1 is out of range
		tf.setText("2020");
		clickOn("#buttonR2");
		s1 = t.getText();
		s2 = "Please input year within the range";
		assertTrue(s1.equals(s2));

		// Case: y1 > y2
		tf.setText("2015");
		clickOn("#buttonR2");
		s1 = t.getText();
		s2 = "first year should be strictly smaller than last year";
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testButtonR3() {
		clickOn("#tabReport3");
		// default value
		clickOn("#buttonR3");
		String s1 = t.getText();
		String s2 = "5 names are found to be maintained at a high level of popularity within Top 5 over the period from year 1941 to year 1945.\n"
				+ "\n" +
				"Detailed results: (in table form)\n" +
				"-------------------------------------------------------------------------------------\n" +
				"| Name           | Lowest Rank  [in year] | Highest Rank [in year] | Trend          |\n" +
				"|----------------+------------------------+------------------------+----------------|\n" +
				"| James          | 1            [in 1941] | 1            [in 1941] | FLAT           |\n" +
				"|----------------+------------------------+------------------------+----------------|\n" +
				"| Robert         | 2            [in 1941] | 2            [in 1941] | FLAT           |\n" +
				"|----------------+------------------------+------------------------+----------------|\n" +
				"| John           | 3            [in 1941] | 3            [in 1941] | FLAT           |\n" +
				"|----------------+------------------------+------------------------+----------------|\n" +
				"| William        | 4            [in 1941] | 4            [in 1941] | FLAT           |\n" +
				"|----------------+------------------------+------------------------+----------------|\n" +
				"| Richard        | 5            [in 1941] | 5            [in 1941] | FLAT           |\n" +
				"|----------------+------------------------+------------------------+----------------|\n" +
				"End of results\n";
		assertTrue(s1.equals(s2));
		TextField taa = (TextField)s.lookup("#y1R3");
		taa.setText("1990");
		taa = (TextField)s.lookup("#y2R3");
		taa.setText("2017");
		taa = (TextField)s.lookup("#R3_n");
		taa.setText("100");
		clickOn("#buttonR3");
		s1 = t.getText();
		s2 = "38 names are found to be maintained at a high level of popularity within Top 100 over the period from year 1990 to year 2017.\n"
				+ "\n"
				+ "Detailed results: (in table form)\n"
				+ "-------------------------------------------------------------------------------------\n"
				+ "| Name           | Lowest Rank  [in year] | Highest Rank [in year] | Trend          |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Michael        | 12           [in 2017] | 1            [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Christopher    | 39           [in 2017] | 2            [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Matthew        | 16           [in 2010] | 2            [in 1995] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Joshua         | 38           [in 2017] | 3            [in 2002] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Daniel         | 15           [in 2017] | 5            [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| David          | 22           [in 2017] | 6            [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Andrew         | 40           [in 2017] | 5            [in 1991] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| James          | 19           [in 1999] | 4            [in 2017] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Joseph         | 22           [in 2011] | 7            [in 2002] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Ryan           | 44           [in 2017] | 11           [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| John           | 28           [in 2012] | 10           [in 1991] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Robert         | 65           [in 2017] | 13           [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Nicholas       | 68           [in 2017] | 5            [in 1999] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Anthony        | 33           [in 2017] | 7            [in 2007] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| William        | 20           [in 1992] | 3            [in 2011] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Jonathan       | 56           [in 2016] | 17           [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Jacob          | 20           [in 1990] | 1            [in 1999] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Thomas         | 63           [in 2011] | 26           [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Alexander      | 28           [in 1990] | 4            [in 2009] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Jordan         | 73           [in 2017] | 26           [in 1997] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Adam           | 82           [in 2012] | 32           [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Benjamin       | 33           [in 1990] | 6            [in 2016] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Aaron          | 57           [in 2005] | 28           [in 1994] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Charles        | 63           [in 2008] | 38           [in 1990] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Jose           | 81           [in 2017] | 28           [in 2004] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Nathan         | 45           [in 2017] | 20           [in 2004] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Samuel         | 45           [in 1990] | 21           [in 2005] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Jason          | 92           [in 2017] | 39           [in 2000] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Austin         | 75           [in 2017] | 9            [in 1996] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Ethan          | 92           [in 1993] | 2            [in 2009] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Christian      | 60           [in 1990] | 21           [in 2006] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Cameron        | 62           [in 1990] | 31           [in 2000] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Ian            | 80           [in 2006] | 65           [in 2003] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Evan           | 85           [in 2017] | 35           [in 2009] | DOWN           |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Dylan          | 83           [in 1990] | 19           [in 2003] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Caleb          | 88           [in 1990] | 31           [in 2009] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Adrian         | 99           [in 1993] | 56           [in 2008] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "| Gabriel        | 100          [in 1990] | 21           [in 2010] | UP             |\n"
				+ "|----------------+------------------------+------------------------+----------------|\n"
				+ "End of results\n";
		assertTrue(s1.equals(s2));

		// check different values

		/*
		 * t = (TextArea)s.lookup("#textAreaConsole");
		 */

		// Case: startingYear out of range
		TextField tf = (TextField)s.lookup("#y1R3");
		tf.setText("0");
		clickOn("#buttonR3");
		s1 = t.getText();
		s2 = "Invalid Input: YEAR out of range. Please input year between 1880 and 2019.";
		assertTrue(s1.equals(s2));

		// Case: endingYear is empty
		tf.setText("1941");
		tf = (TextField)s.lookup("#y2R3");
		tf.setText("");
		clickOn("#buttonR3");
		s1 = t.getText();
		s2 = "Invalid Input: YEAR empty. Please input year.";
		assertTrue(s1.equals(s2));

		// Case: y1 > y2
		tf.setText("1930");
		clickOn("#buttonR3");
		s1 = t.getText();
		s2 = "Invalid Input: Period. Please ensure StartingYear < EndingYear.";
		assertTrue(s1.equals(s2));

		// Case: n < 1
		tf.setText("1945");
		tf = (TextField)s.lookup("#R3_n");
		tf.setText("0");
		clickOn("#buttonR3");
		s1 = t.getText();
		s2 = "Invalid input: N out of range. Please input N >= 1";
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testButtonA1() {
		clickOn("#tabApp1");
		clickOn("#buttonA1");
		String s1 = t.getText();
		String s2 = "Recommended male name: Benjamin\n" +
				"Recommended female name: Olivia";
		assertTrue(s1.equals(s2));

		// check other cases

		// Case: different vintage years
		TextField tf = (TextField)s.lookup("#textfieldA1vintageYear");
		tf.setText("2000");
		clickOn("#buttonA1");
		s1 = t.getText();
		s2 = "Recommended male name: Andrew\n" +
				"Recommended female name: Emily";
		assertTrue(s1.equals(s2));

		// Case: empty dad name
		tf = (TextField)s.lookup("#textfieldA1dadName");
		tf.setText("");
		clickOn("#buttonA1");
		s1 = t.getText();
		s2 = "Empty input! Please enter name of dad.";
		assertTrue(s1.equals(s2));

		// Case: empty mom name
		tf.setText("David");
		tf = (TextField)s.lookup("#textfieldA1momName");
		tf.setText("");
		clickOn("#buttonA1");
		s1 = t.getText();
		s2 = "Empty input! Please enter name of mom.";
		assertTrue(s1.equals(s2));

		// Case: empty dad year of birth
		tf.setText("Desire");
		tf = (TextField)s.lookup("#textfieldA1dadYOB");
		tf.setText("");
		clickOn("#buttonA1");
		s1 = t.getText();
		s2 = "Empty input! Please enter a valid year for year of birth of dad (1880 - 2019).";
		assertTrue(s1.equals(s2));

		// Case: invalid mom year of birth
		tf.setText("1941");
		tf = (TextField)s.lookup("#textfieldA1momYOB");
		tf.setText("nineteen");
		clickOn("#buttonA1");
		s1 = t.getText();
		s2 = "Invalid input! Please enter a valid year for year of birth of mom (1880 - 2019).";
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testButtonA2() {
		clickOn("#tabApp2");
		
		clickOn("#buttonA2");
		String s1 = t.getText();
		String s2 = "The soulmate name will be Brandon";
		assertTrue(s1.equals(s2));
//

//		// check other cases
//
		// Case: empty user name
		TextField tf = (TextField)s.lookup("#textfieldA2iName");
		tf.setText("");
		clickOn("#buttonA2");
		s1 = t.getText();
		s2 = "Please input your name";
		assertTrue(s1.equals(s2));

		// Case: empty iYOB
		tf.setText("Ryan");
		tf = (TextField)s.lookup("#textfieldA2iYOB");
		tf.setText("");
		clickOn("#buttonA2");
		s1 = t.getText();
		s2 = "Please input your year of birth";
		assertTrue(s1.equals(s2));

		// Case: iYOB out of range
		tf.setText("2222");
		clickOn("#buttonA2");
		s1 = t.getText();
		s2 = "Can only calculate year of birth from 1881 to 2018";
		assertTrue(s1.equals(s2));
		
		// Case: invalid iYOB
			tf.setText("twenty");
			clickOn("#buttonA2");
			s1 = t.getText();
			s2 = "Invalid Year. Please input year between 1880 and 2019.";
			assertTrue(s1.equals(s2));
	}
		
	

	@Test
	public void testButtonA3() {
		clickOn("#tabApp3");
		clickOn("#buttonA3");
		String s1 = t.getText();
		String s2 = "Score of Compatibility = 4%";
		assertTrue(s1.equals(s2));

		// check other cases

		// Case: empty user name
		TextField tf = (TextField)s.lookup("#textfieldA3iName");
		tf.setText("");
		clickOn("#buttonA3");
		s1 = t.getText();
		s2 = "Invalid Input. Please input Your Name.";
		assertTrue(s1.equals(s2));

		// Case: empty soulmate's name
		tf.setText("Herman");
		tf = (TextField)s.lookup("#textfieldA3iNameMate");
		tf.setText("");
		clickOn("#buttonA3");
		s1 = t.getText();
		s2 = "Invalid Input. Please input Soulmate's Name.";
		assertTrue(s1.equals(s2));

		// Case: empty iYOB
		tf.setText("Mary");
		tf = (TextField)s.lookup("#textfieldA3iYOB");
		tf.setText("");
		clickOn("#buttonA3");
		s1 = t.getText();
		s2 = "Invalid Input: YEAR empty. Please input year.";
		assertTrue(s1.equals(s2));

		// Case: invalid iYOB
		tf.setText("twenty");
		clickOn("#buttonA3");
		s1 = t.getText();
		s2 = "Invalid Input: YEAR. Please input year between 1880 and 2019.";
		assertTrue(s1.equals(s2));
	}

}
