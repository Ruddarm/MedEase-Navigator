/*
 * 
 */
package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class WaitingInterface {
    MedPannel BackPannel;
    MedPannel FrontPannel;
    JLabel WaitingLable;
    JScrollPane jsp;
    JTable WattingTable;
    DefaultTableModel Dtm;
    String TableHead[] = {
            "PID", "Name", "Number", "Status", "Time Slot"
    };

    public WaitingInterface(JFrame MedFrame) {
        BackPannel = new MedPannel(GUIUtil.Dark_BLue, GUIUtil.Dark_BLue, null, 20);
        BackPannel.setBounds(750, 50, 500, 300);
        MedFrame.add(BackPannel);
        FrontPannel = new MedPannel(GUIUtil.WhiteClr, GUIUtil.WhiteClr, null, 0);
        FrontPannel.setBounds(0, 50, 500, 250);
        BackPannel.add(FrontPannel);
        SetWaitingTable();

    }

    public void SetWaitingTable() {
        Dtm = new DefaultTableModel();
        for (String string : TableHead) {
            Dtm.addColumn(string);
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
