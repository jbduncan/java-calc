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

import com.lrdev.bn.BigRational;

/**
 * @author Jonathan Bluett-Duncan
 */
public class InfixEvaluator {

  private static final Map<String, OperatorInfo> OPERATORS = getOperators();

  private InfixEvaluator() {}
  
  public static BigRational evaluate(List<String> expression) {
    List<String> rpnExpression = shunt(expression);
    BigRational result = RPNEvaluator.evaluate(rpnExpression);
    return result;
  }

  private static List<String> shunt(List<String> infixExpression) {
    
    List<String> outputQueue = new ArrayList<String>();
    Deque<String> operatorStack = new ArrayDeque<String>();
    
    for (String token : infixExpression) {
      
      if (isNumeric(token)) {
        outputQueue.add(token);
      }
      else if (isOperator(token)) {
        String o1 = token;
        String o2;
        while (isOperator(o2 = operatorStack.peek())) {
          if ((isLeftAssociative(o1) && isEqualPrecedence(o1, o2)) || isLessPrecedence(o1, o2)) {
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
    
    return outputQueue;
    
  }

  private static boolean isNumeric(String s) {
    try {
      Double.parseDouble(s);
    }
    catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  private static boolean isOperator(String s) {
    return OPERATORS.containsKey(s);
  }

  private static boolean isLeftAssociative(String o) {
    return OPERATORS.get(o).getAssociativity() == Associativity.LEFT;
  }

  private static boolean isEqualPrecedence(String o1, String o2) {
    Precedence p1 = OPERATORS.get(o1).getPrecedence();
    Precedence p2 = OPERATORS.get(o2).getPrecedence();
    return p1.equalsPrecedence(p2);
  }

  private static boolean isLessPrecedence(String o1, String o2) {
    Precedence p1 = OPERATORS.get(o1).getPrecedence();
    Precedence p2 = OPERATORS.get(o2).getPrecedence();
    return p1.isLessPrecedence(p2);
  }
  
  private static Map<String, OperatorInfo> getOperators() {
    Map<String, OperatorInfo> operators = new HashMap<String, OperatorInfo>();
    operators.put("+", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    operators.put("-", new OperatorInfo(Precedence.ADDITIVE, Associativity.LEFT));
    operators.put("*", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
    operators.put("/", new OperatorInfo(Precedence.MULTIPLICATIVE, Associativity.LEFT));
    return operators;
  }

}
