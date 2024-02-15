package MedEaseNavigator.AppointMentModule;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class ViewPatient {
    MedCreatePatient pt;
    DBOperation DBO;
    JDialog ViewBox;
    MedPannel ProfilePannel, InfoPannel, ReportPannel;
    JScrollPane jsp;
    DefaultTableModel Dtm;
    JTable MediclReportTable;
    JLabel PaitienTLogo, PID, Name, Number, Age, Gender, BloodGrup, Heigh, Weight, Allergy;
    String PatientHead[] = {
            "PID",
            "Name",
            "Number",
            "MRID",
            "Chief Complaint",
            "Date",
            "Doctor Name"

    };

    public ViewPatient(DBOperation DBO, MedEasePatient Pt) {
        ViewBox = new JDialog();
        ViewBox.setLayout(null);
        ViewBox.setBounds(100, 100, 830, 550);
        ViewBox.getContentPane().setBackground(GUIUtil.Dark_BLue);
        ViewBox.setVisible(true);
        ViewBox.setResizable(false);

        /*
         * Setting profile box pannel
         */
        ProfilePannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 10);
        ProfilePannel.setBounds(20, 20, 150, 150);
        ViewBox.add(ProfilePannel);
        /*
         * Setting info pannel;
         */

        InfoPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 10);
        InfoPannel.setBounds(180, 20, 620, 150);
        ViewBox.add(InfoPannel);

        PID = new JLabel("PID");
        PID.setFont(GUIUtil.TimesBoldS2);
        PID.setBounds(10, 10, 100, 30);
        InfoPannel.add(PID);

        Name = new JLabel("Name");
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(10, 50, 100, 30);
        InfoPannel.add(Name);

        Number = new JLabel("Number");
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(10, 90, 100, 30);
        InfoPannel.add(Number);

        Age = new JLabel("Age");
        Age.setFont(GUIUtil.TimesBoldS2);
        Age.setBounds(80, 120, 100, 30);
        InfoPannel.add(Age);

        Gender = new JLabel("Gender");
        Gender.setFont(GUIUtil.TimesBoldS2);
        Gender.setBounds(150, 120, 100, 30);
        InfoPannel.add(Gender);

        BloodGrup = new JLabel("Blood Group");
        BloodGrup.setFont(GUIUtil.TimesBoldS2);
        BloodGrup.setBounds(240, 120, 120, 30);
        InfoPannel.add(BloodGrup);

        Heigh = new JLabel("Height");
        Heigh.setFont(GUIUtil.TimesBoldS2);
        Heigh.setBounds(365, 120, 100, 30);
        InfoPannel.add(Heigh);

        Weight = new JLabel("Weight");
        Weight.setFont(GUIUtil.TimesBoldS2);
        Weight.setBounds(455, 120, 100, 30);
        InfoPannel.add(Weight);

        Allergy = new JLabel("Allergy");
        Allergy.setFont(GUIUtil.TimesBoldS2);
        Allergy.setBounds(545, 120, 200, 30);
        InfoPannel.add(Allergy);

        /*
         * Settting Report Pannel
         */
        ReportPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 10);
        ReportPannel.setBounds(20, 190, 780, 300);
        ViewBox.add(ReportPannel);

        /*
         * 
         */

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
        ReportPannel.add(jsp);

    }

}
