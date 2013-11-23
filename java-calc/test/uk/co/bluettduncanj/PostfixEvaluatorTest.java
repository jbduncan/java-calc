/**
 * PostfixEvaluatorTest.java
 */

package uk.co.bluettduncanj;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Jonathan
 */
public class PostfixEvaluatorTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link uk.co.bluettduncanj.PostfixEvaluator#PostfixEvaluator(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testPostfixEvaluator() {
    String e = "3 4 +";
    new PostfixEvaluator(e, " ");
    new PostfixEvaluator(e);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testPostfixEvaluatorPostfixExpressionIsEmpty() {
    String expr = "";
    try {
      new PostfixEvaluator(expr);
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testPostfixEvaluatorPostfixExpressionIsFullyWhitespace() {
    String expr = "   ";
    try {
      new PostfixEvaluator(expr);
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }

  /**
   * Test method for {@link uk.co.bluettduncanj.PostfixEvaluator#evaluate()}.
   */
  @Test
  public void testEvaluateAddition() {
    String expr = "3 4 +";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    assertEquals(7, p.getResult().doubleValue(), 0);
    assertEquals(3 + 4, p.getResult().doubleValue(), 0);
  }
  
  @Test
  public void testEvaluateSubtraction() {
    String expr = "10 5 -";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    assertEquals(5, p.getResult().doubleValue(), 0);
    assertEquals(10 - 5, p.getResult().doubleValue(), 0);
  }
  
  @Test
  public void testEvaluateMultiply() {
    String expr = "30 4 *";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    assertEquals(120, p.getResult().doubleValue(), 0);
    assertEquals(30 * 4, p.getResult().doubleValue(), 0);
  }
  
  @Test
  public void testEvaluateDivide() {
    String expr = "9 2 /";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    assertEquals(4.5, p.getResult().doubleValue(), 1);
    assertEquals(9 / 2, p.getResult().doubleValue(), 1);
  }
  
  @Test
  public void testEvaluateDivide2() {
    String expr = "1 3 /";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    
    String result = p.getResult().toString();
    
    System.out.println(result);
    
    double numberAnswer = 1.0 / 3.0;
    String answer = Double.toString(numberAnswer);
    assertEquals(answer, result);
    
    expr = result + " 3 *";
    p = new PostfixEvaluator(expr);
    
    String result2 = p.getResult().toString();
    
    System.out.println(result2);
    
    assertEquals("1", result2);
  }
  
  @Test(expected = ArithmeticException.class)
  public void testEvaluateDivideByZero() {
    String expr = "1 0 /";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    p.getResult();
  }
  
  @Test(expected = IllegalArgumentException.class) 
  public void testEvaluateTooManyTokens1() {
    String expr = "5 6 7";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    try {
      p.getResult();
    }
    catch (IllegalArgumentException e) {
      System.out.println(expr + ", " + e.getMessage());
      throw e;
    }
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testEvaluateTooManyTokens2() {
    String expr = "1 2 + 5 6";
    PostfixEvaluator p = new PostfixEvaluator(expr);
    try {
      p.getResult();
    }
    catch (IllegalArgumentException e) {
      System.out.println(expr + ", " + e.getMessage());
      throw e;
    }
  }

}
