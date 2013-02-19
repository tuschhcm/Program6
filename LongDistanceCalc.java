import java.text.DecimalFormat;
import javax.swing.*;

public class LongDistanceCalc {
   
   //instance fields
   private double selectedRate, charges;
   private int minutesEntered;
   private double minimumMinutes = 0;
   
   /**
      constructor
   */
   
   public LongDistanceCalc(double r, String m) {
      try{
         
         //move data into instance fields
         selectedRate = r;
         minutesEntered = Integer.parseInt(m);
         
         //check minutes entry
         if(minutesEntered < minimumMinutes) {
            throw new NumberFormatException("negative number");
         }
         
         //once all data is good, call this
         calculateCharges();
      
      } catch(NumberFormatException e) {
         
         //display error message to user
         JOptionPane.showMessageDialog(null, "Minutes not valid.", 
            "Input Error", JOptionPane.ERROR_MESSAGE);
      }
   }
   
   /**
      calculateCharges method displays the charges
   */
   
   public void calculateCharges() {
            
      //calculate charges
      charges = selectedRate * minutesEntered;
      
      //create decimal format object for output
      DecimalFormat dollar = new DecimalFormat("$0.00");
      
      //Display the Charges
      JOptionPane.showMessageDialog(null,minutesEntered +
         " minutes at the rate of " + dollar.format(selectedRate) +
         " per minute.\n Total Charges are " + dollar.format(charges), 
         "Phone Charges", JOptionPane.INFORMATION_MESSAGE);
   }
}
