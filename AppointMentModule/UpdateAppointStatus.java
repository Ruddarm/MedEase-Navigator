package MedEaseNavigator.AppointMentModule;

import javax.swing.*;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.UtilityModule.AppointMent;
public class UpdateAppointStatus {
    JDialog UpdateBox;
    MedCreatePatient pt;
    AppointMent appoint;
    DBOperation DBO;
    JLabel NameLabe,PIDLabel,NumberLabe,Status_lable;
    JComboBox<String> StatusOpt;
    String opt[] ={
        "Schedule",
        "In",
        "Current",
        ""
    };

}
