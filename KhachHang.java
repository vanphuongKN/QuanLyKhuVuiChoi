
package quanlykhuvuichoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhachHang extends Person {
    private String email;
    private String soCCCD;
    private List<DatCho> danhSachDatCho;
    private int diemTichLuy;
    public KhachHang() {
        super();
        this.danhSachDatCho = new ArrayList<>();
        this.diemTichLuy = 0;
    }
      public KhachHang(String ten, String soDienThoai, String email, String soCCCD) {
        super(ten, soDienThoai);
        this.email = email;
        this.soCCCD = soCCCD;
        this.danhSachDatCho = new ArrayList<>();
        this.diemTichLuy = 0;
    }
    @Override
    public void nhap(Scanner scanner){
        System.out.println("\n NHAP THONG TIN KHACH HANG ");
        super.nhap(scanner);
        System.out.print("nhap email: ");
        this.email = scanner.nextLine();
        System.out.print("nhap so CCCD: ");
        this.soCCCD = scanner.nextLine();
    }
      @Override
    public void xuat() {
        System.out.println("\n THONG TIN KHACH HANG");
        super.xuat();
        System.out.println("Email: " + this.email);
        System.out.println("so CCCD: " + this.soCCCD);
        System.out.println("Diem tich luy: " + this.diemTichLuy);
        System.out.println("so lan dat cho: " + this.danhSachDatCho.size());
        System.out.println("tong chi tieu: " + tinhTongChiTieu());
    }
    public void themDatCho(DatCho datCho) {
        this.danhSachDatCho.add(datCho);
        if (datCho.isDaThanhToan()) {
            this.diemTichLuy += (int)(datCho.getTongTien() / 50000);
        }
    }
     public double tinhTongChiTieu() {
        return danhSachDatCho.stream()
                .filter(DatCho::isDaThanhToan)
                .mapToDouble(DatCho::getTongTien)
                .sum();
    }
      public int demVeDaMua() {
        return danhSachDatCho.stream()
                .filter(DatCho::isDaThanhToan)
                .mapToInt(datCho -> datCho.getDanhSachVe().size())
                .sum();
    }

    public void xemLichSuDatCho() {
        if (danhSachDatCho.isEmpty()) {
            System.out.println("khach hang chua dat cho");
            return;
        }
     System.out.println("\n Lich su dat cho cua " + getTen().toUpperCase() + " ---");
        for (DatCho datCho : danhSachDatCho) {
            datCho.xuat();
            System.out.println("--------------------");
        }
    }


    public String getEmail() {
        return email; 
    }
    public String getSoCCCD() { 
        return soCCCD; 
    }
    public List<DatCho> getDanhSachDatCho() {
        return new ArrayList<>(danhSachDatCho);
    }
    public int getDiemTichLuy() {
        return diemTichLuy; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD; 
    }
}
