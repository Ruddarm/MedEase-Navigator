/*
 * Set GUI for Payment 
 * @author Ruddarm
 *
 */
package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import MedEaseNavigator.AppointMentModule.ViewPatient;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import MedEaseNavigator.UtilityModule.MedQueue;

public class PaymentInterface implements TableColumnModelListener {
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
        System.out.println("Ye  nulla nahi  hai");
        PaymentQueue.CreateAppointmentList();
        AppointMent Temp = PaymentQueue.Head;
        while (Temp != null) {
            String appointdata[] = { Temp.getPID(), Temp.getName(), Temp.getNumber(), Temp.getStatus(),
                    Temp.getTimeSlot() };
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
        PaymentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumnModel colummodel = PaymentTable.getColumnModel();
        colummodel.addColumnModelListener(this);
        jsp = new JScrollPane(PaymentTable);
        jsp.setBounds(0, 0, 500, 200);
        FrontPannel.add(jsp);

    }

    public void UpdatePaymentTable() {
        FrontPannel.remove(jsp);
        FrontPannel.repaint();
        SetPaymentTable();
    }

    @Override
    public void columnAdded(TableColumnModelEvent e) {
    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int row = PaymentTable.getSelectedRow();
            if (row != -1 && PaymentTable.getSelectedColumn() == 0) {
                MedEasePatient pt = new MedEasePatient();
                MedEasePatient.SetPTData(pt, DBO.GetPatient("" + PaymentTable.getValueAt(row, 2)));
                new ViewPatient(DBO, pt);
                PaymentTable.clearSelection();
                UpdatePaymentTable();

            }
        }
    }

}
