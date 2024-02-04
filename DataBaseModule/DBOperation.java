package MedEaseNavigator.DataBaseModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import MedEaseNavigator.NotificationMoudle.MedEaseNotify;
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
        //  SELECT *from patient where Number = '836517140';

        try{
          preparedQuery = DBcon.prepareStatement("SELECT *from patient where Number = ?;");
          preparedQuery.setString(1, Number);
          data = preparedQuery.executeQuery();
          if(data.next()!=false){
            System.out.println(" Patient found");
          }else{
            System.out.println(" Pt not found   ");
          }

        }catch(SQLException ex){
            Dbnotfy.setMsg(""+ex, -1);
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
        try {
            preparedQuery = this.DBcon.prepareStatement("UPDATE utility set Admin_login =?, Pswd=? WHERE utindex =1;");
            preparedQuery.setString(1, UserName);
            preparedQuery.setString(2, Password);
            preparedQuery.executeUpdate();
            Dbnotfy.setMsg("User Detials Updated ", 1);
            return true;
        } catch (SQLException ex) {
            Dbnotfy.setMsg("Error while Updatning User Detials", 0);
            return false;
        }
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
     * A method to find patient details using contact number
     * 
     * @param Number Number of Patient
     * 
     * @return Patient/Null
     * 
     */

}
