/**
 * GUI.java
 */

package uk.co.bluettduncanj.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.GridBagLayout;


/**
 * @author Jonathan Bluett-Duncan
 */
public class GUI {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      public void run() {
        try {
          GUI window = new GUI();
          window.frame.setVisible(true);
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
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{0};
    gridBagLayout.rowHeights = new int[]{0};
    gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
    frame.getContentPane().setLayout(gridBagLayout);
  }

}
