package MedEaseNavigator.MedMenuBar;

import javax.swing.JMenuBar;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.DoctorDashBoard.MedDoctorDashBoard;
import MedEaseNavigator.UtilityModule.GUIUtil;

import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MenuBar implements ActionListener{
    JMenuBar menubar;
    JMenu AdminLog, DocLog;
    DBOperation DBO;
    public MenuBar(JFrame medFrame, DBOperation DBO) {
        menubar = new JMenuBar();
        AdminLog = new JMenu("Admin Login ");
        DocLog = new JMenu("Doctor Login");
        AdminLog.setForeground(GUIUtil.WhiteClr);
        DocLog.setForeground(GUIUtil.WhiteClr);
        menubar.add(AdminLog);
        menubar.add(DocLog);
        medFrame.add(menubar);
        menubar.setBounds(0, 0, 1440, 30);
        menubar.setBackground(GUIUtil.Dark_BLue);
        DocLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Dab gaya");
            }
        });
        AdminLog.addActionListener(this);   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==DocLog) {
            System.out.println("Clicked");
            new MedDoctorDashBoard(DBO);
        }
    }
}
