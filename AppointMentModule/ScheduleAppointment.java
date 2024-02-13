package MedEaseNavigator.AppointMentModule;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.AppointMentInterface;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AdminInterface;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleAppointment implements ActionListener {
    DBOperation DBO;
    JDialog ScheduleAppointBox;
    MedPannel infoBox;
    JLabel HeadingLabel, PIDLabel, PNameLabel, PNumberLabel, hrsLabel, Minlabe, Am_PMLabel;
    MedEaseBtn Schedule;
    MedEasePatient PT;
    JComboBox<Integer> Hrs;
    JComboBox<String> Day, Min;
    Integer hrs[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    String min[] = { "00", "15", "30", "45" };
    String day[] = { "AM", "PM" };
    AdminInterface AddminInterfaceObj;

    ScheduleAppointment(DBOperation DBO, MedEasePatient Pt, AdminInterface AddminInterfaceObj) {
        this.DBO = DBO;
        this.AddminInterfaceObj = AddminInterfaceObj;
        this.PT = Pt;
        ScheduleAppointBox = new JDialog();
        ScheduleAppointBox.setBounds(100, 50, 300, 350);
        ScheduleAppointBox.setVisible(true);
        ScheduleAppointBox.setLayout(null);
        ScheduleAppointBox.getContentPane().setBackground(GUIUtil.Dark_BLue);
        infoBox = new MedPannel(GUIUtil.WhiteClr, null, null, 0);
        infoBox.setBounds(0, 50, 300, 300);
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
        Hrs.setBounds(50, 160, 50, 25);
        Hrs.setFont(GUIUtil.TimesBold);
        infoBox.add(Hrs);
        Min = new JComboBox<String>(min);
        Min.setBounds(110, 160, 50, 25);
        Min.setFont(GUIUtil.TimesBold);
        infoBox.add(Min);
        Day = new JComboBox<String>(day);
        Day.setBounds(170, 160, 50, 25);
        Day.setFont(GUIUtil.TimesBold);
        infoBox.add(Day);
        Schedule = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 15);
        Schedule.setText("Schedule");
        Schedule.setBounds(50, 195, 150, 30);
        Schedule.setFont(GUIUtil.TimesBold);
        Schedule.setForeground(GUIUtil.WhiteClr);
        Schedule.addActionListener(this);
        infoBox.add(Schedule);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Schedule) {
            DateTimeFormatter formatr = DateTimeFormatter.ofPattern("hh:mm a");

            String hrs, min, day;
            hrs = "" + Hrs.getSelectedItem();
            min = "" + Min.getSelectedItem();
            day = "" + Day.getSelectedItem();
            String time = hrs + ":" + min + " " + day;
            String Date = "" + LocalDate.now();
            AppointMent appoint = new AppointMent();
            appoint.setPID(PT.getStrPID());
            appoint.setName(PT.getName());
            appoint.setTimeSlot(time);
            System.out.println(time);
            appoint.setDate(Date);
            // appoint.setIntime("00:00 am");
            appoint.setStatus("Schedule");
            appoint.setIntime("" + LocalTime.now().format(formatr));
            DBO.ScheduleAppointment(appoint);
            ScheduleAppointBox.dispose();
            AddminInterfaceObj.AppointmentInterfaceObj.UpdateTable();

        }

    }
}
