package MedEaseNavigator.DoctorDashBoard;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class ViewMedicalReport extends KeyAdapter {
    JDialog ViewBoxl;
    JTextField PidField, NameField, NumberFeild, MRIDFeild, DoctorName;
    JTextArea ChiefArea, DiagnosisArea, PrescriptionArea, FollowUPAdivceArea;
    JLabel ChiefLabel, Chiefmaxchar;
    Boolean view = false;
    DBOperation DBO;
    MedEasePatient pt;
    String chieftext;

    public ViewMedicalReport(MedEasePatient pt, DBOperation dbo) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewBoxl = new JDialog();
                // pt=pt;
                // this.DBO=dbo;
                ViewBoxl.setBounds(100, 0, 1000, 600);
                ViewBoxl.getContentPane().setBackground(GUIUtil.Base_Background);
                ViewBoxl.setLayout(null);
                ViewBoxl.setVisible(true);
                PidField = new JTextField();
                PidField.setText("PID");
                PidField.setBounds(75, 10, 150, 30);
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
                NameField.setBounds(245, 10, 150, 30);
                NameField.setFont(GUIUtil.TimesBold);
                NameField.setEditable(false);

                ViewBoxl.add(NameField);

                NumberFeild = new JTextField();
                NumberFeild.setText("Number");
                NumberFeild.setBounds(415, 10, 150, 30);
                NumberFeild.setFont(GUIUtil.TimesBold);
                NumberFeild.setEditable(false);
                ViewBoxl.add(NumberFeild);

                MRIDFeild = new JTextField();
                MRIDFeild.setText("MRID Feild");
                MRIDFeild.setBounds(585, 10, 150, 30);
                MRIDFeild.setFont(GUIUtil.TimesBold);
                MRIDFeild.setEditable(false);
                ViewBoxl.add(MRIDFeild);

                DoctorName = new JTextField();
                DoctorName.setText("Doctor Name");
                DoctorName.setBounds(755, 10, 150, 30);
                DoctorName.setFont(GUIUtil.TimesBold);
                DoctorName.setEditable(false);
                ViewBoxl.add(DoctorName);

                ChiefLabel = new JLabel();
                ChiefLabel.setText("Chief Complaint");
                ChiefLabel.setBounds(75, 50, 150, 20);
                ChiefLabel.setFont(GUIUtil.TimesBoldS2);
                ViewBoxl.add(ChiefLabel);

                /*
                 * Chiefl label max character
                 */
                Chiefmaxchar = new JLabel("0/300");
                Chiefmaxchar.setBounds(755, 50, 100, 20);
                Chiefmaxchar.setFont(GUIUtil.TimesItalicwarn);
                ViewBoxl.add(Chiefmaxchar);
                /*
                 * Cheif Complaint area
                 */
                ChiefArea = new JTextArea();
                ChiefArea.setBounds(75, 75, 830, 35);
                ChiefArea.setFont(GUIUtil.TimesBold);
                addlistner();
                ViewBoxl.add(ChiefArea);


            }


        });

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ChiefArea) {
            chieftext = ChiefArea.getText();
            int len =chieftext.length();
            if (len>150) {
                Chiefmaxchar.setForeground(GUIUtil.WarningColor);
            }
            Chiefmaxchar.setText(len+"/300");
        }
    }
    public void addlistner(){
        ChiefArea.addKeyListener(this);
    }

}
