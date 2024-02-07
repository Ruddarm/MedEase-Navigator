/*
 * @author Ruddarm
 */
package MedEaseNavigator.AppointMentModule;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
public class MedEaseAppointMentInterface {
    /*
     * 
     * 
     */
    JDialog PatientBox;
    MedPannel logoBox, InfoBox;
    JLabel Plogo, PIDLabel, NameLabel, NumberLabel,WarngingLabel;
    DBOperation DBO;
    MedEaseBtn AppointmentBtn, ViewBtn;
    MedEasePatient Patient;
    String Number;
    AppointmenEventHandling AppointmentEvenetHanldingObj;

    public MedEaseAppointMentInterface(MedEasePatient pt,DBOperation dbo,String Number) {
        this.DBO=dbo;
        PatientBox = new JDialog();
        this.Number=Number;
        this.Patient= pt;
        PatientBox.setBounds(100, 50, 600, 250);
        PatientBox.setVisible(true);
        PatientBox.getContentPane().setBackground(GUIUtil.Base_Background);
        PatientBox.setLayout(null);
        PatientBox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        logoBox = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 10);
        logoBox.setBounds(20, 20, 130, 130);
        PatientBox.add(logoBox);
        /*
         * 
         */
        Plogo = new JLabel();
        Plogo.setText("This is profile");
        Plogo.setBackground(GUIUtil.Dark_BLue);
        logoBox.add(Plogo);
        Plogo.setBounds(0, 0, 130, 130);
        Plogo.setBorder(BorderFactory.createLineBorder(Color.black));
        /*
         * 
         */
        InfoBox =new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr   , null, 10);
        InfoBox.setBounds(170, 20, 400, 130);
        InfoBox.setLayout(null);
        PatientBox.add(InfoBox);

        AppointmentBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 10);
        if(Patient!=null){
            AppointmentBtn.setText("Book Appointment");
        }else{
            AppointmentBtn.setText("Add Patient");
        }
        AppointmentBtn.setForeground(GUIUtil.WhiteClr);
        AppointmentBtn.setFont(GUIUtil.TimesBold);
        AppointmentBtn.setBounds(410, 160, 150, 40);
        PatientBox.add(AppointmentBtn);

        ViewBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.WhiteClr, null, 10);
        ViewBtn.setText("View ");
        ViewBtn.setForeground(GUIUtil.WhiteClr);
        ViewBtn.setFont(GUIUtil.TimesBold);
        ViewBtn.setBounds(250,160,150,40);;
        PatientBox.add(ViewBtn);
        AppointmentEvenetHanldingObj = new AppointmenEventHandling(this);
        AppointmentBtn.addActionListener(AppointmentEvenetHanldingObj);
        if(Patient==null){
            ViewBtn.setVisible(false);
            WarngingLabel =new JLabel();
            WarngingLabel.setText("Patient Not Found");
            WarngingLabel.setForeground(GUIUtil.WarningColor);
            WarngingLabel.setFont(GUIUtil.TimesBold);
            WarngingLabel.setBounds(100, 50, 200, 30);
            System.out.println("Code was here");
            InfoBox.add(WarngingLabel);
        }else{
            SetPatientDetials();
        }
    }
    public void SetPatientDetials(){
        PIDLabel=new JLabel(Patient.getStrPID());
        PIDLabel.setFont(GUIUtil.TimesBold);
        PIDLabel.setBounds(30, 10, 150, 20);
        InfoBox.add(PIDLabel);
        NameLabel=new JLabel(Patient.getName());
        NameLabel.setFont(GUIUtil.TimesBold);
        NameLabel.setBounds(30, 35, 150, 20);
        InfoBox.add(NameLabel);
        NumberLabel=new JLabel(Patient.getNumber());
        NumberLabel.setFont(GUIUtil.TimesBold);
        NumberLabel.setBounds(30, 60, 150, 20);
        InfoBox.add(NumberLabel);
        NameLabel=new JLabel();
    }
    
}
