/* A Patient class to store data of Patient 
 * @author Ruddarm  
 * @author Ashlesha
 * 
 */
package MedEaseNavigator.UtilityModule;

public class MedEasePatient {
   private int PID; // PId+112
   private String Name;
   private String Number;
   private String DOB;
   private String Gender;
   private String BlodGroup, height,Allergy;
   private int Weight;
   private MedEaseMedicalReport ReportHead;
   private Boolean IsVlaid;
   /* Getter Method */
   public String getAllergy() {
       return Allergy;
   }public String getBlodGroup() {
       return BlodGroup;
   }public String getDOB() {
       return DOB;
   }public String getGender() {
       return Gender;
   }public String getHeight() {
       return height;
   }public int getWeight() {
       return Weight;
   }public String getName() {
       return Name;
   }public String getNumber() {
       return Number;
   }public int getPID() {
       return PID;
   }public MedEaseMedicalReport getReportHead() {
       return ReportHead;
   }
   /* Setter Method */
   public void setAllergy(String allergy) {
       Allergy = allergy;
   }public void setBlodGroup(String blodGroup) {
       BlodGroup = blodGroup;
   }public void setDOB(String dOB) {
       DOB = dOB;
   }public void setGender(String gender) {
       Gender = gender;
   }public void setHeight(String height) {
       this.height = height;
   }public void setName(String name) {
       Name = name;
   }public void setNumber(String number) {
       Number = number;
   }public void setPID(int pID) {
       PID = pID;
   }public void setReportHead(MedEaseMedicalReport reportHead) {
       ReportHead = reportHead;
   }public void setWeight(int weight) {
       Weight = weight;
   }
   public Boolean getIsVlaid() {
       return IsVlaid;
   }
   public void setIsVlaid(Boolean isVlaid) {
       IsVlaid = isVlaid;
   }
}
