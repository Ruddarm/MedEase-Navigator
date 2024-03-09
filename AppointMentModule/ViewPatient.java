package MedEaseNavigator.AppointMentModule;

import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.DoctorDashBoard.ViewMedicalReport;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEaseMedicalReport;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class ViewPatient  implements TableColumnModelListener {
    MedCreatePatient pt;
    DBOperation DBO;
    JDialog ViewBox;
    MedPannel ProfilePannel, InfoPannel, ReportPannel;
    JScrollPane jsp;
    DefaultTableModel Dtm;
    MedEasePatient Patient;
    JTable MediclReportTable;
    JLabel PaitienTLogo, PID, Name, Number, Age, Gender, BloodGrup, Heigh, Weight, Allergy,ProfileLogo ;
    String PatientHead[] = {
            "MRID",
            "Date",
            "Chief Complaint",
            "Status",
            "Doctor Name"

    };

    public ViewPatient(DBOperation DBO, MedEasePatient Pt) {
        this.Patient = Pt;
        this.DBO = DBO;
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
        ProfileLogo=new JLabel(GUIUtil.PTICON);
        ProfileLogo.setBounds(0, 0, 150, 150);
        ProfilePannel.add(ProfileLogo);
        // BackPannel.add(ProfilePannel);
        ViewBox.add(ProfilePannel);
        /*
         * Setting info pannel;
         */

        InfoPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 10);
        InfoPannel.setBounds(180, 20, 620, 150);
        ViewBox.add(InfoPannel);

        PID = new JLabel(Patient.getStrPID());
        PID.setFont(GUIUtil.TimesBoldS2);
        PID.setBounds(10, 10, 100, 30);
        InfoPannel.add(PID);

        Name = new JLabel(Patient.getName());
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(10, 50, 100, 30);
        InfoPannel.add(Name);

        Number = new JLabel(Patient.getNumber());
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(10, 90, 100, 30);
        InfoPannel.add(Number);

        Age = new JLabel(Patient.getDOB());
        Age.setFont(GUIUtil.TimesBoldS2);
        Age.setBounds(50, 120, 100, 30);
        InfoPannel.add(Age);

        Gender = new JLabel(Patient.getGender());
        Gender.setFont(GUIUtil.TimesBoldS2);
        Gender.setBounds(150, 120, 100, 30);
        InfoPannel.add(Gender);

        BloodGrup = new JLabel(Patient.getBlodGroup());
        BloodGrup.setFont(GUIUtil.TimesBoldS2);
        BloodGrup.setBounds(240, 120, 120, 30);
        InfoPannel.add(BloodGrup);

        Heigh = new JLabel(Patient.getHeight());
        Heigh.setFont(GUIUtil.TimesBoldS2);
        Heigh.setBounds(365, 120, 100, 30);
        InfoPannel.add(Heigh);

        Weight = new JLabel(""+Patient.getWeight());
        Weight.setFont(GUIUtil.TimesBoldS2);
        Weight.setBounds(455, 120, 100, 30);
        InfoPannel.add(Weight);

        // Allergy = new JLabel();
        // Allergy.setFont(GUIUtil.TimesBoldS2);
        // Allergy.setBounds(545, 120, 200, 30);
        // InfoPannel.add(Allergy);

        /*
         * Settting Report Pannel
         */
        ReportPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 10);
        ReportPannel.setBounds(20, 190, 780, 300);
        ViewBox.add(ReportPannel);
        SetMedicalReportTable();
        /*
         * 
         */

    }
    

    public void SetMedicalReportTable() {
        Dtm = new DefaultTableModel();
        for (String string : PatientHead) {
            Dtm.addColumn(string);
        }
        ResultSet ReportData = DBO.GetMedicalReport(Patient.getStrPID());
        if (ReportData != null) {
            MedEasePatient.SetMedicalReport(Patient, ReportData);
            MedEaseMedicalReport Temp = Patient.getReportHead();
            while (Temp != null) {
                String row[] = {
                        Temp.getMRID(),
                        Temp.getReportDate(),
                        Temp.getChiefcomplaint(),
                        Temp.getStatus(),
                        Temp.getDID(),
                };
                Temp = Temp.getNext();
                Dtm.addRow(row);
            }
        }
        MediclReportTable  = new JTable(Dtm);
        MediclReportTable.getColumnModel().getColumn(0).setMaxWidth(100);
        MediclReportTable.getColumnModel().getColumn(1).setMaxWidth(150);
        MediclReportTable.getColumnModel().getColumn(2).setMinWidth(400);
        MediclReportTable.getColumnModel().getColumn(3).setMaxWidth(100);
        MediclReportTable.getColumnModel().getColumn(3).setMaxWidth(100);
        MediclReportTable.setRowSelectionAllowed(false);
        MediclReportTable.setColumnSelectionAllowed(false);
        MediclReportTable.setCellSelectionEnabled(true);
        TableColumnModel colummodel = MediclReportTable.getColumnModel();
        colummodel.addColumnModelListener(this);
        jsp = new JScrollPane(MediclReportTable);
        jsp.setBounds(0, 0, 780, 300);
        ReportPannel.add(jsp);

    }

    @Override
    public void columnAdded(TableColumnModelEvent e) {
    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            int row = MediclReportTable.getSelectedRow();
            if(row!=-1&& MediclReportTable.getSelectedColumn()==0){
                MedEaseMedicalReport Temp = Patient.getReportHead();
                int i =0;
                while (i<row) {
                    Temp= Temp.getNext();
                    i++;
                }
                new ViewMedicalReport(Patient, DBO, null, Temp, false);
                MediclReportTable.clearSelection();
            }
        }
    }

}
