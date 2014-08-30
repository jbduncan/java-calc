/**
 * GUI.java
 */

package uk.co.bluettduncanj.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import net.miginfocom.swing.MigLayout;

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
  private JButton     btn1;
  private JButton     btn2;
  private JButton     btn3;
  private JButton     btn4;
  private JButton     btn5;
  private JButton     btn6;
  private JButton     btn7;
  private JButton     btn8;
  private JButton     btn9;
  private JButton     btn0;
  private JButton     btnBackspace;
  private JButton     btnClear;
  private JButton     btnAdd;
  private JButton     btnSubtract;
  private JButton     btnMultiply;
  private JButton     btnDivide;
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
   * Create the application.
   */
  public GUI() {
    initLookAndFeel();
    this.initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    this.frmJcalculator = new JFrame();
    this.frmJcalculator.setResizable(false);
    this.frmJcalculator.setTitle("JCalculator");
    this.frmJcalculator.setBounds(100, 100, 361, 276);
    this.frmJcalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frmJcalculator.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][grow][grow][grow]"));

    this.txtExpression = new JTextField();
    this.txtExpression.setEditable(false);
    this.txtExpression.setBackground(UIManager.getColor("TextField.background"));
    this.txtExpression.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    this.txtExpression.setHorizontalAlignment(SwingConstants.TRAILING);
    this.frmJcalculator.getContentPane().add(this.txtExpression, "cell 0 0 5 1,growx");
    this.txtExpression.setColumns(12);

    this.txtResult = new JTextField();
    this.txtResult.setEditable(false);
    this.txtResult.setBackground(UIManager.getColor("TextField.background"));
    this.txtResult.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
    this.txtResult.setHorizontalAlignment(SwingConstants.TRAILING);
    this.frmJcalculator.getContentPane().add(this.txtResult, "cell 0 1 5 1,growx");
    this.txtResult.setColumns(10);

    this.btn7 = new JButton("7");
    this.btn7.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn7, "cell 0 2,grow");

    this.btn8 = new JButton("8");
    this.btn8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn8, "cell 1 2,grow");

    this.btn9 = new JButton("9");
    this.btn9.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn9, "cell 2 2,grow");

    this.btnBackspace = new JButton("\u2190");
    this.btnBackspace.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnBackspace, "cell 3 2,grow");

    this.btnClear = new JButton("C");
    this.btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnClear, "cell 4 2,grow");

    this.btn4 = new JButton("4");
    this.btn4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn4, "cell 0 3,grow");

    this.btn5 = new JButton("5");
    this.btn5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn5, "cell 1 3,grow");

    this.btn6 = new JButton("6");
    this.btn6.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn6, "cell 2 3,grow");

    this.btnMultiply = new JButton("\u00D7");
    this.btnMultiply.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnMultiply, "cell 3 3,grow");

    this.btnDivide = new JButton("\u00F7");
    this.btnDivide.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnDivide, "cell 4 3,grow");

    this.btn1 = new JButton("1");
    this.btn1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn1, "cell 0 4,grow");

    this.btn2 = new JButton("2");
    this.btn2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn2, "cell 1 4,grow");

    this.btn3 = new JButton("3");
    this.btn3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn3, "cell 2 4,grow");

    this.btnAdd = new JButton("+");
    this.btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnAdd, "cell 3 4,grow");

    this.btnSubtract = new JButton("-");
    this.btnSubtract.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnSubtract, "cell 4 4,grow");

    this.btn0 = new JButton("0");
    this.btn0.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btn0, "cell 0 5 2 1,grow");

    this.btnDecimalPlace = new JButton(".");
    this.btnDecimalPlace.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnDecimalPlace, "cell 2 5,grow");

    this.btnEquals = new JButton("=");
    this.btnEquals.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    this.frmJcalculator.getContentPane().add(this.btnEquals, "cell 3 5 2 1,grow");

    this.menuBar = new JMenuBar();
    this.frmJcalculator.setJMenuBar(this.menuBar);

    this.mnEdit = new JMenu(" Edit ");
    this.menuBar.add(this.mnEdit);

    this.mntmCopy = new JMenuItem(" Copy ");
    this.mnEdit.add(this.mntmCopy);

    this.mntmPaste = new JMenuItem(" Paste ");
    this.mnEdit.add(this.mntmPaste);

    this.separatorEdit = new JSeparator();
    this.mnEdit.add(this.separatorEdit);

    this.mntmQuit = new JMenuItem(" Quit ");
    this.mnEdit.add(this.mntmQuit);

    this.mnHelp = new JMenu(" Help ");
    this.menuBar.add(this.mnHelp);

    this.mntmAbout = new JMenuItem(" About ");
    this.mnHelp.add(this.mntmAbout);

    // Pack the components as small as possible
    this.frmJcalculator.pack();
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
          if (THEME.equals("DefaultMetal")) {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
          }
          else if (THEME.equals("Ocean")) {
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
          }
          else {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
          }

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

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
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

}
