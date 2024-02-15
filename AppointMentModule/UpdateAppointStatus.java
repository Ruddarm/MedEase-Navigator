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
    JLabel PID, Name, Number, Status_lable, time;
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

        Name = new JLabel("NAME");
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(10, 50, 100, 30);
        infoPannel.add(Name);

        Number = new JLabel("NUMBER");
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(10, 90, 100, 30);
        infoPannel.add(Number);

        time = new JLabel("TIME");
        time.setFont(GUIUtil.TimesBoldS2);
        time.setBounds(10, 130, 100, 30);
        infoPannel.add(time);

        Status_lable = new JLabel("STATUS");
        Status_lable.setFont(GUIUtil.TimesBoldS2);
        Status_lable.setBounds(10, 170, 100, 30);
        infoPannel.add(Status_lable);

        StatusOpt = new JComboBox<String>(opt);
        StatusOpt.setBounds(110, 170, 200, 30);
        StatusOpt.setFont(GUIUtil.TimesBold);
        infoPannel.add(StatusOpt);

        Update = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
        Update.setBounds(110, 210, 80, 30);
        Update.setText("LOGIN");
        Update.setForeground(Color.white);
        Update.setFont(GUIUtil.TimesBold);
        // Update.addActionListener();
        // Update.addKeyListener();
        infoPannel.add(Update);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update) {
            DBO.UpdateAppointment("" + StatusOpt.getSelectedItem());
        }
    }

}
