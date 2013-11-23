/**
 * GUI.java
 */

package uk.co.bluettduncanj;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.text.NumberFormat;


/**
 * @author Jonathan
 */
public class GUI {

  private JFrame frmCalculator;
  private JTextField txtInputOutput;
  private JButton btnCalculate;
  private JButton btn0;
  private JButton btnDecimalPoint;
  private JButton btn1;
  private JButton btn2;
  private JButton btn3;
  private JButton btn4;
  private JButton btn5;
  private JButton btn6;
  private JButton btn7;
  private JButton btn8;
  private JButton btn9;
  private JButton btnSpace;
  private JButton btnAdd;
  private JButton btnSubtract;
  private JButton btnMultiply;
  private JButton btnDivide;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

      public void run() {
        try {
          GUI window = new GUI();
          window.frmCalculator.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GUI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCalculator = new JFrame();
    frmCalculator.setResizable(false);
    frmCalculator.setTitle("RPN Calculator");
    frmCalculator.setBounds(100, 100, 417, 265);
    frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmCalculator.getContentPane().setLayout(null);
    
    txtInputOutput = new JTextField();
    txtInputOutput.setFocusTraversalKeysEnabled(false);
    txtInputOutput.addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        switch (key) {
          case ' ':
          case '1':
          case '2':
          case '3':
          case '4':
          case '5':
          case '6':
          case '7':
          case '8':
          case '9':
          case '0':
          case '.':
          case '+':
          case '-':
          case '*':
          case '/':
            appendText(String.valueOf(key));
        }
      }
      
    });
    txtInputOutput.setBackground(Color.WHITE);
    txtInputOutput.setEditable(false);
    txtInputOutput.setHorizontalAlignment(SwingConstants.RIGHT);
    txtInputOutput.setFont(new Font("Tahoma", Font.PLAIN, 16));
    txtInputOutput.setBounds(10, 11, 390, 31);
    frmCalculator.getContentPane().add(txtInputOutput);
    txtInputOutput.setColumns(10);
    
    btnCalculate = new JButton("=");
    btnCalculate.setFocusTraversalKeysEnabled(false);
    btnCalculate.setFocusable(false);
    btnCalculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        calculate();
      }
    });
    btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnCalculate.setBounds(170, 190, 70, 35);
    frmCalculator.getContentPane().add(btnCalculate);
    
    btn7 = new JButton("7");
    btn7.setFocusTraversalKeysEnabled(false);
    btn7.setFocusable(false);
    btn7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn7.getText());
      }
    });
    btn7.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn7.setBounds(10, 53, 70, 35);
    frmCalculator.getContentPane().add(btn7);
    
    btn8 = new JButton("8");
    btn8.setFocusTraversalKeysEnabled(false);
    btn8.setFocusable(false);
    btn8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn8.getText());
      }
    });
    btn8.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn8.setBounds(90, 53, 70, 35);
    frmCalculator.getContentPane().add(btn8);
    
    btn9 = new JButton("9");
    btn9.setFocusTraversalKeysEnabled(false);
    btn9.setFocusable(false);
    btn9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn9.getText());
      }
    });
    btn9.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn9.setBounds(170, 53, 70, 35);
    frmCalculator.getContentPane().add(btn9);
    
    btn4 = new JButton("4");
    btn4.setFocusTraversalKeysEnabled(false);
    btn4.setFocusable(false);
    btn4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn4.getText());
      }
    });
    btn4.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn4.setBounds(10, 98, 70, 35);
    frmCalculator.getContentPane().add(btn4);
    
    btn5 = new JButton("5");
    btn5.setFocusTraversalKeysEnabled(false);
    btn5.setFocusable(false);
    btn5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn5.getText());
      }
    });
    btn5.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn5.setBounds(90, 98, 70, 35);
    frmCalculator.getContentPane().add(btn5);
    
    btn6 = new JButton("6");
    btn6.setFocusTraversalKeysEnabled(false);
    btn6.setFocusable(false);
    btn6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn6.getText());
      }
    });
    btn6.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn6.setBounds(170, 98, 70, 35);
    frmCalculator.getContentPane().add(btn6);
    
    btn1 = new JButton("1");
    btn1.setFocusTraversalKeysEnabled(false);
    btn1.setFocusable(false);
    btn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn1.getText());
      }
    });
    btn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn1.setBounds(10, 144, 70, 35);
    frmCalculator.getContentPane().add(btn1);
    
    btn2 = new JButton("2");
    btn2.setFocusTraversalKeysEnabled(false);
    btn2.setFocusable(false);
    btn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn2.getText());
      }
    });
    btn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn2.setBounds(90, 144, 70, 35);
    frmCalculator.getContentPane().add(btn2);
    
    btn3 = new JButton("3");
    btn3.setFocusTraversalKeysEnabled(false);
    btn3.setFocusable(false);
    btn3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn3.getText());
      }
    });
    btn3.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn3.setBounds(170, 145, 70, 35);
    frmCalculator.getContentPane().add(btn3);
    
    btn0 = new JButton("0");
    btn0.setFocusTraversalKeysEnabled(false);
    btn0.setFocusable(false);
    btn0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btn0.getText());
      }
    });
    btn0.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btn0.setBounds(10, 190, 70, 35);
    frmCalculator.getContentPane().add(btn0);
    
    btnDecimalPoint = new JButton(".");
    btnDecimalPoint.setFocusTraversalKeysEnabled(false);
    btnDecimalPoint.setFocusable(false);
    btnDecimalPoint.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btnDecimalPoint.getText());
      }
    });
    btnDecimalPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnDecimalPoint.setBounds(90, 190, 70, 35);
    frmCalculator.getContentPane().add(btnDecimalPoint);
    
    JButton btnClear = new JButton("C");
    btnClear.setFocusTraversalKeysEnabled(false);
    btnClear.setFocusable(false);
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        clear();
      }
    });
    btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnClear.setBounds(330, 53, 70, 35);
    frmCalculator.getContentPane().add(btnClear);
    
    JButton btnBack = new JButton("<-");
    btnBack.setFocusTraversalKeysEnabled(false);
    btnBack.setFocusable(false);
    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        back();
      }
    });
    btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnBack.setBounds(250, 53, 70, 35);
    frmCalculator.getContentPane().add(btnBack);
    
    btnMultiply = new JButton("*");
    btnMultiply.setFocusTraversalKeysEnabled(false);
    btnMultiply.setFocusable(false);
    btnMultiply.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btnMultiply.getText());
      }
    });
    btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnMultiply.setBounds(250, 98, 70, 35);
    frmCalculator.getContentPane().add(btnMultiply);
    
    btnDivide = new JButton("/");
    btnDivide.setFocusTraversalKeysEnabled(false);
    btnDivide.setFocusable(false);
    btnDivide.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btnDivide.getText());
      }
    });
    btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnDivide.setBounds(330, 98, 70, 35);
    frmCalculator.getContentPane().add(btnDivide);
    
    btnAdd = new JButton("+");
    btnAdd.setFocusTraversalKeysEnabled(false);
    btnAdd.setFocusable(false);
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btnAdd.getText());
      }
    });
    btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnAdd.setBounds(250, 144, 70, 35);
    frmCalculator.getContentPane().add(btnAdd);
    
    btnSubtract = new JButton("-");
    btnSubtract.setFocusTraversalKeysEnabled(false);
    btnSubtract.setFocusable(false);
    btnSubtract.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(btnSubtract.getText());
      }
    });
    btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnSubtract.setBounds(330, 144, 70, 35);
    frmCalculator.getContentPane().add(btnSubtract);
    
    btnSpace = new JButton("Space");
    btnSpace.setFocusTraversalKeysEnabled(false);
    btnSpace.setFocusable(false);
    btnSpace.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        appendText(" ");
      }
    });
    btnSpace.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnSpace.setBounds(250, 190, 150, 35);
    frmCalculator.getContentPane().add(btnSpace);
  }
  
  private void calculate() {
    String input = this.txtInputOutput.getText();
    PostfixEvaluator evaluator = new PostfixEvaluator(input);
    
    double answer = 0.0;
    try {
      answer = evaluator.getResult();
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    String output = null;
    
    NumberFormat nf;
    if (Utility.isWholeNumber(answer)) {
      nf = NumberFormat.getIntegerInstance();
    }
    else {
      nf = NumberFormat.getInstance();
    }
    nf.setGroupingUsed(false);
    output = nf.format(answer);
    
    this.txtInputOutput.setText(output);
  }
  
  private void clear() {
    this.txtInputOutput.setText(null);
  }
  
  private void back() {
    String currentText = this.txtInputOutput.getText();
    if (!currentText.isEmpty()) {
      currentText = currentText.substring(0, currentText.length() - 1);
      this.txtInputOutput.setText(currentText);
    }
  }
  
  private void appendText(String newText) {
    String currentText = this.txtInputOutput.getText();
    currentText += newText;
    this.txtInputOutput.setText(currentText);
  }

  /**
   * @param e
   *
   * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
   */
  /*
  @Override
  public void keyTyped(KeyEvent e) {
    char key = e.getKeyChar();
    System.out.println(key);
  }
  */
}
