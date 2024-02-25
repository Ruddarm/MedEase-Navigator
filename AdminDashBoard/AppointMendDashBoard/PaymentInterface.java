/*
 * Set GUI for Payment 
 * @author Ruddarm
 *
 */
package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
            "PID", "Name", "Number", "Status"
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
        PaymentQueue.Head = null;
        PaymentQueue.GetPaymentAppointmentData();
        PaymentQueue.CreateAppointmentList();
        AppointMent Temp = PaymentQueue.Head;
        while (Temp != null) {
            String appointdata[] = { Temp.getPID(), Temp.getName(), Temp.getNumber(), Temp.getStatus(),
                    Temp.getTimeSlot() };
            // System.out.println(temp.getName());
            Dtm.addRow(appointdata);
            Temp = Temp.getNextAppointment();

        }
        PaymentTable = new JTable(Dtm);
        PaymentTable.getColumnModel().getColumn(0).setMinWidth(80);
        PaymentTable.getColumnModel().getColumn(0).setMaxWidth(50);
        PaymentTable.removeEditor();
        PaymentTable.setFont(GUIUtil.TimesBold);
        PaymentTable.setLayout(null);
        PaymentTable.setDragEnabled(false);
        PaymentTable.setRowSelectionAllowed(false);
        PaymentTable.setColumnSelectionAllowed(false);
        PaymentTable.setCellSelectionEnabled(true);
        PaymentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jsp = new JScrollPane(PaymentTable);
        jsp.setBounds(0, 0, 500, 200);
        FrontPannel.add(jsp);

    }

}
