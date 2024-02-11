package MedEaseNavigator.UtilityModule;

public class MedEaseMedicalReport {
    private String MRID;
    private String chiefcomplaint;
    private String diagnosis;
    private String prescription;
    private String followupadvice;
    private String followupdate;
    private String symptoms;
    private String labtest;
    private String status;
    private double fees;
    private double Paid;
    // try 
    private String PID;
    private String DID;
    private MedEaseMedicalReport next;
    private Boolean IsVlaid;
    /*Getter method */
    public String getChiefcomplaint() {
        return chiefcomplaint;
    }
    public String getDID() {
        return DID;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public double getFees() {
        return fees;
    }
    public String getFollowupadvice() {
        return followupadvice;
    }
    public String getFollowupdate() {
        return followupdate;
    }
    public Boolean getIsVlaid() {
        return IsVlaid;
    }
    public String getLabtest() {
        return labtest;
    }
    public String getMRID() {
        return MRID;
    }
    public String getPID() {
        return PID;
    }
    public String getPrescription() {
        return prescription;
    }
    public MedEaseMedicalReport getNextReport() {
        return next;
    }
    public String getStatus() {
        return status;
    }
    public String getSymptoms() {
        return symptoms;
    }
    /*Setter method */
    public void setChiefcomplaint(String chiefcomplaint) {
        this.chiefcomplaint = chiefcomplaint;
    }
    public void setNextReport(MedEaseMedicalReport nextReport) {
        this.next = nextReport;
    }
    public void setDID(String dID) {
        DID = dID;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public void setFees(double fees) {
        this.fees = fees;
    }
    public void setFollowupadvice(String followupadvice) {
        this.followupadvice = followupadvice;
    }
    public void setFollowupdate(String followupdate) {
        this.followupdate = followupdate;
    }
    public void setIsVlaid(Boolean isVlaid) {
        IsVlaid = isVlaid;
    }
    public void setLabtest(String labtest) {
        this.labtest = labtest;
    }
    public void setMRID(String mRID) {
        MRID = mRID;
    }
    public void setPID(String pID) {
        PID = pID;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public double getPaid() {
        return Paid;
    }
    public MedEaseMedicalReport getNext() {
        return next;
    }
    public void setNext(MedEaseMedicalReport next) {
        this.next = next;
    }
    public void setPaid(double paid) {
        Paid = paid;
    }

    


    
    
}  
