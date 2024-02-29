package MedEaseNavigator.DataBaseModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import MedEaseNavigator.NotificationMoudle.MedEaseNotify;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.MedEaseDoctor;
import MedEaseNavigator.UtilityModule.MedEaseMedicalReport;
import MedEaseNavigator.UtilityModule.MedEasePatient;

public class DBOperation implements DBOpertaionInterface {
    Connection DBcon;
    ResultSet data;
    PreparedStatement preparedQuery;
    Statement SqlStatement;
    MedEaseNotify Dbnotfy = new MedEaseNotify();

    public DBOperation(Connection DBcon2) {
        this.DBcon = DBcon2;
        try {

            SqlStatement = this.DBcon.createStatement();

        } catch (SQLException ex) {
            System.out.println("Error in DBopertiaon Constructor");
        }
    }

    @Override
    public ResultSet GetPatient(String Number) {
        // SELECT *from patient where Number = '836517140';

        try {
            preparedQuery = DBcon.prepareStatement("SELECT *from patient where Number = ?;");
            preparedQuery.setString(1, Number);
            data = preparedQuery.executeQuery();
            if (data.next() != false) {
                return data;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Dbnotfy.setMsg("" + ex, -1);
            return null;
        }
    }

    @Override
    public ResultSet GetMedicalReport(String PID) {
        try {
            preparedQuery = DBcon.prepareStatement("Select *from Medical_history where patient_ID =? order by reportdate desc");
            preparedQuery.setString(1, PID);
            data = preparedQuery.executeQuery();
            if (data.next() != false) {
                return data;
            } else {
                // Dbnotfy.setMsg("No Medical History", -1);
                return null;
            }

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error To find Medical Report", -1);
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public ResultSet GetAppointmentSchedule(String Date) {
        throw new UnsupportedOperationException("Unimplemented method 'GetAppointmentSchedule'");
    }

    @Override
    public boolean UpdateAppointment(AppointMent Appointment) {

        try {
            preparedQuery = DBcon.prepareStatement(
                    "Update appointment set status= ? , IN_TIME = ? where date = ? && patient_id = ?");
            preparedQuery.setString(1, Appointment.getStatus());
            preparedQuery.setString(2, Appointment.getIntime());
            preparedQuery.setString(3, "" + LocalDate.now());
            preparedQuery.setString(4, Appointment.getPID());
            System.out.println(preparedQuery);

            preparedQuery.executeUpdate();
            DBcon.commit();
            Dbnotfy.setMsg("Updated", 1);

            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Gadbad hogya", -1);
            System.out.println(ex);
            return false;
        }

    }

    @Override
    public boolean SetUserDetails(String UserName, String Password) {
        if (SetUserName(UserName) & SetUserPswd(Password)) {
            Dbnotfy.setMsg("Updated User Details", 1);
            return true;
        } else {
            try {
                DBcon.rollback();
                ;
            } catch (SQLException ex) {
                return false;

            }
        }
        return false;
    }

    /*
     * A Method to insert patient detials in Database
     * 
     * @param MedeasePatietn a object containg data of patient
     * 
     * @return boolen true if isnertion compelte suceffuly else false
     */
    public boolean InsertPatient(MedEasePatient pt) {
        try {
            // INSERT INTO patient
            // VALUEs('PID111','Ruddarm','8369517140','2002-10-24','5ft',54,'B+')
            preparedQuery = DBcon.prepareStatement("INSERT INTO patient VALUEs(?,?,?,?,?,?,?,?)");
            preparedQuery.setString(1, (pt.getStrPID()));
            preparedQuery.setString(2, pt.getName());
            preparedQuery.setString(3, pt.getNumber());
            preparedQuery.setString(4, pt.getDOB());
            preparedQuery.setString(5, pt.getHeight());
            preparedQuery.setInt(6, pt.getWeight());
            preparedQuery.setString(7, pt.getBlodGroup());
            preparedQuery.setString(8, pt.getGender());
            preparedQuery.executeUpdate();
            Dbnotfy.setMsg("Patient Added", 1);
            int id = pt.getPID();
            id++;
            if (UPdatePID(id)) {
                DBcon.commit();
                return true;
            }
            Dbnotfy.setMsg("Unable to add patient", -1);
            return false;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Patient Not added", -1);
            System.out.println(ex);
            return false;
        }
    }

    /*
     * A method to insert doctor data in database
     * 
     * @param MeddeaseDoctor A doctor object conataing data of doctor
     * 
     * @retrun boolena will retuurn true if insertion performed sucesfully
     * 
     */
    public boolean InsertDoctor(MedEaseDoctor doc) {

        try {
            // INSERT INTO doctor
            // VALUES('DOC111','Ruddarm','86369517140','39','ruddarmuser','ruddarm4234')
            preparedQuery = DBcon.prepareStatement(" INSERT INTO doctor VALUES(?,?,?,?,?,?)");
            preparedQuery.setString(1, "DOC" + doc.getDID());
            preparedQuery.setString(2, doc.getName());
            preparedQuery.setString(3, doc.getPhnNumber());
            preparedQuery.setInt(4, doc.getAge());
            preparedQuery.setString(5, doc.getUsername());
            preparedQuery.setString(6, doc.getPswd());
            preparedQuery.executeUpdate();
            DBcon.commit();
            Dbnotfy.setMsg(" Doctor added Sucesfully", 1);
            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg(" Unable to add Doctor", -1);
            return false;
        }

    }

    /*
     * A method to insert medical history in data base
     * 
     * @para MedEaseMedicaL Report a objec consist of all data
     * 
     * @return True if insertion sucessfull else false;
     */
    public boolean InsertMedicalHistory(MedEaseMedicalReport MedicalReport) {
        try {
            // INSERT INTO medical_history VALUES ('MRID11','Fever','viral fever
            // ','Crocine','Nothing','null','high
            // temprature','no','close','700','PID111','DOC123')
            preparedQuery = DBcon.prepareStatement(" INSERT INTO medical_history VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedQuery.setString(1, MedicalReport.getMRID());
            preparedQuery.setString(2, MedicalReport.getChiefcomplaint());
            preparedQuery.setString(3, MedicalReport.getDiagnosis());
            preparedQuery.setString(4, MedicalReport.getPrescription());
            preparedQuery.setString(5, MedicalReport.getFollowupadvice());
            preparedQuery.setString(6, MedicalReport.getReportDate());
            preparedQuery.setString(7, MedicalReport.getSymptoms());
            preparedQuery.setString(8, MedicalReport.getLabtest());
            preparedQuery.setString(9, MedicalReport.getStatus());
            preparedQuery.setDouble(10, MedicalReport.getFees());
            preparedQuery.setDouble(11, MedicalReport.getPaid());
            preparedQuery.setString(12, MedicalReport.getPID());
            preparedQuery.setString(13, MedicalReport.getDID());

            preparedQuery.executeUpdate();
            DBcon.commit();
            Dbnotfy.setMsg("Medical Report Added", 1);
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while Inserting Medical Reprot", -1);
            System.out.println(ex);
            return false;
        }
    }

    /*
     * UPdate PID in utility table;
     * 
     */
    public boolean UPdatePID(int newPID) {
        try {
            preparedQuery = DBcon.prepareStatement("UPDATE utility SET last_pid=? WHERE Utindex=1;");
            preparedQuery.setInt(1, newPID);
            preparedQuery.executeUpdate();
            DBcon.commit();
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updating PID", -1);
            System.out.println(ex);
            return false;

        }
    }

    /*
     * UPdte MID in utilit table
     */
    public boolean UPdateMID(int newMID) {
        try {
            preparedQuery = DBcon.prepareStatement("UPDATE utility SET last_MID=? WHERE Utindex=1;");
            preparedQuery.setInt(1, newMID);
            preparedQuery.executeUpdate();
            DBcon.commit();
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updating MID", -1);
            System.out.println(ex);
            return false;

        }

    }

    /*
     * update Dotor id
     */
    public boolean UPdateDoc(int newDOCID) {
        try {
            preparedQuery = DBcon.prepareStatement("UPDATE utility SET last_DID=? WHERE Utindex=1;");
            preparedQuery.setInt(1, newDOCID);
            preparedQuery.executeUpdate();
            DBcon.commit();
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updating DOC ID", -1);
            System.out.println(ex);
            return false;
        }

    }

    public boolean UpdatePayment(MedEaseMedicalReport Report) {
        try {
            preparedQuery = DBcon.prepareStatement("UPDATE medical_history SET status=? , Paid_Amount =? WHERE MRID=?");
            preparedQuery.setString(1, Report.getStatus());
            preparedQuery.setDouble(2, Report.getPaid());
            preparedQuery.setString(3, Report.getMRID());
            preparedQuery.execute();
            DBcon.commit();
            Dbnotfy.setMsg("Payment Updated", 1);
            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Eroor while Updating ", -1);
            return false;
        }
    }

    public boolean SetUserName(String UserName) {
        try {
            preparedQuery = DBcon.prepareStatement("UPDATE utility SET Admin_login=? WHERE Utindex=1;");
            preparedQuery.setString(1, UserName);
            preparedQuery.executeUpdate();
            DBcon.commit();
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updating User Name", -1);
            System.out.println(ex);
            return false;
        }
    }

    public boolean SetUserPswd(String Pswd) {
        try {
            preparedQuery = DBcon.prepareStatement("UPDATE utility SET pswd=? WHERE Utindex=1;");
            preparedQuery.setString(1, Pswd);
            preparedQuery.executeUpdate();
            DBcon.commit();
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updating User Name", -1);
            System.out.println(ex);
            return false;
        }
    }

    /*
     * A method to get last pid
     */
    public int GetLastPID() {
        try {
            data = SqlStatement.executeQuery("select *from Utility where utindex =1");
            if (data.next() != false) {
                return data.getInt(2);
            }
        } catch (SQLException ex) {

            Dbnotfy.setMsg("Error In get Last PID method ", -1);
            return 0;
        }
        return 0;
    }

    /*
     * A method to get last mid
     */
    
    public int GetLastMID() {

        try {
            data = SqlStatement.executeQuery("Select *from Utility where utindex = 1 ");
            if (data.next() != false) {
                return data.getInt(3);
            }
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Get lat mid method ", -1);
            return 0;
        }
        return 0;
    }

    public int GetLastDID() {

        try {
            data = SqlStatement.executeQuery("Select *from Utility where utindex = 1 ");
            if (data.next() != false) {
                return data.getInt(4);
            }
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Get lat mid method ", -1);
            return 0;
        }
        return 0;
    }

    public String GetUserName() {

        try {
            data = SqlStatement.executeQuery("Select *from Utility where utindex = 1 ");
            if (data.next() != false) {
                return data.getString(5);
            }
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Get lat mid method ", -1);
            return "";
        }
        return "";
    }

    public String GetPswd() {

        try {
            data = SqlStatement.executeQuery("Select *from Utility where utindex = 1 ");
            if (data.next() != false) {
                return data.getString(6);
            }
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Get lat mid method ", -1);
            return "";
        }
        return "";
    }

    /*
     * A method to check login credintals
     * 
     * @param Username
     * 
     * @param Password
     * 
     * @return boolean
     */
    public boolean AdminLogin(String UserName, String Password) {
        String Admin = GetUserName();
        String pswd = GetPswd();
        if (Admin.equals(UserName) && pswd.equals(Password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean DoctorLogin(String Number, String UserName, String Password) {
        try {
            preparedQuery = DBcon.prepareStatement("Select *from Doctor where Phone_no=?");
            preparedQuery.setString(1, Number);
            data = preparedQuery.executeQuery();
            if (data.next() != false) {
                String DocUser = data.getString(5);
                String DocPswd = data.getString(6);
                if (DocUser.equals(UserName) && DocPswd.equals(Password)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {

            Dbnotfy.setMsg("Erro in Doctor Loging", -1);
            return false;
        }
    }

    public ResultSet GetPaymentAppontment() {
        try {
            preparedQuery = DBcon.prepareStatement(
                    "SELECT appointment.*, patient.name AS patient_name , patient.Number as patientNumber\r\n" + //
                            "FROM appointment\r\n" + //
                            "INNER JOIN patient ON appointment.patient_id = patient.patient_id WHERE Date= ? && Status = 'PAYMENT' ORDER  BY Time asc;");

            preparedQuery.setString(1, "" + LocalDate.now());
            ResultSet Data = preparedQuery.executeQuery();
            return Data;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Erorr in Payment Appointment", -1);
            System.out.println(ex);

            return null;
        }
    }

    /*
     * 
     * A method to create appoint in database
     * 
     * @param Medease Appointment
     * 
     * @return boolean
     */
    public boolean ScheduleAppointment(AppointMent appoint) {
        // INSERT INTO appointment VALUE('PID111',str_to_date('8:50 am','%h:%i
        // %p'),'2002-10-24','Created',null);
        try {
            preparedQuery = DBcon.prepareStatement(
                    "INSERT INTO appointment VALUE(?,str_to_date(?,'%h:%i %p'),?,?,str_to_date(?,'%h:%i %p'))");
            preparedQuery.setString(1, appoint.getPID());
            preparedQuery.setString(2, appoint.getTimeSlot());
            preparedQuery.setString(3, appoint.getDate());
            preparedQuery.setString(4, appoint.getStatus());
            preparedQuery.setString(5, "" + appoint.getIntime());
            preparedQuery.executeUpdate();
            DBcon.commit();
            Dbnotfy.setMsg("Appointment Scheduled", 1);
            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while Scheduling appointment", -1);
            System.out.println(ex);
            return false;
        }
    }

    /*
     * A method to get today Appointment
     */
    public ResultSet GetTodayAppointment() {

        try {
            // SELECT *from appointment WHERE Date = '2024-02-04'
            preparedQuery = DBcon.prepareStatement(
                    "SELECT appointment.*, patient.name AS patient_name , patient.Number as patientNumber\r\n" + //
                            "FROM appointment\r\n" + //
                            "INNER JOIN patient ON appointment.patient_id = patient.patient_id WHERE Date= ? && Status = 'Schedule' ORDER  BY Time asc;");
            preparedQuery.setString(1, "" + LocalDate.now());
            data = preparedQuery.executeQuery();
            return data;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Today Appointmetn method", 1);
            return null;
        }

    }

    public ResultSet GetWaitingAppointMent() {

        try {
            // SELECT *from appointment WHERE Date = '2024-02-04'
            preparedQuery = DBcon.prepareStatement(
                    "SELECT appointment.*, patient.name AS patient_name , patient.Number as patientNumber\r\n" + //
                            "FROM appointment\r\n" + //
                            "INNER JOIN patient ON appointment.patient_id = patient.patient_id WHERE Date= ? && (Status = 'IN' || Status='Waiting' || Status='NEXT' || Status='Current') ORDER  BY IN_time asc;");
            preparedQuery.setString(1, "" + LocalDate.now());
            data = preparedQuery.executeQuery();
            return data;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Today Appointmetn method", 1);
            return null;
        }

    }

    public ResultSet GetNextPatient() {
        try {
            // SELECT *from appointment WHERE Date = '2024-02-04'
            preparedQuery = DBcon.prepareStatement(
                    "SELECT appointment.*, patient.name AS patient_name , patient.Number as patientNumber\r\n" + //
                            "FROM appointment\r\n" + //
                            "INNER JOIN patient ON appointment.patient_id = patient.patient_id WHERE Date= ? &&  Status='WAITING'  ORDER  BY IN_Time asc;");
            preparedQuery.setString(1, "" + LocalDate.now());
            data = preparedQuery.executeQuery();
            if (data.next() != false) {
                return data;
            }
            return null;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error in Today Appointmetn method", 1);
            return null;
        }
    }

    public boolean UpdateAppointment(String Status, int PID) {

        try {
            // UPDATE appointment SET status='in' WHERE DATE='2024-02-04' &&
            // patient_id='PID111';
            preparedQuery = DBcon.prepareStatement("UPDATE appointment SET status=? WHERE DATE=? && patient_id=?;");
            preparedQuery.setString(1, Status);
            preparedQuery.setString(2, "" + LocalDate.now());
            preparedQuery.setString(3, "PID" + PID);
            preparedQuery.executeUpdate();
            DBcon.commit();
            Dbnotfy.setMsg("Status Updated", 1);
            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updating Appointment Status", -1);
            return false;
        }
    }

    public boolean UpdatePatientDetials(MedEasePatient pt) {
        // UPDATE patient set name='Nikita',Number ='9594120025', Dob='2004-7-22',
        // height='5.4ft', Weight='45',bloodgrp='B+' WHERE patient_ID = 'PID112'
        try {
            preparedQuery = DBcon.prepareStatement(
                    "UPDATE patient set name=?,Number =?, Dob=?, height=?, Weight=?,bloodgrp=? WHERE patient_ID = ?");
            preparedQuery.setString(1, pt.getName());
            preparedQuery.setString(2, pt.getNumber());
            preparedQuery.setString(3, pt.getDOB());
            preparedQuery.setString(4, pt.getHeight());
            preparedQuery.setInt(5, pt.getWeight());
            preparedQuery.setString(6, pt.getBlodGroup());
            preparedQuery.setString(7, "PID" + pt.getPID());
            preparedQuery.executeUpdate();
            DBcon.commit();
            Dbnotfy.setMsg("Patient data Updated", 1);
            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while updateing data ", -1);
            return false;
        }
    }

}