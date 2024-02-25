/* This is Our Main Class from where our software will start it is like engine of our software
 * @author Ruddarm
 * @author Soumya Vinod
 * .
 * .
 * 
 */
package MedEaseNavigator.DriverPackage;

import java.util.concurrent.Semaphore;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.AppointMentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.PaymentInterface;
import MedEaseNavigator.AdminDashBoard.AppointMendDashBoard.WaitingInterface;
import MedEaseNavigator.DataBaseModule.DBConnectivity;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.FindPatientModule.FindCustomerUtil;
import MedEaseNavigator.LoginModule.MedEaseLogin;
import MedEaseNavigator.MedMenuBar.MenuBar;
import MedEaseNavigator.UtilityModule.UtilityMedease;

public class MedEaseApp {
    UtilityMedease MedEaseUtil;

    public MedEaseApp() {
        MedEaseUtil = new UtilityMedease();
    }

    public static void main(String[] args) {
        MedEaseApp app = new MedEaseApp();
        Semaphore sema = new Semaphore(0);
        synchronized (app) {
            /*
             * First we will setup connection with database
             */
            // Creating object of DBconnectivity
            app.MedEaseUtil.DbConnectObj = new DBConnectivity("jdbc:mysql://localhost:3306/", "ruddarmsql",
                    app.MedEaseUtil.DBCon);
            // If true then connection Sucesfull
            if (!app.MedEaseUtil.DbConnectObj.setConnection()) {
                app.MedEaseUtil.Notify.setMsg("DATABASE HAS NOT BEEN CONNECTED ", -1);
            }
            // if True then DataBase MedEaseNavigator already exist or created
            if (!app.MedEaseUtil.DbConnectObj.CreateDB("MedEaseNavigator")) {
                app.MedEaseUtil.Notify.setMsg("DATABASE HAS NOT BEEN CREATED ", -1);
            }

            app.MedEaseUtil.DBCon = app.MedEaseUtil.DbConnectObj.GetConnection();

            app.MedEaseUtil.DBO = new DBOperation(app.MedEaseUtil.DBCon);
            app.MedEaseUtil.Medlogin = new MedEaseLogin(app.MedEaseUtil.DBO, sema);
            try {
                // System.out.println(currentThread().getName());
                sema.acquire();

            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            app.MedEaseUtil.SetMainFrame();

            // while (TodayQueue.Head!=null) {
            // System.out.println(TodayQueue.Head.getName());
            // TodayQueue.Head= TodayQueue.Head.getNextAppointment();
            // }
            new MenuBar(app.MedEaseUtil.MedEaseFrmae, app.MedEaseUtil.DBO);
            app.MedEaseUtil.Admin.AppointmentInterfaceObj = new AppointMentInterface(app.MedEaseUtil.MedEaseFrmae,
                    app.MedEaseUtil.DBO);
            // AppointMent ap =new AppointMent();
            // ap.setPID("PID111");
            // ap.setName("Ruddarm");
            // ap.setNumber("8369517140");
            // ap.setStatus("Schedule");
            // ap.setTimeSlot("1:45 am");
            // ap.setNextAppointment(null);
            // AppointementI.SetTable(TodayQueue.Head);
            app.MedEaseUtil.Admin.WaitingInterfaceObj = new WaitingInterface(app.MedEaseUtil.MedEaseFrmae,
                    app.MedEaseUtil.DBO);
            app.MedEaseUtil.Admin.PaymentInterfaceObj = new PaymentInterface(app.MedEaseUtil.MedEaseFrmae,
                    app.MedEaseUtil.DBO);
            app.MedEaseUtil.Admin.AppointmentInterfaceObj.setWaittable(app.MedEaseUtil.Admin.WaitingInterfaceObj);
            app.MedEaseUtil.Admin.SetRefBtn(app.MedEaseUtil.Admin.AppointmentInterfaceObj.FrontPannel);
            new FindCustomerUtil(app.MedEaseUtil.MedEaseFrmae, app.MedEaseUtil.DBO, app.MedEaseUtil.Admin);

        }
    }
}

/*
 * Testign Add pation method
 */
// MedEasePatient demopt= new MedEasePatient();
// demopt.setName(" Nikita");
// demopt.setNumber("9702400616");
// demopt.setPID(112);
// demopt.setHeight("5ft");
// demopt.setWeight(54);
// demopt.setBlodGroup("B+");
// app.MedEaseUtil.DBO.InsertPatient(demopt);

/*
 * Testing Get Patient Method
 * app.MedEaseUtil.DBO.GetPatient("836951140");
 * 
 */
/*
 * Testing Method to add doctor
 * MedEaseDoctor doc =new MedEaseDoctor();
 * doc.setName(" Ruddarm");
 * doc.setPhnNumber("8369517140");
 * doc.setDID(123);
 * doc.setUsername(" RuddarmUser");
 * doc.setPswd("ruddarmpswd");
 * doc.setAge(21);
 * app.MedEaseUtil.DBO.InsertDoctor(doc);
 * 
 */
/*
 * Testign Medical Report History Added Method
 * MedEaseMedicalReport mr = new MedEaseMedicalReport();
 * mr.setPID(111);
 * mr.setChiefcomplaint("Fever");
 * mr.setDID(123);
 * mr.setDiagnosis("Viral Fever");
 * mr.setFollowupadvice("Nothing");
 * // mr.setFollowupdate(null);
 * mr.setFees(800);
 * mr.setLabtest("NO");
 * mr.setMRID(1000);
 * mr.setPrescription("Crocine");
 * app.MedEaseUtil.DBO.InsertMedicalHistory(mr);
 * 
 * 
 * 
 */
/*
 * Testing Utility Method
 * app.MedEaseUtil.DBO.UPdateDoc(124);
 * app.MedEaseUtil.DBO.UPdateMID(1001);
 * app.MedEaseUtil.DBO.SetUserDetails("Ruddarm", "Ruddarm4234");
 * 
 */
/*
 * Getter Method of Utilty testin
 * 
 * System.out.println(app.MedEaseUtil.DBO.GetLastPID());
 * System.out.println(app.MedEaseUtil.DBO.GetLastMID());
 * System.out.println(app.MedEaseUtil.DBO.GetLastDID());
 * System.out.println(app.MedEaseUtil.DBO.GetPswd());
 * System.out.println(app.MedEaseUtil.DBO.GetUserName());
 * 
 */
/*
 * Get medical Report method
 * ResultSet data =app.MedEaseUtil.DBO.GetMedicalReport(111);
 * 
 */
/*
 * Testing Dotor Login method
 * if (app.MedEaseUtil.DBO.DoctorLogin("8369517140", "RuddarmUser",
 * "ruddarmpswd")) {
 * System.out.println("Loged in");
 * }
 */
/*
 * Testing Appointment method
 * DateTimeFormatter formatr = DateTimeFormatter.ofPattern("hh:mm a");
 * System.out.println(LocalTime.now().format(formatr));
 * 
 * AppointMent appoin = new AppointMent();
 * appoin.setPID("PID111");
 * appoin.setTimeSlot("10:20 am");
 * appoin.setDate("" + LocalDate.now());
 * appoin.setIntime(LocalTime.now().format(formatr));
 * appoin.setStatus("Createdd");
 * app.MedEaseUtil.DBO.ScheduleAppointment(appoin);
 * 
 */