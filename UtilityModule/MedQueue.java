package MedEaseNavigator.UtilityModule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.NotificationMoudle.MedEaseNotify;

public class MedQueue {
    public AppointMent Head, temp;
    public ResultSet AppointData;
    public MedEaseNotify notfication;
    public DBOperation DBO;

    public MedQueue(DBOperation DBO) {
        this.DBO = DBO;
        notfication = new MedEaseNotify();

    }

    public void GetAppointmentData() {
        AppointData = DBO.GetTodayAppointment();
    }

    public void GetWaitingAppointmentData() {
        AppointData = DBO.GetWaitingAppointMent();
    }

    public void GetPaymentAppointmentData() {
        AppointData = DBO.GetPaymentAppontment();
    }

    /*
     * To add patient in queue
     */
    public void CreateAppointmentList() {
        // DateTimeFormatter formatr = DateTimeFormatter.ofPattern("hh:mm a");
        try {
            this.temp = Head;
            while (AppointData.next() != false) {

                if (Head == null) {
                    AppointMent Nodeone = new AppointMent();
                    Nodeone.setPID(AppointData.getString(1));
                    Time Time = AppointData.getTime(2);
                    Nodeone.setTimeSlot("" + Time);
                    Nodeone.setDate(AppointData.getString(3));
                    Nodeone.setStatus(AppointData.getString(4));
                    Nodeone.setIntime(AppointData.getString(5));
                    Nodeone.setName(AppointData.getString(6));
                    Nodeone.setNumber(AppointData.getString(7));
                    Nodeone.setNextAppointment(null);
                    Head = Nodeone;
                    temp = Nodeone;
                } else {
                    AppointMent NextNode = new AppointMent();
                    NextNode.setPID(AppointData.getString(1));
                    NextNode.setTimeSlot(AppointData.getString(2));
                    NextNode.setDate(AppointData.getString(3));
                    NextNode.setStatus(AppointData.getString(4));
                    NextNode.setIntime(AppointData.getString(5));
                    NextNode.setName(AppointData.getString(6));
                    NextNode.setNumber(AppointData.getString(7));
                    NextNode.setNextAppointment(null);
                    temp.setNextAppointment(NextNode);
                    temp = NextNode;
                }
                // System.out.println(AppointData.getString(1));
            }
            ;
            System.out.println("List createed");

        } catch (SQLException xe) {
            notfication.setMsg("Error while Creating Appoinment List", -1);
            System.out.println(xe);
        }
    }

}
