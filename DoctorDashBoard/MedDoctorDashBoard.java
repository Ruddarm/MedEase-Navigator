package MedEaseNavigator.DoctorDashBoard;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Result;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedDoctorDashBoard implements ActionListener {
    DocDasBoarUtil docDasBoarUtil = new DocDasBoarUtil();
    MedPannel BackPannel, ProfielBox, InfoBox;
    /*
     * 
     */
    JLabel WelcomLogo;
    /*
     * Patitent information
     */
    JLabel PaitienTLogo, PID, Name, Number, Age, Gender, BloodGrup, Heigh, Weight, Allergy;
    MedEaseBtn Update, Next, CreateMedicalReport;
    JTable MediclReportTable;
    DefaultTableModel Dtm;
    JScrollPane jsp;
    MedEasePatient Patient;
    MedEaseBtn GetPatitentBtn, MedicalReportBtn;
    ResultSet PTdata;
    DBOperation DBO;
    String PatientHead[] = {

            "PID",
            "Name",
            "Number",
            "MRID",
            "Chief Complaint",
            "Date",
            "Doctor Name"

    };

    public MedDoctorDashBoard(DBOperation DBO) {
        this.DBO = DBO;
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 0);
        BackPannel.setBounds(0, 100, 1440, 500);
        docDasBoarUtil.DoctorFrame.add(BackPannel);
        ProfielBox = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 5);
        ProfielBox.setBounds(135, 20, 150, 150);
        BackPannel.add(ProfielBox);
        InfoBox = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 5);
        InfoBox.setLayout(null);
        // InfoBox.setBounds(305, 20, 1000, 150); for 15inch
        InfoBox.setBounds(305, 20, 850, 150);
        BackPannel.add(InfoBox);

        SetMedicalReportTable();
        GetPatitentBtn = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 10);
        GetPatitentBtn.setText("Get Patient");
        GetPatitentBtn.setBounds(800, 450, 150, 40);
        GetPatitentBtn.addActionListener(this);
        BackPannel.add(GetPatitentBtn);

        MedicalReportBtn = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 10);
        MedicalReportBtn.setText("Medical Report");
        MedicalReportBtn.setBounds(500, 450, 150, 40);
        BackPannel.add(MedicalReportBtn);

        Update = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 10);
        Update.setText("UPDATE");
        Update.setBounds(720, 115, 100, 30);
        InfoBox.add(Update);

        PID = new JLabel("PID");
        PID.setFont(GUIUtil.TimesBoldS2);
        PID.setBounds(10, 10, 100, 30);
        InfoBox.add(PID);

        Name = new JLabel("Name");
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(10, 50, 100, 30);
        InfoBox.add(Name);

        Number = new JLabel("Number");
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(10, 90, 100, 30);
        InfoBox.add(Number);

        Age = new JLabel("Age");
        Age.setFont(GUIUtil.TimesBoldS2);
        Age.setBounds(110, 120, 100, 30);
        InfoBox.add(Age);

        Gender = new JLabel("Gender");
        Gender.setFont(GUIUtil.TimesBoldS2);
        Gender.setBounds(180, 120, 100, 30);
        InfoBox.add(Gender);

        BloodGrup = new JLabel("Blood Group");
        BloodGrup.setFont(GUIUtil.TimesBoldS2);
        BloodGrup.setBounds(270, 120, 120, 30);
        InfoBox.add(BloodGrup);

        Heigh = new JLabel("Height");
        Heigh.setFont(GUIUtil.TimesBoldS2);
        Heigh.setBounds(400, 120, 100, 30);
        InfoBox.add(Heigh);

        Weight = new JLabel("Weight");
        Weight.setFont(GUIUtil.TimesBoldS2);
        Weight.setBounds(490, 120, 100, 30);
        InfoBox.add(Weight);

        // Allergy = new JLabel("Allergy");
        // Allergy.setFont(GUIUtil.TimesBoldS2);
        // Allergy.setBounds(590, 120, 200, 30);
        // InfoBox.add(Allergy);

    }

    /* A methoto to set Patient Info */
    public void SetPtINfo() {
        Name.setText(Patient.getName());
        Number.setText(Patient.getNumber());
        Gender.setText(Patient.getGender());
        Age.setText(Patient.getDOB());
        BloodGrup.setText(Patient.getBlodGroup());
        Heigh.setText(Patient.getHeight());
        Weight.setText(""+Patient.getWeight());

    }

    public void SetMedicalReportTable() {
        Dtm = new DefaultTableModel();
        for (String string : PatientHead) {
            Dtm.addColumn(string);
        }
        MediclReportTable = new JTable(Dtm);
        MediclReportTable.getColumnModel().getColumn(0).setMaxWidth(100);
        MediclReportTable.getColumnModel().getColumn(1).setMinWidth(150);
        MediclReportTable.getColumnModel().getColumn(1).setMaxWidth(200);
        MediclReportTable.getColumnModel().getColumn(2).setMaxWidth(150);
        MediclReportTable.getColumnModel().getColumn(3).setMaxWidth(100);
        MediclReportTable.getColumnModel().getColumn(5).setMaxWidth(150);
        MediclReportTable.getColumnModel().getColumn(6).setMinWidth(50);
        MediclReportTable.getColumnModel().getColumn(6).setMaxWidth(100);
        jsp = new JScrollPane(MediclReportTable);
        jsp.setBounds(200, 180, 900, 250);
        BackPannel.add(jsp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GetPatitentBtn) {
            ResultSet AppointData = DBO.GetNextPatient();
            AppointMent appoinment = new AppointMent();
            
            MedEasePatient pt = new MedEasePatient();
            try{
            appoinment.setNumber(AppointData.getString(7));

            }catch(SQLException ex){

            }
            MedEasePatient.SetPTData(pt, DBO.GetPatient(appoinment.getNumber()));
            if (PTdata!=null) {
                Patient= new MedEasePatient();
                MedEasePatient.SetPTData(Patient, PTdata);
                SetPtINfo();
            }
            
                                            


        }

    }
}
