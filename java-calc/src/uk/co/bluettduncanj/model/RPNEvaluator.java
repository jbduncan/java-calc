/**
 * RPNEvaluator.java
 */

package uk.co.bluettduncanj.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import kip.util.BigFraction;


/**
 * @author Jonathan Bluett-Duncan
 */
public class RPNEvaluator {
  
  private static final String INVALID = "Invalid";
  private static final String UNDEFINED = "Undefined";
  
  private List<String> expr;
  private Deque<BigFraction> stack;
  
  public RPNEvaluator(List<String> expr) {
    this.expr = expr;
    this.stack = new ArrayDeque<BigFraction>(expr.size());
  }
  
  /**
   * 
   * @return
   * 
   * @throws NumberFormatException, IllegalArgumentException, ArithmeticException
   */
  public String evaluate() {
    if (!stack.isEmpty()) stack.clear();
    for (String token : expr) {
      switch (token) {
      case "+": 
        add(); 
        break;
      case "-": 
        subtract();
        break;
      case "*":
        multiply();
        break;
      case "/":
        divide();
        break;
      default:
        // Interpret as a number
        stack.push(BigFraction.valueOf(token));
      }
    }
    return stack.pop().toBigDecimal().toString();
  }
  
  private void add() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigFraction a = stack.pop();
    BigFraction b = stack.pop();
    stack.push(a.add(b));
  }
  
  private void subtract() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigFraction a = stack.pop();
    BigFraction b = stack.pop();
    stack.push(b.subtract(a));
  }
  
  private void multiply() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigFraction a = stack.pop();
    BigFraction b = stack.pop();
    stack.push(a.multiply(b));
  }
  
  private void divide() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigFraction a = stack.pop();
    BigFraction b = stack.pop();
    if (a.equals(BigFraction.ZERO) && b.equals(BigFraction.ZERO)) {
      throw new ArithmeticException(UNDEFINED);
    } else if (a.equals(BigFraction.ZERO)) {
      throw new ArithmeticException(UNDEFINED);
    } else {
      stack.push(b.divide(a));
    }
  }
  
}
