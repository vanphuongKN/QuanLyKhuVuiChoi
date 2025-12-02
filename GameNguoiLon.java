// File: GameNguoiLon.java
package quanlykhuvuichoi;

import java.util.Scanner;

public class GameNguoiLon extends Game {
    private boolean coHuongDan;
    private String mucDoHapDan;

    public GameNguoiLon() {
        super();
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.println("--- Nhap thong tin tro choi nguoi lon---");
        super.nhap(scanner);
        System.out.print("co huong dan (true/false): ");
        this.coHuongDan = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Muc do (Cao/Trung bình/Thấp): ");
        this.mucDoHapDan = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("co huong dan: " + (this.coHuongDan ? "co" : "khong"));
        System.out.println("muc do: " + this.mucDoHapDan);
    }
}