package MedEaseNavigator.AppointMentModule;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class ScheduleAppointment {
    DBOperation DBO;
    JDialog ScheduleAppointBox;
    MedPannel infoBox;
    JLabel HeadingLabel, PIDLabel, PNameLabel, PNumberLabel, hrsLabel, Minlabe, Am_PMLabel;
    MedEaseBtn Schedule;

    JComboBox<Integer> Hrs, Min;
    JComboBox<String> Day;
    Integer hrs[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    Integer min[] = { 00, 15, 30, 45 };
    String day[] = { "AM", "PM" };

    ScheduleAppointment(DBOperation DBO, MedEasePatient Pt) {
        ScheduleAppointBox = new JDialog();
        ScheduleAppointBox.setBounds(100, 50, 400, 350);
        ScheduleAppointBox.setVisible(true);
        ScheduleAppointBox.setLayout(null);
        ScheduleAppointBox.getContentPane().setBackground(GUIUtil.Dark_BLue);
        infoBox = new MedPannel(GUIUtil.WhiteClr, null, null, 0);
        infoBox.setBounds(0, 50, 400, 300);
        HeadingLabel = new JLabel("Schedule Appointment");
        HeadingLabel.setBounds(10, 10, 300, 20);
        HeadingLabel.setForeground(GUIUtil.WhiteClr);
        HeadingLabel.setFont(GUIUtil.TimesBoldS2);
        ScheduleAppointBox.add(HeadingLabel);
        ScheduleAppointBox.add(infoBox);
        PIDLabel = new JLabel(Pt.getStrPID());
        PIDLabel.setBounds(50, 20, 150, 20);
        PIDLabel.setFont(GUIUtil.TimesBoldS2);
        infoBox.add(PIDLabel);
        PNameLabel = new JLabel(Pt.getName());
        PNameLabel.setBounds(50, 50, 150, 20);
        PNameLabel.setFont(GUIUtil.TimesBoldS2);
        infoBox.add(PNameLabel);
        PNumberLabel = new JLabel(Pt.getNumber());
        PNumberLabel.setBounds(50, 90, 150, 20);
        PNumberLabel.setFont(GUIUtil.TimesBoldS2);
        infoBox.add(PNumberLabel);
        hrsLabel = new JLabel("Hrs : ");
        hrsLabel.setBounds(50, 135, 50, 20);
        hrsLabel.setFont(GUIUtil.TimesBoldS2);
        infoBox.add(hrsLabel);
        Minlabe = new JLabel("Mins : ");
        Minlabe.setBounds(120, 135, 70, 20);
        Minlabe.setFont(GUIUtil.TimesBoldS2);
        infoBox.add(Minlabe);
        Am_PMLabel = new JLabel("AM/PM");
        Am_PMLabel.setBounds(180, 135, 70, 20);
        Am_PMLabel.setFont(GUIUtil.TimesBoldS2);
        infoBox.add(Am_PMLabel);
        Hrs = new JComboBox<Integer>(hrs);
        Hrs.setBounds(50, 160, 50, 20);
        Hrs.setFont(GUIUtil.TimesBold);
        infoBox.add(Hrs);
    }
}
