package comp3111.popnames;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProfile {
	
	@Test
	public void testgetRankM1941()
	{
		Profile a = new Profile(1941, "M", "Macarthur");
		assertTrue(a.getRank() == 3816);
	}
	
	@Test
	public void testgetRankM1945()
	{
		Profile a = new Profile(1941, "M", "Macarthur");
		assertTrue(a.getRank() == 1115);
	}
	
	@Test
	public void testgetRankF1941()
	{
		Profile a = new Profile(1941, "M", "Sally");
		assertTrue(a.getRank() == 1552);
	}
	
	@Test
	public void testgetRankF1945()
	{
		Profile a = new Profile(1941, "M", "Sally");
		assertTrue(a.getRank() == -1);
	}
	
	@Test
	public void testgetFreqWithName()
	{
		Profile a = new Profile(1941, "F", "Dera");
		assertTrue(a.getFreq() == 5);
	}
	
	@Test
	public void testgetFreqWithRank()
	{
		Profile a = new Profile(1880, "F", 2);
		assertTrue(a.getFreq() == 2604);
	}
}
