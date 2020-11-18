package comp3111.popnames;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProfile {
	
	@Test
	public void testA()
	{
		Profile a = new Profile(2008, "F", "Oaklynn");
		assertTrue(a.getRank() == 19673);
	}
	
	@Test
	public void testB()
	{
		Profile a = new Profile(1950, "F", "Velma");
		assertTrue(a.getRank() == 267);
	}
	
	@Test
	public void testC()
	{
		Profile a = new Profile(2006, "F", "Jaslene");
		assertTrue(a.getRank() == 18340);
	}
	
	@Test
	public void testD()
	{
		Profile a = new Profile(2005, "F", "Jenascia");
		assertTrue(a.getRank() == 17595);
	}
	
	@Test
	public void testE()
	{
		Profile a = new Profile(2001, "F", "Lashanti");
		assertTrue(a.getRank() == 16788);
	}
	
	@Test
	public void testF()
	{
		Profile a = new Profile(2002, "F", "Lashanti");
		assertTrue(a.getRank() == 1703);
	}
}
