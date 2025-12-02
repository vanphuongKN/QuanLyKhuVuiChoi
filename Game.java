// File: Game.java
package quanlykhuvuichoi;

import java.util.Scanner;

public class Game {
    protected String tenGame;
    protected String theLoai;
    protected String doKho;
    protected String doTuoiYeuCau;
    protected double giaVe;

    public Game() {}

    public void nhap(Scanner scanner) {
        System.out.println("--- nhap thong tin tro choi ---");
        System.out.print("Nhap ten: ");
        this.tenGame = scanner.nextLine();
        System.out.print("Nhap the loai: ");
        this.theLoai = scanner.nextLine();
        System.out.print("Nhap do kho: ");
        this.doKho = scanner.nextLine();
        System.out.print("Nhap do tuoi: ");
        this.doTuoiYeuCau = scanner.nextLine();
        System.out.print("Nhap gia ve: ");
        this.giaVe = Double.parseDouble(scanner.nextLine());
    }

    public void xuat() {
        System.out.println("--- thong tin tro choi ---");
        System.out.println("ten tro choi: " + this.tenGame);
        System.out.println("The loai: " + this.theLoai);
        System.out.println("Do kho: " + this.doKho);
        System.out.println("Do tuoi: " + this.doTuoiYeuCau);
        System.out.println("Gia ve: " + this.giaVe);
    }

    public String getTenGame() {
        return this.tenGame;
    }
    public double getGiaVe() {
        return this.giaVe;
    }
}
