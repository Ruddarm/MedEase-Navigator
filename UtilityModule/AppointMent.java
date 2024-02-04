package MedEaseNavigator.UtilityModule;
public class AppointMent {
    private String Date;
    private String TimeSlot;
    private String PID;
    private String Name;
    private String Status;
    private String intime;
    AppointMent nextAppointment;
    
    public void setDate(java.lang.String string) {
        Date = string;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNextAppointment(AppointMent nextAppointment) {
        this.nextAppointment = nextAppointment;
    }
    

    public void setPID(String pID) {
        PID = pID;
    }

    public void setTimeSlot(String timeSlot) {
        TimeSlot = timeSlot;
    }

    public String getDate() {
        return Date;
    }

    public String getTimeSlot() {
        return TimeSlot;
    }

    public String getName() {
        return Name;
    }

    public String getPID() {
        return PID;
    }
    public String getIntime() {
        return intime;
    }public AppointMent getNextAppointment() {
        return nextAppointment;
    }public String getStatus() {
        return Status;
    }public void setIntime(String intime) {
        this.intime = intime;
    }public void setStatus(String status) {
        Status = status;
    }

    public void CreateAppointmentList() {

    }
}
