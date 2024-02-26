package MedEaseNavigator.DoctorDashBoard;

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
    JLabel DID, Name,Number,UserName,Password,Age;
    JTextField DIDFeild,NameFeild,NumberFeild,UserNameFeild,PasswordFeild,AgeFeild;
    MedEaseBtn AddDocBtn;
    public AddDoctor(DBOperation dbo){
        this.DBO= dbo;
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                AddBox = new JDialog();
                AddBox.setTitle("Add Doctor");
                AddBox.setFont(GUIUtil.TimesBold);
                AddBox.setBounds(300, 50, 400, 450);
                AddBox.setVisible(true);
            }
        });
    }

}
