/**
 * GUI.java
 */

package uk.co.bluettduncanj.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import org.jdesktop.xswingx.PromptSupport;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

/**
 * @author Jonathan Bluett-Duncan
 */
public class GUI {

  /**
   * Specify the look and feel to use by defining the LOOKANDFEEL constant. Valid values are: null (use the default), "Metal",
   * "System", "Motif", and "GTK".
   */
  final static String LOOKANDFEEL = "System";

  /**
   * If you choose the Metal L&F, you can also choose a theme. Specify the theme to use by defining the THEME constant. Valid values
   * are: "DefaultMetal", "Ocean", and "Test".
   */
  final static String THEME       = "DefaultMetal";

  private JFrame      frmJcalculator;
  private JTextField  txtExpression;
  private JTextField  txtResult;
  private JButton     btn7;
  private JButton     btn8;
  private JButton     btn9;
  private JButton     btnBackspace;
  private JButton     btnClear;
  private JButton     btn4;
  private JButton     btn5;
  private JButton     btn6;
  private JButton     btnMultiply;
  private JButton     btnDivide;
  private JButton     btn1;
  private JButton     btn2;
  private JButton     btn3;
  private JButton     btnAdd;
  private JButton     btnSubtract;
  private JButton     btn0;
  private JButton     btnDecimalPlace;
  private JButton     btnEquals;
  private JMenuBar    menuBar;
  private JMenu       mnEdit;
  private JMenuItem   mntmCopy;
  private JMenuItem   mntmPaste;
  private JMenu       mnHelp;
  private JMenuItem   mntmAbout;
  private JSeparator  separatorEdit;
  private JMenuItem   mntmQuit;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      public void run() {
        try {
          GUI window = new GUI();
          window.frmJcalculator.setVisible(true);
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
    initLookAndFeel();
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmJcalculator = new JFrame();
    frmJcalculator.setTitle("JCalculator");
    frmJcalculator.setBounds(100, 100, 361, 276);
    frmJcalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmJcalculator.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][grow][grow][grow]"));

    txtExpression = new JTextField();
    txtExpression.setEditable(false);
    txtExpression.setBackground(UIManager.getColor("TextField.background"));
    txtExpression.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    txtExpression.setHorizontalAlignment(SwingConstants.TRAILING);
    frmJcalculator.getContentPane().add(txtExpression, "cell 0 0 5 1,growx");
    txtExpression.setColumns(12);

    txtResult = new JTextField();
    txtResult.setEditable(false);
    txtResult.setBackground(UIManager.getColor("TextField.background"));
    txtResult.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
    txtResult.setHorizontalAlignment(SwingConstants.TRAILING);
    PromptSupport.setPrompt("0", txtResult);
    frmJcalculator.getContentPane().add(txtResult, "cell 0 1 5 1,growx");
    txtResult.setColumns(10);

    btn7 = new JButton("7");
    btn7.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn7, "cell 0 2,grow");

    btn8 = new JButton("8");
    btn8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn8, "cell 1 2,grow");

    btn9 = new JButton("9");
    btn9.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn9, "cell 2 2,grow");

    btnBackspace = new JButton("\u2190");
    btnBackspace.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnBackspace, "cell 3 2,grow");

    btnClear = new JButton("C");
    btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnClear, "cell 4 2,grow");

    btn4 = new JButton("4");
    btn4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn4, "cell 0 3,grow");

    btn5 = new JButton("5");
    btn5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn5, "cell 1 3,grow");

    btn6 = new JButton("6");
    btn6.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn6, "cell 2 3,grow");

    btnMultiply = new JButton("\u00D7");
    btnMultiply.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnMultiply, "cell 3 3,grow");

    btnDivide = new JButton("\u00F7");
    btnDivide.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnDivide, "cell 4 3,grow");

    btn1 = new JButton("1");
    btn1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn1, "cell 0 4,grow");

    btn2 = new JButton("2");
    btn2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn2, "cell 1 4,grow");

    btn3 = new JButton("3");
    btn3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn3, "cell 2 4,grow");

    btnAdd = new JButton("+");
    btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnAdd, "cell 3 4,grow");

    btnSubtract = new JButton("-");
    btnSubtract.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnSubtract, "cell 4 4,grow");

    btn0 = new JButton("0");
    btn0.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btn0, "cell 0 5 2 1,grow");

    btnDecimalPlace = new JButton(".");
    btnDecimalPlace.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnDecimalPlace, "cell 2 5,grow");

    btnEquals = new JButton("=");
    btnEquals.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    frmJcalculator.getContentPane().add(btnEquals, "cell 3 5 2 1,grow");

    menuBar = new JMenuBar();
    frmJcalculator.setJMenuBar(menuBar);

    mnEdit = new JMenu(" Edit ");
    menuBar.add(mnEdit);

    mntmCopy = new JMenuItem(" Copy ");
    mnEdit.add(mntmCopy);

    mntmPaste = new JMenuItem(" Paste ");
    mnEdit.add(mntmPaste);

    separatorEdit = new JSeparator();
    mnEdit.add(separatorEdit);

    mntmQuit = new JMenuItem(" Quit ");
    mnEdit.add(mntmQuit);

    mnHelp = new JMenu(" Help ");
    menuBar.add(mnHelp);

    mntmAbout = new JMenuItem(" About ");
    mnHelp.add(mntmAbout);
    
    // Pack the components as small as possible
    frmJcalculator.pack();
  }

  private static void initLookAndFeel() {
    String lookAndFeel;

    if (LOOKANDFEEL != null) {
      if (LOOKANDFEEL.equals("Metal")) {
        lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
      }

      else if (LOOKANDFEEL.equals("System")) {
        lookAndFeel = UIManager.getSystemLookAndFeelClassName();
      }

      else if (LOOKANDFEEL.equals("Motif")) {
        lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
      }

      else if (LOOKANDFEEL.equals("GTK")) {
        lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
      }

      else {
        System.err.println("Unexpected value of LOOKANDFEEL specified: " + LOOKANDFEEL);
        lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
      }

      try {
        UIManager.setLookAndFeel(lookAndFeel);

        // If L&F = "Metal", set the theme
        if (LOOKANDFEEL.equals("Metal")) {
          if (THEME.equals("DefaultMetal"))
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
          else if (THEME.equals("Ocean"))
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
          else
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());

          UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
      }
      catch (ClassNotFoundException e) {
        System.err.println("Couldn't find class for specified look and feel:" + lookAndFeel);
        System.err.println("Did you include the L&F library in the class path?");
        System.err.println("Using the default look and feel.");
      }
      catch (UnsupportedLookAndFeelException e) {
        System.err.println("Can't use the specified look and feel (" + lookAndFeel + ") on this platform.");
        System.err.println("Using the default look and feel.");
      }
      catch (Exception e) {
        System.err.println("Couldn't get specified look and feel (" + lookAndFeel + "), for some reason.");
        System.err.println("Using the default look and feel.");
        e.printStackTrace();
      }
    }
  }

}
