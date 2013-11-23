/**
 * Utility.java
 */

package uk.co.bluettduncanj;


/**
 * @author Jonathan
 */
public class Utility {
  
  /**
   * Checks whether a {@code String} contains only whitespace characters, as determined by {@code Character.isWhitespace(String)}.
   * 
   * @param s
   *          The String to evaluate.
   * @return true if the String contains only whitespace characters, otherwise false.
   */
  public static boolean isFullyWhitespace(String s) {
    boolean isFullyWhitespace = true;
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isWhitespace(s.charAt(i))) {
        isFullyWhitespace = false;
      }
    }
    return isFullyWhitespace;
  }
  
  public static boolean isWholeNumber(double d) {
    return (d % 1 == 0);
  }
  
}
