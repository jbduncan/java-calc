/**
 * RPNEvaluatorTest.java
 */

package uk.co.bluettduncanj;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.bluettduncanj.model.RPNEvaluator;


/**
 * @author Jonathan Bluett-Duncan
 */
public class RPNEvaluatorTest {

  private static List<List<String>> testData;
  private static List<String> expectedResults;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    testData = new ArrayList<List<String>>();
    testData.add(Arrays.asList("5", "10", "+"));
    testData.add(Arrays.asList("-5", "12", "+"));
    testData.add(Arrays.asList("-1", "-4", "+"));
    testData.add(Arrays.asList("0.1", "0.8", "+"));
    testData.add(Arrays.asList("1", "2", "3", "4", "+", "+", "+"));
    testData.add(Arrays.asList("1", "2", "+", "3", "+", "4", "+"));
    testData.add(Arrays.asList("0", "0", "+"));
    testData.add(Arrays.asList("5", "2", "-"));
    testData.add(Arrays.asList("10", "13", "-"));
    testData.add(Arrays.asList("5", "-10", "-"));
    testData.add(Arrays.asList("0.8", "0.1", "-"));
    testData.add(Arrays.asList("10", "4", "-", "3", "-", "2", "-"));
    testData.add(Arrays.asList("5", "5", "*"));
    testData.add(Arrays.asList("5", "-5", "*"));
    testData.add(Arrays.asList("-5", "-5", "*"));
    testData.add(Arrays.asList("5", "0", "*"));
    testData.add(Arrays.asList("0", "0", "*"));
    testData.add(Arrays.asList("1", "2", "3", "4", "*", "*", "*"));
    testData.add(Arrays.asList("1", "2", "*", "3", "*", "4", "*"));
    testData.add(Arrays.asList("1", "2", "/"));
    testData.add(Arrays.asList("10", "2", "/", "2", "/"));
    
    expectedResults = new ArrayList<String>();
    expectedResults.add("15");
    expectedResults.add("7");
    expectedResults.add("-5");
    expectedResults.add("0.9");
    expectedResults.add("10");
    expectedResults.add("10");
    expectedResults.add("0");
    expectedResults.add("3");
    expectedResults.add("-3");
    expectedResults.add("15");
    expectedResults.add("0.7");
    expectedResults.add("1");
    expectedResults.add("25");
    expectedResults.add("-25");
    expectedResults.add("25");
    expectedResults.add("0");
    expectedResults.add("0");
    expectedResults.add("24");
    expectedResults.add("24");
    expectedResults.add("0.5");
    expectedResults.add("2.5");
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link uk.co.bluettduncanj.model.RPNEvaluator#evaluate()}.
   */
  @Test
  public void testEvaluate() {
    /*
    List<String> input = Arrays.asList("5", "10", "+");
    PostfixEvaluator p = new PostfixEvaluator(input);
    double output = p.evaluate();
    assertEquals("Unexpected result.", 15.0, output, 0);
    */
    
    for (int i = 0; i < testData.size(); i++) {
      RPNEvaluator p = new RPNEvaluator(testData.get(i));
      //double output = p.evaluate();
      String output = p.evaluate();
      assertEquals("Unexpected result", expectedResults.get(i), output);
      System.out.println(expectedResults.get(i) + " == " + output);
    }
  }

}
