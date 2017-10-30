package project.entities;

import java.util.Date;

public class ThietBi {
	private String matb;
	private String tentb;
	public String madv;
	private String tskt;
	private Double gia;
	private int trangthai;
	private String nsx;
	private Date thoigiancap;

	public ThietBi() {
	}

	public ThietBi(String matb, String tentb, String madv, String tskt, Double gia, int trangthai, String nsx, Date thoigiancap) {
		this.matb = matb;
		this.tentb = tentb;
		this.madv = madv;
		this.tskt = tskt;
		this.gia = gia;
		this.trangthai = trangthai;
		this.nsx = nsx;
		this.thoigiancap = thoigiancap;
	}

	public String getmatb() {
		return matb;
	}

	public void set_matb(String x) {
		matb = x;
	}

	public String gettentb() {
		return tentb;
	}

	public void settentb(String x) {
		tentb = x;
	}

	public String getmadv() {
		return madv;
	}

	public void setmadv(String x) {
		madv = x;
	}

	public String gettskt() {
		return tskt;
	}

	public void set_tskt(String x) {
		tskt = x;
	}

	public Double getgia() {
		return gia;
	}

	public void set_gia(Double x) {
		gia = x;
	}

	public int gettrangthai() {
		return trangthai;
	}

	public void set_trangthai(int x) {
		trangthai = x;
	}

	public String getnsx() {
		return nsx;
	}

	public void set_nsx(String x) {
		nsx = x;
	}

	public Date getthoigiancap() {
		return thoigiancap;
	}

	public void set_thoigiancapi(Date x) {
		thoigiancap = x;

	}
}
