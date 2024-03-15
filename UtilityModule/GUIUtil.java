package MedEaseNavigator.UtilityModule;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;;

public class GUIUtil {
    public static Color Base_Background = new Color(195, 209, 217);
    public static Color Dark_BLue = new Color(63, 88, 83);
    public static Color WhiteClr = Color.white;
    public static Color MedEaseGrey = new Color(217, 217, 217);
    public static Color WarningColor = Color.red;
    public static Color SucesfullColor = Color.yellow;
    public static Color BlueColor = Color.blue;
    public static Font TimesBold = new Font("Times New Roman", Font.BOLD, 14);
    public static Font TimesBold3 = new Font("Times New Roman", Font.BOLD, 22);
    public static Font TimesItalic = new Font("Times New Roman", Font.ITALIC, 18);
    public static Font TimesBoldS2 = new Font("Times New Roman", Font.BOLD, 18);
    public static Font TimesItalicwarn = new Font("Times New Roman", Font.ITALIC, 145);
    public static Color BlackClr = Color.black;
    public static Color RedClr = Color.red;
    public  static Image ptimg = Toolkit.getDefaultToolkit().getImage("MedEaseNavigator\\resource\\mysql-connector-java\\8.0.23\\patient.png");
    public static ImageIcon PTICON =new ImageIcon(ptimg);
    
}   
