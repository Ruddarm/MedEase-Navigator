/* Utilities we may required through out project  
 * @author Ruddarm
 * 
*/
package MedEaseNavigator.UtilityModule;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import MedEaseNavigator.DataBaseModule.DBConnectivity;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.LoginModule.MedEaseLogin;
import MedEaseNavigator.NotificationMoudle.MedEaseNotify;

public class UtilityMedease {
    public JFrame MedEaseFrmae; // Main Window Frame
    public Connection DBCon; // Database Connection
    public DBConnectivity DbConnectObj; // object to create Database and estabhlish connection with database
    public MedEaseNotify Notify;
    public DBOperation DBO;
    public AdminInterface Admin;
    public MedEaseLogin Medlogin;

    public UtilityMedease() {
        Notify = new MedEaseNotify();

    }

    public void SetMainFrame() {
        MedEaseFrmae = new JFrame("MeadEas Navigator");
        MedEaseFrmae.setSize(1920, 1020);
        MedEaseFrmae.getContentPane().setBackground(GUIUtil.Base_Background);
        MedEaseFrmae.setVisible(true);
        MedEaseFrmae.setLayout(null);
        MedEaseFrmae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Admin = new AdminInterface();
        // MedEaseFrmae.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /*
     * this method will chech weather givn number is valid contact number or not
     * 
     * @param Number A string of Number
     * 
     * @return boolean true if String length =10 and String char== 0 to 9;
     * 
     */
    public static boolean isValidNumber(String Number) {
        Number.trim();
        if (Number.isBlank() || Number.isEmpty()) {
            return false;
        } else {

            for (int i = 0; i < Number.length(); i++) {
                char ch = Number.charAt(i);
                if (ch < 48 && ch > 57) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String Validity(String Number)
    {
        String s = null;
        if (Number.length() > 0) 
        {
            System.out.println("entering");
            String tt = Number;
            Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
            Matcher match = ptrn.matcher(tt);
            boolean sett = (match.find() && match.group().equals(tt));
            if (sett == false) 
            {
                System.out.println(true);
                //SrchFeild.setForeground(GUIUtil.WarningColor);
                s = "0";
                return s;
            }
            else
            {
                s = "1";
                return s;
            }

        }
        return s;
    }
    /*
     * A Method to count Character in String
     * 
     * @param String A set of character array
     * 
     * @return int Number of character in given String
     */

}
