/**
 * Factorial.java
 */

package uk.co.bluettduncanj;


/**
 * @author Jonathan
 */
public class Factorial {
  
  /**
   * <p>Calculates the factorial of a <code>double</code> non-negative integer number, and returns the result as a <code>double</code>.</p>
   * 
   * <p>As of Java 7, <code>double</code> variables cannot hold values larger than (2-2<sup>-52</sup>) x 21023 [7.257415615308004E306],
   * and so cannot hold factorials greater than <i>170!</i>. Therefore this method is limited to returning factorials in the range
   * <i>0! - 170!</i>.</p>
   * 
   * <p>Also, since only factorials of whole numbers can be calculated, the input value must be equivalent to a whole number,
   * irrespective of the Java definitions of of the primitive data types {@code short}, {@code int} and {@code long}.</p>
   * 
   * @param value
   *          The number to compute the factorial of.
   * @return the factorial of value.
   * @throws IllegalArgumentException if value is not a whole number, negative (value < 0) or larger than 170 (value > 170).
   */
  public static double factorial(double value) {
    
    // Check value will not cause an overflow or underflow
    if (value < 0) {
      throw new IllegalArgumentException("Underflow error in factorial - Factorials can only be applied to non-negative integers.");
    }
    int largestValue = 170;
    if (value > largestValue) {
      throw new IllegalArgumentException("Overflow error in factorial - Factorials of numbers larger than " + 
          largestValue + " cannot be calculated.");
    }
    
    // If value is not a whole number, we cannot calculate its factorial
    if (!isWholeNumber(value)) {
      throw new IllegalArgumentException("Cannot calculate factorials of fractional numbers.");
    }
    
    // Start calculation
    if (value == 0 || value == 1) {
      // Return default answer of 1
      return 1;
    }
    // Otherwise, calculate the factorial of 'value'
    double factorial = 1;
    for (double i = value; i > 1; i--) {
      factorial = factorial * i;
    }
    return factorial;
  }
  
  /**
   * Checks whether the value of a {@code double} is equivalent to an integer (whole number), irrespective of the Java definitions
   * of the primitive data types {@code short}, {@code int} and {@code long}.
   * 
   * @param d
   *          The double to evaluate.
   * @return true if the value of d is a whole number, otherwise false.
   */
  private static boolean isWholeNumber(double d) {
    return (d % 1 == 0);
  }

}
