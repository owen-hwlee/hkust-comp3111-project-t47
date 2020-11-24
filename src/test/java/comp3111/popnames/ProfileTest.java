package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void testProfileGetName(){
        Profile howard = new Profile(2001, "M", 646);
        String s = "Howard";
        assertTrue(s.equals(howard.getName()));
    }

    @Test
    public void testProfileGetGender(){
        Profile marco = new Profile(2000, "M", "Marco");
        String s = "M";
        assertTrue(s.equals(marco.getGender()));
    }

    @Test
    public void testProfileGetYearOfBirth(){
        Profile victor = new Profile(2000, "M", "Victor");
        int y = 2000;
        assertEquals(y, victor.getYearOfBirth());
    }

    @Test
    public void testProfileGetFreq(){
        Profile peter = new Profile(2000, "M", "Peter");
        int f = 3146;
        assertEquals(f, peter.getFreq());
    }

    @Test
    public void testProfileGetRank(){
        Profile francis = new Profile(2000, "M", "Francis");
        int r = 435;
        assertEquals(r, francis.getRank());
    }

}
