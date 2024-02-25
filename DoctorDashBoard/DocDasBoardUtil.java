package MedEaseNavigator.DoctorDashBoard;

import javax.swing.JFrame;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.UtilityModule.GUIUtil;
public class DocDasBoardUtil {
    JFrame DoctorFrame;
    DBOperation DBO;
    public DocDasBoardUtil() {
        DoctorFrame = new JFrame();
        System.out.println("ruunning");
        DoctorFrame.setTitle("Doctor Frame");
        DoctorFrame.getContentPane().setBackground(GUIUtil.Base_Background);
        DoctorFrame.setSize(1440, 1010);
        DoctorFrame.setVisible(true);
        DoctorFrame.setLayout(null);
    }
}
