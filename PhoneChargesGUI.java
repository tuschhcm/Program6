import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PhoneChargesGUI extends JFrame {
   private RatePanel rate;
   private DurationPanel duration;
   private JPanel buttonPanel;
   private JButton calcButton;
   
   public PhoneChargesGUI() {
      
      //display a title
      setTitle("Program 6");
      
      //specify an action for the close button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //create a border layout manager
      setLayout(new BorderLayout());
      
      //create the panels
      rate = new RatePanel();
      duration = new DurationPanel();
      
      // create the button panel
      buildButtonPanel();
      
      //setup action handlers
      rate.rateSelectedAction(new Action() {
         public void onAction(){
            duration.focus();
         }
      });
      
      //add the components to the content pane
      add(rate, BorderLayout.NORTH);
      add(duration, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
            
      //pack and set defaults
      pack();
      getRootPane().setDefaultButton(calcButton);
      setLocationRelativeTo(null);
      duration.focus();
      
      //Make window visible
      setVisible(true);
   }

   /**
      buildButtonPanel method builds buttonPanel
   */
   
   private void buildButtonPanel() {
   
      //create a panel fot the button
      buttonPanel = new JPanel();
      
      //create the button
      calcButton = new JButton("Calculate Charges");
      
      //register action listener
      calcButton.addActionListener(new CalcButtonListener());
      
      // add the buttons to the button panel
      buttonPanel.add(calcButton);
   } 
   
   /**
      private inner class that handles the button press
   */
   
   private class CalcButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
         //gather info from panels and send to longDistanceCalc
         new LongDistanceCalc(rate.getSelectedRate(), duration.getText());
         
         //clear text field for next entry
         duration.clearText();
      }
   }
   
   public static void main(String[] args) {
      new PhoneChargesGUI();
   }
}