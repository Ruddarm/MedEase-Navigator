package MedEaseNavigator.MedMenuBar;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import MedEaseNavigator.MedEaseComponent.MedEaseBtn;

public class AdminChangeUserName {
    JDialog UNbox;
    JLabel Username, psd ;
    JTextField pswd, UN;
    MedEaseBtn ChangeBtn;

    UNbox = new JDialog();
    UNbox.setTitle("Change Username");
    UNbox.setFont(GUIUtil.TimesBold);
    UNbox.setLayout(null);
    UNbox.setBounds(300, 50, 300, 200);
    UNbox.setVisible(true);
    UNbox.getContentPane().setBackground(GUIUtil.Base_Background);

    Username = new JLabel("New Username :");
    Username.setFont(GUIUtil.TimesBold);
    Username.setBounds(70, 30, 150, 30);
    UNbox.add(Username);

    UN = new JTextField(" ");
    UN.setFont(GUIUtil.TimesBold);
    UN.setBounds(180, 30, 150, 30);
    UNbox.add(UN);

    psd = new JLabel(" Password : ");
    psd.setFont(GUIUtil.TimesBold);
    psd.setBounds(70, 65, 100, 30);
    UNbox.add(psd);

    pswd = new JTextField();
    pswd.setFont(GUIUtil.TimesBold);
    pswd.setBounds(180, 65, 150, 30);
    UNbox.add(pswd);

    ChangeBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 5);
    ChangeBtn.setText("CHANGE");
    ChangeBtn.setForeground(GUIUtil.WhiteClr);
    ChangeBtn.setFont(GUIUtil.TimesBold);
    ChangeBtn.setBounds(200, 240, 100, 30);
    UNbox.add(ChangeBtn);

    
}
