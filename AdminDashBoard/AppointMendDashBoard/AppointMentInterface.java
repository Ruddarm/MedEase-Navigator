package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import MedEaseNavigator.MedEaseComponent.MedPannel;
import MedEaseNavigator.UtilityModule.GUIUtil;

public class AppointMentInterface {
    JFrame mainFrame;
    MedPannel BackPannel, FrontPannel;
    JLabel TodayLabel;
    JTable AppointMentTable;
    JTableHeader JTh;
    DefaultTableModel DTM;
    JScrollPane jsp;
    String TabelHead[] = { "PID", "Name", "Number", "Status", "Time Slot" };

    public AppointMentInterface(JFrame MedEaseFrame) {
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

    public void SetTable() {
        DTM = new DefaultTableModel();
        for (String string : TabelHead) {
            DTM.addColumn(string);
        }
        AppointMentTable = new JTable(DTM);
        AppointMentTable.getColumnModel().getColumn(0).setMinWidth(80);
        AppointMentTable.getColumnModel().getColumn(0).setMaxWidth(50);
        // AppointMentTable.setBounds(0, 0, 600, 400);
        jsp = new JScrollPane(AppointMentTable);
        jsp.setBounds(0, 0, 600, 350);
        FrontPannel.add(jsp);
        // for (int i = 0; i < TabelHead.length; i++) {
        // AppointMentTable.getColumnModel().getColumn(i).setMinWidth(150);
        // }

    }
}
