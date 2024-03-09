package MedEaseNavigator.MedMenuBar;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;

import javax.swing.*;
public class AdminChangePswd {
    
    DBOperation DBO;
    JDialog pswdDalog;
    JLabel  NewPswd,ExistPswd;
    MedEaseBtn Update;
    JTextField newPswd;
    JPasswordField exisitngpswd;

    AdminChangePswd(DBOperation dbo){
        this.DBO=dbo;
        pswdDalog =new JDialog();
        pswdDalog.setTitle("Change Password");
        pswdDalog.setBounds(100, 100, 400, 200);
        pswdDalog.setVisible(true);
        pswdDalog.setLayout(null);
        
    }

    
    
}
