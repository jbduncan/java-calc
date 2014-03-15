/**
 * Precedence.java
 */

package uk.co.bluettduncanj.model;


/**
 * @author Jonathan Bluett-Duncan
 */
public enum Precedence {
  ADDITIVE(0), MULTIPLICATIVE(1), EXPONENTIAL_OR_ROOT(2), NOT_APPLICABLE(-1);
  
  private int order;
  
  private Precedence(int order) {
    this.order = order;
  }
  
  public boolean isLessThan(Precedence that) {
    return this.order < that.order;
  }
  
  public boolean isEqualTo(Precedence that) {
    return this.order == that.order;
  }
  
  public boolean isGreaterThan(Precedence that) {
    return this.order > that.order;
  }
}
