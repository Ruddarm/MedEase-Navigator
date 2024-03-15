package MedEaseNavigator.MedMenuBar;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.UtilityModule.GUIUtil;

import javax.swing.*;

public class AdminChangePswd {

    DBOperation DBO;
    JDialog Pswdbox;
    JLabel Password, newpswd;
    JTextField pswd;
    MedEaseBtn ChangeBtn;
    JPasswordField exisitngpswd;

    AdminChangePswd(DBOperation dbo) {
        this.DBO = dbo;
        Pswdbox = new JDialog();
        Pswdbox.setTitle("Change Password");
        Pswdbox.setFont(GUIUtil.TimesBold);
        Pswdbox.setLayout(null);
        Pswdbox.setBounds(300, 50, 500, 200);
        Pswdbox.setVisible(true);
        Pswdbox.getContentPane().setBackground(GUIUtil.Base_Background);

        Password = new JLabel("Existing Password :");
        Password.setFont(GUIUtil.TimesBold);
        Password.setBounds(70, 30, 150, 30);
        Pswdbox.add(Password);

        pswd = new JTextField(" ");
        pswd.setFont(GUIUtil.TimesBold);
        pswd.setBounds(200, 30, 150, 30);
        Pswdbox.add(pswd);

        newpswd = new JLabel("New Password :");
        newpswd.setFont(GUIUtil.TimesBold);
        newpswd.setBounds(70, 65, 100, 30);
        Pswdbox.add(newpswd);

        exisitngpswd = new JPasswordField();
        exisitngpswd.setFont(GUIUtil.TimesBold);
        exisitngpswd.setBounds(200, 65, 150, 30);
        Pswdbox.add(exisitngpswd);

        ChangeBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 5);
        ChangeBtn.setText("UPDATE");
        ChangeBtn.setForeground(GUIUtil.WhiteClr);
        ChangeBtn.setFont(GUIUtil.TimesBold);
        ChangeBtn.setBounds(200, 120, 100, 30);
        Pswdbox.add(ChangeBtn);
    }
}
