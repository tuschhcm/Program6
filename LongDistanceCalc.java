import java.text.DecimalFormat;
import javax.swing.*;

public class LongDistanceCalc {
   
   //instance fields
   private double selectedRate;
   private int minutesEntered;
   
   /**
      constructor
   */
   
   public LongDistanceCalc(double r, String m) {
      try{
         selectedRate = r;
         minutesEntered = Integer.parseInt(m);
         calculateCharges();
      
      } catch(NumberFormatException e) {
         invalidEntry();
      }
   }
   
   /**
      calculateCharges
   */
   
   public void calculateCharges() {
      try{
         //variables to hold rate, minutes and charges
         double charges;
         double minimumMinutes = 0;
            
         //check minutes entry
         if(minutesEntered < minimumMinutes) {
            throw new NumberFormatException("negative number");
         }
         
         //calculate charges
         charges = selectedRate * minutesEntered;
         
         //create decimal format object for output
         DecimalFormat dollar = new DecimalFormat("$0.00");
         
         //Display the Charges
         JOptionPane.showMessageDialog(null,minutesEntered +
            " minutes at the rate of " + dollar.format(selectedRate) +
            " per minute.\n Total Charges are " + dollar.format(charges), 
            "Phone Charges", JOptionPane.INFORMATION_MESSAGE);
         
      }catch(NumberFormatException e) {
         invalidEntry();      
      }
   }
      
   public void invalidEntry() {
       
      //display error message to user
      JOptionPane.showMessageDialog(null, "Minutes not valid.", 
         "Input Error", JOptionPane.ERROR_MESSAGE);
   }
}