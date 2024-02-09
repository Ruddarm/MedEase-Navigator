/*
 * In this class we will have all operation such as DB connectivty, adn DB and Table  creation 
 * 
 */
package MedEaseNavigator.DataBaseModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import MedEaseNavigator.NotificationMoudle.MedEaseNotify;

public class DBConnectivity {
    String UserName;
    String Password;
    Connection DBCon;
    Statement SqlStaement;
    MedEaseNotify DbNotify = new MedEaseNotify();

    public DBConnectivity(String UserName, String Password, Connection DBCon2) {
        this.UserName = UserName;
        this.Password = Password;
        this.DBCon = DBCon2;
    }

    public Connection GetConnection() {
        return DBCon;
    }

    // Set connection with Mysql
    public boolean setConnection() {
        try {
            DBCon = DriverManager.getConnection(UserName, "root", Password);
            DBCon.setAutoCommit(false);
            return true;
        } catch (SQLException connectionError) {
            // System.out.println("ik");
            DbNotify.setMsg("Unnable To Connect ", -1);
            return false;
        }

    }

    /*
     * A method to create DB is not exist else return connection with
     * MedEaseDatabase
     * 
     * @param DBName Name of DB for e.g MedEaeDB
     * 
     * @return boolean return true if connection established else return false
     * 
     */
    public boolean CreateDB(String DBName) {
        try {
            UserName = UserName + DBName;
            DBCon = DriverManager.getConnection(UserName, "root", Password);
            DBCon.setAutoCommit(false);
            SqlStaement = DBCon.createStatement();
        } catch (SQLException DBCreation) {
            try {
                SqlStaement = DBCon.createStatement();
                // System.out.println(UserName);
                SqlStaement.execute("Create Database " + DBName);
                DBCon.commit();
                // System.out.println("Crating DB");
                DBCon = DriverManager.getConnection(UserName, "root", Password);
                SqlStaement = DBCon.createStatement();
                DBCon.setAutoCommit(false);
                if (createPatientTable() &&
                        CreateAppointmentTable() &&
                        CreateDoctorTable() &&
                        CreateMedicalReportTable() &&
                        CreateUtilitytable()) {
                    DBCon.commit();
                } else {
                    DbNotify.setMsg("Uanablee to create tables", -1);
                }
                return true;
            } catch (SQLException error) {
                DbNotify.setMsg("DB Creation Failed ", -1);
                return false;
            }
        }
        // System.out.println("DB exist");
        return true;
    }

    /*
     * A method to create Tables in DBbase
     */
    public boolean createPatientTable() {
        try {

            String PatientTableQuerry = "create table PATIENT" +
                    "( Patient_ID          varchar(40)             primary key," +
                    " Name                varchar(50)        not null," +
                    " Number              varchar(10)        not null," +
                    " DOB                 Date  DEFAULT null," +
                    " Height              varchar(5) DEFAULT null," +
                    " Weight              int      DEFAULT null," +
                    " BloodGrp            varchar(3) DEFAULT null," +
                    " Gender              varchar(3) Default null" +
                    " )";
            SqlStaement.execute(PatientTableQuerry);
            DBCon.commit();
            return true;
        } catch (SQLException ex) {
            DbNotify.setMsg("Error While Creating Patient Table", -1);
            System.out.println(ex);
        }
        return true;
    }

    public boolean CreateMedicalReportTable() {
        try {
            String MedicalReportTableQuerry = " create table MEDICAL_HISTORY" +
                    " ( MRID               varchar(20)        not null     primary key," +
                    "   Cheif_Complaint    varchar(500)    DEFAULT null," +
                    "   Diagnosis          varchar(4000)    DEFAULT null," +
                    "   Prescription       varchar(1000)    DEFAULT null," +
                    "   FollowUp_Advice    varchar(500)    DEFAULT null," +
                    "   FollowUp_Date      Date    DEFAULT null," +
                    "   Symptoms           varchar(500)    DEFAULT null," +
                    "   Lab_Test           varchar(1500)    DEFAULT null," +
                    "   Status             varchar(20)    DEFAULT null," +
                    "   Fees               int    DEFAULT null," +
                    "   Patient_ID         varchar(40)     ," +
                    "   DID                varchar(40)," +
                    "   FOREIGN KEY(Patient_ID) REFERENCES PATIENT(Patient_ID)," +
                    "   FOREIGN KEY(DID) REFERENCES Doctor(DID)" +
                    " )";
            SqlStaement.execute(MedicalReportTableQuerry);
            DBCon.commit();
            return true;

        } catch (SQLException ex) {
            DbNotify.setMsg("Error while Creating Medical Report Table", -1);
            System.out.println(ex);
            return false;
        }

    }

    // public boolean Creat
    public boolean CreateDoctorTable() {
        try {
            String MedicalReportTableQuerry = "create table DOCTOR" +
                    "(" +
                    "  DID                 varchar(40) PRIMARY KEY," +
                    "  Name                varchar(50)," +
                    "  Phone_No            varchar(10)," +
                    "  Age                 int," +
                    "  Username            varchar(50)," +
                    "  Pswd                varchar(20)" +
                    ")";
            SqlStaement.execute(MedicalReportTableQuerry);
            DBCon.commit();
            return true;
        } catch (SQLException ex) {
            DbNotify.setMsg("Error while Creating Doctor  Table", -1);
            System.out.println(ex);
            return false;
        }

    }

    public boolean CreateAppointmentTable() {
        try {
            String MedicalReportTableQuerry = "create table APPOINTMENT" +
                    "(" +
                    "  Patient_ID          varchar(40)," +
                    "  Time                Time," +
                    "  Date                Date," +
                    "  Status              varchar(50)," +
                    "  IN_Time             TIME," +
                    "  FOREIGN KEY(Patient_ID) REFERENCES PATIENT(Patient_ID)" +
                    ")";
            SqlStaement.execute(MedicalReportTableQuerry);
            DBCon.commit();
            return true;

        } catch (SQLException ex) {
            DbNotify.setMsg("Error while Creating Appointment  Table", -1);
            System.out.println(ex);
            return false;
        }

    }

    public boolean CreateUtilitytable() {
        try {
            String CreatUtlityTable = "create table Utility" +
                    "( " +
                    "  UTINDEX                 int              PRIMARY KEY DEFAULT 1," +
                    "  Last_PID             int         DEFAULT 111  ," +
                    "  Last_MID             int         DEFAULT 1  ," +
                    "  Last_DID             int         DEFAULT 1000  ," +
                    "  Admin_Login         varchar(50)  DEFAULT 'Admin'," +
                    "  Pswd                varchar(25)  DEFAULT 'root'" +
                    ")";
            SqlStaement.execute(CreatUtlityTable);
            SqlStaement.executeUpdate("insert into utility values()");
            DBCon.commit();
            return true;
        } catch (SQLException ex) {
            DbNotify.setMsg("Error while Creating Utility  Table", -1);
            System.out.println(ex);
            return false;
        }
    }

}
