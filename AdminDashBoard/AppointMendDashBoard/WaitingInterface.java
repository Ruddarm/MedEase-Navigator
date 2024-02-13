/*
 * 
 * 
 * 
 */
package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MedEaseNavigator.DataBaseModule.DBOperation;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.AppointMent;
import MedEaseNavigator.UtilityModule.GUIUtil;
import MedEaseNavigator.UtilityModule.MedQueue;

public class WaitingInterface {
    MedPannel BackPannel;
    MedPannel FrontPannel;
    JLabel WaitingList;
    JScrollPane jsp;
    JTable WattingTable;
    AppointMent WaitingAppoint;
    DefaultTableModel Dtm;
    DBOperation DBO;
    MedQueue WaitingQueue;
    String TableHead[] = {
            "PID", "Name", "Number", "Status", "Time Slot"
    };

    public WaitingInterface(JFrame MedFrame, DBOperation DBO) {
        this.DBO = DBO;
        WaitingQueue = new MedQueue(DBO);
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 20);
        BackPannel.setBounds(750, 50, 500, 300);
        MedFrame.add(BackPannel);
        FrontPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
        FrontPannel.setBounds(0, 50, 500, 250);
        BackPannel.add(FrontPannel);

        JLabel WaitingList = new JLabel("WAITING LIST");
        WaitingList.setForeground(GUIUtil.WhiteClr);
        WaitingList.setFont(GUIUtil.TimesBoldS2);
        WaitingList.setBounds(190, 20, 200, 20);
        BackPannel.add(WaitingList);
        SetWaitingTable();
    }

    public void SetWaitingTable() {
        Dtm = new DefaultTableModel();
        WaitingQueue.GetWaitingAppointmentData();
        WaitingQueue.Head = null;
        WaitingQueue.CreateAppointmentList();

        for (String string : TableHead) {
            Dtm.addColumn(string);
        }
        AppointMent temp = WaitingQueue.Head;
        while (temp != null) {
            while (temp != null) {
                String appointdata[] = { temp.getPID(), temp.getName(), temp.getNumber(), temp.getStatus(),
                        temp.getTimeSlot() };
                System.out.println(temp.getName());
                Dtm.addRow(appointdata);
                temp = temp.getNextAppointment();
            }
        }
        WattingTable = new JTable(Dtm);
        jsp = new JScrollPane(WattingTable);
        jsp.setBounds(0, 0, 500, 250);
        FrontPannel.add(jsp);
        for (int i = 0; i < WattingTable.getColumnCount(); i++) {
            WattingTable.getColumnModel().getColumn(i).setCellRenderer(DashBoardUtil.render);
        }

    }
    

}
