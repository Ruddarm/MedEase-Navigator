package MedEaseNavigator.MedMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEaseDoctor;


public class AdminChangePswd 
{
    JDialog Pswdbox;
    JLabel Password, newpswd ;
    JTextField pswd, newpsd;
    MedEaseBtn ChangeBtn;

    Pswdbox = new JDialog();
     Pswdbox.setTitle("Change Password");
    Pswdbox.setFont(GUIUtil.TimesBold);
    Pswdbox.setLayout(null);
    Pswdbox.setBounds(300, 50, 300, 200);
    Pswdbox.setVisible(true);
    Pswdbox.getContentPane().setBackground(GUIUtil.Base_Background);

    Password = new JLabel("Existing Password :");
    Password.setFont(GUIUtil.TimesBold);
    Password.setBounds(70, 30, 150, 30);
    Pswdbox.add(Password);

    pswd = new JTextField(" ");
    pswd.setFont(GUIUtil.TimesBold);
    pswd.setBounds(180, 30, 150, 30);
    Pswdbox.add(pswd);

    newpswd = new JLabel("newpswd");
    newpswd.setFont(GUIUtil.TimesBold);
    newpswd.setBounds(70, 65, 100, 30);
    Pswdbox.add(newpswd);

    newpsd = new JTextField();
    newpsd.setFont(GUIUtil.TimesBold);
    newpsd.setBounds(180, 65, 150, 30);
    Pswdbox.add(newpsd);

    ChangeBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 5);
    ChangeBtn.setText("CHANGE");
    ChangeBtn.setForeground(GUIUtil.WhiteClr);
    ChangeBtn.setFont(GUIUtil.TimesBold);
    ChangeBtn.setBounds(200, 240, 100, 30);
    Pswdbox.add(ChangeBtn);


}}
