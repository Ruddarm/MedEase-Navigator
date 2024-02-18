package MedEaseNavigator.DoctorDashBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import javax.swing.*;
import java.awt.*;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEaseDoctor;
import MedEaseNavigator.UtilityModule.MedEaseMedicalReport;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class ViewMedicalReport extends KeyAdapter implements ActionListener {
    JDialog ViewBoxl;
    JTextField PidField, NameField, NumberFeild, MRIDFeild, DoctorName, FeesArea, PaidAmountArea;
    JTextArea ChiefArea, DiagnosisArea, PrescriptionArea, FollowUPAdivceArea, SymptompsArea, LabTestArea;
    JLabel ChiefLabel, Chiefmaxchar, DiagnosisLabel, Diagnosismaxchar, PrescriptionLabel, PrecriptionMaxChar,
            FollowUpAdviceLabel, FollowUPAdivceMaxChar, SymptomsLabel, SymptomsMaxChar, LabTestLabel, LabTextMaxChar,
            StatusLabel, FeesLabel, PaidLabel, WarnLabel;
    Boolean view = false;
    DBOperation DBO;
    MedEasePatient pt;
    String chieftext, DaigText, SympText, FollowUPText, PrectptionText, LabTestText, FeesText, PaidText;
    JScrollPane JSPBack, DiganosisJSP, PrescriptionJSP, FollowUPAdivceJSP, SymptompsJSP, LabTestJSP;
    JViewport viewp;
    JPanel JSPpane;
    JScrollBar jsb;
    JComboBox<String> StatusOpt;
    String Option[] = {
            "Open",
            "Pending",
            "Paid"
    };
    Boolean isvalid = true;
    MedEaseBtn UpdateBtn;
    MedEaseMedicalReport MedicalReport;
    MedEaseDoctor Doc;


    public ViewMedicalReport(MedEasePatient pt, DBOperation dbo, MedEaseDoctor doc, MedEaseMedicalReport MedicalReport,Boolean editable) {
        this.pt = pt;
        this.DBO = dbo;
        this.Doc = doc;
        this.view=editable;
        this.MedicalReport=MedicalReport;
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
                ViewBoxl.add(ChiefArea);
                /*
                 * setting jsp
                 */
                viewp = new JViewport();
                // JSPpane = new MedPannel(GUIUtil.MedEaseGrey, GUIUtil.WhiteClr, null, 0);
                JSPpane = new JPanel();
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

                LabTestLabel = new JLabel();
                LabTestLabel = new JLabel("Lab Test");
                LabTestLabel.setBounds(10, 450, 810, 20);
                LabTestLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(LabTestLabel);
                LabTextMaxChar = new JLabel("0/2000");
                LabTextMaxChar.setBounds(750, 450, 100, 20);
                LabTextMaxChar.setFont(GUIUtil.TimesItalicwarn);
                JSPpane.add(LabTextMaxChar);
                LabTestArea = new JTextArea();
                LabTestArea.setLineWrap(true);
                LabTestArea.setWrapStyleWord(true);
                LabTestArea.setFont(GUIUtil.TimesBold);
                LabTestJSP = new JScrollPane(LabTestArea);
                LabTestJSP.setBounds(10, 475, 810, 80);
                JSPpane.add(LabTestJSP);

                WarnLabel = new JLabel("Enter Valid amount");
                WarnLabel.setForeground(GUIUtil.WarningColor);
                WarnLabel.setFont(GUIUtil.TimesItalicwarn);
                WarnLabel.setVisible(false);
                WarnLabel.setBounds(480, 560, 150, 20);
                JSPpane.add(WarnLabel);
                StatusLabel = new JLabel("Status : ");
                StatusLabel.setBounds(30, 585, 100, 30);
                StatusLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(StatusLabel);
                StatusOpt = new JComboBox<String>(Option);
                StatusOpt.setBounds(140, 585, 100, 30);
                JSPpane.add(StatusOpt);

                FeesLabel = new JLabel("Fees Rs.");
                FeesLabel.setBounds(250, 585, 100, 30);
                FeesLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(FeesLabel);

                FeesArea = new JTextField("0");
                FeesArea.setBounds(360, 585, 150, 30);
                FeesArea.setFont(GUIUtil.TimesBold);
                JSPpane.add(FeesArea);

                PaidLabel = new JLabel("Paid  Rs. ");
                PaidLabel.setBounds(530, 585, 100, 30);
                PaidLabel.setFont(GUIUtil.TimesBold);
                JSPpane.add(PaidLabel);

                PaidAmountArea = new JTextField();
                PaidAmountArea.setText("0");
                PaidAmountArea.setBounds(650, 585, 150, 30);
                PaidAmountArea.setFont(GUIUtil.TimesBold);
                JSPpane.add(PaidAmountArea);
                UpdateBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 10);
                UpdateBtn.setBounds(650, 660, 150, 40);
                UpdateBtn.setText("Update");
                UpdateBtn.setFont(GUIUtil.TimesBoldS2);
                UpdateBtn.setForeground(GUIUtil.WhiteClr);
                JSPpane.add(UpdateBtn);

                JSPBack = new JScrollPane(JSPpane);
                JSPBack.setBounds(75, 120, 850, 500);
                JSPpane.setPreferredSize(new Dimension(830, 800));
                ViewBoxl.add(JSPBack);
                addlistner();
                if(pt!=null){
                    SetPTdata();
                    SetMedicalReport();
                }
                
                
            }
        });
    }

    public void SetPTdata(){
        PidField.setText(pt.getStrPID());
        NameField.setText(pt.getName());
        NumberFeild.setText(pt.getNumber());
    }
    public void SetMedicalReport(){
        if(view==true){
            String MRID= "MRID"+DBO.GetLastMID();
            MRIDFeild.setText(MRID);
        }else{
            MRIDFeild.setText(MedicalReport.getMRID());
            ChiefArea.setText(MedicalReport.getChiefcomplaint());
            ChiefArea.setEditable(false);
            DiagnosisArea.setText(MedicalReport.getDiagnosis());
            DiagnosisArea.setEditable(false);
            SymptompsArea.setText(MedicalReport.getSymptoms());
            SymptompsArea.setEditable(false);
            PrescriptionArea.setText(MedicalReport.getPrescription());
            PrescriptionArea.setEditable(false);
            
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ChiefArea) {
            chieftext = ChiefArea.getText();
            int len = chieftext.length();
            if (len > 150) {
                Chiefmaxchar.setForeground(GUIUtil.WarningColor);
                isvalid = false;
            } else {
                Chiefmaxchar.setForeground(GUIUtil.BlackClr);
                isvalid = true;
            }
            Chiefmaxchar.setText(len + "/150");
        } else if (e.getSource() == DiagnosisArea) {
            DaigText = DiagnosisArea.getText();
            int len = DaigText.length();
            if (len > 4000) {
                Diagnosismaxchar.setForeground(GUIUtil.WarningColor);
                isvalid = false;
            } else {
                Diagnosismaxchar.setForeground(GUIUtil.BlackClr);
                isvalid = false;
            }
            Diagnosismaxchar.setText(len + "/4000");
        } else if (e.getSource() == SymptompsArea) {
            SympText = DiagnosisArea.getText();
            int len = SympText.length();
            if (len > 1000) {
                SymptomsMaxChar.setForeground(GUIUtil.WarningColor);
                isvalid = false;
            } else {
                SymptomsMaxChar.setForeground(GUIUtil.BlackClr);
                isvalid = true;
            }
            SymptomsMaxChar.setText(len + "/1000");

        } else if (e.getSource() == PrescriptionArea) {
            PrectptionText = PrescriptionArea.getText();
            int len = PrectptionText.length();
            if (len > 2000) {
                PrecriptionMaxChar.setForeground(GUIUtil.WarningColor);
                isvalid = false;
            } else {
                PrecriptionMaxChar.setForeground(GUIUtil.BlackClr);
                isvalid = true;
            }
            PrecriptionMaxChar.setText(len + "/2000");

        } else if (e.getSource() == FollowUPAdivceArea) {
            FollowUPText = FollowUPAdivceArea.getText();
            int len = FollowUPText.length();
            if (len > 1000) {
                FollowUPAdivceMaxChar.setForeground(GUIUtil.WarningColor);
                isvalid = false;
            } else {
                FollowUPAdivceMaxChar.setForeground(GUIUtil.BlackClr);
                isvalid = true;
            }
            FollowUPAdivceMaxChar.setText(len + "/1000");
        } else if (e.getSource() == LabTestArea) {
            LabTestText = FollowUPAdivceArea.getText();
            int len = LabTestText.length();
            if (len > 2000) {
                LabTextMaxChar.setForeground(GUIUtil.WarningColor);
                isvalid = false;
            } else {
                LabTextMaxChar.setForeground(GUIUtil.BlackClr);
                isvalid = true;
            }
            LabTextMaxChar.setText(len + "/2000");
        }

    }

    public void addlistner() {
        ChiefArea.addKeyListener(this);
        DiagnosisArea.addKeyListener(this);
        SymptompsArea.addKeyListener(this);
        PrescriptionArea.addKeyListener(this);
        FollowUPAdivceArea.addKeyListener(this);
        LabTestArea.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WarnLabel.setVisible(false);
        if (e.getSource() == UpdateBtn & isvalid) {
            double Fees;
            double Paid;
            try {
                Fees = Double.parseDouble(FeesArea.getText());
                Paid = Double.parseDouble(PaidAmountArea.getText());

            } catch (NumberFormatException ex) {
                // System.out.println("number error");
                WarnLabel.setVisible(true);
                return;
            }
            MedicalReport = new MedEaseMedicalReport();
            MedicalReport.setMRID(MRIDFeild.getText());
            MedicalReport.setPID(PidField.getText());
            MedicalReport.setDID(Doc.getDID());
            MedicalReport.setChiefcomplaint(ChiefArea.getText());
            MedicalReport.setDiagnosis(DiagnosisArea.getText());
            MedicalReport.setSymptoms(SymptompsArea.getText());
            MedicalReport.setPrescription(PrescriptionArea.getText());
            MedicalReport.setFollowupadvice(FollowUPAdivceArea.getText());
            MedicalReport.setReportDate(""+LocalDate.now());
            MedicalReport.setLabtest(LabTestArea.getText());
            MedicalReport.setFees(Fees);
            MedicalReport.setPaid(Paid);
            if(Fees==Paid){
                MedicalReport.setStatus(StatusOpt.getItemAt(2));
            }else{
                MedicalReport.setStatus(StatusOpt.getItemAt(1));
            }
            DBO.InsertMedicalHistory(MedicalReport);

        }
    }

}
