package MedEaseNavigator.DataBaseModule;

import java.sql.ResultSet;

public interface DBOpertaionInterface {

    // set login for first time
    /*
     * @param UserName
     * 
     * @param Password
     * 
     * @return boolean true if Username and password insert in DB sucesfully false
     * if any error occurs
     */
    public boolean SetUserDetails(String UserName, String Password);

    // GetLoginDetails
    /*
     * @param userName user name given by user
     * 
     * @param Password password enterd by user
     * 
     * @return boolean true if username and password is same
     * 
     */
    public static boolean Login(String UserName, String Password) {
        return false;
    }

    public static boolean DocLogin(String DocUserName, String Password) {
        return false;
    }

    /*
     * Get Patient
     * 
     * @param Number get PID from Number
     * 
     * @return ResultSet if Pateint exist else Null
     */
    public ResultSet GetPatient(String Number);

    /*
     * Get Medical Report using PID
     * 
     * @param PID PID of patient
     * 
     * @return ResultSet //Result Set of Medical Report
     */
    public ResultSet GetMedicalReport(String PID);

    /*
     * Get AppointMent Schedule
     * 
     * @param Today_Date Date of current Day
     * 
     * @return ResultSet Resultset containg Appointment
     * 
     */
    public ResultSet GetAppointmentSchedule(String Date);

    /*
     * Update Appointmetn
     * 
     * @param Status status of appointment
     * 
     * @return boolean true if sucessfull else falsse
     * 
     */
    public boolean UpdateAppointment(String  Stas);

}
