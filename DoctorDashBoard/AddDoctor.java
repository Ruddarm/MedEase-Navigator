package MedEaseNavigator.DoctorDashBoard;

import javax.print.attribute.standard.MediaSize.NA;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class AddDoctor {
    DBOperation DBO;
    JDialog AddBox;
    JLabel DID, Name, Number, UserName, Password, Age;
    JTextField DIDFeild, NameFeild, NumberFeild, UserNameFeild, PasswordFeild, AgeFeild;
    MedEaseBtn AddDocBtn;

    public AddDoctor(DBOperation dbo) {
        this.DBO = dbo;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddBox = new JDialog();
                AddBox.setTitle("Add Doctor");
                AddBox.setFont(GUIUtil.TimesBold);
                AddBox.setLayout(null);
                AddBox.setBounds(300, 50, 400, 450);
                AddBox.setVisible(true);
                AddBox.getContentPane().setBackground(GUIUtil.Base_Background);
                DID = new JLabel("DID");
                DID.setFont(GUIUtil.TimesBold);
                DID.setBounds(70, 30, 100, 30);
                AddBox.add(DID);
                DIDFeild = new JTextField();
                DIDFeild.setFont(GUIUtil.TimesBold);
                DIDFeild.setBounds(180, 30, 150, 30);
                AddBox.add(DIDFeild);

                Name = new JLabel("Name");
                Name.setFont(GUIUtil.TimesBold);
                Name.setBounds(70, 65, 100, 30);
                AddBox.add(Name);
                NameFeild = new JTextField();
                NameFeild.setFont(GUIUtil.TimesBold);
                NameFeild.setBounds(180, 65, 150, 30);
                AddBox.add(NameFeild);

                
                
                UserName=new JLabel("User Name");
                UserName.setFont(GUIUtil.TimesBold);
                UserName.setBounds(30, 100, 100, 30);
                AddBox.add(UserName);
                UserNameFeild=new JTextField();
                UserNameFeild.setFont(GUIUtil.TimesBold);
                UserNameFeild.setBounds(150, 100, 150, 30);
                AddBox.add(UserNameFeild);




            }
        });
    }

}
