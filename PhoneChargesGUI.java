import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PhoneChargesGUI extends JFrame {
   private RatePanel rate;
   private DurationPanel duration;
   private JPanel buttonPanel;
   private JButton calcButton;
   
   private final int MINIMUM_MINUTES = 0;
   
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
      //rate.rateSelectedAction(new Action() {
      //   public void onAction(){
      //      duration.focus();
      //   }
      //});
      
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
         
         try{
            
            //import data into fields
            double selectedRate = rate.getSelectedRate();
            int minutesEntered = Integer.parseInt(duration.getText());
         
            //check minutes entry
            if(minutesEntered < MINIMUM_MINUTES) {
               throw new NumberFormatException("negative number");
            }
         
            //calculate charges
            double charges = selectedRate * minutesEntered;
            
            //clear text field for next entry
            duration.clearText();
      
            //create decimal format object for output
            DecimalFormat dollar = new DecimalFormat("$0.00");
      
            //Display the Charges
            JOptionPane.showMessageDialog(null,minutesEntered +
               " minutes at the rate of " + dollar.format(selectedRate) +
               " per minute.\n Total Charges are " + dollar.format(charges), 
               "Phone Charges", JOptionPane.INFORMATION_MESSAGE);
      
         } catch(NumberFormatException a) {
         
            //clear text field for next entry
            duration.clearText();
            
            //display error message to user
            JOptionPane.showMessageDialog(null, "Minutes not valid.", 
               "Input Error", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   /**
      start the app
   */
   
   public static void main(String[] args) {
      new PhoneChargesGUI();
   }
}