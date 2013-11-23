/**
 * InfixToPostfixConverter.java
 */

package uk.co.bluettduncanj;

import java.util.ArrayDeque;


/**
 * This class uses Dijkstra's shunting-yard algorithm.
 * 
 * @author Jonathan
 */
public class InfixToPostfixConverter {
  
  /** The input infix notation text string to be converted to Reverse-Polish postfix notation */
  private String input;
  
  /** The output in Reverse-Polish postfix notation and in a text string format */
  private String output;
  
  /** The stack used to hold operators during the infix-to-postfix conversion */
  private ArrayDeque<String> operatorStack;
  
  public InfixToPostfixConverter(String infixExpression) {
    super();
    this.init(infixExpression);
  }
  
  private void init(String infixExpression) throws NullPointerException, IllegalArgumentException {
    if (infixExpression == null) {
      throw new NullPointerException("The infix expression is null.");
    }
    
    if (infixExpression.length() == 0) {
      throw new IllegalArgumentException("The infix expression is empty.");
    }
    
    // Reject 'empty' infix expressions that are just sequences of whitespaces
    if (Utility.isFullyWhitespace(infixExpression)) {
      throw new IllegalArgumentException("The infix expression only contains whitespace.");
    }
    
    this.input = infixExpression;
    this.output = null;
    this.operatorStack = null;
  }
  
  public String getPostfixExpression() {
    if (this.output == null) {
      this.convert();
    }
    return this.output;
  }
  
  private void convert() {
    
    // Initialise the operator stack (the 'shunting-yard')
    this.operatorStack = new ArrayDeque<String>();

    
    
  }
  
}
