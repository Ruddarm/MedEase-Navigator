/* This is Our Main Class from where our software will start it is like engine of our software
 * @author Ruddarm
 * @author 
 * .
 * .
 * 
 */
package MedEaseNavigator.DriverPackage;

import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.AppointMentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.PaymentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.WaitingInterface;
import MedEaseNavigator.DataBaseModule.DBConnectivity;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.DoctorDashBoard.MedDoctorDashBoard;
import MedEaseNavigator.FindPatientModule.FindCustomerUtil;
import MedEaseNavigator.LoginModule.MedEaseLogin;
import MedEaseNavigator.MedMenuBar.MenuBar;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import MedEaseNavigator.UtilityModule.UtilityMedease;

public class MedEaseApp {
    UtilityMedease MedEaseUtil;

    public MedEaseApp() {
        MedEaseUtil = new UtilityMedease();
    }

    public static void main(String[] args) {
        MedEaseApp app = new MedEaseApp();
        /*
         * First we will setup connection with database
         */
        // Creating object of DBconnectivity
        app.MedEaseUtil.DbConnectObj = new DBConnectivity("jdbc:mysql://localhost:3306/", "ruddarmsql",
                app.MedEaseUtil.DBCon);
        // If true then connection Sucesfull
        if (!app.MedEaseUtil.DbConnectObj.setConnection()) {
            app.MedEaseUtil.Notify.setMsg("Bhai DataBase connect Nhi ho raha hai ", -1);
        }
        // if True then DataBase MedEaseNavigator already exist or created
        if (!app.MedEaseUtil.DbConnectObj.CreateDB("MedEaseNavigator")) {
            app.MedEaseUtil.Notify.setMsg("Bhai DB nhi create hua ", -1);
        }
        app.MedEaseUtil.DBCon = app.MedEaseUtil.DbConnectObj.GetConnection();
        app.MedEaseUtil.DBO = new DBOperation(app.MedEaseUtil.DBCon);

        // App main screen
        // new MedEaseLogin();
        // app.MedEaseUtil.SetMainFrame();
        // new MenuBar(app.MedEaseUtil.MedEaseFrmae);
        // new FindCustomerUtil(app.MedEaseUtil.MedEaseFrmae);
        // new AppointMentInterface(app.MedEaseUtil.MedEaseFrmae);
        // new WaitingInterface(app.MedEaseUtil.MedEaseFrmae);
        // new PaymentInterface(app.MedEaseUtil.MedEaseFrmae);
        // new MedDoctorDashBoard();

    }
}

/*
 * Testign Add pation method
 */
//          MedEasePatient demopt= new MedEasePatient();
//          demopt.setName(" Nikita");
//          demopt.setNumber("9702400616");
//          demopt.setPID(112);
//          demopt.setHeight("5ft");
//          demopt.setWeight(54);
//          demopt.setBlodGroup("B+");
//          app.MedEaseUtil.DBO.InsertPatient(demopt);

/*
 * Testing Get Patient Method
            app.MedEaseUtil.DBO.GetPatient("836951140");
 * 
 */