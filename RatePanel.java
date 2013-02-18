import javax.swing.*;
import java.awt.*;

public class RatePanel extends JPanel {
   
   //constant declaring the rates of phone calls
   public final double DAYTIME = .25;
   public final double EVENING = .12;
   public final double OFFPEAK = .05;
   
   //components of ratepanel
   private JRadioButton daytime;
   private JRadioButton evening;
   private JRadioButton offPeak;
   private ButtonGroup bg;
   
   /**
   constructor
   */
   
   public RatePanel() {
      
      //create grid layout with three rows
      // and one column
      setLayout(new GridLayout(3,1));
      
      //create radio buttons
      daytime = new JRadioButton("Daytime - 8:00 a.m. to 5:00 p.m.", true);
      evening = new JRadioButton("Evening - 5:00 p.m. to 11:00 p.m.");
      offPeak = new JRadioButton("Off-Peak - 11:00 p.m. to 8:00 a.m.");
      
      //group the radio buttons
      bg = new ButtonGroup();
      bg.add(daytime);
      bg.add(evening);
      bg.add(offPeak);
      
      //add border around panel
      setBorder(BorderFactory.createTitledBorder("Select a Rate"));
      
      //add the radio buttons to the panel
      add(daytime);
      add(evening);
      add(offPeak);
   }
   
   /**
      getSelectedRate method
      @return the billing rate selected by user
   */
   
   public double getSelectedRate() {
      
      double selectedRate;
      
      if(daytime.isSelected()){
         selectedRate = DAYTIME;
      
      } else if(evening.isSelected()){
         selectedRate = EVENING;
      
      } else {
         selectedRate = OFFPEAK;
      }
      
      return selectedRate;
   }
}