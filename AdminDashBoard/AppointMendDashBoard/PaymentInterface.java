/*
 * Set GUI for Payment 
 * @author Ruddarm
 *
 */
package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JLabel;
import javax.swing.JTable;

import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedQueue;

public class PaymentInterface {
    MedPannel BackPannel;
    MedPannel FrontPannel;
    JLabel PaymentLble;
    DBOperation DBO;
    JScrollPane jsp;
    JTable PaymentTable;
    DefaultTableModel Dtm;
    MedQueue PaymentQueue;

    String TableHead[] = {
            "PID", "Name", "Number", "Status", "Fees"
    };

    public PaymentInterface(JFrame MedEaseFrame, DBOperation dbo) {
        this.DBO = dbo;
        PaymentQueue = new MedQueue(dbo);
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 20);
        BackPannel.setBounds(750, 380, 500, 250);
        MedEaseFrame.add(BackPannel);
        FrontPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
        FrontPannel.setBounds(0, 50, 500, 200);
        BackPannel.add(FrontPannel);
        PaymentLble = new JLabel("PAYMENT");
        PaymentLble.setForeground(GUIUtil.WhiteClr);
        PaymentLble.setFont(GUIUtil.TimesBoldS2);
        PaymentLble.setBounds(195, 20, 200, 20);
        BackPannel.add(PaymentLble);
        SetPaymentTable();

    }

    public void SetPaymentTable() {
        Dtm = new DefaultTableModel();
        for (String string : TableHead) {
            Dtm.addColumn(string);
        }
        PaymentQueue.Head=null;
        PaymentQueue.GetPaymentAppointmentData();
        PaymentQueue.CreateAppointmentList();
        AppointMent Temp= PaymentQueue.Head;
        while (Temp!=null) {
            
            
        }

        PaymentTable = new JTable(Dtm);
        jsp = new JScrollPane(PaymentTable);
        // jsp.setLayout(null);
        jsp.setBounds(0, 0, 500, 200);
        FrontPannel.add(jsp);

    }

}
