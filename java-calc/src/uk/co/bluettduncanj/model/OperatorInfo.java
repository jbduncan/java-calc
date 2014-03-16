/**
 * OperatorInfo.java
 */

package uk.co.bluettduncanj.model;


/**
 * @author Jonathan Bluett-Duncan
 */
public class OperatorInfo {
  
  private static final String NULL = "Null pointer";
  
  private final Precedence precedence;
  private final Associativity associativity;
  
  public OperatorInfo(Precedence precedence, Associativity associativity) {
    if (precedence == null) {
      throw new IllegalArgumentException(NULL);
    }
    if (associativity == null) {
      throw new IllegalArgumentException(NULL);
    }
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

  /**
   * @return
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.associativity == null) ? 0 : this.associativity.hashCode());
    result = prime * result + ((this.precedence == null) ? 0 : this.precedence.hashCode());
    return result;
  }

  /**
   * @param obj
   * @return
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof OperatorInfo)) {
      return false;
    }
    OperatorInfo that = (OperatorInfo) obj;
    if (this.associativity != that.associativity) {
      return false;
    }
    if (this.precedence != that.precedence) {
      return false;
    }
    return true;
  }

  /**
   * @return
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return String.format("OperatorInfo [precedence=%s, associativity=%s]", this.precedence, this.associativity);
  }
  
}
