package MedEaseNavigator.DoctorDashBoard;
import javax.print.attribute.standard.MediaSize.NA;
import javax.swing.*;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
public class ViewMedicalReport {
    JDialog  ViewBoxl;
    JTextField PidField,NameField,NumberFeild,MRIDFeild,DoctorName;
    JTextArea ChiefArea,DiagnosisArea, PrescriptionArea,FollowUPAdivceArea;
    Boolean view = false;
    DBOperation DBO;
    MedEasePatient pt;
    public ViewMedicalReport(MedEasePatient pt, DBOperation dbo){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewBoxl= new JDialog();
            // pt=pt;
            // this.DBO=dbo;
            ViewBoxl.setBounds(100,0, 1000, 600);
            ViewBoxl.getContentPane().setBackground(GUIUtil.Base_Background);
            ViewBoxl.setLayout(null);
            ViewBoxl.setVisible(true);
            PidField = new JTextField();
            PidField.setText("PID");
            PidField.setBounds(10,10,150,30);
            PidField.setVisible(true);
            PidField.setFont(GUIUtil.TimesBold);
            PidField.setText("PID");
            PidField.setEditable(false);
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
            NameField.setFont(GUIUtil.TimesBold);
            NameField.setEditable(false);
            ViewBoxl.add(NameField);
    
            NumberFeild  = new JTextField();
            NumberFeild.setText("Number");
            NumberFeild.setBounds(330,10,150,30);
            NumberFeild.setFont(GUIUtil.TimesBold);
            ViewBoxl.add(NumberFeild);
    
            MRIDFeild  = new JTextField();
            MRIDFeild.setText("MRID Feild");
            MRIDFeild.setBounds(500,10,150,30);
            MRIDFeild.setFont(GUIUtil.TimesBold);
            ViewBoxl.add(MRIDFeild);
            

            }

        });




    }


}
