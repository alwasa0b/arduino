package javatestswing;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JFrameWin extends JFrame{
     
    public JFrameWin(){
         
        final JPanel jPanel = new JPanel();
         
        this.setTitle("java-buddy.blogspot.com");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        JButton buttonExit = new JButton(" Exit ");
        buttonExit.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
         
        final JRadioButton jRadioButtonA = new JRadioButton("JRadioButton A");
        final JRadioButton jRadioButtonB = new JRadioButton("JRadioButton B");
        final JRadioButton jRadioButtonC = new JRadioButton("JRadioButton C");
         
        JButton buttonReadRadio = new JButton(" Read Radio Buttons ");
        buttonReadRadio.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                String radioSetting = "";
                 
                if (jRadioButtonA.isSelected()){
                    radioSetting += "jRadioButtonA is selected.\n";
                }
                if (jRadioButtonB.isSelected()){
                    radioSetting += "jRadioButtonB is selected.\n";
                }
                if (jRadioButtonC.isSelected()){
                    radioSetting += "jRadioButtonC is selected.\n";
                }
                 
                JOptionPane.showMessageDialog(JFrameWin.this, radioSetting);
            }
        });
         
        jPanel.add(jRadioButtonA);
        jPanel.add(jRadioButtonB);
        jPanel.add(jRadioButtonC);
        jPanel.add(buttonReadRadio);
        jPanel.add(buttonExit);
         
        this.add(jPanel);
         
    }
}