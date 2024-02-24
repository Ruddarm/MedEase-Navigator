package MedEaseNavigator.DoctorDashBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.html.parser.DocumentParser;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class DocLogin extends KeyAdapter implements ActionListener {
    JFrame DocLoginFram;
    MedEaseBtn LoginBtn; // Btn to login
    MedEaseBtn AddDocBtn; // setup Btn
    MedPannel UserDetailsPannel;
    JLabel DocNumberLabel, DocUserNameLabel, warn, DoctorPswdLabel;
    JLabel MedEaselabel, NavigatorLabel;
    JPasswordField DocPassword;
    JTextField DocNumberFeild;
    JTextField DocUserNameFeild, DocPswdFeild;
    DBOperation DBO;

    public DocLogin(DBOperation dbo) {
        this.DBO = dbo;
        DocLoginFram = new JFrame();
        setLoginInterface();
    }

    public void setLoginInterface() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* Design Implemntaion of Login Frame */
                DocLoginFram.setBounds(200, 200, 650, 300);
                DocLoginFram.setVisible(true);
                DocLoginFram.setLayout(null);
                DocLoginFram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                DocLoginFram.setResizable(false);
                DocLoginFram.getContentPane().setBackground(GUIUtil.Dark_BLue);
                DocLoginFram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                UserDetailsPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
                UserDetailsPannel.setBounds(300, 0, 350, 350);
                UserDetailsPannel.setLayout(null);
                DocLoginFram.add(UserDetailsPannel);
                MedEaselabel = new JLabel("MedEase");
                MedEaselabel.setForeground(GUIUtil.WhiteClr);
                MedEaselabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
                MedEaselabel.setBounds(70, 80, 200, 30);
                DocLoginFram.add(MedEaselabel);
                NavigatorLabel = new JLabel("Navigator");
                NavigatorLabel.setForeground(GUIUtil.WhiteClr);
                NavigatorLabel.setBounds(80, 130, 200, 40);
                NavigatorLabel.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 30));
                warn = new JLabel();
                warn.setVisible(false);
                warn.setBounds(10, 10, 400, 20);
                warn.setFont(GUIUtil.TimesItalic);
                warn.setForeground(GUIUtil.WarningColor);
                UserDetailsPannel.add(warn);
                DocLoginFram.add(NavigatorLabel);
                DocNumberLabel = new JLabel(" Number");
                DocNumberLabel.setFont(GUIUtil.TimesBoldS2);
                DocNumberLabel.setBounds(30, 20, 150, 30);
                UserDetailsPannel.add(DocNumberLabel);
                DocNumberFeild = new JTextField();
                DocNumberFeild.setBounds(30, 50, 170, 30);
                DocNumberFeild.setFont(GUIUtil.TimesBoldS2);
                // DocNumberFeild.setBackground(GUIUtil.MedEaseGrey);
                DocNumberFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                UserDetailsPannel.add(DocNumberFeild);
                DocUserNameLabel = new JLabel("Username");
                DocUserNameLabel.setFont(GUIUtil.TimesBoldS2);
                DocUserNameLabel.setBounds(30, 85, 100, 30);
                UserDetailsPannel.add(DocUserNameLabel);
                DocUserNameFeild = new JTextField();
                DocUserNameFeild.setBounds(30, 115, 170, 30);
                DocUserNameFeild.setFont(GUIUtil.TimesBoldS2);
                DocUserNameFeild.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                UserDetailsPannel.add(DocUserNameFeild);
                DoctorPswdLabel = new JLabel("Password");
                DoctorPswdLabel.setFont(GUIUtil.TimesBoldS2);
                DoctorPswdLabel.setBounds(30, 145, 100, 30);

                UserDetailsPannel.add(DoctorPswdLabel);
                DocPassword = new JPasswordField();
                DocPassword.setBounds(30, 175, 170, 30);
                DocPassword.setBorder(BorderFactory.createLineBorder(Color.black));
                DocPassword.setFont(GUIUtil.TimesBoldS2);
                UserDetailsPannel.add(DocPassword);
                // AddDocBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
                // AddDocBtn.setBounds(140, 215, 100, 30);
                // AddDocBtn.setText("ADD");
                // AddDocBtn.setForeground(Color.WHITE);
                // AddDocBtn.setFont(GUIUtil.TimesBold);
                // UserDetailsPannel.add(AddDocBtn);
                LoginBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.BlueColor, null, 5);
                LoginBtn.setBounds(125, 215, 100, 30);
                LoginBtn.setText("LOGIN");
                LoginBtn.setForeground(Color.WHITE);
                LoginBtn.setFont(GUIUtil.TimesBold);
                UserDetailsPannel.add(LoginBtn);
                addActionlistenre();
            }
        });

    }

    public void addActionlistenre() {
        LoginBtn.addActionListener(this);
        DocPassword.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == LoginBtn) {
            String number, username;
            StringBuilder pswd = new StringBuilder();
            number = DocNumberFeild.getText();
            username = DocUserNameFeild.getText();
            char pswdarray[] = DocPassword.getPassword();
            for (char c : pswdarray) {
                pswd.append(c);
            }
            if (DBO.DoctorLogin(number, username, pswd.toString())) {
                DocLoginFram.dispose();
                new MedDoctorDashBoard(DBO);
            } else {
                warn.setText("Something went wrong");
                warn.setVisible(true);
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            LoginBtn.doClick();
        }
    }

}
