package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import MedEaseNavigator.AppointMentModule.UpdateAppointMentTime;
import MedEaseNavigator.AppointMentModule.UpdateAppointStatus;
import MedEaseNavigator.AppointMentModule.ViewPatient;
import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedEasePatient;
import MedEaseNavigator.UtilityModule.MedQueue;

public class AppointMentInterface implements TableColumnModelListener {
    JFrame mainFrame;
    MedPannel BackPannel, FrontPannel;
    JLabel TodayLabel;

    JTableHeader JTh;
    DefaultTableModel DTM;
    JScrollPane jsp;
    String TabelHead[] = { "PID", "Name", "Number", "Status", "Time Slot" };
    String AppointMentData[];
    AppointMent Appointment;
    MedQueue TodayQueue;
    DBOperation DBO;
    JTable AppointMentTable;

    public AppointMentInterface(JFrame MedEaseFrame, DBOperation DBO) {
        this.DBO = DBO;
        TodayQueue = new MedQueue(this.DBO);
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 20);
        BackPannel.setBounds(100, 130, 600, 500);
        BackPannel.setLayout(null);
        FrontPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
        FrontPannel.setBounds(0, 50, 600, 450);
        FrontPannel.setLayout(null);
        BackPannel.add(FrontPannel);
        MedEaseFrame.add(BackPannel);
        JLabel TodayLabel = new JLabel("TODAY'S APPOINTMENT");
        TodayLabel.setForeground(GUIUtil.WhiteClr);
        TodayLabel.setFont(GUIUtil.TimesBoldS2);
        TodayLabel.setBounds(160, 20, 300, 20);
        BackPannel.add(TodayLabel);
        SetTable();

    }

    // { "PID", "Name", "Number", "Status", "Time Slot" };
    public void SetTable() {

        TodayQueue.GetAppointmentData();
        TodayQueue.Head = null;
        TodayQueue.CreateAppointmentList();
        this.Appointment = TodayQueue.Head;
        DTM = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (String string : TabelHead) {
            DTM.addColumn(string);
        }

        AppointMent temp = Appointment;

        while (temp != null) {
            String appointdata[] = { temp.getPID(), temp.getName(), temp.getNumber(), temp.getStatus(),
                    temp.getTimeSlot() };
            System.out.println(temp.getName());
            DTM.addRow(appointdata);
            temp = temp.getNextAppointment();
        }
        AppointMentTable = new JTable(DTM);
        AppointMentTable.getColumnModel().getColumn(0).setMinWidth(80);
        AppointMentTable.getColumnModel().getColumn(0).setMaxWidth(50);
        AppointMentTable.removeEditor();
        AppointMentTable.setFont(GUIUtil.TimesBold);
        AppointMentTable.setLayout(null);
        AppointMentTable.setDragEnabled(false);
        AppointMentTable.setRowSelectionAllowed(false);
        AppointMentTable.setColumnSelectionAllowed(false);
        AppointMentTable.setCellSelectionEnabled(true);

        AppointMentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumnModel colummodel = AppointMentTable.getColumnModel();
        colummodel.addColumnModelListener(this);
        // AppointMentTable.setBounds(0, 0, 600, 400);
        jsp = new JScrollPane(AppointMentTable);
        jsp.setBounds(0, 0, 600, 350);
        FrontPannel.add(jsp);
        // for (int i = 0; i < TabelHead.length; i++) {
        // AppointMentTable.getColumnModel().getColumn(i).setMinWidth(150);
        // }

    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub
        if (!e.getValueIsAdjusting()) {
            int row = AppointMentTable.getSelectedRow();
            if (row != -1 && AppointMentTable.getSelectedColumn() == 3) {
                String Pnumber = "" + AppointMentTable.getValueAt(row, 2);
                MedEasePatient Pt = new MedEasePatient();
                MedEasePatient.SetPTData(Pt, DBO.GetPatient(Pnumber));
                new UpdateAppointStatus(Appointment, DBO, null);
                AppointMentTable.clearSelection();
            } else if (row != -1 && AppointMentTable.getSelectedColumn() == 4) {
                String Pnumber = "" + AppointMentTable.getValueAt(row, 0);
                MedEasePatient Pt = new MedEasePatient();
                MedEasePatient.SetPTData(Pt, DBO.GetPatient(Pnumber));
                new UpdateAppointMentTime(Appointment, DBO, null);
                AppointMentTable.clearSelection();

            } else if (row != -1 && AppointMentTable.getSelectedColumn() == 0) {
                new ViewPatient(DBO, null);
                AppointMentTable.clearSelection();
            }
        }

    }

    @Override
    public void columnAdded(TableColumnModelEvent e) {

    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
        // TODO Auto-generated method stub

    }

    public void UpdateTable() {
        FrontPannel.remove(jsp);
        FrontPannel.repaint();
        SetTable();
        // for (int i = 0; i < DTM.getRowCount(); i++) {
        // DTM.removeRow(i);
        // }

        // TodayQueue.GetAppointmentData();
        // TodayQueue.Head=null;
        // TodayQueue.CreateAppointmentList();
        // AppointMent temp = Appointment;
        // while (temp != null) {
        // String appointdata[] = { temp.getPID(), temp.getName(), temp.getStatus(),
        // temp.getTimeSlot() };
        // System.out.println(temp.getName());
        // DTM.addRow(appointdata);
        // temp = temp.getNextAppointment();
        // }
        // AppointMentTable = new JTable(DTM);
        // AppointMentTable.getColumnModel().getColumn(0).setMinWidth(80);
        // AppointMentTable.getColumnModel().getColumn(0).setMaxWidth(50);

        // // AppointMentTable.setBounds(0, 0, 600, 400);
        // jsp = new JScrollPane(AppointMentTable);
        // jsp.setBounds(0, 0, 600, 350);
        // FrontPannel.add(jsp);

    }
}
