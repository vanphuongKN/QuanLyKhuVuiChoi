// File: LichChoi.java
package quanlykhuvuichoi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LichChoi {
    private LocalDateTime thoiGianChoi;
    private Game game;
    private KhuVuc khuVuc;
    private List<VeChoi> danhSachVe;
    private double giaVe;

    public LichChoi() {
        this.danhSachVe = new ArrayList<>();
    }
    
    public LichChoi(Game game, KhuVuc khuVuc, LocalDateTime thoiGianChoi) {
        this.game = game;
        this.khuVuc = khuVuc;
        this.thoiGianChoi = thoiGianChoi;
        this.danhSachVe = new ArrayList<>();
        this.giaVe = game != null ? game.getGiaVe() : 0;
    }

    public void nhap(Scanner scanner) {
        System.out.println("\n--- NHAP THONG TIN LICH CHOI ---");
        
        while (true) {
            try {
                System.out.print("Nhap thoi gian choi (dd/MM/yyyy HH:mm): ");
                String thoiGianStr = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                this.thoiGianChoi = LocalDateTime.parse(thoiGianStr, formatter);
                
                if (this.thoiGianChoi.isBefore(LocalDateTime.now())) {
                    System.out.println("khong ton tai!");
                    continue;
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("nhap lai!");
            }
        }
        
        System.out.print("Nhap gia ve: ");
        this.giaVe = Double.parseDouble(scanner.nextLine());
    }

    public void xuat() {
        System.out.println("\n--- THONG TIN LICH CHOI ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Thoi gian: " + this.thoiGianChoi.format(formatter));
        System.out.println("Tro choi: " + (game != null ? game.getTenGame() : "Chua co"));
        System.out.println("Khu vuc: " + (khuVuc != null ? khuVuc.getTenKhuVuc() : "Chua co"));
        System.out.println("Gia ve: " + giaVe);
        System.out.println("So ve đa đat: " + danhSachVe.size() + "/" + 
                          (khuVuc != null ? khuVuc.getSucChua() : "N/A"));
        System.out.println("Doanh thu: " + tinhDoanhThu());
    }

    public boolean datTram(String maTram) {
        if (khuVuc == null) return false;
        
        TramChoi tram = khuVuc.timTramTheoMa(maTram);
        if (tram != null && !tram.getTrangThai()) {
            tram.setTrangThai(true);
            tram.setGame(this.game);
            return true;
        }
        return false;
    }

    public boolean huyTram(String maTram) {
        if (khuVuc == null) return false;
        
        TramChoi tram = khuVuc.timTramTheoMa(maTram);
        if (tram != null && tram.getTrangThai()) {
            tram.setTrangThai(false);
            tram.setGame(null);
            return true;
        }
        return false;
    }

    public void themVe(VeChoi ve) {
        this.danhSachVe.add(ve);
    }

    public double tinhDoanhThu() {
        return danhSachVe.stream()
                .filter(VeChoi::isActive)
                .mapToDouble(VeChoi::getGiaVe)
                .sum();
    }

    // Getter methods
    public LocalDateTime getThoiGianChoi() { return thoiGianChoi; }
    public Game getGame() { return game; }
    public KhuVuc getKhuVuc() { return khuVuc; }
    public List<VeChoi> getDanhSachVe() { return new ArrayList<>(danhSachVe); }
    public double getGiaVe() { return giaVe; }
    
    // Setter methods
    public void setGame(Game game) { 
        this.game = game; 
        if (game != null) {
            this.giaVe = game.getGiaVe();
        }
    }
    public void setKhuVuc(KhuVuc khuVuc) { this.khuVuc = khuVuc; }
}