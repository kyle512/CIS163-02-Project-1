package project1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestGeoCountDownTimer {

    /**
     * The following are simple JUnit test cases... After talking with your instructor, create
     * many, many more that shows that your code is functioning correctly.
     */

    @Test
    public void testDefaultConstructor(){
        GeoCountDownTimer s = new GeoCountDownTimer();
        assertEquals(s.toDateString(), "1/1/2022");
    }

    @Test
    public void testConstructorOther(){
        GeoCountDownTimer other = new GeoCountDownTimer(2121, 5, 5);
        GeoCountDownTimer s = new GeoCountDownTimer(other);
        assertEquals(s.toDateString(), "5/5/2121");
    }

    @Test
    public void testConstructorDates() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 10);
        assertEquals(s.toDateString(), "5/10/2121");

        s = new GeoCountDownTimer(2121, 1, 11);
        assertEquals(s.toDateString(), "1/11/2121");

        s = new GeoCountDownTimer(10000, 12, 31);
        assertEquals(s.toDateString(), "12/31/10000");
    }

    @Test
    public void testConstructorDatesLeapYear(){
        GeoCountDownTimer s = new GeoCountDownTimer(2024, 2, 29);
        assertEquals(s.toDateString(), "2/29/2024");

        s = new GeoCountDownTimer(2028, 2, 29);
        assertEquals(s.toDateString(), "2/29/2028");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidDate() {
        GeoCountDownTimer s = new GeoCountDownTimer(2, -3, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidDay1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 32);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidDay2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 4, 31);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidDay3() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 4, -8);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidDay4(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 2, 29);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidDay5(){
        GeoCountDownTimer s = new GeoCountDownTimer(2024, 2, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidMonth1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 13, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidMonth2(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 0, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidMonth3(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, -5, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidYear1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2021, 2, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidYear2(){
        GeoCountDownTimer s = new GeoCountDownTimer(-20, 2, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDatesInvalidYear3(){
        GeoCountDownTimer s = new GeoCountDownTimer(50, 2, 2);
    }

    @Test
    public void testConstructorGeoDate() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2121");
        assertTrue(s.toDateString().equals("5/10/2121"));

        s = new GeoCountDownTimer("1/31/2121");
        assertEquals(s.toDateString(), "1/31/2121");

        s = new GeoCountDownTimer("4/30/10000");
        assertEquals(s.toDateString(), "4/30/10000");
    }

    @Test
    public void testConstructorGeoDateLeapYear(){
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2024");
        assertEquals(s.toDateString(), "2/29/2024");

        s = new GeoCountDownTimer("2/29/2028");
        assertEquals(s.toDateString(), "2/29/2028");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateNull() {
        GeoCountDownTimer s = new GeoCountDownTimer((GeoCountDownTimer) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidDate(){
        GeoCountDownTimer s = new GeoCountDownTimer("2/-3/-3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidString() {
        GeoCountDownTimer s = new GeoCountDownTimer("-4 2/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInavlidString(){GeoCountDownTimer s = new GeoCountDownTimer("Hello");}

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidDay1(){
        GeoCountDownTimer s = new GeoCountDownTimer("5/32/2121");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidDay2() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/-5/2121");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidDay3() {
        GeoCountDownTimer s = new GeoCountDownTimer("4/31/2121");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidDay4() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2121");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidMonth1() {
        GeoCountDownTimer s = new GeoCountDownTimer("13/2/2021");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidMonth2() {
        GeoCountDownTimer s = new GeoCountDownTimer("0/2/2021");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidMonth3() {
        GeoCountDownTimer s = new GeoCountDownTimer("-4/2/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidYear1() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/2/2021");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidYear2() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/2/-50");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGeoDateInvalidYear3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/2/20");
    }


    @Test
    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 10);
        s1.inc(365);
        assertTrue(s1.toDateString().equals("5/10/2122"));

        s1.dec(365);
        assertTrue(s1.toDateString().equals("5/10/2121"));

        s1 = new GeoCountDownTimer(2120, 1, 10);

        for (int i = 0; i < 366; i++)
            s1.inc();
        assertTrue(s1.toDateString().equals("1/10/2121"));

        s1 = new GeoCountDownTimer(2022, 5, 10);

        for (int i = 0; i < 31665; i++)
            s1.inc();

        for (int i = 0; i < 31665; i++)
            s1.dec();

        assertTrue(s1.toDateString().equals("5/10/2022"));

    }

    @Test
    public void testEqual() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 5);
        GeoCountDownTimer s4 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s6 = new GeoCountDownTimer(3000, 6, 9);
        GeoCountDownTimer s7 = new GeoCountDownTimer(3001, 6, 9);

        assertEquals(s4, s5);
        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s4));
        assertFalse(s5.equals(s6));
        assertFalse(s6.equals(s7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualNull(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 4);
        assertTrue(s1.equals(null));
    }


    @Test
    public void testCompareTo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 8);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(2122, 5, 9);

        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertTrue(s1.compareTo(s4) == 0);
        assertTrue(s1.compareTo(s2) < 0);
        assertTrue(s5.compareTo(s4) > 0);
        assertTrue(s4.compareTo(s5) < 0);
        assertTrue(s1.compareTo(s3) > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNull(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer((GeoCountDownTimer) null);
    }

    @Test
    public void testDecWithParam(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 5);
        s.dec(4);
        assertEquals(s.toDateString(), "5/1/2121");

        s.dec(10);
        assertEquals(s.toDateString(), "4/21/2121");

        s.dec(365);
        assertEquals(s.toDateString(), "4/21/2120");

        s.dec(1);
        assertEquals(s.toDateString(), "4/20/2120");

        s.dec(20);
        assertEquals(s.toDateString(), "3/31/2120");

        s = new GeoCountDownTimer(2024, 3, 5);
        s.dec(5);
        assertEquals(s.toDateString(), "2/29/2024");

        s = new GeoCountDownTimer(2023, 3,5);
        s.dec(5);
        assertEquals(s.toDateString(), "2/28/2023");

        s= new GeoCountDownTimer(2121, 1, 5);
        s.dec(5);
        assertEquals(s.toDateString(), "12/31/2120");

        s= new GeoCountDownTimer(2121, 5, 5);
        s.dec(5);
        assertNotEquals(s.toDateString(), "4/31/2121");

        s= new GeoCountDownTimer(2121, 4, 5);
        s.dec(5);
        assertNotEquals(s.toDateString(), "4/30/2121");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecWithParamInvalidDay1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 1, 5);
        s.dec(20);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDecWithParamInvalidDay2(){
        GeoCountDownTimer s = new GeoCountDownTimer(2024, 1, 5);
        s.dec(-5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDecWithParamInvalidDay3(){
        GeoCountDownTimer s = new GeoCountDownTimer(2021, 1, 5);
    }

    @Test
    public void testDec(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 1, 5);
        s.dec();
        assertEquals(s.toDateString(),  "1/4/2121");

        s = new GeoCountDownTimer(2121, 1, 1);
        s.dec();
        assertEquals(s.toDateString(), "12/31/2120");

        s = new GeoCountDownTimer(2024, 3, 1);
        s.dec();
        assertEquals(s.toDateString(), "2/29/2024");

        s = new GeoCountDownTimer(2023, 3, 1);
        s.dec();
        assertEquals(s.toDateString(), "2/28/2023");

        s = new GeoCountDownTimer(2121, 4, 1);
        s.dec();
        assertEquals(s.toDateString(), "3/31/2121");

        s = new GeoCountDownTimer(2121, 5, 1);
        s.dec();
        assertEquals(s.toDateString(), "4/30/2121");

        s = new GeoCountDownTimer(2121, 5, 1);
        s.dec();
        assertNotEquals( s.toDateString(),"4/31/2121");

        s = new GeoCountDownTimer(2121, 4, 1);
        s.dec();
        assertNotEquals( s.toDateString(),"3/30/2121");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecError1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 1, 1);
        s.dec();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDecError2(){
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 5);
        for(int i = 0; i <= 365; i++){
            s.dec();
        }
    }

    @Test
    public void testIncWithParam(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 5);
        s.inc(5);
        assertEquals(s.toDateString(), "5/10/2121");

        s.inc(22);
        assertEquals(s.toDateString(), "6/1/2121");

        s.inc(30);
        assertEquals(s.toDateString(), "7/1/2121");

        s = new GeoCountDownTimer(2121, 12, 30);
        s.inc(2);
        assertEquals(s.toDateString(), "1/1/2122");

        s = new GeoCountDownTimer(2024, 2, 26);
        s.inc(3);
        assertEquals(s.toDateString(), "2/29/2024");

        s = new GeoCountDownTimer(2025, 2, 26);
        s.inc(3);
        assertEquals(s.toDateString(), "3/1/2025");

        s = new GeoCountDownTimer(2025, 2, 26);
        s.inc(2);
        assertEquals(s.toDateString(), "2/28/2025");

        s = new GeoCountDownTimer(2024, 2, 26);
        s.inc(4);
        assertEquals(s.toDateString(), "3/1/2024");

        s = new GeoCountDownTimer(2121, 4, 30);
        s.inc();
        assertNotEquals(s.toDateString(),"4/31/2121");

        s = new GeoCountDownTimer(2121, 5, 30);
        s.inc();
        assertNotEquals(s.toDateString(),"6/1/2121");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncWithParamError1(){
        GeoCountDownTimer s= new GeoCountDownTimer(2121, 5, 5);
        s.inc(-3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIncWithParamError3(){
        GeoCountDownTimer s= new GeoCountDownTimer(2121, 13, 5);
    }

    @Test
    public void testInc(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 5);
        s.inc();
        assertEquals(s.toDateString(), "5/6/2121");

        s = new GeoCountDownTimer(2121, 5, 31);
        s.inc();
        assertEquals(s.toDateString(), "6/1/2121");

        s = new GeoCountDownTimer(2121, 5, 30);
        s.inc();
        assertEquals(s.toDateString(), "5/31/2121");

        s = new GeoCountDownTimer(2121, 4, 30);
        s.inc();
        assertEquals(s.toDateString(), "5/1/2121");

        s = new GeoCountDownTimer(2121, 12, 31);
        s.inc();
        assertEquals(s.toDateString(), "1/1/2122");

        s = new GeoCountDownTimer(2024, 2, 28);
        s.inc();
        assertEquals(s.toDateString(), "2/29/2024");

        s = new GeoCountDownTimer(2025, 2, 28);
        s.inc();
        assertEquals(s.toDateString(), "3/1/2025");

        s = new GeoCountDownTimer(2024, 2, 29);
        s.inc();
        assertEquals(s.toDateString(), "3/1/2024");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncError(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 13, -2);
    }

    @Test
    public void testToString(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 5);
        assertEquals(s.toString(), "May 5,2121");

        s = new GeoCountDownTimer(2022, 1, 25);
        assertEquals(s.toString(), "January 25,2022");
    }

    @Test
    public void testToDateString(){
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 5);
        assertEquals(s.toDateString(), "5/5/2121");

        s = new GeoCountDownTimer(2022, 1, 25);
        assertEquals(s.toDateString(), "1/25/2022");
    }



//    @Test
//    public void testLoadSave() {
//        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
//        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 9, 1);
//
//        s1.save("file1");
//        s1 = new GeoCountDownTimer(2111, 1, 1);  // resets to zero
//        s1.load("file1");
//        assertTrue(s2.equals(s1));
//
//    }
//
//    @Test
//    public void testDaysToGo() {
//        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 2, 9);
//        assertTrue(s1.daysToGo("2/1/2121") == 8);
//        assertTrue(s1.daysToGo("2/8/2121") == 1);
//        assertTrue(s1.daysToGo("2/9/2121") == 0);
//
//    }
//
//    @Test
//    public void testDaysInFuture () {
//        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 12,9);
//        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 12,19);
//
//        assertTrue (s1.daysInFuture(10).equals(s2));
//
//    }


}
