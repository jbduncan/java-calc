/**
 * Calculator.java
 */

package uk.co.bluettduncanj.controller;

import java.math.MathContext;
import java.util.List;

import com.lrdev.bn.BigRational;

import uk.co.bluettduncanj.model.InfixEvaluator;


/**
 * @author Jonathan Bluett-Duncan
 */
public class Calculator {
  
  private BigRational ans;
  
  public Calculator evaluate(List<String> expression) {
    InfixEvaluator evaluator = new InfixEvaluator();
    ans = evaluator.evaluate(expression);
    return this;
  }
  
  public String asString() {
    // TODO: Return the answer in an appropriate String format.
    // STUB
    return ans.bigDecimalValue(MathContext.DECIMAL64.getPrecision() + 2).toString();
  }
  
  public BigRational asBigRational() {
    return ans;
  }
  
}
