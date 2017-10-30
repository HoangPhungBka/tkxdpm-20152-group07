package project.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import project.utils.ConnectionUtils;

public class YeuCau {
	
	private static Connection connection;
	private static Statement statement;
	
	/**
	 * Đoạn block code này dùng để khởi tạo kết nối đến database
	 */
	static {
		if (connection == null) {
			try {
				connection = ConnectionUtils.getConnection();
				statement = connection.createStatement();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Phương thức này sẽ nhận tham số từ ThongKeController và truy vẫn CSDL
	 * @param currentDate đại diện cho ngày hiện tại
	 * @param beforeDate đại diện cho một ngày trước đo
	 * @return đối tượng ResultSet là kết quả truy vấn được từ CSDL
	 */
	public static ResultSet layVatTuTieuThuTheoThoiGian(Date currentDate, Date beforeDate) {
		// Định dạng ngày phải có dạng "yyyy-MM-dd"
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Tạo câu truy vấn tương ứng
		String query = "SELECT * FROM `vattutieuthu` WHERE `thoigiansudung` BETWEEN CAST('"
				+ dateFormat.format(beforeDate) + "' AS DATE) AND CAST('" + dateFormat.format(currentDate) + "'AS DATE)";
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
