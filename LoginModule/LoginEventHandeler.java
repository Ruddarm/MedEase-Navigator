// A login event will hande herer
/*
 * @author ruddarm
 * 
 */

package MedEaseNavigator.LoginModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginEventHandeler extends KeyAdapter implements ActionListener {
    MedEaseLogin logobj;

    public LoginEventHandeler(MedEaseLogin Logobj) {
        this.logobj = Logobj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logobj.warn.setVisible(false);
        if (e.getSource() == logobj.LoginBtn) {
            String Username = logobj.UserName.getText();
            String Password = logobj.Password.getText();
            if (logobj.DBO.AdminLogin(Username, Password)) {
                logobj.LoginFrame.dispose();
                logobj.sema.release();
            } else {
                logobj.warn.setText("User Name or Password is wrong");
                System.out.println("error");
                logobj.warn.setVisible(true);
                

            }

        }else if(e.getSource()==logobj.SetupBtn){
            System.out.println("setupbtn");
        }
    }

     @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            logobj.LoginBtn.doClick();
        }

    }

}
