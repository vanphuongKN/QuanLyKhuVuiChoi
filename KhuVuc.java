// File: KhuVuc.java
package quanlykhuvuichoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhuVuc {
    protected String maKhuVuc;
    protected String tenKhuVuc;
    protected int sucChua;
    protected List<TramChoi> danhSachTram;

    public KhuVuc() {
        this.danhSachTram = new ArrayList<>();
    }

    public KhuVuc(String maKhuVuc, String tenKhuVuc, int sucChua) {
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
        this.sucChua = sucChua;
        this.danhSachTram = new ArrayList<>();
        khoiTaoTramTuDong();
    }

    public void nhap(Scanner scanner) {
        System.out.println("\n--- NHAP THONG TIN KHU VUC ---");
        System.out.print("Nhap ma khu vuc: ");
        this.maKhuVuc = scanner.nextLine().trim().toUpperCase();
        System.out.print("Nhap ten khu vuc: ");
        this.tenKhuVuc = scanner.nextLine();
        System.out.print("Nhap suc chua: ");
        this.sucChua = Integer.parseInt(scanner.nextLine());
        
        khoiTaoTramTuDong();
        System.out.println("Đa khoi tao tu đong " + sucChua + " tram choi cho khu vuc.");
    }

    private void khoiTaoTramTuDong() {
        danhSachTram.clear();
        for (int i = 1; i <= sucChua; i++) {
            String maTram = maKhuVuc + "-T" + i;
            String tenTram = "Tram " + i + " - " + tenKhuVuc;
            danhSachTram.add(new TramChoi(maTram, tenTram));
        }
    }

    public void xuat() {
        System.out.println("\n--- THoNG TIN KHU VuC ---");
        System.out.println("Ma khu vuc: " + maKhuVuc);
        System.out.println("Ten khu vuc: " + tenKhuVuc);
        System.out.println("Suc chua: " + sucChua);
        System.out.println("So tram trong: " + demTramTrong());
        
        System.out.println("\nDANH SACH TRAM CHOI:");
        inSoDoTram();
    }

    public void inSoDoTram() {
        System.out.println("     KHU VUC " + tenKhuVuc.toUpperCase());
        System.out.println("============================");
        
        int count = 0;
        for (TramChoi tram : danhSachTram) {
            String trangThai = tram.getTrangThai() ? "[X]" : "[ ]";
            System.out.print(tram.getMaTram() + trangThai + " ");
            count++;
            
            if (count % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n[ ]: Trong | [X]: Đa dat");
    }

    public TramChoi timTramTheoMa(String maTram) {
        return danhSachTram.stream()
                .filter(tram -> tram.getMaTram().equalsIgnoreCase(maTram))
                .findFirst()
                .orElse(null);
    }

    public int demTramTrong() {
        return (int) danhSachTram.stream()
                .filter(tram -> !tram.getTrangThai())
                .count();
    }

    // Getter methods
    public String getMaKhuVuc() { return maKhuVuc; }
    public String getTenKhuVuc() { return tenKhuVuc; }
    public int getSucChua() { return sucChua; }
    public List<TramChoi> getDanhSachTram() { return new ArrayList<>(danhSachTram); }
}