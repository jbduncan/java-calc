/**
 * InfixEvaluatorTest.java
 */

package uk.co.bluettduncanj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Jonathan Bluett-Duncan
 */
public class InfixEvaluatorTest {
  
  private List<List<String>> testData;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    testData = new ArrayList<List<String>>();
    testData.add(Arrays.asList("5", "+", "10"));
    testData.add(Arrays.asList("-5", "+", "12"));
    testData.add(Arrays.asList("-1", "+", "-4"));
    testData.add(Arrays.asList("0.1", "+", "0.8"));
    testData.add(Arrays.asList("1", "+", "2", "+", "3", "+", "4"));
    testData.add(Arrays.asList("0", "+", "0"));
    testData.add(Arrays.asList("5", "-", "2"));
    testData.add(Arrays.asList("10", "-", "13"));
    testData.add(Arrays.asList("5", "-", "-10"));
    testData.add(Arrays.asList("0.8", "-", "0.1"));
    testData.add(Arrays.asList("10", "-", "4", "-", "3", "-", "2"));
    testData.add(Arrays.asList("5", "*", "5"));
    testData.add(Arrays.asList("5", "*", "-5"));
    testData.add(Arrays.asList("-5", "*", "-5"));
    testData.add(Arrays.asList("5", "*", "0"));
    testData.add(Arrays.asList("0", "*", "0"));
    testData.add(Arrays.asList("1", "*", "2", "*", "3", "*", "4"));
    testData.add(Arrays.asList("1", "/", "2"));
    testData.add(Arrays.asList("10", "/", "2", "/", "2"));
    testData.add(Arrays.asList("(", "1", "/", "3", ")", "*", "3"));
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link uk.co.bluettduncanj.model.InfixEvaluator#evaluate()}.
   */
  @Test
  public void testEvaluate() {
    
    long begin = System.currentTimeMillis();
    long end;
    
    for (List<String> data : testData) {
      System.out.println(data + " = " + InfixEvaluator.evaluate(data).toString());
    }
    
    end = System.currentTimeMillis();
    System.out.println("Total time taken: " + (end - begin) + " milliseconds.");
    
  }

}
