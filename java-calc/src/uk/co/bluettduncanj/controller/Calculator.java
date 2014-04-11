/**
 * Calculator.java
 */

package uk.co.bluettduncanj.controller;

import java.util.List;

import com.lrdev.bn.BigRational;

import uk.co.bluettduncanj.model.InfixEvaluator;


/**
 * @author Jonathan Bluett-Duncan
 */
public class Calculator {
  
  private BigRational  ans;
  
  
  public Calculator evaluate(List<String> expression) {
    ans = InfixEvaluator.evaluate(expression);
    return this;
  }
  
  public String toString() {
    // TODO: Return the answer in an appropriate String format.
    // STUB
    return ans.toString();
  }
  
}
