/*
 * GUI interface to add patient 
 * 
 */
package MedEaseNavigator.AppointMentModule;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class MedCreatePatient {

    JDialog CreateDailog;
    JLabel CreateHeadingLabel, pid, PatientName, PatientNumber, DOB, Gender, Height, Weight, BloodGroup;
    MedPannel BackPannel;
    JTextField NameField, NumberField, DOBfeild, GenderFeild, HeightFeild, WeightFeild, GroupFeild;
    MedEaseBtn AddPatientBtn;


    public MedCreatePatient() {
        CreateDailog = new JDialog();
        CreateDailog.getContentPane().setBackground(GUIUtil.Dark_BLue);
        CreateDailog.setBounds(200, 100, 450, 500);
        CreateDailog.setVisible(true);
        CreateDailog.setLayout(null);
        BackPannel = new MedPannel(GUIUtil.MedEaseGrey, GUIUtil.MedEaseGrey, null, 0);
        BackPannel.setBackground(GUIUtil.Dark_BLue);
        BackPannel.setBounds(0, 40, 450, 475);
        CreateDailog.add(BackPannel);
        CreateHeadingLabel = new JLabel();
        CreateHeadingLabel.setText("Create Patient");
        CreateHeadingLabel.setForeground(GUIUtil.WhiteClr);
        CreateHeadingLabel.setFont(GUIUtil.TimesBoldS2);
        CreateHeadingLabel.setBounds(10, 10, 150, 20);
        CreateDailog.add(CreateHeadingLabel);
        /*
         * 
         */
        AddPatientBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 10);
        AddPatientBtn.setBounds(280, 380, 150, 35);
        AddPatientBtn.setText("Add");
        AddPatientBtn.setForeground(GUIUtil.WhiteClr);
        AddPatientBtn.setFont(GUIUtil.TimesBoldS2);
        BackPannel.add(AddPatientBtn);
    }


}
