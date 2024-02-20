package MedEaseNavigator.DoctorDashBoard;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.NotificationMoudle.MedEaseNotify;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEaseMedicalReport;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.time.LocalTime;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedDoctorDashBoard implements ActionListener, TableColumnModelListener {
    DocDasBoarUtil docDasBoarUtil = new DocDasBoarUtil();
    MedPannel BackPannel, ProfielBox, InfoBox;
    /*
     * 
     */
    JLabel WelcomLogo;
    /*
     * Patitent information
     */
    JLabel PaitienTLogo, PID, Name, Number, Age, Gender, BloodGrup, Heigh, Weight, Allergy, NotFondLabel, PID_L, Name_L,
            Height_L, Weight_L,
            BloodGrup_L,
            Gender_L,
            Age_L,
            Number_L;
    MedEaseBtn Update, Next, CreateMedicalReport;
    JTable MediclReportTable;
    DefaultTableModel Dtm;
    JScrollPane jsp;
    MedEasePatient Patient;
    MedEaseBtn GetPatitentBtn, MedicalReportBtn, CloseAppointmentBtn;
    ResultSet PTdata;
    DBOperation DBO;
    MedEaseMedicalReport Temp;
    MedEaseNotify Notify;
    String PatientHead[] = {

            // "PID",
            // "Name",
            // "Number",
            "MRID",
            "Date",
            "Chief Complaint",
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
        Patient = new MedEasePatient();
        SetMedicalReportTable(Patient);

        GetPatitentBtn = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 5);
        GetPatitentBtn.setText("Get Patient");
        GetPatitentBtn.setBounds(800, 450, 150, 40);
        GetPatitentBtn.addActionListener(this);
        BackPannel.add(GetPatitentBtn);
        MedicalReportBtn = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 5);
        MedicalReportBtn.setText("Medical Report");
        MedicalReportBtn.setBounds(600, 450, 150, 40);
        MedicalReportBtn.addActionListener(this);
        BackPannel.add(MedicalReportBtn);
        CloseAppointmentBtn = new MedEaseBtn(GUIUtil.RedClr, GUIUtil.RedClr, null, 5);
        CloseAppointmentBtn.setText("Close");
        CloseAppointmentBtn.setBounds(1000, 450, 150, 40);
        CloseAppointmentBtn.addActionListener(this);
        BackPannel.add(CloseAppointmentBtn);
        Update = new MedEaseBtn(GUIUtil.Base_Background, GUIUtil.Base_Background, null, 10);
        Update.setText("UPDATE");
        Update.setBounds(740, 115, 100, 30);
        InfoBox.add(Update);

        PID_L = new JLabel("Patient ID   : ");
        PID_L.setFont(GUIUtil.TimesBoldS2);
        PID_L.setBounds(10, 10, 120, 30);
        InfoBox.add(PID_L);

        PID = new JLabel("PID");
        PID.setFont(GUIUtil.TimesBoldS2);
        PID.setBounds(150, 10, 100, 30);
        InfoBox.add(PID);

        Name_L = new JLabel("Name           :");
        Name_L.setFont(GUIUtil.TimesBoldS2);
        Name_L.setBounds(10, 50, 120, 30);
        InfoBox.add(Name_L);

        Name = new JLabel("Name");
        Name.setFont(GUIUtil.TimesBoldS2);
        Name.setBounds(150, 50, 200, 30);
        InfoBox.add(Name);

        Number_L = new JLabel("Number      :");
        Number_L.setFont(GUIUtil.TimesBoldS2);
        Number_L.setBounds(10, 90, 120, 30);
        InfoBox.add(Number_L);

        Number = new JLabel("Number");
        Number.setFont(GUIUtil.TimesBoldS2);
        Number.setBounds(150, 90, 200, 30);
        InfoBox.add(Number);

        Age_L = new JLabel("DOB : ");
        Age_L.setFont(GUIUtil.TimesBoldS2);
        Age_L.setBounds(30, 120, 100, 30);
        InfoBox.add(Age_L);

        Age = new JLabel("   ");
        Age.setFont(GUIUtil.TimesBoldS2);
        Age.setBounds(100, 120, 100, 30);
        InfoBox.add(Age);

        Gender_L = new JLabel("GENDER  :");
        Gender_L.setFont(GUIUtil.TimesBoldS2);
        Gender_L.setBounds(200, 120, 100, 30);
        InfoBox.add(Gender_L);

        Gender = new JLabel(" ");
        Gender.setFont(GUIUtil.TimesBoldS2);
        Gender.setBounds(300, 120, 100, 30);
        InfoBox.add(Gender);

        BloodGrup_L = new JLabel("BLOOD GRP :");
        BloodGrup_L.setFont(GUIUtil.TimesBoldS2);
        BloodGrup_L.setBounds(330, 120, 180, 30);
        InfoBox.add(BloodGrup_L);

        BloodGrup = new JLabel(" ");
        BloodGrup.setFont(GUIUtil.TimesBoldS2);
        BloodGrup.setBounds(460, 120, 120, 30);
        InfoBox.add(BloodGrup);

        Height_L = new JLabel("HEIGHT :");
        Height_L.setFont(GUIUtil.TimesBoldS2);
        Height_L.setBounds(490, 120, 100, 30);
        InfoBox.add(Height_L);

        Heigh = new JLabel(" ");
        Heigh.setFont(GUIUtil.TimesBoldS2);
        Heigh.setBounds(580, 120, 100, 30);
        InfoBox.add(Heigh);

        Weight_L = new JLabel("WEIGHT :");
        Weight_L.setFont(GUIUtil.TimesBoldS2);
        Weight_L.setBounds(620, 120, 100, 30);
        InfoBox.add(Weight_L);

        Weight = new JLabel(" ");
        Weight.setFont(GUIUtil.TimesBoldS2);
        Weight.setBounds(710, 120, 100, 30);
        InfoBox.add(Weight);
        Notify = new MedEaseNotify();

        // Allergy = new JLabel("Allergy");
        // Allergy.setFont(GUIUtil.TimesBoldS2);
        // Allergy.setBounds(590, 120, 200, 30);
        // InfoBox.add(Allergy);

    }

    /* A methoto to set Patient Info */
    public void SetPtINfo() {
        PID.setText(Patient.getStrPID());
        Name.setText(Patient.getName());
        Number.setText(Patient.getNumber());
        Gender.setText(Patient.getGender());
        Age.setText(Patient.getDOB());
        BloodGrup.setText(Patient.getBlodGroup());
        Heigh.setText(Patient.getHeight());
        Weight.setText("" + Patient.getWeight());

    }

    public void SetMedicalReportTable(MedEasePatient PT) {
        Dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (String string : PatientHead) {
            Dtm.addColumn(string);
        }
        if (PT != null) {
            System.out.println("Ye oth nala niklaa");
            ResultSet MedicalReport = DBO.GetMedicalReport(PT.getStrPID());
            if (MedicalReport != null) {
                PT.setReportHead(null);
                MedEasePatient.SetMedicalReport(PT, MedicalReport);
                MedEaseMedicalReport Temp = PT.getReportHead();
                // int n = 0;
                while (Temp != null) {
                    String row[] = {
                            Temp.getMRID(),
                            Temp.getReportDate(),
                            Temp.getChiefcomplaint(),
                            Temp.getDID(),
                    };
                    // System.out.println(Temp.getMRID());
                    // System.out.println(row[1]);
                    // n++;
                    Temp = Temp.getNext();
                    Dtm.addRow(row);
                }
                // System.out.println("Total row " + n);
            }
        }
        MediclReportTable = new JTable(Dtm);
        // MediclReportTable.getColumnModel().getColumn(0).setMaxWidth(100);
        // MediclReportTable.getColumnModel().getColumn(1).setMinWidth(150);
        // MediclReportTable.getColumnModel().getColumn().setMaxWidth(200);
        // MediclReportTable.getColumnModel().getColumn(0).setMaxWidth(150);
        MediclReportTable.getColumnModel().getColumn(0).setMaxWidth(100);
        MediclReportTable.getColumnModel().getColumn(1).setMaxWidth(150);
        MediclReportTable.getColumnModel().getColumn(2).setMinWidth(500);
        MediclReportTable.getColumnModel().getColumn(3).setMaxWidth(100);
        MediclReportTable.setRowSelectionAllowed(false);
        MediclReportTable.setColumnSelectionAllowed(false);
        MediclReportTable.setCellSelectionEnabled(true);
        TableColumnModel colummodel = MediclReportTable.getColumnModel();
        colummodel.addColumnModelListener(this);

        jsp = new JScrollPane(MediclReportTable);
        jsp.setBounds(200, 180, 900, 250);
        BackPannel.add(jsp);
    }

    public void restdata() {
        PID.setText(" ");
        Name.setText(" ");
        Number.setText(" ");
        Age.setText(" ");
        BloodGrup.setText(" ");
        Heigh.setText(" ");
        Weight.setText(" ");
        Gender.setText(" ");
        SetMedicalReportTable(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GetPatitentBtn) {
            GetPtFunction();

        } else if (e.getSource() == MedicalReportBtn) {
            new ViewMedicalReport(Patient, DBO, null, null, true);

        } else if (e.getSource() == CloseAppointmentBtn) {
            if (Patient != null) {
                AppointMent appoint = new AppointMent();
                appoint.setPID(Patient.getStrPID());
                appoint.setIntime("" + LocalTime.now());
                appoint.setStatus("PAYMENT");
                DBO.UpdateAppointment(appoint);
                restdata();
            }
        }

    }

    public void GetPtFunction() {
        ResultSet AppointData = DBO.GetNextPatient();
        String number = "";
        if (AppointData != null) {
            try {
                number = AppointData.getString(7);
            } catch (SQLException ex) {

            }
        } else {
            Notify.setMsg("Patient Not found", -1);
            return;
        }
        Patient = new MedEasePatient();
        ResultSet PTdata = DBO.GetPatient(number);
        if (PTdata != null) {
            MedEasePatient.SetPTData(Patient, PTdata);
            SetPtINfo();
        }
        BackPannel.remove(jsp);
        BackPannel.repaint();
        SetMedicalReportTable(Patient);

    }

    @Override
    public void columnAdded(TableColumnModelEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'columnAdded'");
    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'columnRemoved'");
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'columnMoved'");
    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        //
        // 'columnMarginChanged'");
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub
        if (!e.getValueIsAdjusting()) {
            int row = MediclReportTable.getSelectedRow();
            if (row != -1 && MediclReportTable.getSelectedColumn() == 0) {
                int i = 0;
                Temp = Patient.getReportHead();
                while (i < row) {
                    Temp = Temp.getNext();
                    i++;
                }
                new ViewMedicalReport(Patient, DBO, null, Temp, false);
                MediclReportTable.clearSelection();
            }
        }
    }
}
