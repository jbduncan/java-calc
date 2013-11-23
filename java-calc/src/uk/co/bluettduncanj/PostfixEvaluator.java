/**
 * PostfixEvaluator.java
 */

package uk.co.bluettduncanj;

import java.util.ArrayDeque;


/**
 * @author Jonathan
 */
public class PostfixEvaluator {
  
  private String[] tokens;
  
  private ArrayDeque<Double> stack;
  
  private Double result; 
  
  private static final String INSUFFICIENTLY_FEW_VALUES_MESSAGE = "The postfix expression has insufficiently few values";
  
  public PostfixEvaluator(String postfixExpression) throws NullPointerException, IllegalArgumentException {
    super();
    this.init(postfixExpression, " ");
  }
  
  public PostfixEvaluator(String postfixExpression, String delimiter) throws NullPointerException, IllegalArgumentException {
    super();
    this.init(postfixExpression, delimiter);
  }
  
  private void init(String postfixExpression, String delimiter) throws NullPointerException, IllegalArgumentException {
    if (postfixExpression == null) {
      throw new NullPointerException("The postfix expression is null.");
    }
    
    if (postfixExpression.length() == 0) {
      throw new IllegalArgumentException("The postfix expression is empty.");
    }
    
    if (delimiter == null) {
      throw new NullPointerException("The delimiter is null.");
    }
    
    if (delimiter.length() == 0) {
      throw new IllegalArgumentException("The delimiter is empty.");
    }

    // Reject 'empty' postfix expressions that are just sequences of whitespaces
    if (Utility.isFullyWhitespace(postfixExpression)) {
      throw new IllegalArgumentException("The postfix expression only contains whitespace.");
    }
    
    this.tokens = postfixExpression.split(delimiter);
    this.stack = null;
    this.result = null;
  }
  
  public Double getResult() throws IllegalArgumentException, ArithmeticException {
    if (this.result == null) {
      this.evaluate();
    }
    return this.result;
  }
  
  private void evaluate() throws IllegalArgumentException, ArithmeticException {
     
    // Initialise the stack
    this.stack = new ArrayDeque<Double>();
    
    // Evaluate each token
    for (String token : this.tokens) { 
    
      // Attempt to produce a numerical value from the token.
      try {
        Double newVal = Double.valueOf(token);
        this.stack.push(newVal);
      }
      // Otherwise the token is not a valid numerical value
      catch (NumberFormatException e) {
        // Attempt to evaluate the token as an operator or function
        if (token.equals(Operator.Add.getOperator())) { // "+"
          this.add();
        }
        else if (token.equals(Operator.Subtract.getOperator())) { // "-"
          this.subtract();
        }
        else if (token.equals(Operator.Multiply.getOperator())) { // "*"
          this.multiply();
        }
        else if (token.equals(Operator.Divide.getOperator())) { // "/"
          this.divide();
        }
        else {
          // The token is neither a valid numerical value, nor an operator nor function
          throw new IllegalArgumentException("The postfix expression contains one or more invalid tokens.");
        }
      }
    }
    if (this.stack.size() == 1) {
      // This single element on the stack is the answer!
      this.result = this.stack.pop();
    }
    else { // The stack has more than one element on it left, so the postfix expression is invalid!
      throw new IllegalArgumentException("The postfix expression has too many numerical values or no operators/functions.");
    }
  }
  
  private void add() throws IllegalArgumentException {
    if (this.stack.size() < Operator.Add.getNoOfOperands()) {
      throw new IllegalArgumentException(INSUFFICIENTLY_FEW_VALUES_MESSAGE);
    }
    Double op1 = this.stack.pop();
    Double op2 = this.stack.pop();
    Double result = op1 + op2;
    this.stack.push(result);
  }

  private void subtract() throws IllegalArgumentException {
    if (this.stack.size() < Operator.Subtract.getNoOfOperands()) {
      throw new IllegalArgumentException(INSUFFICIENTLY_FEW_VALUES_MESSAGE);
    }
    Double op2 = this.stack.pop();
    Double op1 = this.stack.pop();
    Double result = op1 - op2;
    this.stack.push(result);
  }
  
  private void multiply() throws IllegalArgumentException {
    if (this.stack.size() < Operator.Multiply.getNoOfOperands()) {
      throw new IllegalArgumentException(INSUFFICIENTLY_FEW_VALUES_MESSAGE);
    }
    Double op1 = this.stack.pop();
    Double op2 = this.stack.pop();
    Double result = op1 * op2;
    this.stack.push(result);
  }
  
  private void divide() throws IllegalArgumentException, ArithmeticException {
    if (this.stack.size() < Operator.Divide.getNoOfOperands()) {
      throw new IllegalArgumentException(INSUFFICIENTLY_FEW_VALUES_MESSAGE);
    }
    Double op2 = this.stack.pop();
    Double op1 = this.stack.pop();
    if (op2.doubleValue() == 0) { // Cannot divide by 0
      throw new ArithmeticException("Arithmetic error - Cannot divide by 0");
    }
    Double result = op1 / op2;
    this.stack.push(result);
  }
  
}
