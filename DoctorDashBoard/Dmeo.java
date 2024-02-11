package MedEaseNavigator.DoctorDashBoard;

// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JScrollBar;
// import javax.swing.JScrollPane;

// import MedEaseNavigator.UtilityModule.GUIUtil;

// public class Dmeo {
//     public static void main(String[] args) {
//         JScrollBar jsb= new JScrollBar();
//         jsb.setBounds(390, 0, 10, 400);
//         JFrame jf=new JFrame();
//         jf.setSize(800, 700);
//         jf.setLayout(null);
//         JPanel jp = new JPanel();
//         jp.setBounds(0,0,100, 900);
//         jp.setBackground(GUIUtil.Dark_BLue);
//         JPanel pp2=new JPanel();
//         pp2.setBackground(GUIUtil.WhiteClr);;
//         jp.setBounds(50, 100, 400, 400);
//         jp.setLayout(null);
//         jp.add(jsb);
//         jf.add(jp);
//         jf.setVisible(true);
//     }
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dmeo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrollable Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Add some components to exceed the visible area
        
        // for (int i = 0; i < 20; i++) {
        //     contentPanel.add(new JLabel("Label " + i));
        // }
        JLabel tyr =new JLabel("this is");
        tyr.setBounds(10, 10, 100, 20);
        contentPanel.add(tyr);
        
        // Set the preferred size of the content panel
        contentPanel.setPreferredSize(new Dimension(200, 400)); // Set the preferred size to be larger than the frame

        // Create a vertical scrollbar
        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, contentPanel.getPreferredSize().height);

        verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = e.getValue();
                contentPanel.setLocation(contentPanel.getX(), -value);
            }
        });

        // Add the scrollbar to the frame
        frame.add(verticalScrollBar, BorderLayout.EAST);
        
        // Add the contentPanel to the frame
        frame.add(contentPanel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}
