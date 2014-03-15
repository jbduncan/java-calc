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
  
  private List<String> expr;
  private List<String> outputQueue;
  private Deque<String> operatorStack;
  private static final Map<String, OperatorInfo> OPERATORS = operators();
  
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
      } else if (isOperator(token)) {
        String o1 = token;
        String o2 = operatorStack.peek();
        while ( 
            isOperator(o2) 
            && ((isLeftAssociative(o1) && hasEqualPrecedence(o1, o2)) 
                || hasLessPrecedence(o1, o2)) 
        ) {
          outputQueue.add(operatorStack.pop());
          o2 = operatorStack.peek();
        }
        operatorStack.push(o1);
      } else if ("(".equals(token)) {
        operatorStack.push(token);
      } else if (")".equals(token)) {
        while (!"(".equals(operatorStack.peek())) {
          
          if (operatorStack.isEmpty()) {
            throw new IllegalArgumentException("Mismatched parenthesis in input");
          }
          
          // Pop off "("
          outputQueue.add(operatorStack.pop());
        }
        operatorStack.pop();
      } else {
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
  
  private static Map<String, OperatorInfo> operators() {
    Map<String, OperatorInfo> map = new HashMap<String, OperatorInfo>();
    map.put("+", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    map.put("-", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    map.put("*", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
    map.put("/", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
    return map;
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
  
  private boolean hasEqualPrecedence(String o1, String o2) {
    Precedence p1 = OPERATORS.get(o1).getPrecedence();
    Precedence p2 = OPERATORS.get(o2).getPrecedence();
    return p1.isEqualTo(p2);
  }
  
  private boolean hasLessPrecedence(String o1, String o2) {
    Precedence p1 = OPERATORS.get(o1).getPrecedence();
    Precedence p2 = OPERATORS.get(o2).getPrecedence();
    return p1.isLessThan(p2);
  }
  
}
