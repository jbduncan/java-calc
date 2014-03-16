/**
 * Evaluator.java
 */

package uk.co.bluettduncanj.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jonathan Bluett-Duncan
 */
public class Evaluator {

  private static final Map<String, OperatorInfo> OPERATORS;
  private List<String>                           expr;
  private List<String>                           outputQueue;
  private Deque<String>                          operatorStack;

  static {
    OPERATORS = new HashMap<String, OperatorInfo>();
    OPERATORS.put("+", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    OPERATORS.put("-", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    OPERATORS.put("*", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
    OPERATORS.put("/", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
  }

  public Evaluator(List<String> expr) {
    this.expr = expr;
    this.outputQueue = new ArrayList<String>(expr.size());
    this.operatorStack = new ArrayDeque<String>(expr.size());
  }

  /**
   * Evaluates the mathematical infix expression <code>expr</code> and returns the result as a String.
   * 
   * @return the result of <code>expr</code>.
   */
  public String evaluate() {
    List<String> rpnExpr = shuntingYard();
    RPNEvaluator r = new RPNEvaluator(rpnExpr);
    return r.evaluate();
  }

  private List<String> shuntingYard() {
    outputQueue.clear();
    operatorStack.clear();
    for (String token : expr) {
      if (isNumeric(token)) {
        outputQueue.add(token);
      }
      else if (isOperator(token)) {
        String o1 = token;
        String o2;
        while (isOperator(o2 = operatorStack.peek())) {
          if ((isLeftAssociative(o1) && haveEqualPrecedence(o1, o2)) || haveLessPrecedence(o1, o2)) {
            outputQueue.add(operatorStack.pop());
          }
        }
        operatorStack.push(o1);
      }
      else if ("(".equals(token)) {
        operatorStack.push(token);
      }
      else if (")".equals(token)) {
        while (!"(".equals(operatorStack.peek())) {

          if (operatorStack.isEmpty()) {
            throw new IllegalArgumentException("Mismatched parenthesis in input");
          }

          // Pop off "("
          outputQueue.add(operatorStack.pop());
        }
        operatorStack.pop();
      }
      else {
        throw new IllegalArgumentException(String.format("Invalid token: %s", token));
      }
    }
    while (!operatorStack.isEmpty()) {
      String o = operatorStack.peek();
      if ("(".equals(o) || ")".equals(o)) {
        throw new IllegalArgumentException("Invalid expression");
      }
      outputQueue.add(operatorStack.pop());
    }

    return outputQueue;
  }

  private boolean isNumeric(String s) {
    try {
      Double.parseDouble(s);
    }
    catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  private boolean isOperator(String s) {
    return OPERATORS.containsKey(s);
  }

  private boolean isLeftAssociative(String o) {
    return OPERATORS.get(o).getAssociativity() == Associativity.LEFT;
  }

  private boolean haveEqualPrecedence(String o1, String o2) {
    Precedence p1 = OPERATORS.get(o1).getPrecedence();
    Precedence p2 = OPERATORS.get(o2).getPrecedence();
    return p1.equalsPrecedence(p2);
  }

  private boolean haveLessPrecedence(String o1, String o2) {
    Precedence p1 = OPERATORS.get(o1).getPrecedence();
    Precedence p2 = OPERATORS.get(o2).getPrecedence();
    return p1.isLessPrecedence(p2);
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
    result = prime * result + ((this.expr == null) ? 0 : this.expr.hashCode());
    result = prime * result + ((this.operatorStack == null) ? 0 : this.operatorStack.hashCode());
    result = prime * result + ((this.outputQueue == null) ? 0 : this.outputQueue.hashCode());
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
    if (!(obj instanceof Evaluator)) {
      return false;
    }
    Evaluator other = (Evaluator) obj;
    if (this.expr == null) {
      if (other.expr != null) {
        return false;
      }
    }
    else if (!this.expr.equals(other.expr)) {
      return false;
    }
    if (this.operatorStack == null) {
      if (other.operatorStack != null) {
        return false;
      }
    }
    else if (!this.operatorStack.equals(other.operatorStack)) {
      return false;
    }
    if (this.outputQueue == null) {
      if (other.outputQueue != null) {
        return false;
      }
    }
    else if (!this.outputQueue.equals(other.outputQueue)) {
      return false;
    }
    return true;
  }

}
