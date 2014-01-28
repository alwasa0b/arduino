/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonDemo extends JPanel
                             implements ActionListener {
    static String birdString = "cToF";
    static String pigString = "fToC";
    
    final JTextField textArea=new JTextField(20);
    final JTextField loginName = new JTextField(20);
 
 
    public void fToC(JTextField loginName){
    	
    	double y = Double.parseDouble(loginName.getText());
    	double f = (y*9/5)+32 ;
    	textArea.setText(Double.toString(f));
    	loginName.selectAll();
    }
    
    public void cToF(JTextField loginName){
    	double y = Double.parseDouble(loginName.getText());
    	double c = (y-32) * 5/9;
    	textArea.setText(Double.toString(c));
    	loginName.selectAll();
    }
    
    public RadioButtonDemo() {
        super(new BorderLayout());
 
        //Create the radio buttons.
        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);
 
      
  
 
        JRadioButton pigButton = new JRadioButton(pigString);
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand(pigString);
        
     //   JButton convert = new JButton( "convert");
      
       // convert.setActionCommand( "convert");

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
 
        group.add(pigButton);
 
        //Register a listener for the radio buttons.
        birdButton.addActionListener(this);
       
        
       
        pigButton.addActionListener(this);
        //convert.addActionListener(this);
 
        //Set up the picture label.
       
 
        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image.
        //A real program would compute this.
      
 
 
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel();
        radioPanel.add(birdButton);
        radioPanel.add(pigButton);
       // radioPanel.add(convert);
        radioPanel.add(loginName);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        radioPanel.add(textArea);
 
        add(radioPanel, BorderLayout.LINE_START);
       
       
    }
 
    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
    		e.getActionCommand();
    		if (e.getActionCommand()==pigString){
    			cToF(loginName);
    		}
    		if (e.getActionCommand()==birdString){
    			fToC(loginName);
    		}
                                        
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */

 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new RadioButtonDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}