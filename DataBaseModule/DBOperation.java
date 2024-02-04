package MedEaseNavigator.DataBaseModule;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;

import MedEaseNavigator.NotificationMoudle.MedEaseNotify;
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
                System.out.println(" Patient found");
            } else {
                System.out.println(" Pt not found   ");
            }

        } catch (SQLException ex) {
            Dbnotfy.setMsg("" + ex, -1);
            return null;
        }

        return null;
    }

    @Override
    public ResultSet GetMedicalReport(String PID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetMedicalReport'");
    }

    @Override
    public ResultSet GetAppointmentSchedule(String Date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetAppointmentSchedule'");
    }

    @Override
    public boolean UpdateAppointment(String Stas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateAppointment'");
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
            preparedQuery = DBcon.prepareStatement("INSERT INTO patient VALUEs(?,?,?,?,?,?,?)");
            preparedQuery.setString(1, ("PID" + pt.getPID()));
            preparedQuery.setString(2, pt.getName());
            preparedQuery.setString(3, pt.getNumber());
            preparedQuery.setString(4, pt.getDOB());
            preparedQuery.setString(5, pt.getHeight());
            preparedQuery.setInt(6, pt.getWeight());
            preparedQuery.setString(7, pt.getBlodGroup());
            preparedQuery.executeUpdate();
            Dbnotfy.setMsg("Patient Added", 1);
            DBcon.commit();
            return true;

        } catch (SQLException ex) {
            Dbnotfy.setMsg("Patient Not added", -1);
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
            preparedQuery = DBcon.prepareStatement(" INSERT INTO medical_history VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedQuery.setString(1, "MRID" + MedicalReport.getMRID());
            preparedQuery.setString(2, MedicalReport.getChiefcomplaint());
            preparedQuery.setString(3, MedicalReport.getDiagnosis());
            preparedQuery.setString(4, MedicalReport.getPrescription());
            preparedQuery.setString(5, MedicalReport.getFollowupadvice());
            preparedQuery.setString(6, MedicalReport.getFollowupdate());
            preparedQuery.setString(7, MedicalReport.getSymptoms());
            preparedQuery.setString(8, MedicalReport.getLabtest());
            preparedQuery.setString(9, MedicalReport.getStatus());
            preparedQuery.setFloat(10, MedicalReport.getFees());
            preparedQuery.setString(11, "PID" + MedicalReport.getPID());
            preparedQuery.setString(12, "DOC" + MedicalReport.getDID());

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
}
