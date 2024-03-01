package MedEaseNavigator.AppointMentModule;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class UpdateAppointMentTime implements ActionListener {
    JDialog UpdateBox;
    MedCreatePatient pt;
    AppointMent appoint;
    DBOperation DBO;
    MedPannel infoPannel;
    JLabel NameLabel, PIDLabel, NumberLabe, Status_lable;
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

    public UpdateAppointMentTime(AppointMent appoint, DBOperation dbo, MedCreatePatient pt) {
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update) {
            // DBO.UpdateAppointment();
        }
    }

   
}
