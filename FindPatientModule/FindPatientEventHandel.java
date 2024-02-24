package MedEaseNavigator.FindPatientModule;

import java.awt.event.*;

import java.sql.ResultSet;
import MedEaseNavigator.AppointMentModule.MedEaseAppointMentInterface;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import MedEaseNavigator.UtilityModule.UtilityMedease;

public class FindPatientEventHandel extends KeyAdapter implements ActionListener {
    FindCustomerUtil findpteint;
    ResultSet ptdata;

    public FindPatientEventHandel(FindCustomerUtil obj) {
        findpteint = obj;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findpteint.ScrhBtn) {

            String Number = findpteint.SrchFeild.getText();
            if (UtilityMedease.isValidNumber(Number)) {
                MedEasePatient Patient = new MedEasePatient();

                ptdata = findpteint.DBO.GetPatient(Number);
                if (ptdata != null) {
                    MedEasePatient.SetPTData(Patient, ptdata);
                } else {
                    Patient = null;
                }
                new MedEaseAppointMentInterface(Patient,findpteint.DBO,Number,findpteint.AdminInterfaceObj);
            }

        }


    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==findpteint.SrchFeild){
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                findpteint.ScrhBtn.doClick();
            }
        }
    }

}
