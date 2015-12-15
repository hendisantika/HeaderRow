package hendi.headerrow.ui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class ImageRender extends DefaultTableCellRenderer 
{
	public Component getTableCellRendererComponent(JTable tabel,Object obj,boolean isSelected,boolean hasFocus,int baris,int kolom)
	{
		textIcon ti = (textIcon) obj;
		if(obj == ti)
		{
			setIcon(ti.imgIcon);
			setText(ti.text);
		}
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		setHorizontalAlignment(JLabel.CENTER);
		return this;
	}
}
