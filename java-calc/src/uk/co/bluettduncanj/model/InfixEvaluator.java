/**
 * InfixEvaluator.java
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
public class InfixEvaluator {

  private static final Map<String, OperatorInfo> OPERATORS;
  private List<String>                           expr;
  private Deque<String>                          operatorStack;
  private List<String>                           outputQueue;

  static {
    OPERATORS = new HashMap<String, OperatorInfo>();
    OPERATORS.put("+", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    OPERATORS.put("-", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    OPERATORS.put("*", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
    OPERATORS.put("/", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
  }

  public InfixEvaluator(List<String> expr) {
    this.expr = expr;
    this.operatorStack = new ArrayDeque<String>();
    this.outputQueue = new ArrayList<String>();
  }

  /**
   * Evaluates the mathematical infix expression <code>expr</code> and returns the result as a String.
   * 
   * @return the result of <code>expr</code>.
   */
  public String evaluate() {
    shunt();
    RPNEvaluator r = new RPNEvaluator(outputQueue);
    return r.evaluate();
  }

  private void shunt() {
    
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
        while (!("(".equals(operatorStack.peek()))) {

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
    
    while (!(operatorStack.isEmpty())) {
      String o = operatorStack.peek();
      if ("(".equals(o) || ")".equals(o)) {
        throw new IllegalArgumentException("Invalid expression");
      }
      outputQueue.add(operatorStack.pop());
    }
    
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

}
