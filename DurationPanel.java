//*********************************************************************** 
// Project: Program 6
// 
// Author: Craig Tuschhoff 
// 
// Completion time: 5 hours total 
// 
// Honor Code: I pledge that this program represents my own program code. 
// I received help from Jesse Morgan (implementing action.java) in designing 
// and debugging my program. 
//***********************************************************************


import javax.swing.*;
import java.awt.*;

public class DurationPanel extends JPanel {

   //components of CallDuration
   private JLabel minutes;
   private JTextField minutesInput;
   
   /**
      constructor
   */
   
   public DurationPanel(){
      
      //create the panel elements
      minutes = new JLabel("Minutes:");
      minutesInput = new JTextField(10);
      
      //add border
      setBorder(BorderFactory.createTitledBorder("Duration of Call"));
      
      //add components to the panel
      add(minutes);
      add(minutesInput);
   }
   
   /**
      getMinutes method
      @returns number of minutes entered
   */
   
   public String getText(){
      return(minutesInput.getText());
   }
   
   /**
      focus method requests focus on text field
   */
   
   public void focus() {
      requestFocus();
      minutesInput.requestFocus();
   }
   
   
   /**
      clearText clears the text field
   */
   
   public void clearText() {
      minutesInput.setText("");
   }
}