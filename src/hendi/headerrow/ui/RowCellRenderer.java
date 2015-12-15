package hendi.headerrow.ui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

@SuppressWarnings("rawtypes")
public class RowCellRenderer implements ListCellRenderer 
{
	JLabel lbl_1 = new JLabel();
	JTable tabel;
	
	public RowCellRenderer(JTable tabelParam)
	{
		tabel = tabelParam;
	}

	@SuppressWarnings("static-access")
	@Override
	public Component getListCellRendererComponent(JList list, Object obj,
			int index, boolean isSelected, boolean hasFocus) 
	{
		// TODO Auto-generated method stub
		JTableHeader tabelHeader = tabel.getTableHeader();
		lbl_1.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		lbl_1.setForeground(tabelHeader.getForeground().BLUE);
		lbl_1.setBackground(tabelHeader.getBackground());
		lbl_1.setFont(tabelHeader.getFont());
		lbl_1.setText(obj.toString());
		return lbl_1;
	}
}
