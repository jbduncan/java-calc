/**
 * BigFractionTest.java
 */

package kip.junit;

import static org.junit.Assert.*;

import java.math.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kip.util.BigFraction;

import org.junit.Test;


public class BigFractionTest {
  
  @Test
  public void testValueOf() {
    assertEquals("valueOf(1.1)", "2476979795053773/2251799813685248", BigFraction.valueOf(1.1).toString());
    assertEquals("valueOf(-0.0)", "0/1", BigFraction.valueOf(-0.0).toString());
    assertEquals("valueOf(1.1f)", "9227469/8388608", BigFraction.valueOf(1.1f).toString());
    assertEquals("valueOf(\"1.1\")", "11/10", BigFraction.valueOf("1.1").toString());
    assertEquals("valueOf(11,10)", "11/10", BigFraction.valueOf(11,10).toString());
    assertEquals("valueOf(2*5*7, 3*5*11)", "14/33", BigFraction.valueOf(2*5*7,3*5*11).toString());
    assertEquals("valueOf(100,-7)", "-100/7", BigFraction.valueOf(100,-7).toString());
    assertEquals("valueOf(\"-1.0E2/-0.007E3\")", "100/7", BigFraction.valueOf("-1.0E2/-0.007E3").toString());
    assertEquals("valueOf(\"+9.02E-10\")", "451/500000000000", BigFraction.valueOf("+9.02E-10").toString());
    assertEquals("valueOf(\"-0.000000E+500\")", "0/1", BigFraction.valueOf("-0.000000E+500").toString());
    
  }
  
  
  @Test
  public void testAdd() {
    assertEquals("5/1 + -3", "2/1", BigFraction.valueOf(5).add(-3).toString());
    assertEquals("11/17 + 2/3", "67/51", BigFraction.valueOf("11/17").add(BigFraction.valueOf("2/3")).toString());
    assertEquals("1/6 + 1/15", "7/30", BigFraction.valueOf("1/6").add(BigFraction.valueOf("1/15")).toString());
    assertEquals("1/6 + 1/6", "1/3", BigFraction.valueOf("1/6").add(BigFraction.valueOf("1/6")).toString());
    assertEquals("-1/6 + 1/6", "0/1", BigFraction.valueOf("-1/6").add(BigFraction.valueOf("1/6")).toString());
    assertEquals("-1/6 + -1/6", "-1/3", BigFraction.valueOf("-1/6").add(BigFraction.valueOf("-1/6")).toString());
    assertEquals("-1/6 + 1/15", "-1/10", BigFraction.valueOf("-1/6").add(BigFraction.valueOf("1/15")).toString());
  }
  
  @Test
  public void testSubtract() {
    assertEquals("5/1 - -3/1", "8/1", BigFraction.valueOf(5).subtract(-3).toString());
    assertEquals("-5/1 - 2/1", "-7/1", BigFraction.valueOf(-5).subtract(2).toString());
    assertEquals("-5/1 - -2/1", "-3/1", BigFraction.valueOf(-5).subtract(-2).toString());
    assertEquals("11/17 - 2/3", "-1/51", BigFraction.valueOf("11/17").subtract(BigFraction.valueOf("2/3")).toString());
    assertEquals("1/6 - 1/6", "0/1", BigFraction.valueOf("1/6").subtract(BigFraction.valueOf("1/6")).toString());
    assertEquals("-1/6 - 1/6", "-1/3", BigFraction.valueOf("-1/6").subtract(BigFraction.valueOf("1/6")).toString());
  }
  
  @Test
  public void testMultiply() {
    assertEquals("(11/17)(0/1)", "0/1", BigFraction.valueOf("11/17").multiply(-0.0).toString());
    assertEquals("(1/3)(3/4)", "1/4", BigFraction.valueOf("1/3").multiply(BigFraction.valueOf("3/4")).toString());
    assertEquals("(-1/12)(16/5)", "-4/15", BigFraction.valueOf("-1/12").multiply(BigFraction.valueOf("16/5")).toString());
    assertEquals("(-7/6)(-5/9)", "35/54", BigFraction.valueOf("-7/6").multiply(BigFraction.valueOf("-5/9")).toString());
    assertEquals("(4/5)(-7/2)", "-14/5", BigFraction.valueOf("4/5").multiply(BigFraction.valueOf("7/-2")).toString());
  }
  
  @Test
  public void testDivide() {
    assertEquals("(1/3)/(4/3)", "1/4", BigFraction.valueOf("1/3").divide(BigFraction.valueOf("4/3")).toString());
    assertEquals("(-1/12)/(5/16)", "-4/15", BigFraction.valueOf("-1/12").divide(BigFraction.valueOf("5/16")).toString());
    assertEquals("(-7/6)/(-9/5)", "35/54", BigFraction.valueOf("-7/6").divide(BigFraction.valueOf("9/-5")).toString());
    assertEquals("(4/5)/(-2/7)", "-14/5", BigFraction.valueOf("4/5").divide(BigFraction.valueOf("-2/7")).toString());
  }
  
  @Test
  public void testReciprocal() {
    assertEquals("(1/1).reciprocal", "1/1", BigFraction.valueOf(1.0).reciprocal().toString());
    assertEquals("(1/2).reciprocal", "2/1", BigFraction.valueOf(2,4).reciprocal().toString());
    assertEquals("(-10/-14).reciprocal", "7/5", BigFraction.valueOf(-10,-14).reciprocal().toString());
    assertEquals("(-6/1).reciprocal", "-1/6", BigFraction.valueOf(-6).reciprocal().toString());
  }
  
  @Test
  public void testComplement() {
    assertEquals("(10/14).complement", "2/7", BigFraction.valueOf(10,14).complement().toString());
    assertEquals("(1/1).complement", "0/1", BigFraction.valueOf(1).complement().toString());
    assertEquals("(-1/1).complement", "2/1", BigFraction.valueOf(-1).complement().toString());
    assertEquals("(0/1).complement", "1/1", BigFraction.valueOf(0).complement().toString());
    assertEquals("(17/11).complement", "-6/11", BigFraction.valueOf(17,11).complement().toString());
  }
  
  @Test
  public void testPow() {
    //Note: 0^0 returns 1 (just like Math.pow())
    assertEquals("(0/1)^(0)", "1/1", BigFraction.valueOf(0,1).pow(0).toString());
    assertEquals("(11/17)^(5)", "161051/1419857", BigFraction.valueOf(11,17).pow(5).toString());
    assertEquals("(11/17)^(-5)", "1419857/161051", BigFraction.valueOf(11,17).pow(-5).toString());
    assertEquals("(5/8)^(0)", "1/1", BigFraction.valueOf(5,8).pow(0).toString());
    assertEquals("(9/16)^(-1)", "16/9", BigFraction.valueOf(9,16).pow(-1).toString());
    assertEquals("(9/16)^(1)", "9/16", BigFraction.valueOf(9,16).pow(1).toString());
  }
  
  @Test
  public void testToMixedString() {
    assertEquals("4/3 == 1 1/3", "1 1/3", BigFraction.valueOf("4/3").toMixedString());
    assertEquals("-4/3 == -1 1/3", "-1 1/3", BigFraction.valueOf("-4/3").toMixedString());
    assertEquals("6/3 == 2", BigFraction.valueOf("6/3").toMixedString(), "2");
    assertEquals("6/-3 == -2", BigFraction.valueOf("6/-3").toMixedString(), "-2");
    assertEquals("2/3 == 2/3", BigFraction.valueOf("2/3").toMixedString(), "2/3");
    assertEquals("2/-3 == -2/3", BigFraction.valueOf("2/-3").toMixedString(), "-2/3");
    assertEquals("0/3 == 0", BigFraction.valueOf("0/3").toMixedString(), "0");
    assertEquals("0/-3 == 0", BigFraction.valueOf("0/-3").toMixedString(), "0");
  }
  
  @Test
  public void testRound() {
    new RoundingTest("5.5", "6", "5", "6", "5", "6", "5", "6", "ArithmeticException").test();
    new RoundingTest("2.5", "3", "2", "3", "2", "3", "2", "2", "ArithmeticException").test();
    new RoundingTest("1.6", "2", "1", "2", "1", "2", "2", "2", "ArithmeticException").test();
    new RoundingTest("1.1", "2", "1", "2", "1", "1", "1", "1", "ArithmeticException").test();
    new RoundingTest("1", "1", "1", "1", "1", "1", "1", "1", "1").test();
    new RoundingTest("0.999999999999999999999999999999999999999999999999999999999999999999999999", "1", "0", "1", "0", "1", "1", "1", "ArithmeticException").test();
    new RoundingTest("0.500000000000000000000000000000000000000000000000000000000000000000000001", "1", "0", "1", "0", "1", "1", "1", "ArithmeticException").test();
    new RoundingTest("0.5", "1", "0", "1", "0", "1", "0", "0", "ArithmeticException").test();
    new RoundingTest("0.499999999999999999999999999999999999999999999999999999999999999999999999", "1", "0", "1", "0", "0", "0", "0", "ArithmeticException").test();
    new RoundingTest("0.000000000000000000000000000000000000000000000000000000000000000000000001", "1", "0", "1", "0", "0", "0", "0", "ArithmeticException").test();
    new RoundingTest("0", "0", "0", "0", "0", "0", "0", "0", "0").test();
    new RoundingTest("0.000000000000000000000000000000000000000000000000000000000000000000000000", "0", "0", "0", "0", "0", "0", "0", "0").test();
    new RoundingTest("-0.000000000000000000000000000000000000000000000000000000000000000000000001", "-1", "0", "0", "-1", "0", "0", "0", "ArithmeticException").test();
    new RoundingTest("-0.499999999999999999999999999999999999999999999999999999999999999999999999", "-1", "0", "0", "-1", "0", "0", "0", "ArithmeticException").test();
    new RoundingTest("-0.5", "-1", "0", "0", "-1", "-1", "0", "0", "ArithmeticException").test();
    new RoundingTest("-0.500000000000000000000000000000000000000000000000000000000000000000000001", "-1", "0", "0", "-1", "-1", "-1", "-1", "ArithmeticException").test();
    new RoundingTest("-0.999999999999999999999999999999999999999999999999999999999999999999999999", "-1", "0", "0", "-1", "-1", "-1", "-1", "ArithmeticException").test();
    new RoundingTest("-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1").test();
    new RoundingTest("-1.1", "-2", "-1", "-1", "-2", "-1", "-1", "-1", "ArithmeticException").test();
    new RoundingTest("-1.6", "-2", "-1", "-1", "-2", "-2", "-2", "-2", "ArithmeticException").test();
    new RoundingTest("-2.5", "-3", "-2", "-2", "-3", "-3", "-2", "-2", "ArithmeticException").test();
    new RoundingTest("-5.5", "-6", "-5", "-5", "-6", "-6", "-5", "-6", "ArithmeticException").test();
  }
  
  @Test
  public void testCompareTo() {
    //Adds all positive and negative fractions with denominator less than or
    //equal to 10 and numerator less than or equal to 20 to a set. Then
    //creates a list from the set and sorts the set.
    //
    //This tests several things at once:
    // * It tests .equals() and .hashCode() by making sure that fractions that
    //   are duplicates (once reduced) don't appear in the set twice (since Set
    //   does not contain duplicates).
    // * Verifies once again that reduction works.
    // * Most importantly, tests compareTo() across positive, negative, and zero
    //   values, and across proper and improper fractions, by ensuring that
    //   sorting works.
    Set<BigFraction> set = new HashSet<BigFraction>();
    
    for(int num = 0; num <= 20; num++)
    {
      for(int den = 1; den <= 10; den++)
      {
        BigFraction bf = BigFraction.valueOf(num, den);
        set.add(bf);
        set.add(bf.negate());
      }
    }
    
    List<BigFraction> lst = new ArrayList<BigFraction>(set);
    Collections.sort(lst);
    
    /*
    String expected = "[-1/1, -9/10, -8/9, -7/8, -6/7, -5/6, -4/5, -7/9, -3/4, -5/7, -7/10, -2/3, -5/8"
                    + ", -3/5, -4/7, -5/9, -1/2, -4/9, -3/7, -2/5, -3/8, -1/3, -3/10, -2/7, -1/4, -2/9"
                    + ", -1/5, -1/6, -1/7, -1/8, -1/9, -1/10, 0/1, 1/10, 1/9, 1/8, 1/7, 1/6, 1/5, 2/9"
                    + ", 1/4, 2/7, 3/10, 1/3, 3/8, 2/5, 3/7, 4/9, 1/2, 5/9, 4/7, 3/5, 5/8, 2/3, 7/10"
                    + ", 5/7, 3/4, 7/9, 4/5, 5/6, 6/7, 7/8, 8/9, 9/10, 1/1]";
    */
    
    String expected = "[-20/1, -19/1, -18/1, -17/1, -16/1, -15/1, -14/1, -13/1, -12/1, -11/1, -10/1"
                    + ", -19/2, -9/1, -17/2, -8/1, -15/2, -7/1, -20/3, -13/2, -19/3, -6/1, -17/3"
                    + ", -11/2, -16/3, -5/1, -19/4, -14/3, -9/2, -13/3, -17/4, -4/1, -19/5, -15/4"
                    + ", -11/3, -18/5, -7/2, -17/5, -10/3, -13/4, -16/5, -19/6, -3/1, -20/7, -17/6"
                    + ", -14/5, -11/4, -19/7, -8/3, -13/5, -18/7, -5/2, -17/7, -12/5, -19/8, -7/3"
                    + ", -16/7, -9/4, -20/9, -11/5, -13/6, -15/7, -17/8, -19/9, -2/1, -19/10, -17/9"
                    + ", -15/8, -13/7, -11/6, -9/5, -16/9, -7/4, -12/7, -17/10, -5/3, -13/8, -8/5"
                    + ", -11/7, -14/9, -3/2, -13/9, -10/7, -7/5, -11/8, -4/3, -13/10, -9/7, -5/4"
                    + ", -11/9, -6/5, -7/6, -8/7, -9/8, -10/9, -11/10, -1/1, -9/10, -8/9, -7/8, -6/7"
                    + ", -5/6, -4/5, -7/9, -3/4, -5/7, -7/10, -2/3, -5/8, -3/5, -4/7, -5/9, -1/2"
                    + ", -4/9, -3/7, -2/5, -3/8, -1/3, -3/10, -2/7, -1/4, -2/9, -1/5, -1/6, -1/7"
                    + ", -1/8, -1/9, -1/10, 0/1, 1/10, 1/9, 1/8, 1/7, 1/6, 1/5, 2/9, 1/4, 2/7, 3/10"
                    + ", 1/3, 3/8, 2/5, 3/7, 4/9, 1/2, 5/9, 4/7, 3/5, 5/8, 2/3, 7/10, 5/7, 3/4, 7/9"
                    + ", 4/5, 5/6, 6/7, 7/8, 8/9, 9/10, 1/1, 11/10, 10/9, 9/8, 8/7, 7/6, 6/5, 11/9"
                    + ", 5/4, 9/7, 13/10, 4/3, 11/8, 7/5, 10/7, 13/9, 3/2, 14/9, 11/7, 8/5, 13/8"
                    + ", 5/3, 17/10, 12/7, 7/4, 16/9, 9/5, 11/6, 13/7, 15/8, 17/9, 19/10, 2/1, 19/9"
                    + ", 17/8, 15/7, 13/6, 11/5, 20/9, 9/4, 16/7, 7/3, 19/8, 12/5, 17/7, 5/2, 18/7"
                    + ", 13/5, 8/3, 19/7, 11/4, 14/5, 17/6, 20/7, 3/1, 19/6, 16/5, 13/4, 10/3, 17/5"
                    + ", 7/2, 18/5, 11/3, 15/4, 19/5, 4/1, 17/4, 13/3, 9/2, 14/3, 19/4, 5/1, 16/3"
                    + ", 11/2, 17/3, 6/1, 19/3, 13/2, 20/3, 7/1, 15/2, 8/1, 17/2, 9/1, 19/2, 10/1"
                    + ", 11/1, 12/1, 13/1, 14/1, 15/1, 16/1, 17/1, 18/1, 19/1, 20/1]";
    
    assertEquals(expected, lst.toString());
  }
  
  @Test
  public void testNumberInterface() {
    //Same setup as testCompareTo, but after sorting test each of
    //the methods from Number interface.
    Set<BigFraction> set = new HashSet<BigFraction>();
    
    for(int num = 0; num <= 20; num++)
    {
      for(int den = 1; den <= 10; den++)
      {
        BigFraction bf = BigFraction.valueOf(num, den);
        set.add(bf);
        set.add(bf.negate());
      }
    }
    
    List<BigFraction> lst = new ArrayList<BigFraction>(set);
    Collections.sort(lst);
    
    BigFraction lastBF = lst.get(0);
    byte lastByte = lastBF.byteValue();
    short lastShort = lastBF.shortValue();
    int lastInt = lastBF.intValue();
    long lastLong = lastBF.longValue();
    float lastFloat = lastBF.floatValue();
    double lastDouble = lastBF.doubleValue();
    BigInteger lastBI = lastBF.round();
    BigDecimal lastBD = lastBF.toBigDecimal();
    
    for(int i = 1; i < lst.size(); i++)
    {
      BigFraction currBF = lst.get(i);
      byte currByte = currBF.byteValue();
      short currShort = currBF.shortValue();
      int currInt = currBF.intValue();
      long currLong = currBF.longValue();
      float currFloat = currBF.floatValue();
      double currDouble = currBF.doubleValue();
      BigInteger currBI = currBF.round();
      BigDecimal currBD = currBF.toBigDecimal();
      
      assertTrue("(byte)(" + lastBF + ") <= (byte)(" + currBF + ")", lastByte <= currByte);
      assertTrue("(short)(" + lastBF + ") <= (short)(" + currBF + ")", lastShort <= currShort);
      assertTrue("(int)(" + lastBF + ") <= (int)(" + currBF + ")", lastInt <= currInt);
      assertTrue("(long)(" + lastBF + ") <= (long)(" + currBF + ")", lastLong <= currLong);
      assertTrue("(float)(" + lastBF + ") < (float)(" + currBF + ")", lastFloat < currFloat);
      assertTrue("(double)(" + lastBF + ") < (double)(" + currBF + ")", lastDouble < currDouble);
      assertTrue("(BigInteger)(" + lastBF + ") <= (BigInteger)(" + currBF + ")", lastBI.compareTo(currBI) <= 0);
      assertTrue("(BigDecimal)(" + lastBF + ") < (BigDecimal)(" + currBF + ")", lastBD.compareTo(currBD) < 0);
      
      lastBF = currBF;
      lastByte = currByte;
      lastShort = currShort;
      lastInt = currInt;
      lastLong = currLong;
      lastFloat = currFloat;
      lastDouble = currDouble;
      lastBI = currBI;
      lastBD = currBD;
    }
  }
  
  //exception testing
  //---------------------------------------------------------------------------
  
  @Test(expected=IllegalArgumentException.class)
  public void testNaN() {
    BigFraction.valueOf(Double.NaN);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testPositiveInfinity() {
    BigFraction.valueOf(Double.POSITIVE_INFINITY);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testNegativeInfinity() {
    BigFraction.valueOf(Double.NEGATIVE_INFINITY);
  }
  
  @Test(expected=ArithmeticException.class)
  public void testZeroDenominator1() {
    BigFraction.valueOf(0,0);
  }
  
  @Test(expected=ArithmeticException.class)
  public void testZeroDenominator2() {
    BigFraction.valueOf(100.9,0.0);
  }
  
  @Test(expected=ArithmeticException.class)
  public void testZeroDenominator3() {
    BigFraction.valueOf("900/0");
  }
  
  @Test(expected=ArithmeticException.class)
  public void testZeroDenominator4() {
    BigFraction.valueOf(BigFraction.valueOf(900),BigFraction.valueOf(0,488));
  }
  
  @Test(expected=ArithmeticException.class)
  public void testDivideZero1() {
    BigFraction.valueOf(0).divide(BigFraction.valueOf(0));
  }
  
  @Test(expected=ArithmeticException.class)
  public void testDivideZero2() {
    BigFraction.valueOf(10).divide(0);
  }
  
  @Test(expected=ArithmeticException.class)
  public void testDivideZero3() {
    BigFraction.valueOf(90).divide(0.0);
  }
  
  @Test(expected=ArithmeticException.class)
  public void testDivideZero4() {
    BigFraction.valueOf(16).divide(new BigDecimal("0"));
  }
  
  @Test(expected=ArithmeticException.class)
  public void testZeroReciprocal() {
    BigFraction.ZERO.reciprocal();
  }
  
  @Test(expected=ArithmeticException.class)
  public void testZeroNegativePow() {
    BigFraction.ZERO.pow(-3);
  }
  
  
  private static class RoundingTest
  {
    private final String input;
    private final BigFraction bf;
    private final Map<RoundingMode, String> expected = new HashMap<RoundingMode, String>();
    
    public RoundingTest(String input, String up, String down, String ceiling, String floor,
            String halfUp, String halfDown, String halfEven, String unnecessary)
    {
      this.input = input;
      bf = BigFraction.valueOf(input);
      expected.put(RoundingMode.UP, up);
      expected.put(RoundingMode.DOWN, down);
      expected.put(RoundingMode.CEILING, ceiling);
      expected.put(RoundingMode.FLOOR, floor);
      expected.put(RoundingMode.HALF_UP, halfUp);
      expected.put(RoundingMode.HALF_DOWN, halfDown);
      expected.put(RoundingMode.HALF_EVEN, halfEven);
      expected.put(RoundingMode.UNNECESSARY, unnecessary);
    }
    
    public void test()
    {
      for(Map.Entry<RoundingMode, String> entry : expected.entrySet())
      {
        String actual;
        try {
          actual = bf.round(entry.getKey()).toString();
        }
        catch(Exception e) {
          actual = e.getClass().getSimpleName();
        }
        assertEquals("round(" + input + ", " + entry.getKey() + ")", entry.getValue(), actual);
      }
      
      //test that default rounding mode is the same as HALF_UP
      assertEquals("round(" + input + ")", expected.get(RoundingMode.HALF_UP), bf.round().toString());
    }
  }
}