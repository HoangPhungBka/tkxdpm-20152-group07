package project.controllers;

import java.sql.ResultSet;
import java.util.Date;

import project.entities.YeuCau;

public class ThongKeController {
	public static ResultSet yeuCauThietBi(String interval) {
		// Tạo đối tượng Date đại diện cho ngày hiện tại
		Date currentDate = new Date();
		// Tạo một đối tượng Date đại diện cho ngày trước đó
		Date beforeDate = null;
		// Tùy vào khoảng thời gian mà người dùng chọn sẽ khởi tạo đối tượng beforeDate là 1, 2 hay 3 tuần trước
		if (interval.equalsIgnoreCase("1 Tuan")) {
			// Khởi tạo đối tượng boforeDate là 1 tuần trước
			beforeDate = new Date(currentDate.getTime() - 604800000);
		} else if (interval.equalsIgnoreCase("2 Tuan")) {
			// Khởi tạo đối tượng boforeDate là 2 tuần trước
			beforeDate = new Date(currentDate.getTime() - 2 * 604800000);
		} else if (interval.equalsIgnoreCase("3 Tuan")) {
			// Khởi tạo đối tượng boforeDate là 3 tuần trước
			beforeDate = new Date(currentDate.getTime() - 3 * 604800000);
		}
		ResultSet resultSet = YeuCau.layVatTuTieuThuTheoThoiGian(currentDate, beforeDate);
		return resultSet;
	}
}
