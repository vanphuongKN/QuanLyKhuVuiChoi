// File: DatCho.java
package quanlykhuvuichoi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatCho {
    private String maDatCho;
    private LocalDateTime thoiGianDat;
    private double tongTien;
    private boolean daThanhToan;
    private KhachHang khachHang;
    private LichChoi lichChoi;
    private List<VeChoi> danhSachVe;
    private Payment phuongThucThanhToan;

    public DatCho() {
        this.maDatCho = "DC" + System.currentTimeMillis();
        this.thoiGianDat = LocalDateTime.now();
        this.danhSachVe = new ArrayList<>();
        this.daThanhToan = false;
    }

    public DatCho(KhachHang khachHang, LichChoi lichChoi) {
        this();
        this.khachHang = khachHang;
        this.lichChoi = lichChoi;
    }

    public void nhap(Scanner scanner) {
        System.out.println("\n--- THÔNG TIN ĐẶT CHỖ ---");
        System.out.println("Mã đặt chỗ: " + this.maDatCho);
        System.out.println("Thời gian đặt: " + 
            thoiGianDat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    public void xuat() {
        System.out.println("\n--- THÔNG TIN ĐẶT CHỖ ---");
        System.out.println("Mã đặt chỗ: " + this.maDatCho);
        System.out.println("Thời gian đặt: " + 
            thoiGianDat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Tổng tiền: " + this.tongTien);
        System.out.println("Trạng thái: " + (this.daThanhToan ? "Đã thanh toán" : "Chưa thanh toán"));
        System.out.println("Số vé: " + this.danhSachVe.size());
        
        if (khachHang != null) {
            System.out.println("Khách hàng: " + khachHang.getTen());
        }
        
        if (lichChoi != null) {
            System.out.println("Lịch chơi: " + 
                lichChoi.getThoiGianChoi().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }
    }

    public void themVe(VeChoi ve) {
        this.danhSachVe.add(ve);
        this.tongTien += ve.getGiaVe();
    }

    public void huyVe(VeChoi ve) {
        if (this.danhSachVe.remove(ve)) {
            this.tongTien -= ve.getGiaVe();
            ve.huyVe();
        }
    }

    public boolean thucHienThanhToan(Payment phuongThuc) {
        if (this.daThanhToan) {
            System.out.println("Đặt chỗ đã được thanh toán!");
            return false;
        }
        
        if (phuongThuc.pay(this.tongTien)) {
            this.daThanhToan = true;
            this.phuongThucThanhToan = phuongThuc;
            
            if (khachHang != null) {
                khachHang.themDatCho(this);
            }
            
            System.out.println("Thanh toán thành công!");
            return true;
        } else {
            System.out.println("Thanh toán thất bại!");
            return false;
        }
    }

    public void huyDatCho() {
        if (!this.daThanhToan) {
            for (VeChoi ve : danhSachVe) {
                ve.huyVe();
            }
            danhSachVe.clear();
            tongTien = 0;
            System.out.println("Đã hủy đặt chỗ " + maDatCho);
        } else {
            System.out.println("Không thể hủy đặt chỗ đã thanh toán!");
        }
    }

    // Getter methods
    public String getMaDatCho() { return maDatCho; }
    public LocalDateTime getThoiGianDat() { return thoiGianDat; }
    public double getTongTien() { return tongTien; }
    public boolean isDaThanhToan() { return daThanhToan; }
    public KhachHang getKhachHang() { return khachHang; }
    public LichChoi getLichChoi() { return lichChoi; }
    public List<VeChoi> getDanhSachVe() { return new ArrayList<>(danhSachVe); }
    
    // Setter methods
    public void setDaThanhToan(boolean daThanhToan) { this.daThanhToan = daThanhToan; }
    public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; }
    public void setLichChoi(LichChoi lichChoi) { this.lichChoi = lichChoi; }
}