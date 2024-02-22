package MedEaseNavigator.DoctorDashBoard;

import javax.swing.JFrame;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.UtilityModule.GUIUtil;
public class DocDasBoarUtil {
    JFrame DoctorFrame;
    DBOperation DBO;
    public DocDasBoarUtil() {
        DoctorFrame = new JFrame();
        DoctorFrame.getContentPane().setBackground(GUIUtil.Base_Background);
        DoctorFrame.setSize(1440, 1010);
        DoctorFrame.setVisible(true);
        DoctorFrame.setLayout(null);
    }
}
