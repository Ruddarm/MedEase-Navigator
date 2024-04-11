package MedEaseNavigator.AppointMentModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmenEventHandling implements ActionListener {
    MedEaseAppointMentInterface appoint;
    public AppointmenEventHandling(MedEaseAppointMentInterface api) {
        this.appoint = api;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appoint.AppointmentBtn && appoint.Patient == null) {
            new MedCreatePatient(appoint.DBO, appoint.Number, appoint.AdminInterfaceObj);
        } else if (e.getSource() == appoint.AppointmentBtn && appoint.Patient != null) {
            new ScheduleAppointment(appoint.DBO, appoint.Patient, appoint.AdminInterfaceObj);
        } else if (e.getSource() == appoint.ViewBtn) {
            System.out.println("Btn click view");
            new ViewPatient(appoint.DBO, appoint.Patient);

        }
    }
}
