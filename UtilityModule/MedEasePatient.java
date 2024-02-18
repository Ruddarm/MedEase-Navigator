/* A Patient class to store data of Patient 
 * @author Ruddarm  
 * @author Ashlesha
 * 
 */

package MedEaseNavigator.UtilityModule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedEasePatient {
    private int PID; // PId+112
    private String Name;
    private String Number;
    private String DOB;
    private String Gender;
    private String strPID;

    private String BlodGroup, height, Allergy;
    private int Weight;
    private MedEaseMedicalReport ReportHead, Temp;
    private Boolean IsVlaid;

    /* Getter Method */
    public String getAllergy() {
        return Allergy;
    }

    public String getBlodGroup() {
        return BlodGroup;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return Gender;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return Weight;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public int getPID() {
        return PID;
    }

    public MedEaseMedicalReport getReportHead() {
        return ReportHead;
    }

    /* Setter Method */
    public void setAllergy(String allergy) {
        Allergy = allergy;
    }

    public void setBlodGroup(String blodGroup) {
        BlodGroup = blodGroup;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setPID(int pID) {
        PID = pID;
    }

    public void setReportHead(MedEaseMedicalReport reportHead) {
        ReportHead = reportHead;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public Boolean getIsVlaid() {
        return IsVlaid;
    }

    public void setIsVlaid(Boolean isVlaid) {
        IsVlaid = isVlaid;
    }

    public String getStrPID() {
        return strPID;
    }

    public void setStrPID(String strPID) {
        this.strPID = strPID;
    }

    public MedEaseMedicalReport getTemp() {
        return Temp;
    }

    public void setTemp(MedEaseMedicalReport temp) {
        Temp = temp;
    }

    /*
     * A method to set Patient data from result set
     * 
     * @param MedeasePatient
     * 
     * @param Resultset
     * 
     */
    public static boolean SetPTData(MedEasePatient pt, ResultSet data) {
        try {
            pt.setStrPID(data.getString(1));
            pt.setName(data.getString(2));
            pt.setNumber(data.getString(3));
            pt.setDOB(data.getString(4));
            pt.setHeight(data.getString(5));
            pt.setWeight(data.getInt(6));
            pt.setBlodGroup(data.getString(7));
            pt.setGender(data.getString(8));
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    // # MRID, Cheif_Complaint, Diagnosis, Prescription, FollowUp_Advice,
    // FollowUp_Date, Symptoms, Lab_Test, Status, Fees, Patient_ID, DID

    public static boolean SetMedicalReport(MedEasePatient pt, ResultSet data) {
        if (pt.getReportHead() == null) {
            MedEaseMedicalReport onenode = new MedEaseMedicalReport();
            try {
                onenode.setMRID(data.getString(1));
                onenode.setChiefcomplaint(data.getString(2));
                onenode.setDiagnosis(data.getString(3));
                onenode.setPrescription(data.getString(4));
                onenode.setFollowupadvice(data.getString(5));
                onenode.setReportDate("" + data.getDate(6));
                onenode.setSymptoms(data.getString(7));
                onenode.setLabtest(data.getString(8));
                onenode.setStatus(data.getString(9));
                onenode.setFees(data.getFloat(10));
                onenode.setPaid(data.getDouble(11));
                onenode.setPID(data.getString(12));
                onenode.setDID(data.getString(13));
                onenode.setNextReport(null);
                pt.setReportHead(onenode);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            pt.setTemp(pt.getReportHead());
            MedEaseMedicalReport newnode = new MedEaseMedicalReport();
            try {
                newnode.setMRID(data.getString(1));
                newnode.setChiefcomplaint(data.getString(2));
                newnode.setDiagnosis(data.getString(3));
                newnode.setPrescription(data.getString(4));
                newnode.setFollowupadvice(data.getString(5));
                newnode.setReportDate("" + data.getDate(6));
                newnode.setSymptoms(data.getString(7));
                newnode.setLabtest(data.getString(8));
                newnode.setStatus(data.getString(9));
                newnode.setFees(data.getFloat(10));
                newnode.setPaid(data.getDouble(11));
                newnode.setPID(data.getString(12));
                newnode.setDID(data.getString(13));
                newnode.setNextReport(null);
                pt.getTemp().setNextReport(newnode);
                pt.setTemp(newnode);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return false;
    }
}
