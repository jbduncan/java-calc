/**
 * GUI.java
 */

package uk.co.bluettduncanj;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Jonathan
 */
public class GUI {

  private JFrame     frmCalculator;
  private JTextField txtInputOutput;
  private JButton    btnCalculate;
  private JButton    btnDecimalPoint;
  private JButton[]  btnNums;
  private JButton    btnSpace;
  private JButton    btnAdd;
  private JButton    btnSubtract;
  private JButton    btnMultiply;
  private JButton    btnDivide;
  private Font       commonFont;

  /**
   * Create the application.
   */
  public GUI() {
    this.initialize();
  }

  private void appendText(String newText) {
    String currentText = this.txtInputOutput.getText();
    currentText += newText;
    this.txtInputOutput.setText(currentText);
  }

  private void back() {
    String currentText = this.txtInputOutput.getText();
    if (!currentText.isEmpty()) {
      currentText = currentText.substring(0, currentText.length() - 1);
      this.txtInputOutput.setText(currentText);
    }
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

    String output = "";

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

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    this.commonFont = new Font("Tahoma", Font.PLAIN, 16);

    this.frmCalculator = new JFrame();
    this.frmCalculator.setResizable(false);
    this.frmCalculator.setTitle("RPN Calculator");
    this.frmCalculator.setBounds(100, 100, 417, 265);
    this.frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frmCalculator.getContentPane().setLayout(null);

    this.txtInputOutput = new JTextField();
    this.txtInputOutput.setFocusTraversalKeysEnabled(false);
    this.txtInputOutput.addKeyListener(new KeyListener() {

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
            GUI.this.appendText(String.valueOf(key));
        }
      }

    });
    this.txtInputOutput.setBackground(Color.WHITE);
    this.txtInputOutput.setEditable(false);
    this.txtInputOutput.setHorizontalAlignment(SwingConstants.RIGHT);
    this.txtInputOutput.setFont(this.commonFont);
    this.txtInputOutput.setBounds(10, 11, 390, 31);
    this.frmCalculator.getContentPane().add(this.txtInputOutput);
    this.txtInputOutput.setColumns(10);

    this.btnCalculate = new JButton("=");
    this.btnCalculate.setFocusTraversalKeysEnabled(false);
    this.btnCalculate.setFocusable(false);
    this.btnCalculate.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        GUI.this.calculate();
      }
    });
    this.btnCalculate.setFont(this.commonFont);
    this.btnCalculate.setBounds(170, 190, 70, 35);
    this.frmCalculator.getContentPane().add(this.btnCalculate);

    this.btnNums = new JButton[10];
    for (int i = 0; i < 10; i++) {
      this.btnNums[i] = new JButton(String.valueOf(i));
      this.btnNums[i].setFocusTraversalKeysEnabled(false);
      this.btnNums[i].setFocusable(false);
      this.btnNums[i].addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          JButton btn = (JButton) e.getSource();
          GUI.this.appendText(btn.getText());
        }
      });
      this.btnNums[i].setFont(this.commonFont);
    }
    this.btnNums[0].setBounds(10, 190, 70, 35);
    this.btnNums[1].setBounds(10, 143, 70, 35);
    this.btnNums[2].setBounds(90, 143, 70, 35);
    this.btnNums[3].setBounds(170, 143, 70, 35);
    this.btnNums[4].setBounds(10, 98, 70, 35);
    this.btnNums[5].setBounds(90, 98, 70, 35);
    this.btnNums[6].setBounds(170, 98, 70, 35);
    this.btnNums[7].setBounds(10, 53, 70, 35);
    this.btnNums[8].setBounds(90, 53, 70, 35);
    this.btnNums[9].setBounds(170, 53, 70, 35);
    for (int i = 0; i < 10; i++) {
      this.frmCalculator.getContentPane().add(this.btnNums[i]);
    }

    this.btnDecimalPoint = new JButton(".");
    this.btnDecimalPoint.setFocusTraversalKeysEnabled(false);
    this.btnDecimalPoint.setFocusable(false);
    this.btnDecimalPoint.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.appendText(GUI.this.btnDecimalPoint.getText());
      }
    });
    this.btnDecimalPoint.setFont(this.commonFont);
    this.btnDecimalPoint.setBounds(90, 190, 70, 35);
    this.frmCalculator.getContentPane().add(this.btnDecimalPoint);

    JButton btnClear = new JButton("C");
    btnClear.setFocusTraversalKeysEnabled(false);
    btnClear.setFocusable(false);
    btnClear.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        GUI.this.clear();
      }
    });
    btnClear.setFont(this.commonFont);
    btnClear.setBounds(330, 53, 70, 35);
    this.frmCalculator.getContentPane().add(btnClear);

    JButton btnBack = new JButton("<-");
    btnBack.setFocusTraversalKeysEnabled(false);
    btnBack.setFocusable(false);
    btnBack.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.back();
      }
    });
    btnBack.setFont(this.commonFont);
    btnBack.setBounds(250, 53, 70, 35);
    this.frmCalculator.getContentPane().add(btnBack);

    this.btnMultiply = new JButton("*");
    this.btnMultiply.setFocusTraversalKeysEnabled(false);
    this.btnMultiply.setFocusable(false);
    this.btnMultiply.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.appendText(GUI.this.btnMultiply.getText());
      }
    });
    this.btnMultiply.setFont(this.commonFont);
    this.btnMultiply.setBounds(250, 98, 70, 35);
    this.frmCalculator.getContentPane().add(this.btnMultiply);

    this.btnDivide = new JButton("/");
    this.btnDivide.setFocusTraversalKeysEnabled(false);
    this.btnDivide.setFocusable(false);
    this.btnDivide.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.appendText(GUI.this.btnDivide.getText());
      }
    });
    this.btnDivide.setFont(this.commonFont);
    this.btnDivide.setBounds(330, 98, 70, 35);
    this.frmCalculator.getContentPane().add(this.btnDivide);

    this.btnAdd = new JButton("+");
    this.btnAdd.setFocusTraversalKeysEnabled(false);
    this.btnAdd.setFocusable(false);
    this.btnAdd.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.appendText(GUI.this.btnAdd.getText());
      }
    });
    this.btnAdd.setFont(this.commonFont);
    this.btnAdd.setBounds(250, 144, 70, 35);
    this.frmCalculator.getContentPane().add(this.btnAdd);

    this.btnSubtract = new JButton("-");
    this.btnSubtract.setFocusTraversalKeysEnabled(false);
    this.btnSubtract.setFocusable(false);
    this.btnSubtract.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.appendText(GUI.this.btnSubtract.getText());
      }
    });
    this.btnSubtract.setFont(this.commonFont);
    this.btnSubtract.setBounds(330, 144, 70, 35);
    this.frmCalculator.getContentPane().add(this.btnSubtract);

    this.btnSpace = new JButton("Space");
    this.btnSpace.setFocusTraversalKeysEnabled(false);
    this.btnSpace.setFocusable(false);
    this.btnSpace.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        GUI.this.appendText(" ");
      }
    });
    this.btnSpace.setFont(this.commonFont);
    this.btnSpace.setBounds(250, 190, 150, 35);
    this.frmCalculator.getContentPane().add(this.btnSpace);
  }

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

      @Override
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
}
