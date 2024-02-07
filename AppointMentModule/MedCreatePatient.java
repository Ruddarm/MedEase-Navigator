/*
 * GUI interface to add patient 
 * 
 */
package MedEaseNavigator.AppointMentModule;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
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
import java.awt.event.ActionListener;;

public class MedCreatePatient implements ActionListener {

    JDialog CreateDailog;
    JLabel CreateHeadingLabel, pid, PatientName, PatientNumber, DOB, Gender, Height, Weight, BloodGroup, Allergy;
    MedPannel BackPannel;
    JTextField PidField, NameField, NumberField, DOBfeild, GenderFeild, HeightFeild, WeightFeild, GroupFeild,
            AllergyField;
    MedEaseBtn AddPatientBtn;
    DBOperation DBO;
    JComboBox<String> Genderopt;

    String Number;

    public MedCreatePatient(DBOperation dbo,String Number) {
        this.Number=Number;
        this.DBO=dbo;
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
        PidField.setText("PID"+DBO.GetLastPID());
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
        DOB.setBounds(57, 180, 100, 30);
        BackPannel.add(DOB);

        // DOB TEXT FIELd
        DOBfeild = new JTextField();
        DOBfeild.setBounds(15, 215, 120, 30);
        DOBfeild.setFont(GUIUtil.TimesBold);
        DOBfeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(DOBfeild);

        // GENDER LABEL
        Gender = new JLabel("GENDER");
        Gender.setFont(GUIUtil.TimesBold);
        Gender.setBounds(170, 180, 100, 30);
        BackPannel.add(Gender);

        // GENDER TEXTFIELD
        // GenderFeild = new JTextField();
        // GenderFeild.setBounds(150, 215, 120, 30);
        // GenderFeild.setFont(GUIUtil.TimesBold);
        // GenderFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // BackPannel.add(GenderFeild);
        String gender[]={"M","F","NA"};
        Genderopt = new JComboBox<String>(gender);
        Genderopt.setBounds(150, 215, 120, 30);
        Genderopt.setFont(GUIUtil.TimesBoldS2);
        Genderopt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(Genderopt);  

        // HEIGHT LABEL
        Height = new JLabel("HEIGHT");
<<<<<<< HEAD
        Height.setFont(GUIUtil.TimesBoldS2);
        Height.setBounds(305, 180, 100, 30);
=======
        Height.setFont(GUIUtil.TimesBold);
        Height.setBounds(304, 180, 100, 30);
>>>>>>> 9ba5552436dac00505e23d85c27a7ac890261c81
        BackPannel.add(Height);

        // HEIGHT TEXTFIELD
        HeightFeild = new JTextField();
        HeightFeild.setBounds(290, 215, 120, 30);
        HeightFeild.setFont(GUIUtil.TimesBold);
        HeightFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(HeightFeild);

        // WEIGHT LABEL
        Weight = new JLabel("WEIGHT");
        Weight.setFont(GUIUtil.TimesBold);
        Weight.setBounds(38, 270, 120, 30);
        BackPannel.add(Weight);

        // WEIGHT TEXT FIELd
        WeightFeild = new JTextField();
        WeightFeild.setBounds(15, 305, 120, 30);
        WeightFeild.setFont(GUIUtil.TimesBold);
        WeightFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(WeightFeild);

        // BLOODGRP LABEL
        BloodGroup = new JLabel("BLOOD GROUP");
        BloodGroup.setFont(GUIUtil.TimesBold);
        BloodGroup.setBounds(150, 270, 130, 30);
        BackPannel.add(BloodGroup);

        // BLOOD GROUP TEXTFIELD
        GroupFeild = new JTextField();
        GroupFeild.setBounds(150, 305, 120, 30);
        GroupFeild.setFont(GUIUtil.TimesBold);
        GroupFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(GroupFeild);

        // Allergy LABEL
        Allergy = new JLabel("ALLERGY");
        Allergy.setFont(GUIUtil.TimesBold);
        Allergy.setBounds(305, 270, 120, 30);
        BackPannel.add(Allergy);

        // Allergy TEXTFIELD
        AllergyField = new JTextField();
        AllergyField.setBounds(290, 305, 120, 30);
        AllergyField.setFont(GUIUtil.TimesBold);
        AllergyField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(AllergyField);

        // ADD BUTTON
        AddPatientBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 10);
        AddPatientBtn.setBounds(280, 380, 150, 35);
        AddPatientBtn.setText("Add");
        AddPatientBtn.setForeground(GUIUtil.WhiteClr);
        AddPatientBtn.setFont(GUIUtil.TimesBold);
        BackPannel.add(AddPatientBtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddPatientBtn){
            if(NameField.getText().trim().isEmpty()){
                // warn label   
            }
            MedEasePatient pt=new MedEasePatient();
            pt.setStrPID(PidField.getText());
            pt.setName(NameField.getText());
            pt.setNumber(NumberField.getText());
            pt.setDOB(DOBfeild.getText());
            pt.setBlodGroup(GroupFeild.getText());
            // pt.setGender(Number);
        }    
    }
}
