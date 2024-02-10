package MedEaseNavigator.DoctorDashBoard;
import javax.swing.*;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
public class ViewMedicalReport {
    JDialog  ViewBoxl;
    JTextField PidField,NameField,NumberFeild,MRIDFeild,DoctorName;
    JTextArea ChiefArea,DiagnosisArea, PrescriptionArea,FollowUPAdivce,
    Boolean view = false;
    DBOperation DBO;
    MedEasePatient pt;
    public ViewMedicalReport(MedEasePatient pt, DBOperation dbo){
        ViewBoxl= new JDialog();
        this.pt=pt;
        this.DBO=dbo;
        ViewBoxl.setBounds(100,0, 1000, 600);
        ViewBoxl.getContentPane().setBackground(GUIUtil.Dark_BLue);
        ViewBoxl.setLayout(null);

        PidField = new JTextField();
        PidField.setText("PID");
        PidField.setBounds(10,10,150,30);
        PidField.setVisible(true);
        PidField.setFont(GUIUtil.TimesBold);
        PidField.setText("PID");
        ViewBoxl.add(PidField);
        

        // ViewBoxl.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Area1 = new JTextArea();
        // Area1.setBounds(100, 100, 300, 200);
        // Area1.setWrapStyleWord(true);
        // Area1.setLineWrap(true);
        // ViewBoxl.add(Area1);
        NameField = new JTextField();
        NameField.setText("NAME");
        NameField.setBounds(170, 10, 150, 30);
        
        MRIDFeild  = new JTextField();
        MRIDFeild.setBounds(320,10,150,30);
        MRIDFeild.setFont(GUIUtil.TimesBold);
        




        


    }


}
