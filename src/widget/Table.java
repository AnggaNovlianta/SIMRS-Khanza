package widget;

import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author usu
 */
public class Table extends JTable {

    /*
     * Serial version UID
     */
    private static final long serialVersionUID = 1L;

    public Table() {
        super();
        //setBackground(new Color(255,235,255));
        //setGridColor(new Color(245,170,245));
        //setForeground(new Color(90,90,90));
        setBackground(new Color(255,255,255));
        setGridColor(new Color(233,238,228));
        setForeground(new Color(100,80,80));
        setFont(new java.awt.Font("Tahoma", 0, 11));
        setRowHeight(22);
        setSelectionBackground(new Color(255,255,255));
        setSelectionForeground(new Color(255,0,0));
        getTableHeader().setForeground(new Color(100,80,80));
        getTableHeader().setBackground(new Color(250,255,248));
        getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new Color(252,252,243)));
        getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 11));
    }
}
