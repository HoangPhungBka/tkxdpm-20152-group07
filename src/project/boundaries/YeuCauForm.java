package project.boundaries;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class YeuCauForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YeuCauForm frame = new YeuCauForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YeuCauForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 22, 259, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTenVatTu = new JLabel("Tên Thiết Bị Yêu Cầu");
		lblTenVatTu.setBounds(10, 25, 108, 14);
		contentPane.add(lblTenVatTu);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 91, 377, 116);
		textArea.setBorder(new TitledBorder(null, "Ghi Chú", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(textArea);
		
		JButton btnYeuCau = new JButton("Yêu Cầu Thiết Bị");
		btnYeuCau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnYeuCau.setBounds(120, 218, 162, 32);
		contentPane.add(btnYeuCau);
		
		JLabel lblSoLuongYeu = new JLabel("Số Lượng Yêu Cầu");
		lblSoLuongYeu.setBounds(10, 50, 108, 14);
		contentPane.add(lblSoLuongYeu);
		
		textField = new JTextField();
		textField.setBounds(128, 48, 259, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
