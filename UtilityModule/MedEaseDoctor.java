package MedEaseNavigator.UtilityModule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedEaseDoctor {
    private String name;
    private int age;
    private String PhnNumber;
    private String DID;
    private String Username;
    private String pswd;
    private Boolean IsVlaid;

    /* Getter method */
    public int getAge() {
        return age;
    }

    public String getDID() {
        return DID;
    }

    public String getName() {
        return name;
    }

    public String getPhnNumber() {
        return PhnNumber;
    }

    public String getPswd() {
        return pswd;
    }

    public String getUsername() {
        return Username;
    }

    public Boolean getIsVlaid() {
        return IsVlaid;
    }

    /* Setter Method */
    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setDID(String dID) {
        DID = dID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhnNumber(String PhnNumber) {
        this.PhnNumber = PhnNumber;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public void setIsVlaid(Boolean isVlaid) {
        IsVlaid = isVlaid;
    }

public void SetDocDetails(MedEaseDoctor Doc, ResultSet data){
    if(data!=null){
        // 'DID01', 'Niks', '836957140', 30, 'nikisuser', 'nikspswd'
        try{
        Doc.setName(data.getString(2));
        Doc.setDID(data.getString(1));
        }catch(SQLException ex){
            Doc=null;
            return;
        }
    }
}
}
