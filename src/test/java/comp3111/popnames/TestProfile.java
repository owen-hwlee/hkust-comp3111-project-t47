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
}
