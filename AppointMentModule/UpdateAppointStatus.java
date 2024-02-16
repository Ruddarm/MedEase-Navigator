package MedEaseNavigator.AppointMentModule;

import javax.swing.*;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAppointStatus implements ActionListener {
    JDialog UpdateBox;
    MedCreatePatient pt;
    AppointMent appoint;
    DBOperation DBO;
    MedPannel infoPannel;
    JLabel PID, Name, Number, Status_lable, time, PID_L, Name_L, Number_L, time_L;
    JComboBox<String> StatusOpt;
    MedEaseBtn Update;
    String opt[] = {
            "SCHEDULE",
            "IN",
            "CURRENT",
            "NEXT",
            "PAYMENT",
            "WAITING",
            "CANCEL",
    };

    public UpdateAppointStatus(AppointMent appoint, DBOperation dbo, MedCreatePatient pt) {
        this.appoint = appoint;
        this.DBO = dbo;
        this.pt = pt;
        UpdateBox = new JDialog();
        UpdateBox.setBounds(200, 100, 400, 450);
        UpdateBox.getContentPane().setBackground(GUIUtil.Dark_BLue);
        UpdateBox.setLayout(null);
        UpdateBox.setVisible(true);
        infoPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
        infoPannel.setBounds(0, 50, 400, 400);
        UpdateBox.add(infoPannel);

        PID = new JLabel("PID");
        PID.setFont(GUIUtil.TimesBoldS2);
        PID.setBounds(10, 10, 100, 30);
        infoPannel.add(PID);

        PID_L = new JLabel("PID");
        PID_L.setFont(GUIUtil.TimesBoldS2);
        PID_L.setBounds(110, 10, 200, 30);
        infoPannel.add(PID_L);

        Name = new JLabel("NAME");
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(10, 50, 100, 30);
        infoPannel.add(Name);

        Name_L = new JLabel("NAME");
        Name_L.setFont(GUIUtil.TimesBoldS2);
        Name_L.setBounds(110, 50, 200, 30);
        infoPannel.add(Name_L);

        Number = new JLabel("NUMBER");
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(10, 90, 100, 30);
        infoPannel.add(Number);

        Number_L = new JLabel("NUMBER");
        Number_L.setFont(GUIUtil.TimesBoldS2);
        Number_L.setBounds(10, 90, 100, 30);
        infoPannel.add(Number_L);

        time = new JLabel("TIME");
        time.setFont(GUIUtil.TimesBoldS2);
        time.setBounds(10, 130, 100, 30);
        infoPannel.add(time);

        time_L = new JLabel("TIME");
        time_L.setFont(GUIUtil.TimesBoldS2);
        time_L.setBounds(10, 130, 100, 30);
        infoPannel.add(time_L);

        Status_lable = new JLabel("STATUS");
        Status_lable.setFont(GUIUtil.TimesBoldS2);
        Status_lable.setBounds(10, 170, 100, 30);
        infoPannel.add(Status_lable);

        StatusOpt = new JComboBox<String>(opt);
        StatusOpt.setBounds(110, 170, 200, 30);
        StatusOpt.setFont(GUIUtil.TimesBold);
        infoPannel.add(StatusOpt);

        Update = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
        Update.setBounds(120, 210, 120, 30);
        Update.setText("UPDATE");
        Update.setForeground(Color.white);
        Update.setFont(GUIUtil.TimesBold);
        // Update.addActionListener();
        // Update.addKeyListener();
        infoPannel.add(Update);

        // String status[] = { "-", "IN", "OUT" };
        StatusOpt = new JComboBox<String>(opt);
        StatusOpt.setBounds(110, 170, 150, 25);
        StatusOpt.setFont(GUIUtil.TimesBold);
        infoPannel.add(StatusOpt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update) {
            DBO.UpdateAppointment("" + StatusOpt.getSelectedItem());
        }
    }

}
