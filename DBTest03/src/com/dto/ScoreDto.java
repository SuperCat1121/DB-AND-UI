package com.dto;

public class ScoreDto {

	private String Sname, Sgrade;
	private int Skor, Seng, Smath;
	private int Ssum;
	private double Savg;
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSgrade() {
		return Sgrade;
	}
	public void setSgrade(String sgrade) {
		Sgrade = sgrade;
	}
	public int getSkor() {
		return Skor;
	}
	public void setSkor(int skor) {
		Skor = skor;
	}
	public int getSeng() {
		return Seng;
	}
	public void setSeng(int seng) {
		Seng = seng;
	}
	public int getSmath() {
		return Smath;
	}
	public void setSmath(int smath) {
		Smath = smath;
	}
	public int getSsum() {
		return Ssum;
	}
	public void setSsum(int ssum) {
		Ssum = ssum;
	}
	public double getSavg() {
		return Savg;
	}
	public void setSavg(double savg) {
		Savg = savg;
	}
	@Override
	public String toString() {
		return "ScoreDto [Sname=" + Sname + ", Skor=" + Skor + ", Seng=" + Seng + ", Smath=" + Smath + ", Ssum=" + Ssum
				+ ", Savg=" + Savg + ", Sgrade=" + Sgrade + "]";
	}
	
}
