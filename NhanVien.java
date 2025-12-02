// File: NhanVien.java
package quanlykhuvuichoi;

import java.util.Scanner;

public class NhanVien extends Person {
    private String chucVu;
    private double luong;
    private String maNhanVien;
    private int soGioLam;

    public NhanVien() {
        super();
        this.maNhanVien = "NV" + System.currentTimeMillis();
    }

    public NhanVien(String ten, String soDienThoai, String chucVu, double luong) {
        super(ten, soDienThoai);
        this.chucVu = chucVu;
        this.luong = luong;
        this.maNhanVien = "NV" + System.currentTimeMillis();
        this.soGioLam = 0;
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.println("\n--- NHAP THONG TIN NHAN VIEN ---");
        super.nhap(scanner);
        System.out.print("Nhap chuc vu: ");
        this.chucVu = scanner.nextLine();
        System.out.print("Nhap luong: ");
        this.luong = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap so gio lam: ");
        this.soGioLam = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void xuat() {
        System.out.println("\n--- THONG TIN NHAN VIEN ---");
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        super.xuat();
        System.out.println("Chuc vu: " + this.chucVu);
        System.out.println("Luong: " + this.luong);
        System.out.println("So gio lam: " + this.soGioLam);
        System.out.println("Luong thuc nhan: " + tinhLuongThucNhan());
    }

    public double tinhLuongThucNhan() {
        double luongThuc = this.luong;
        if (soGioLam > 160) {
            luongThuc += (soGioLam - 160) * (luong / 160) * 1.5;
        }
        return luongThuc;
    }

    public void chamCong(int soGio) {
        this.soGioLam += soGio;
        System.out.println("Đa cham cong " + soGio + " gio cho nhan vien " + getTen());
    }

    // Getter & Setter
    public String getChucVu() { return chucVu; }
    public double getLuong() { return luong; }
    public String getMaNhanVien() { return maNhanVien; }
    public int getSoGioLam() { return soGioLam; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }
    public void setLuong(double luong) { this.luong = luong; }
    public void setSoGioLam(int soGioLam) { this.soGioLam = soGioLam; }
}