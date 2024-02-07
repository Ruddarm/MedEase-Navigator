/*
 * GUI interface to add patient 
 * 
 */
package MedEaseNavigator.AppointMentModule;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class MedCreatePatient {

    JDialog CreateDailog;
    JLabel CreateHeadingLabel, pid, PatientName, PatientNumber, DOB, Gender, Height, Weight, BloodGroup, Allergy;
    MedPannel BackPannel;
    JTextField PidField, NameField, NumberField, DOBfeild, GenderFeild, HeightFeild, WeightFeild, GroupFeild,
            AllergyField;
    MedEaseBtn AddPatientBtn;

    public MedCreatePatient() {
        CreateDailog = new JDialog();
        CreateDailog.getContentPane().setBackground(GUIUtil.Dark_BLue);
        CreateDailog.setBounds(200, 100, 450, 500);
        CreateDailog.setVisible(true);
        CreateDailog.setLayout(null);
        BackPannel = new MedPannel(GUIUtil.MedEaseGrey, GUIUtil.MedEaseGrey, null, 0);
        BackPannel.setBackground(GUIUtil.Dark_BLue);
        BackPannel.setBounds(0, 40, 450, 475);
        CreateDailog.add(BackPannel);
        CreateHeadingLabel = new JLabel();
        CreateHeadingLabel.setText("Create Patient");
        CreateHeadingLabel.setForeground(GUIUtil.WhiteClr);
        CreateHeadingLabel.setFont(GUIUtil.TimesBoldS2);
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
        // NumberField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(NumberField);

        // DOB LABEL
        DOB = new JLabel("DOB");
        DOB.setFont(GUIUtil.TimesBoldS2);
        DOB.setBounds(57, 180, 100, 30);
        BackPannel.add(DOB);

        // DOB TEXT FIELd
        DOBfeild = new JTextField();
        DOBfeild.setBounds(15, 215, 120, 30);
        DOBfeild.setFont(GUIUtil.TimesBoldS2);
        DOBfeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(DOBfeild);

        // GENDER LABEL
        Gender = new JLabel("GENDER");
        Gender.setFont(GUIUtil.TimesBoldS2);
        Gender.setBounds(170, 180, 100, 30);
        BackPannel.add(Gender);

        // GENDER TEXTFIELD
        GenderFeild = new JTextField();
        GenderFeild.setBounds(150, 215, 120, 30);
        GenderFeild.setFont(GUIUtil.TimesBoldS2);
        GenderFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(GenderFeild);

        // HEIGHT LABEL
        Height = new JLabel("HEIGHT");
        Height.setFont(GUIUtil.TimesBoldS2);
        Height.setBounds(305, 180, 100, 30);
        BackPannel.add(Height);

        // HEIGHT TEXTFIELD
        HeightFeild = new JTextField();
        HeightFeild.setBounds(290, 215, 120, 30);
        HeightFeild.setFont(GUIUtil.TimesBoldS2);
        HeightFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(HeightFeild);

        // WEIGHT LABEL
        Weight = new JLabel("WEIGHT");
        Weight.setFont(GUIUtil.TimesBoldS2);
        Weight.setBounds(38, 270, 120, 30);
        BackPannel.add(Weight);

        // WEIGHT TEXT FIELd
        WeightFeild = new JTextField();
        WeightFeild.setBounds(15, 305, 120, 30);
        WeightFeild.setFont(GUIUtil.TimesBoldS2);
        WeightFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(WeightFeild);

        // BLOODGRP LABEL
        BloodGroup = new JLabel("BLOOD GRP");
        BloodGroup.setFont(GUIUtil.TimesBoldS2);
        BloodGroup.setBounds(150, 270, 130, 30);
        BackPannel.add(BloodGroup);

        // BLOOD GROUP TEXTFIELD
        GroupFeild = new JTextField();
        GroupFeild.setBounds(150, 305, 120, 30);
        GroupFeild.setFont(GUIUtil.TimesBoldS2);
        GroupFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(GroupFeild);

        // Allergy LABEL
        Allergy = new JLabel("ALLERGY");
        Allergy.setFont(GUIUtil.TimesBoldS2);
        Allergy.setBounds(305, 270, 120, 30);
        BackPannel.add(Allergy);

        // Allergy TEXTFIELD
        AllergyField = new JTextField();
        AllergyField.setBounds(290, 305, 120, 30);
        AllergyField.setFont(GUIUtil.TimesBoldS2);
        AllergyField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BackPannel.add(AllergyField);

        // ADD BUTTON
        AddPatientBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 10);
        AddPatientBtn.setBounds(280, 380, 150, 35);
        AddPatientBtn.setText("Add");
        AddPatientBtn.setForeground(GUIUtil.WhiteClr);
        AddPatientBtn.setFont(GUIUtil.TimesBoldS2);
        BackPannel.add(AddPatientBtn);

    }

}
