/**
 * Calculator.java
 */

package uk.co.bluettduncanj.controller;

import java.util.ArrayList;
import java.util.List;

import com.lrdev.bn.BigRational;

import uk.co.bluettduncanj.model.InfixEvaluator;


/**
 * @author Jonathan Bluett-Duncan
 */
public class Calculator {
  
  private BigRational previousAnswer;
  
  public BigRational evaluate(String expression) {
    
    List<String> tokenisedExpression = splitIntoTokens(expression);
    BigRational answer = InfixEvaluator.evaluate(tokenisedExpression);
    previousAnswer = answer;
    return answer;
    
  }
  
  private List<String> splitIntoTokens(String expression) {
    // TODO: Implement a state machine here?
    
    return new ArrayList<String>();
  }
  
}
