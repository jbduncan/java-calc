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
  
  private List<String>        expression;
  private Deque<BigRational>  stack;
  
  private RPNEvaluator(List<String> expression) {
    this.expression = expression;
    this.stack = new ArrayDeque<BigRational>();
  }
  
  public static BigRational evaluate(List<String> expression) {
    RPNEvaluator r = new RPNEvaluator(expression);
    return r.doEvaluation();
  }
  
  private BigRational doEvaluation() {
    
    stack.clear();
    
    for (String token : expression) {
      switch (token) {
        case "+":  
          add();      break;
        case "-":  
          subtract(); break;
        case "*":  
          multiply(); break;
        case "/":  
          divide();   break;
        default:
          stack.push(new BigRational(token));
      }
    }
    
    BigRational result = stack.pop();
    return result;
    
  }
  
  private void add() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigRational a = stack.pop();
    BigRational b = stack.pop();
    stack.push(a.add(b));
  }
  
  private void subtract() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigRational a = stack.pop();
    BigRational b = stack.pop();
    stack.push(b.subtract(a));
  }
  
  private void multiply() {
    if (stack.size() < 2) {
      throw new IllegalArgumentException(INVALID);
    }
    BigRational a = stack.pop();
    BigRational b = stack.pop();
    stack.push(a.multiply(b));
  }
  
  private void divide() {
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
