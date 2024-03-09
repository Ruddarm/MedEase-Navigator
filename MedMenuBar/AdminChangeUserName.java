package MedEaseNavigator.MedMenuBar;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import javax.swing.*;

public class AdminChangeUserName {
    DBOperation DBO;
    JDialog pswdDalog;
    JLabel  NewUserName,ExistPswd;
    MedEaseBtn Update;
    AdminChangeUserName(DBOperation dbo){
        this.DBO=dbo;
        pswdDalog =new JDialog();
        pswdDalog.setTitle("Change User Name");
        pswdDalog.setBounds(100, 100, 400, 200);
        pswdDalog.setVisible(true);
        pswdDalog.setLayout(null);
    }
}
