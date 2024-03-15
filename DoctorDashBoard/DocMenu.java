package MedEaseNavigator.DoctorDashBoard;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import MedEaseNavigator.UtilityModule.GUIUtil;

public class DocMenu {
    JFrame DocFrame;
    JMenuBar MenuBar;
    JMenu Doctor;
    JMenuItem UserName,Password;
    public DocMenu(JFrame docframe){
        this.DocFrame=docframe;
        MenuBar= new JMenuBar();
        MenuBar.setBounds(0, 0, docframe.getWidth(), 30);
        MenuBar.setBackground(GUIUtil.Dark_BLue);
        Doctor =new JMenu("Doctor")	;
        Doctor.setFont(GUIUtil.TimesBold);
        Doctor.setForeground(GUIUtil.Dark_BLue);
        MenuBar.add(Doctor);
        





    }
}
