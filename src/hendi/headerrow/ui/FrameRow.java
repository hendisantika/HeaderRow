package hendi.headerrow.ui;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FrameRow extends JFrame 
{
	
	@SuppressWarnings("rawtypes")
	JList listHeader;
	JPanel contentPane;
	String header[] = {"Nama","Hobby","Pekerjaan"};
	String headerBaris[] = {"1.","2.","3.","4.","5.","6."};
	String data[][] = {{"Resa","Sepak Bola","CTO"},{"Candra","Badminton","Pegawai"},{"Ayu","Memasak","Pegawai"},
					  {"Dita","Membaca","Wirausaha"},{"Dian","Game","Sekolah"},{"Cancan","Bersepeda","Mahasiswa"}};
	DefaultTableModel tabelModel;
	JTable tabel;
	ImageIcon imgIcon;
	private JScrollPane scrollPane;
	private JButton btnTampilkan;
	private JLabel lblNama;
	private JLabel lblHobby;
	private JLabel lblPekerjaan;
	private JButton btnRefresh;
	private JTextField txtNama;
	private JTextField txtHobby;
	private JTextField txtPekerjaan;
	private JLabel lblBg;
	private JLabel lblIcon;
	/**
	 * Create the frame.
	 */
	public FrameRow() 
	{
		super("Row Header Tabel");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 12, 454, 185);
		contentPane.add(scrollPane);
		
		tabelModel = new DefaultTableModel(data,header);
		tabel = new JTable();
		tabel.setModel(tabelModel);
		imgIcon = new ImageIcon("src/hendi/headerrow/images/kartuNama.png");
		setIcon(tabel, 0, imgIcon, "Nama");
		imgIcon = new ImageIcon("src/hendi/headerrow/images/hobby.png");
		setIcon(tabel, 1, imgIcon, "Hobby");
		imgIcon = new ImageIcon("src/hendi/headerrow/images/pekerjaan.png");
		setIcon(tabel, 2, imgIcon, "Pekerjaan");
		scrollPane.setViewportView(tabel);
		
		btnTampilkan = new JButton("Tampilkan ");
		btnTampilkan.setIcon(new ImageIcon("src/hendi/headerrow/images/Simpan.png"));
		btnTampilkan.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent act)
			{
				int pilih = tabel.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				String nama = (String) tabelModel.getValueAt(pilih, 0);
				txtNama.setText(nama);
				String hobby = (String) tabelModel.getValueAt(pilih, 1);
				txtHobby.setText(hobby);
				String pekerjaan = (String) tabelModel.getValueAt(pilih, 2);
				txtPekerjaan.setText(pekerjaan);
			}
		});
		btnTampilkan.setBounds(41, 222, 146, 40);
		contentPane.add(btnTampilkan);
		
		lblNama = new JLabel("Nama : ");
		lblNama.setForeground(new Color(102, 51, 255));
		lblNama.setBounds(205, 247, 70, 15);
		contentPane.add(lblNama);
		
		lblHobby = new JLabel("Hobby : ");
		lblHobby.setForeground(new Color(0, 51, 255));
		lblHobby.setBounds(205, 274, 70, 15);
		contentPane.add(lblHobby);
		
		lblPekerjaan = new JLabel("Pekerjaan : ");
		lblPekerjaan.setForeground(new Color(0, 51, 255));
		lblPekerjaan.setBounds(205, 301, 85, 15);
		contentPane.add(lblPekerjaan);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon("src/hendi/headerrow/images/Refresh.png"));
		btnRefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent act) 
			{
				txtNama.setText("");
				txtHobby.setText("");
				txtPekerjaan.setText("");
				txtNama.requestFocus();
			}
		});
		btnRefresh.setBounds(41, 274, 146, 42);
		contentPane.add(btnRefresh);
		
		txtNama = new JTextField();
		txtNama.setBounds(311, 245, 130, 19);
		contentPane.add(txtNama);
		txtNama.setColumns(10);
		
		txtHobby = new JTextField();
		txtHobby.setBounds(312, 272, 157, 19);
		contentPane.add(txtHobby);
		txtHobby.setColumns(10);
		
		txtPekerjaan = new JTextField();
		txtPekerjaan.setBounds(311, 299, 186, 19);
		contentPane.add(txtPekerjaan);
		txtPekerjaan.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("src/hendi/headerrow/images/PS.png"));
		lblIcon.setBounds(550, 235, 90, 98);
		contentPane.add(lblIcon);
		
		lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("src/hendi/headerrow/images/kdeGreen.jpg"));
		lblBg.setBounds(0, 0, 678, 359);
		contentPane.add(lblBg);
		setLocationRelativeTo(null);
		setRowHeader();
	}
	
	public void setIcon(JTable tabel,int kol_index,ImageIcon i,String nama)
	{
		tabel.getTableHeader().getColumnModel().getColumn(kol_index).setHeaderRenderer(new ImageRender());
		tabel.getColumnModel().getColumn(kol_index).setHeaderValue(new textIcon(nama, i));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setRowHeader()
	{
		listHeader = new JList();
		listHeader.setListData(headerBaris);
		listHeader.setFixedCellWidth(40);
		listHeader.setFixedCellHeight(tabel.getRowHeight());
		listHeader.setBackground(tabel.getTableHeader().getBackground());
		listHeader.setCellRenderer(new RowCellRenderer(tabel));
		scrollPane.setRowHeaderView(listHeader);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				//McWin Look and Feel from JTattoo
				try 
				{
					com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Large-Font", "Java Swing", "");
                                        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					FrameRow frame = new FrameRow();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				try 
				{
					FrameRow frame = new FrameRow();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
