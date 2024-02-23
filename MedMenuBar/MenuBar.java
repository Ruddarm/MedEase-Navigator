package MedEaseNavigator.MedMenuBar;

import javax.swing.JMenuBar;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.DoctorDashBoard.MedDoctorDashBoard;
import MedEaseNavigator.UtilityModule.GUIUtil;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class MenuBar implements ActionListener {
    JMenuBar menubar;
    JMenuItem AdminLog, DocLog;
    DBOperation DBO;
    JMenuItem Doclogin;

    public MenuBar(JFrame medFrame, DBOperation DBO) {
        menubar = new JMenuBar();
        this.DBO = DBO;
        AdminLog = new JMenu("Admin");
        DocLog = new JMenu("Doctor");
        AdminLog.setForeground(GUIUtil.WhiteClr);
        DocLog.setForeground(GUIUtil.WhiteClr);
        menubar.add(AdminLog);
        menubar.add(DocLog);
        medFrame.add(menubar);
        Doclogin = new JMenuItem("login");
        Doclogin.setSize(150, 30);
        Doclogin.setBackground(GUIUtil.Dark_BLue);
        Doclogin.setForeground(GUIUtil.WhiteClr);
        Doclogin.setFocusPainted(false);
        Doclogin.addActionListener(this);
        DocLog.add(Doclogin);
        menubar.setBounds(0, 0, 1440, 30);
        menubar.setBackground(GUIUtil.Dark_BLue);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Doclogin) {
            new MedDoctorDashBoard(DBO);
        }
    }
}
