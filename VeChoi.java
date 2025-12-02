// File: VeChoi.java
package quanlykhuvuichoi;

import java.util.Scanner;

public class VeChoi {
    private String maVe;
    private double giaVe;
    private TramChoi tramChoi;
    private LichChoi lichChoi;
    private KhachHang khachHang;
    private DatCho datCho;
    private boolean isActive;

    public VeChoi() {
        this.isActive = true;
    }
    
    public VeChoi(String maVe, double giaVe, TramChoi tramChoi, LichChoi lichChoi, 
                  KhachHang khachHang, DatCho datCho) {
        this.maVe = maVe;
        this.giaVe = giaVe;
        this.tramChoi = tramChoi;
        this.lichChoi = lichChoi;
        this.khachHang = khachHang;
        this.datCho = datCho;
        this.isActive = true;
        
        if (tramChoi != null) {
            this.tramChoi.setTrangThai(true);
        }
    }

    public void nhap(Scanner scanner) {
        System.out.println("\n--- NHAP THONG TIN VE ---");
        System.out.print("Nhap ma ve: ");
        this.maVe = scanner.nextLine();
        System.out.print("Nhap gia ve: ");
        this.giaVe = Double.parseDouble(scanner.nextLine());
    }

    public void xuat() {
        System.out.println("\n--- THONG TIN VE ---");
        System.out.println("Ma ve: " + this.maVe);
        System.out.println("Gia ve: " + this.giaVe);
        System.out.println("Trang thai: " + (this.isActive ? "Co hieu luc" : "Da huy"));
        
        if (khachHang != null) {
            System.out.println("Khach hang: " + this.khachHang.getTen());
        }
        
        if (lichChoi != null && lichChoi.getGame() != null) {
            System.out.println("Tro choi: " + this.lichChoi.getGame().getTenGame());
        }
        
        if (tramChoi != null) {
            System.out.println("Tram choi: " + this.tramChoi.getMaTram());
        }
        
        if (datCho != null) {
            System.out.println("Ma đat cho: " + this.datCho.getMaDatCho());
        }
    }

    public void huyVe() {
        if (this.isActive) {
            this.isActive = false;
            if (this.tramChoi != null) {
                this.tramChoi.setTrangThai(false);
            }
            System.out.println("Đa huy ve " + this.maVe);
        } else {
            System.out.println("Ve đa đuoc huy truoc đo!");
        }
    }

    public void inVe() {
        System.out.println("\n=================================");
        System.out.println("           VE CHOI GAME");
        System.out.println("=================================");
        System.out.println("Ma ve: " + maVe);
        System.out.println("Tro choi: " + (lichChoi != null && lichChoi.getGame() != null ? 
            lichChoi.getGame().getTenGame() : "N/A"));
        System.out.println("Khu vuc: " + (lichChoi != null && lichChoi.getKhuVuc() != null ? 
            lichChoi.getKhuVuc().getTenKhuVuc() : "N/A"));
        System.out.println("Tram: " + (tramChoi != null ? tramChoi.getMaTram() : "N/A"));
        System.out.println("Gio choi: " + (lichChoi != null ? 
            lichChoi.getThoiGianChoi().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : "N/A"));
        System.out.println("Gia: " + giaVe);
        System.out.println("=================================");
    }

    // Getter methods
    public String getMaVe() { return maVe; }
    public double getGiaVe() { return giaVe; }
    public TramChoi getTramChoi() { return tramChoi; }
    public LichChoi getLichChoi() { return lichChoi; }
    public KhachHang getKhachHang() { return khachHang; }
    public DatCho getDatCho() { return datCho; }
    public boolean isActive() { return isActive; }
    
    // Setter methods
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }
    public void setActive(boolean active) { isActive = active; }
}