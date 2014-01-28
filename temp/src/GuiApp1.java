//could just import javax.swing.* and java.awt.* etc..
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GuiApp1 {
    
    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {
        
        new GuiApp1();
    }

    public GuiApp1()
    {
        JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example GUI");
        guiFrame.setSize(700,250);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        //Options for the JComboBox 
        String[] fruitOptions = {"Apple", "Apricot", "Banana"
                ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"};
        
        //Options for the JList
        String[] vegOptions = {"Asparagus", "Beans", "Broccoli", "Cabbage"
                , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom"
                , "Pepper", "Radish", "Shallot", "Spinach", "Swede"
                , "Turnip"};
        
        //The first JPanel contains a JLabel and JCombobox
        final JPanel comboPanel = new JPanel();
        JLabel comboLbl = new JLabel("Fruits:");
        JComboBox fruits = new JComboBox(fruitOptions);
        JRadioButton temp = new JRadioButton();
        
        comboPanel.add(comboLbl);
        comboPanel.add(fruits);
        
        //Create the second JPanel. Add a JLabel and JList and
        //make use the JPanel is not visible.
        final JPanel listPanel = new JPanel();
        listPanel.setVisible(false);
        JLabel listLbl = new JLabel("Vegetables:");
        JLabel label = new JLabel("Hello World");
        final String birdString = "Bird";
        final JRadioButton birdButton = new JRadioButton("C to F");
        final JRadioButton jRadioButtonA = new JRadioButton("C to F");
        final JRadioButton jRadioButtonB = new JRadioButton("F to C");
        
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        final JTextField loginName = new JTextField(20);
       // group.add(catButton);
        
        JList vegs = new JList(vegOptions);
        vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
          
        listPanel.add(listLbl);
        listPanel.add(vegs);
        final TextArea textArea=new TextArea();
        
       
        
        JButton vegFruitBut = new JButton( "veg");
        JButton convert = new JButton( "convert");
        //The ActionListener class is used to handle the
        //event that happens when the user clicks the button.
        //As there is not a lot that needs to happen we can 
        //define an anonymous inner class to make the code simpler.
        
        vegFruitBut.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
               //When the fruit of veg button is pressed
               //the setVisible value of the listPanel and
               //comboPanel is switched from true to 
               //value or vice versa.
               listPanel.setVisible(!listPanel.isVisible());
               comboPanel.setVisible(!comboPanel.isVisible());

            }
        });
        
        convert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
               //When the fruit of veg button is pressed
               //the setVisible value of the listPanel and
               //comboPanel is switched from true to 
               //value or vice versa.
               listPanel.setVisible(!listPanel.isVisible());
               comboPanel.setVisible(!comboPanel.isVisible());

            }
        });

        JButton buttonReadRadio = new JButton(" Read Radio Buttons ");
        buttonReadRadio.addActionListener(new ActionListener(){
        	  
            @Override
            public void actionPerformed(ActionEvent ae) {
                String radioSetting = "";
                jRadioButtonA.addActionListener(this);
                
                if (jRadioButtonA.isSelected()){
                    //radioSetting += "jRadioButtonA is selected.\n";
                    System.out.print(true);
                    String text = loginName.getText();
                    textArea.append(text);
                    loginName.selectAll();
                    jRadioButtonB.setSelected(false);
                }
          
                if (jRadioButtonB.isSelected()){
                    //radioSetting += "jRadioButtonA is selected.\n";
                    System.out.print(false);
                    jRadioButtonA.setSelected(false);
                }
   
                 
            }
        });
         
        //The JFrame uses the BorderLayout layout manager.
        //Put the two JPanels and JButton in different areas.
        guiFrame.add(comboPanel, BorderLayout.NORTH);
        comboPanel.add(jRadioButtonA);
        comboPanel.add(jRadioButtonB);
        comboPanel.add(loginName);
        comboPanel.add(textArea);
        //guiFrame.add(listPanel, BorderLayout.CENTER);
       // guiFrame.add(vegFruitBut,BorderLayout.SOUTH);
        guiFrame.add(temp,BorderLayout.CENTER);
        guiFrame.add(buttonReadRadio,BorderLayout.SOUTH);
        //make sure the JFrame is visible
        guiFrame.setVisible(true);
        
        
    }
    
}