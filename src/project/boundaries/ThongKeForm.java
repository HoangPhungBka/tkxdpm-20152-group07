package project.boundaries;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import project.controllers.ThongKeController;

@SuppressWarnings("serial")
public class ThongKeForm extends JFrame {

	private JComboBox<String> comboBox;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ThongKeForm().setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ThongKeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307); contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); setResizable(false);
		contentPane.setLayout(null);

		table = new JTable(); table.setRowHeight(23);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setFocusable(false); table.setBounds(10, 42, 424, 225);
		contentPane.add(table);

		comboBox = new JComboBox<>(); comboBox.setFocusable(false);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "1 Tuan", "2 Tuan", "3 Tuan" }));
		comboBox.setBounds(149, 11, 116, 20);
		contentPane.add(comboBox);

		JButton btnThongKe = new JButton("Thong Ke");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processThongKeButton();
			}
		});
		btnThongKe.setBounds(297, 10, 116, 23);
		btnThongKe.setFocusable(false);
		contentPane.add(btnThongKe);

		JLabel lblKhoangTime = new JLabel("Chon Khoang Thoi Gian:");
		lblKhoangTime.setBounds(23, 11, 116, 20);
		contentPane.add(lblKhoangTime);
	}
	
	/**
	 * Phương thức này dùng để load tiêu đề cho bảng
	 * @return một mảng String các tiêu đề
	 */
	private String[] loadColumnNames() {
		return new String[] {"Ma Vat Tu", "Ma Don Vi", "So Luong", "Thoi Gian" };
	}

	/**
	 * Phương thức này dùng để load dữ liệu cho bảng
	 * @return trả về một mảng 2 chiều tương ứng với dữ liệu của bảng
	 */
	private Object[][] loadRowData(ResultSet resultSet) {
		Object[][] rowData = new Object[10][4];
		try {
			// Định dạng ngày phải có dạng "yyyy-MM-dd"
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			int i = 0;
			while (resultSet.next()) {
				rowData[i][0] = resultSet.getString(1);
				rowData[i][1] = resultSet.getString(2);
				rowData[i][2] = resultSet.getInt(3);
				rowData[i][3] = dateFormat.format(resultSet.getDate(4));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowData;
	}
	
	/**
	 * Phương thức này dùng để xử lý khi người dùng nhấn button "Thống Kê"
	 */
	private void processThongKeButton() {
		// Lấy khoảng thời gian từ comboBox mà người dùng đã chọn rồi truyền cho ThongKeController
		ResultSet resultSet = ThongKeController.yeuCauThietBi((String) comboBox.getSelectedItem());
		TableModel model = new DefaultTableModel(loadRowData(resultSet), loadColumnNames()) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, Integer.class, String.class };
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.setModel(model);
	}
}
