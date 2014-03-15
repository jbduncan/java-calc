/**
 * OperatorInfo.java
 */

package uk.co.bluettduncanj.model;


/**
 * @author Jonathan Bluett-Duncan
 */
public class OperatorInfo {
  
  private final Precedence precedence;
  private final Associativity associativity;
  
  public OperatorInfo(Precedence precedence, Associativity associativity) {
    this.precedence = precedence;
    this.associativity = associativity;
  }
  
  /**
   * @return the precedence
   */
  public Precedence getPrecedence() {
    return this.precedence;
  }
  
  /**
   * @return the associativity
   */
  public Associativity getAssociativity() {
    return this.associativity;
  }
}
