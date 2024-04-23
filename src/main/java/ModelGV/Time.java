package ModelGV;

import java.time.LocalDate;

public class Time {

	private LocalDate MDangKy;
	private LocalDate MBaoCao;
	private LocalDate DDangKy;
	private LocalDate DBaoCao;

	public Time() {
		// TODO Auto-generated constructor stub
	}

	public Time(LocalDate mDangKy, LocalDate dDangKy, LocalDate mBaoCao, LocalDate dBaoCao) {
		super();
		MDangKy = mDangKy;
		MBaoCao = mBaoCao;
		DDangKy = dDangKy;
		DBaoCao = dBaoCao;
	}

	public boolean inNgayDK() {
		LocalDate currentDate = LocalDate.now();
		return (currentDate.isEqual(MDangKy) || currentDate.isAfter(MDangKy))
				&& (currentDate.isEqual(DDangKy) || currentDate.isBefore(DDangKy));
	}

	public boolean inNgayNop() {
		LocalDate currentDate = LocalDate.now();
		return (currentDate.isEqual(DDangKy) || currentDate.isAfter(DDangKy))
				&& (currentDate.isEqual(MBaoCao) || currentDate.isBefore(MBaoCao));
	}

	public LocalDate getMDangKy() {
		return MDangKy;
	}

	public void setMDangKy(LocalDate mDangKy) {
		MDangKy = mDangKy;
	}

	public LocalDate getMBaoCao() {
		return MBaoCao;
	}

	public void setMBaoCao(LocalDate mBaoCao) {
		MBaoCao = mBaoCao;
	}

	public LocalDate getDDangKy() {
		return DDangKy;
	}

	public void setDDangKy(LocalDate dDangKy) {
		DDangKy = dDangKy;
	}

	public LocalDate getDBaoCao() {
		return DBaoCao;
	}

	public void setDBaoCao(LocalDate dBaoCao) {
		DBaoCao = dBaoCao;
	}

}
