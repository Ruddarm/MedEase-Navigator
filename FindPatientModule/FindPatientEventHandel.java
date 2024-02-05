package MedEaseNavigator.FindPatientModule;

import java.awt.event.*;


import java.sql.ResultSet;
import MedEaseNavigator.AppointMentModule.MedEaseAppointMentInterface;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import MedEaseNavigator.UtilityModule.UtilityMedease;

public class FindPatientEventHandel implements ActionListener {
    FindCustomerUtil findpteint;
    MedEasePatient Patient = new MedEasePatient();
    ResultSet ptdata;

    public FindPatientEventHandel(FindCustomerUtil obj) {
        findpteint = obj;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findpteint.ScrhBtn) {
            String Number = findpteint.SrchFeild.getText();
            if (UtilityMedease.isValidNumber(Number)) {
                ptdata = findpteint.DBO.GetPatient(Number);
                if(ptdata!=null){

                }else{
                    Patient=null;
                }
                new MedEaseAppointMentInterface(Patient);
            }

        } else {

        }

    }

}
