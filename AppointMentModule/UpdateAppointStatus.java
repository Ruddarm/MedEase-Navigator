package MedEaseNavigator.AppointMentModule;

import javax.swing.*;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAppointStatus implements ActionListener {
    JDialog UpdateBox;
    MedCreatePatient pt;
    AppointMent appoint;
    DBOperation DBO;
    MedPannel infoPannel;
    JLabel PID, Name, Number, Status_lable;
    JComboBox<String> StatusOpt;
    MedEaseBtn Update;
    String opt[] = {
            "Schedule",
            "In",
            "Current",
            "Next",
            "Payment",
            "Waiting",
            "Cancel",
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

        Name = new JLabel("Name");
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(10, 50, 100, 30);
        infoPannel.add(Name);

        Number = new JLabel("Number");
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(10, 90, 100, 30);
        infoPannel.add(Number);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update) {
            DBO.UpdateAppointment("" + StatusOpt.getSelectedItem());
        }
    }

}
