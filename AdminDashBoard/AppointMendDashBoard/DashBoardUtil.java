package MedEaseNavigator.AdminDashBoard.AppointMendDashBoard;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;

public class DashBoardUtil {

    public static DefaultTableCellRenderer render = new DefaultTableCellRenderer() {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Set background color for even rows
            if (row % 2 == 0) {
                component.setBackground(Color.LIGHT_GRAY);
            } else {
                component.setBackground(Color.WHITE);
            }
            return component;
        }

    };
}
