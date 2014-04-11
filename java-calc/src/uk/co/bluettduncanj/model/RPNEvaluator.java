/**
 * RPNEvaluator.java
 */

package uk.co.bluettduncanj.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.lrdev.bn.BigRational;


/**
 * @author Jonathan Bluett-Duncan
 */
public class RPNEvaluator {
  
  private static final String INVALID   = "Invalid";
  private static final String UNDEFINED = "Undefined";
  
  private RPNEvaluator() {}
  
  public static BigRational evaluate(List<String> expression) {
    
    Deque<BigRational> stack = new ArrayDeque<BigRational>();
    
    for (String token : expression) {
      
      switch (token) {
      case "+":  
        add(stack);
        break;
      case "-":  
        subtract(stack);
        break;
      case "*":  
        multiply(stack);
        break;
      case "/":  
        divide(stack);
        break;
      default:
        stack.push(new BigRational(token));
      }
    }
    
    BigRational result = stack.pop();
    return result;
    
  }
  
  private static void add(Deque<BigRational> stack) {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigRational a = stack.pop();
    BigRational b = stack.pop();
    stack.push(a.add(b));
  }
  
  private static void subtract(Deque<BigRational> stack) {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigRational a = stack.pop();
    BigRational b = stack.pop();
    stack.push(b.subtract(a));
  }
  
  private static void multiply(Deque<BigRational> stack) {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigRational a = stack.pop();
    BigRational b = stack.pop();
    stack.push(a.multiply(b));
  }
  
  private static void divide(Deque<BigRational> stack) {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }

    BigRational a = stack.pop();
    BigRational b = stack.pop();
    if (a.equals(BigRational.ZERO) && b.equals(BigRational.ZERO)) {
      throw new ArithmeticException(UNDEFINED);
    } 
    else if (a.equals(BigRational.ZERO)) {
      throw new ArithmeticException(UNDEFINED);
    } 
    else {
      stack.push(b.divide(a));
    }
  }
  
}
