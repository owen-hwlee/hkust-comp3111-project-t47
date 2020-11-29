package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzeNamesTest {
	
    @Test 
    public void testGetRankNotFound() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "XXX", "M");
		assertEquals(i, -1);
    }
    
    @Test 
    public void testGetRankMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGetRankFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    	
    @Test 
    public void testGetNameMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 27, "M");
    	assertTrue(name.equals("David"));
    }
    
    @Test 
    public void testGetNameFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 2192, "F");
    	assertTrue(name.equals("Desire"));
    }

    @Test
    public void testGetFreqName() {
        AnalyzeNames a = new AnalyzeNames();
        int freq = a.getFreq(1941, "Mary", "F");
        assertTrue(freq==58031);
    }

    @Test
    public void testGetFreqRank() {
    	AnalyzeNames a = new AnalyzeNames();
    	int rank = a.getRank(1999, "Ryan", "M");
    	assertTrue(rank==12);
    }

    @Test
    public void testNK_T4() {
        AnalyzeNames a = new AnalyzeNames();
        String[] names1 = a.NK_T4("Kevin", "Carmen", 2000, 2000, 2019);
        assertTrue(names1[0].equals("Luke"));        // tests boy baby name
        assertTrue(names1[1].equals("Camilla"));     // tests girl baby name
        String[] names2 = a.NK_T4("ToYik", "Yammy", 1998, 1996, 2017);
        assertTrue(names2[0].equals("Liam"));
        assertTrue(names2[1].equals("Emma"));
    }

    @Test
    public void testNK_T5() {
    	AnalyzeNames a = new AnalyzeNames();
    	String names = a.NK_T5("Ryan", "M", 1999, "M", "Younger");
    	assertTrue(names.equals("Brandon"));
    }

    @Test
    public void testNK_T6() {
        AnalyzeNames a = new AnalyzeNames();
        int score = a.NK_T6("Herman", "M", 2000, "Mary", "F", "Younger");
        assertTrue(score == 4);
    }

    @Test
    public void testGetTotalByGender() {
    	AnalyzeNames a = new AnalyzeNames();
    	int rankk = a.getTotalByGender(1999, "M");
    	assertTrue(rankk == 1918809);
    }

    @Test
    public void testReturnYear() {
        String yob = "1984";
        int year = 1984;
        int output = AnalyzeNames.returnYear(yob);
        assertEquals(output, year);

        yob = "1800";
        year = 0;
        output = AnalyzeNames.returnYear(yob);
        assertEquals(output, year);

        yob = "jf24";
        year = -1;
        output = AnalyzeNames.returnYear(yob);
        assertEquals(output, year);

        yob = "";
        year = -2;
        output = AnalyzeNames.returnYear(yob);
        assertEquals(output, year);
    }

    @Test
    public void testReturnNumber() {
        String n = "5";
        int number = 5;
        int output = AnalyzeNames.returnNumber(n);
        assertEquals(output, number);

        n = "-7";
        number = 0;
        output = AnalyzeNames.returnNumber(n);
        assertEquals(output, number);

        n = "jf24";
        number = -1;
        output = AnalyzeNames.returnNumber(n);
        assertEquals(output, number);

        n = "";
        number = -2;
        output = AnalyzeNames.returnNumber(n);
        assertEquals(output, number);
    }

}
