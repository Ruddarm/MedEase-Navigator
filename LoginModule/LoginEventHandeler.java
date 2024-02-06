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
        if(e.getSource()==logobj.LoginBtn){
            System.out.println("btn click");
            String Username =logobj.UserName.getText();
            String Password = logobj.Password.getText();

            if(logobj.DBO.AdminLogin(Username, Password) ){
                System.out.println("Loged in    ");
            }else{
                logobj.warn.setText("User Name or Password is wrong");
                System.out.println("error");
                logobj.warn.setVisible(true);
            }
            
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // super.keyPressed(e);
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            logobj.LoginBtn.doClick();
        }
        
    }

}
