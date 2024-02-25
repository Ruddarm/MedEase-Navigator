package MedEaseNavigator.UtilityModule;


import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.AppointMentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.PaymentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.WaitingInterface;
import MedEaseNavigator.MedEaseComponent.MedEaseBtn;
import MedEaseNavigator.MedEaseComponent.MedPannel;

public class AdminInterface {
    
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
        RefreshBtn.setBounds(300, 400, 100, 30);
        srcPannel.add(RefreshBtn);
    }
    public void RefreshTable(){
        AppointmentInterfaceObj.UpdateTable();
        WaitingInterfaceObj.UpdateTabel();
        
    }
}
