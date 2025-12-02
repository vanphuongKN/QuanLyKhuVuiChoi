// File: GameTreEm.java
package quanlykhuvuichoi;

import java.util.Scanner;

public class GameTreEm extends Game {
    private boolean coGiamSat;
    private int thoiGianChoi;

    public GameTreEm() {
        super();
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.println("--- Nhap thong tin tro choi tre em ---");
        super.nhap(scanner);
        System.out.print("co giam sat (true/false): ");
        this.coGiamSat = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("thoi gian choi: ");
        this.thoiGianChoi = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("co giam sat: " + (this.coGiamSat ? "Co" : "Khong"));
        System.out.println("thoi gian choi: " + this.thoiGianChoi + " phut");
    }
}
