package project.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.entities.ThietBi;
import project.utils.ConnectionUtils;

public class ThietBiController {

	public static PreparedStatement pst = null;
	public static ResultSet rs = null;

	public static boolean SuaThietBi(ThietBi tb) {
		try {
			Connection conn = ConnectionUtils.getConnection();
			pst = conn.prepareStatement(
					"UPDATE thietbi SET  tentb=?," + " madv =?, tskt = ?, gia= ?,trangthai=?,  nsx= ?, thoigiancap= ?where matb = ?");
			pst.setString(1, tb.gettentb());
			pst.setString(2, tb.getmadv());
			pst.setString(3, tb.gettskt());
			pst.setDouble(4, tb.getgia());
			pst.setInt(5, tb.gettrangthai());
			pst.setString(6, tb.getnsx());
			pst.setDate(7, new java.sql.Date(tb.getthoigiancap().getTime()));
			pst.setString(8, tb.getmatb());

			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}
}
