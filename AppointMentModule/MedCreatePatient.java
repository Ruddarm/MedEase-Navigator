/*
 * GUI interface to add patient 
 * 
 */
package MedEaseNavigator.AppointMentModule;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.format.DateTimeFormatter;

public class MedCreatePatient extends KeyAdapter implements ActionListener {
    JDialog CreateDailog;
    JLabel CreateHeadingLabel, pid, PatientName, PatientNumber, DOB, Gender, Height, Weight, BloodGroup, Allergy;
    MedPannel BackPannel;
    JTextField PidField, NameField, NumberField, DOBfeild, GenderFeild, HeightFeild, WeightFeild, GroupFeild,
            AllergyField;
    MedEaseBtn AddPatientBtn;
    DBOperation DBO;
    JComboBox<String> Genderopt;
    JComboBox<String> Dateopt;
    int intpid;

    JComboBox<String> Monthopt;
    JComboBox<String> Yearopt;
    DefaultListCellRenderer LR;

    String Number;

    public MedCreatePatient(DBOperation dbo, String Number) {
        this.Number = Number;
        this.DBO = dbo;
        CreateDailog = new JDialog();
        CreateDailog.getContentPane().setBackground(GUIUtil.Dark_BLue);
        CreateDailog.setBounds(200, 100, 450, 500);
        CreateDailog.setVisible(true);
        CreateDailog.setLayout(null);
        CreateDailog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BackPannel = new MedPannel(GUIUtil.MedEaseGrey, GUIUtil.MedEaseGrey, null, 0);
        BackPannel.setBackground(GUIUtil.Dark_BLue);
        BackPannel.setBounds(0, 40, 450, 475);
        CreateDailog.add(BackPannel);
        CreateHeadingLabel = new JLabel();
        CreateHeadingLabel.setText("Create Patient");
        CreateHeadingLabel.setForeground(GUIUtil.WhiteClr);
        CreateHeadingLabel.setFont(GUIUtil.TimesBold);
        CreateHeadingLabel.setBounds(10, 10, 150, 20);
        CreateDailog.add(CreateHeadingLabel);
        /*
         * 
         */

        // pid LABEL
        pid = new JLabel("PID            :");
        pid.setFont(GUIUtil.TimesBoldS2);
        pid.setBounds(20, 20, 100, 30);
        BackPannel.add(pid);

        // Text Field for pid
        PidField = new JTextField();
        PidField.setBounds(130, 20, 300, 30);
        PidField.setFont(GUIUtil.TimesBoldS2);
        intpid=DBO.GetLastPID();
        PidField.setText("PID" + intpid);
        PidField.setEditable(false);
        // PidField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(PidField);

        // NAME LABEL
        PatientName = new JLabel("NAME       :");
        PatientName.setFont(GUIUtil.TimesBoldS2);
        PatientName.setBounds(20, 70, 100, 30);
        BackPannel.add(PatientName);

        // NAME TEXTFIELD
        NameField = new JTextField();
        NameField.setBounds(130, 70, 300, 30);
        NameField.setFont(GUIUtil.TimesBoldS2);
        // NameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(NameField);

        // NUMBER LABEL
        PatientNumber = new JLabel("NUMBER  :");
        PatientNumber.setFont(GUIUtil.TimesBoldS2);
        PatientNumber.setBounds(20, 120, 100, 30);
        BackPannel.add(PatientNumber);

        // NUMBER TEXT FIELD
        NumberField = new JTextField();
        NumberField.setBounds(130, 120, 300, 30);
        NumberField.setFont(GUIUtil.TimesBoldS2);
        NumberField.setText(Number);
        NumberField.setEditable(false);
        // NumberField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(NumberField);

        // DOB LABEL
        DOB = new JLabel("DOB");
        DOB.setFont(GUIUtil.TimesBold);
        DOB.setBounds(145, 180, 100, 30);
        BackPannel.add(DOB);

        // DOB TEXT FIELd
        // DOBfeild = new JTextField();
        // DOBfeild.setBounds(15, 215, 120, 30);
        // DOBfeild.setFont(GUIUtil.TimesBold);
        // DOBfeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // BackPannel.add(DOBfeild);

        LR = new DefaultListCellRenderer();
        LR.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        String Day[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        Dateopt = new JComboBox<String>(Day);
        Dateopt.setBounds(15, 215, 60, 30);
        Dateopt.setFont(GUIUtil.TimesBoldS2);
        Dateopt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Dateopt.setRenderer(LR);
        BackPannel.add(Dateopt);

        String Months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        Monthopt = new JComboBox<String>(Months);
        Monthopt.setBounds(69, 215, 120, 30);
        Monthopt.setFont(GUIUtil.TimesBoldS2);
        Monthopt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Monthopt.setRenderer(LR);
        BackPannel.add(Monthopt);

        String Year[] = { "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014","2013", "2012",
                         "2011", "2010", "2009","2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", 
                         "1998", "1997", "1996","1995", "1994", "1993", "1992", "1991", "1990", "1989", "1987", "1986", "1985", 
                         "1984", "1983", "1982", "1981", "1980","1979","1978","1977","1976","1975","1974","1973","1972","1971",
                         "1970","1969","1968","1967","1966","1965","1964","1963","1962","1961","1960","1959","1958","1957","1956",
                        "1955","1954","1953","1952","1951","1950","1949","1948","1947","1946","1945","1944","1942","1941","1940",
                        "1939","1938","1937","1936","1935","1934","1933","1932","1931","1930","1929","1928","1927","1925","1924" };
        Yearopt = new JComboBox<String>(Year);
        Yearopt.setBounds(185, 215, 90, 30);
        Yearopt.setFont(GUIUtil.TimesBoldS2);
        Yearopt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Yearopt.setRenderer(LR);
        BackPannel.add(Yearopt);

        // GENDER LABEL
        // DOBfeild = new JTextField();
        // DOBfeild.setBounds(15, 215, 120, 30);
        // DOBfeild.setFont(GUIUtil.TimesBold);
        // DOBfeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Gender = new JLabel("GENDER");
        Gender.setFont(GUIUtil.TimesBold);
        Gender.setBounds(305, 180, 100, 30);
        BackPannel.add(Gender);

        // GENDER TEXTFIELD
        // GenderFeild = new JTextField();
        // GenderFeild.setBounds(150, 215, 120, 30);
        // GenderFeild.setFont(GUIUtil.TimesBold);
        // GenderFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // BackPannel.add(GenderFeild);
        String gender[] = { "M", "F", "NA" };
        Genderopt = new JComboBox<String>(gender);
        Genderopt.setBounds(290, 215, 120, 30);
        Genderopt.setFont(GUIUtil.TimesBoldS2);
        Genderopt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(Genderopt);

        // HEIGHT LABEL
        Height = new JLabel("HEIGHT");

        Height.setFont(GUIUtil.TimesBoldS2);
        Height.setBounds(57, 270, 100, 30);
        Height.setFont(GUIUtil.TimesBold);
        BackPannel.add(Height);

        // HEIGHT TEXTFIELD
        HeightFeild = new JTextField();
        HeightFeild.setBounds(15, 305, 120, 30);
        HeightFeild.setFont(GUIUtil.TimesBold);
        HeightFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        HeightFeild.addKeyListener(this);
        BackPannel.add(HeightFeild);

        // WEIGHT LABEL
        Weight = new JLabel("WEIGHT");
        Weight.setFont(GUIUtil.TimesBold);
        Weight.setBounds(170, 270, 120, 30);
        BackPannel.add(Weight);

        // WEIGHT TEXT FIELd
        WeightFeild = new JTextField();
        WeightFeild.setBounds(150, 305, 120, 30);
        WeightFeild.setFont(GUIUtil.TimesBold);
        WeightFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        WeightFeild.addKeyListener(this);
        BackPannel.add(WeightFeild);

        // BLOODGRP LABEL
        BloodGroup = new JLabel("BLOOD GROUP");
        BloodGroup.setFont(GUIUtil.TimesBold);
        BloodGroup.setBounds(305, 270, 120, 30);
        BackPannel.add(BloodGroup);

        // BLOOD GROUP TEXTFIELD
        GroupFeild = new JTextField();
        GroupFeild.setBounds(290, 305, 120, 30);
        GroupFeild.setFont(GUIUtil.TimesBold);
        GroupFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GroupFeild.addKeyListener(this);
        BackPannel.add(GroupFeild);

        // Allergy LABEL
        // Allergy = new JLabel("ALLERGY");
        // Allergy.setFont(GUIUtil.TimesBold);
        // Allergy.setBounds(305, 270, 120, 30);
        // BackPannel.add(Allergy);

        // Allergy TEXTFIELD
        // AllergyField = new JTextField();
        // AllergyField.setBounds(290, 305, 120, 30);
        // AllergyField.setFont(GUIUtil.TimesBold);
        // AllergyField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // BackPannel.add(AllergyField);

        // ADD BUTTON
        AddPatientBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 10);
        AddPatientBtn.setBounds(280, 380, 150, 35);
        AddPatientBtn.setText("Add");
        AddPatientBtn.setForeground(GUIUtil.WhiteClr);
        AddPatientBtn.setFont(GUIUtil.TimesBold);
        AddPatientBtn.addActionListener(this);
        AddPatientBtn.addKeyListener(this);
        BackPannel.add(AddPatientBtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == AddPatientBtn) {
            if (NameField.getText().trim().isEmpty()) {
                // warn label
            }
            MedEasePatient pt = new MedEasePatient();
            int Weight = 0;
            if (e.getSource() == AddPatientBtn) {

                System.out.println("btn click");
                if (NameField.getText().trim().isEmpty()) {
                    // warn label
                }
                if (HeightFeild.getText().length() > 5) {
                    System.out.println("true");
                    HeightFeild.setForeground(GUIUtil.WarningColor);
                    return;
                }
                if (GroupFeild.getText().length() > 3) {
                    GroupFeild.setForeground(GUIUtil.WarningColor);
                    return;
                }
                try {
                    Weight = Integer.parseInt(WeightFeild.getText());

                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                    WeightFeild.setForeground(GUIUtil.WarningColor);
                }
            }
            pt = new MedEasePatient();
            pt.setStrPID(PidField.getText());
            pt.setName(NameField.getText());
            pt.setPID(Weight);
            pt.setNumber(NumberField.getText());
            String mnth = ""+ (1+Monthopt.getSelectedIndex());
            System.out.println(mnth);
            String date= ""+Yearopt.getSelectedItem()+"-"+mnth+"-"+Dateopt.getSelectedItem();
            pt.setDOB(date);
            pt.setBlodGroup(GroupFeild.getText());
            pt.setHeight(HeightFeild.getText());
            pt.setWeight(Weight);
            pt.setGender("" + Genderopt.getSelectedItem());
            pt.setIsVlaid(true);
            pt.setPID(intpid);
            if(DBO.InsertPatient(pt)){  
                
                CreateDailog.dispose();
                new ScheduleAppointment(DBO, pt);
            }


        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == HeightFeild) {
            HeightFeild.setForeground(Color.black);
        }
        if (e.getSource() == WeightFeild) {
            HeightFeild.setForeground(Color.BLACK);
        }
        if (e.getSource() == BloodGroup) {
            BloodGroup.setForeground(Color.black);
        }
    }

}
