/**
 * OperatorSymbols.java
 */

package uk.co.bluettduncanj;


/**
 * @author Jonathan
 */
public enum Operator {
  Add("+", 2, Associativity.LEFT, 1), Subtract("-", 2, Associativity.LEFT, 1), Multiply("*", 2, Associativity.LEFT, 2), 
    Divide("/", 2, Associativity.LEFT, 2);
  
  private String operator;
  
  /** The number of operands (arguments) that an operator accepts */
  private int noOfOperands;
  
  private Associativity associativity;
  
  private int precedence;
  
  private Operator(String operator, int noOfOperands, Associativity associativity, int precedence) {
    this.operator = operator;
    this.noOfOperands = noOfOperands;
    this.associativity = associativity;
    this.precedence = precedence;
  }
  
  public String getOperator() {
    return this.operator;
  }
  
  public int getNoOfOperands() {
    return this.noOfOperands;
  }
  
  public Associativity getAssociativity() {
    return this.associativity;
  }
  
  public int getPrecedence() {
    return this.precedence;
  }
}

