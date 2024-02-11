package MedEaseNavigator.DoctorDashBoard;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.xdevapi.JsonArray;

import java.awt.*;

import javax.swing.*;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class ViewMedicalReport extends KeyAdapter {
    JDialog ViewBoxl;
    JTextField PidField, NameField, NumberFeild, MRIDFeild, DoctorName;
    JTextArea ChiefArea, DiagnosisArea, PrescriptionArea, FollowUPAdivceArea, SymptompsArea,LabTestArea;
    JLabel ChiefLabel, Chiefmaxchar, DiagnosisLabel, Diagnosismaxchar, PrescriptionLabel, PrecriptionMaxChar,
            FollowUpAdviceLabel, FollowUPAdivceMaxChar, SymptomsLabel, SymptomsMaxChar,LabTestLabel,LabTextMaxChar;

    Boolean view = false;
    DBOperation DBO;
    MedEasePatient pt;
    String chieftext, DaigText;
    JScrollPane JSPBack, DiganosisJSP, PrescriptionJSP, FollowUPAdivceJSP, SymptompsJSP,LabTestJSP;
    JViewport viewp;
    JPanel JSPpane;
    JScrollBar jsb;
    JComboBox<String> StatusOpt;


    public ViewMedicalReport(MedEasePatient pt, DBOperation dbo) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewBoxl = new JDialog();
                // pt=pt;
                // this.DBO=dbo;
                ViewBoxl.setBounds(100, 0, 1000, 700);
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
                Chiefmaxchar = new JLabel("0/150");
                Chiefmaxchar.setBounds(800, 50, 100, 20);
                Chiefmaxchar.setFont(GUIUtil.TimesItalicwarn);
                ViewBoxl.add(Chiefmaxchar);
                /*
                 * Cheif Complaint area
                 */
                ChiefArea = new JTextArea();
                ChiefArea.setBounds(75, 75, 830, 35);
                ChiefArea.setFont(GUIUtil.TimesBoldS2);
                addlistner();
                ViewBoxl.add(ChiefArea);
                /*
                 * setting jsp
                 */
                viewp = new JViewport();
                // JSPpane = new MedPannel(GUIUtil.MedEaseGrey, GUIUtil.WhiteClr, null, 0);
                JSPpane =new JPanel();
                // JSPpane.setSize(830, 800);
                JSPpane.setBackground(GUIUtil.MedEaseGrey);
                JSPpane.setLayout(null);

                /*
                 * Diganosis area
                 */
                DiagnosisLabel = new JLabel("Diagnosis/Examniation");
                DiagnosisLabel.setBounds(10, 5, 150, 20);
                DiagnosisLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(DiagnosisLabel);
                Diagnosismaxchar = new JLabel("0/4000");
                Diagnosismaxchar.setFont(GUIUtil.TimesItalicwarn);
                Diagnosismaxchar.setBounds(750, 5, 100, 20);
                JSPpane.add(Diagnosismaxchar);
                DiagnosisArea = new JTextArea();
                DiagnosisArea.setFont(GUIUtil.TimesBold);
                DiagnosisArea.setLineWrap(true);
                DiagnosisArea.setWrapStyleWord(true);
                DiganosisJSP = new JScrollPane(DiagnosisArea);
                DiganosisJSP.setBounds(10, 30, 810, 100);
                JSPpane.add(DiganosisJSP);
                /*
                 * Prectption area
                 * 
                 */
                SymptomsLabel = new JLabel("Symptoms");
                SymptomsLabel.setBounds(10, 135, 100, 20);
                SymptomsLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(SymptomsLabel);
                /*
                 * Prescition max char
                 */
                SymptomsMaxChar = new JLabel("0/1000");
                SymptomsMaxChar.setBounds(750, 135, 100, 20);
                SymptomsMaxChar.setFont(GUIUtil.TimesItalicwarn);
                JSPpane.add(SymptomsMaxChar);
                /*
                 * Prescption area
                 */
                SymptompsArea = new JTextArea();
                SymptompsArea.setFont(GUIUtil.TimesBold);
                SymptompsArea.setLineWrap(true);
                SymptompsArea.setWrapStyleWord(true);
                SymptompsJSP = new JScrollPane(SymptompsArea);
                SymptompsJSP.setBounds(10, 160, 810, 80);
                JSPpane.add(SymptompsJSP);
                /*
                 * Follow up advice
                 */
                PrescriptionLabel = new JLabel("Prescription");
                PrescriptionLabel.setBounds(10, 245, 810, 20);
                PrescriptionLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(PrescriptionLabel);
                PrecriptionMaxChar = new JLabel("0/2000");
                PrecriptionMaxChar.setBounds(750, 245, 100, 20);
                PrecriptionMaxChar.setFont(GUIUtil.TimesItalicwarn);
                JSPpane.add(PrecriptionMaxChar);
                PrescriptionArea = new JTextArea();
                PrescriptionArea.setLineWrap(true);
                PrescriptionArea.setWrapStyleWord(true);
                PrescriptionArea.setFont(GUIUtil.TimesBold);
                PrescriptionJSP = new JScrollPane(PrescriptionArea);
                PrescriptionJSP.setBounds(10, 265, 810, 70);
                JSPpane.add(PrescriptionJSP);

                FollowUpAdviceLabel = new JLabel("Follow Up Advice");
                FollowUpAdviceLabel.setBounds(10, 340, 810, 20);
                FollowUpAdviceLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(FollowUpAdviceLabel);
                FollowUPAdivceMaxChar = new JLabel("0/1000");
                FollowUPAdivceMaxChar.setBounds(750, 340, 100, 20);
                FollowUPAdivceMaxChar.setFont(GUIUtil.TimesItalicwarn);
                JSPpane.add(FollowUPAdivceMaxChar);
                FollowUPAdivceArea = new JTextArea();
                FollowUPAdivceArea.setLineWrap(true);
                FollowUPAdivceArea.setWrapStyleWord(true);
                FollowUPAdivceArea.setFont(GUIUtil.TimesBold);
                FollowUPAdivceJSP = new JScrollPane(FollowUPAdivceArea);
                FollowUPAdivceJSP.setBounds(10, 365, 810, 80);
                JSPpane.add(FollowUPAdivceJSP);

                JSPBack = new JScrollPane(JSPpane);
                JSPBack.setBounds(75, 120, 850, 500);
                JSPpane.setPreferredSize(new Dimension(830, 800));
                ViewBoxl.add(JSPBack);

                LabTestLabel=new JLabel();
                LabTestLabel = new JLabel("Lab Test");
                LabTestLabel.setBounds(10, 450, 810, 20);
                LabTestLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(LabTestLabel);
                LabTestLabel = new JLabel("0/200");
                LabTestLabel.setBounds(750, 450, 100, 20);
                LabTestLabel.setFont(GUIUtil.TimesItalicwarn);
                JSPpane.add(LabTestLabel);
                LabTestArea = new JTextArea();
                LabTestArea.setLineWrap(true);
                LabTestArea.setWrapStyleWord(true);
                LabTestArea.setFont(GUIUtil.TimesBold);
                LabTestJSP = new JScrollPane(LabTestArea);
                LabTestJSP.setBounds(10, 475, 810, 80);
                JSPpane.add(LabTestJSP);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ChiefArea) {
            chieftext = ChiefArea.getText();
            int len = chieftext.length();
            if (len > 150) {
                Chiefmaxchar.setForeground(GUIUtil.WarningColor);
            }
            Chiefmaxchar.setText(len + "/150");
        }
    }

    public void addlistner() {
        ChiefArea.addKeyListener(this);
    }

}
