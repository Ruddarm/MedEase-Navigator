package MedEaseNavigator.DoctorDashBoard;

import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MedDoctorDashBoard {
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
    MedEaseBtn GetPatitentBtn, MedicalReportBtn;
    String PatientHead[] = {
            "PID",
            "Name",
            "Number",
            "MRID",
            "Chief Complaint",
            "Date",
            "Doctor Name"

    };

    public MedDoctorDashBoard() {
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 0);
        BackPannel.setBounds(0, 100, 1440, 500);
        docDasBoarUtil.DoctorFrame.add(BackPannel);
        ProfielBox = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 5);
        ProfielBox.setBounds(135, 20, 150, 150);
        BackPannel.add(ProfielBox);
        InfoBox = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 5);
        // InfoBox.setBounds(305, 20, 1000, 150); for 15inch
        InfoBox.setBounds(305, 20, 850, 150);

        BackPannel.add(InfoBox);
        SetMedicalReportTable();
        GetPatitentBtn = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 10);
        GetPatitentBtn.setText("Get Patient");
        GetPatitentBtn.setBounds(800, 450, 150, 40);
        BackPannel.add(GetPatitentBtn);

        PID = new JLabel(PID);
        PID.setFont(GUIUtil.TimesBold);
        PID.setBounds(10, 20, 100, 30);
        InfoBox.add(PID);

        MedicalReportBtn = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 10);
        MedicalReportBtn.setText("Medical Report");
        MedicalReportBtn.setBounds(500, 450, 150, 40);
        BackPannel.add(MedicalReportBtn);

    }

    /* A methoto to set Patient Info */
    public void SetPtINfo() {

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
}
