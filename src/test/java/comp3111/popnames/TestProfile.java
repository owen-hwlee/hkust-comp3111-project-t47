package comp3111.popnames;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProfile {
	
	@Test
	public void testFreq()
	{
		Profile a = new Profile(1880, "F", "Anna");
		assertTrue(a.getFreq() == 2604);
	}
	
	@Test
	public void testFreqWithRank()
	{
		Profile a = new Profile(1880, "F", 2);
		assertTrue(a.getFreq() == 2604);
	}
}
