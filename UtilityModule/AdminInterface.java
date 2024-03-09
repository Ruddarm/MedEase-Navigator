package MedEaseNavigator.UtilityModule;


import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.AppointMentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.PaymentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.WaitingInterface;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminInterface extends MouseAdapter implements ActionListener {
    
    public AppointMentInterface AppointmentInterfaceObj;
    public WaitingInterface WaitingInterfaceObj;
    public PaymentInterface PaymentInterfaceObj;
    MedEaseBtn RefreshBtn;
    // public AdminInterface(AppointMentInterface api, WaitingInterface wpi, PaymentInterface pi){
    //     this.AppointmentInterfaceObj=api;
    //     this.WaitingInterfaceObj=wpi;
    //     this.PaymentInterfaceObj=pi;

    // }\
    public void SetRefBtn(MedPannel srcPannel ){
        RefreshBtn = new MedEaseBtn(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 5);
        RefreshBtn.setText("Refresh");
        RefreshBtn.setBounds(490, 360, 100, 30);
        RefreshBtn.setForeground(GUIUtil.WhiteClr);
        RefreshBtn.addActionListener(this);
        RefreshBtn.addMouseListener(this);

        srcPannel.add(RefreshBtn);
    }
    public void RefreshTable(){
        AppointmentInterfaceObj.UpdateTable();
        WaitingInterfaceObj.UpdateTabel();
        PaymentInterfaceObj.UpdatePaymentTable();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==RefreshBtn){
            RefreshTable();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==RefreshBtn){
            RefreshBtn.Background=GUIUtil.BlackClr;
            RefreshBtn.repaint();

        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==RefreshBtn) {
            RefreshBtn.setBackground(GUIUtil.Dark_BLue);
            // RefreshBtn.setFont(GUIUtil.WhiteClr);
        }
    }
}
