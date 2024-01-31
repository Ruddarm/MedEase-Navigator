/*
 * Set GUI for Payment 
 * @author Ruddarm
 *
 */
package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class PaymentInterface {
    MedPannel BackPannel;
    MedPannel FrontPannel;
    JLabel PaymentLble;
    JScrollPane jsp;
    JTable PaymentTable;
    DefaultTableModel Dtm;
    String TableHead[] = {
            "PID", "Name", "Number", "Status", "Fees"
    };

    public PaymentInterface(JFrame MedEaseFrame) {
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 20);
        BackPannel.setBounds(750, 380, 500, 250);
        MedEaseFrame.add(BackPannel);
        FrontPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
        FrontPannel.setBounds(0, 50, 500, 200);
        BackPannel.add(FrontPannel);
        SetPaymentTable();

    }

    public void SetPaymentTable() {
        Dtm = new DefaultTableModel();
        for (String string : TableHead) {
            Dtm.addColumn(string);
        }

        PaymentTable = new JTable(Dtm);
        jsp = new JScrollPane(PaymentTable);
        // jsp.setLayout(null);
        jsp.setBounds(0, 0, 500, 200);
        FrontPannel.add(jsp);

    }

}
