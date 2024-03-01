package MedEaseNavigator.DoctorDashBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.MediaSize.NA;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEaseDoctor;

public class AddDoctor {
    DBOperation DBO;
    JDialog AddBox;
    JLabel DID, Name, Number, UserName, Password, Age, warnJLabel;
    JTextField DIDFeild, NameFeild, NumberFeild, UserNameFeild, PasswordFeild, AgeFeild;
    MedEaseBtn AddDocBtn;

    public AddDoctor(DBOperation dbo) {
        this.DBO = dbo;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddBox = new JDialog();
                AddBox.setTitle("Add Doctor");
                AddBox.setFont(GUIUtil.TimesBold);
                AddBox.setLayout(null);
                AddBox.setBounds(300, 50, 400, 450);
                AddBox.setVisible(true);
                AddBox.getContentPane().setBackground(GUIUtil.Base_Background);
                warnJLabel = new JLabel();
                warnJLabel.setText("warn");
                warnJLabel.setFont(GUIUtil.TimesBold);
                warnJLabel.setForeground(GUIUtil.RedClr);
                warnJLabel.setBounds(180, 10, 150, 10);
                warnJLabel.setVisible(false);
                DID = new JLabel("DID");
                DID.setFont(GUIUtil.TimesBold);
                DID.setBounds(70, 30, 100, 30);
                AddBox.add(DID);
                DIDFeild = new JTextField();
                DIDFeild.setFont(GUIUtil.TimesBold);
                DIDFeild.setBounds(180, 30, 150, 30);
                AddBox.add(DIDFeild);

                Name = new JLabel("Name");
                Name.setFont(GUIUtil.TimesBold);
                Name.setBounds(70, 65, 100, 30);
                AddBox.add(Name);
                NameFeild = new JTextField();
                NameFeild.setFont(GUIUtil.TimesBold);
                NameFeild.setBounds(180, 65, 150, 30);
                AddBox.add(NameFeild);

                Number = new JLabel("Number");
                Number.setFont(GUIUtil.TimesBold);
                Number.setBounds(70, 100, 100, 30);
                AddBox.add(Number);
                NumberFeild = new JTextField();
                NumberFeild.setFont(GUIUtil.TimesBold);
                NumberFeild.setBounds(180, 100, 150, 30);
                // NumberFeild = new JTextField();
                AddBox.add(NumberFeild);

                Age = new JLabel("Age");
                Age.setFont(GUIUtil.TimesBold);
                Age.setBounds(70, 135, 100, 30);
                AddBox.add(Age);
                AgeFeild = new JTextField();
                AgeFeild.setFont(GUIUtil.TimesBold);
                AgeFeild = new JTextField();
                AgeFeild.setBounds(180, 135, 150, 30);
                AddBox.add(AgeFeild);

                UserName = new JLabel("User Name");
                UserName.setFont(GUIUtil.TimesBold);
                UserName.setBounds(70, 170, 100, 30);
                AddBox.add(UserName);
                UserNameFeild = new JTextField();
                UserNameFeild.setFont(GUIUtil.TimesBold);
                UserNameFeild.setBounds(180, 170, 150, 30);
                AddBox.add(UserNameFeild);

                Password = new JLabel("User Name");
                Password.setFont(GUIUtil.TimesBold);
                Password.setBounds(70, 205, 100, 30);
                AddBox.add(Password);
                PasswordFeild = new JTextField();
                PasswordFeild.setFont(GUIUtil.TimesBold);
                PasswordFeild.setBounds(180, 205, 150, 30);
                AddBox.add(PasswordFeild);

                AddDocBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 5);
                AddDocBtn.setText("ADD");
                AddDocBtn.setForeground(GUIUtil.WhiteClr);
                AddDocBtn.setFont(GUIUtil.TimesBold);
                AddDocBtn.setBounds(200, 240, 100, 30);
                AddBox.add(AddDocBtn);
                AddDocBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        warnJLabel.setVisible(false);
                        MedEaseDoctor Doctor = new MedEaseDoctor();
                        Doctor.setDID(DIDFeild.getText());
                        Doctor.setName(NameFeild.getText());
                        Doctor.setPhnNumber(NumberFeild.getText());
                        try {
                            int age = Integer.parseInt(AgeFeild.getText());
                            Doctor.setAge(age);
                        } catch (NumberFormatException ex) {
                            warnJLabel.setText("Enter Valid Age");
                            return;
                        }
                        
                        Doctor.getAge();
                        DBO.InsertDoctor(null);
                    }
                });

            }
        });
    }

}
