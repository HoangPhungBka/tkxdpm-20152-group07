package project.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import project.utils.ConnectionUtils;

public class UpdateTable {
	public static PreparedStatement pst = null; // biến thực thi sql
	public static ResultSet rs = null; // kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
	public static Connection conn;

	static {
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// viết 1 hàm nạp dữ liệu cho bảng
	public static void LoadData(String sql, JTable jTable) {
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			jTable.setModel(DbUtils.resultSetToTableModel(rs));
			// nạp dữ liệu vào lên bảng mà mình truyền vào
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
		}
	}

	// Tiếp theo ta viết 1 hàm đổ 1 dòng dữ liệu từ bảng lên textfield
	public static ResultSet ShowTextField(String sql) {
		try {
			pst = conn.prepareStatement(sql);
			return pst.executeQuery();
			// trả về 1 dòng dữ liệu đọc được
		} catch (Exception e) {
			return null;
			// JOptionPane.showMessageDialog(null, e,"thông báo lỗi",1);
		}

	}

	public static ResultSet ShowTable(String sql1) {
		//To change body of generated methods, choose Tools | Templates.
		throw new UnsupportedOperationException("Not supported yet."); 
	}
}
