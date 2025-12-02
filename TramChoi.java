// File: TramChoi.java
package quanlykhuvuichoi;

import java.util.Scanner;

public class TramChoi {
    private String maTram;
    private String tenTram;
    private boolean trangThai;
    private Game game;

    public TramChoi() {
        this.trangThai = false;
    }

    public TramChoi(String maTram, String tenTram) {
        this.maTram = maTram;
        this.tenTram = tenTram;
        this.trangThai = false;
    }

    public void nhap(Scanner scanner) {
        System.out.print("Nhap ma tram: ");
        this.maTram = scanner.nextLine();
        System.out.print("Nhap ten tram: ");
        this.tenTram = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("Tram [" + this.maTram + " - " + this.tenTram + 
                          "] - Trang thai: " + (this.trangThai ? "da dat" : "con trong"));
        if (game != null) {
            System.out.println("   tro choi: " + game.getTenGame());
        }
    }
    
    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getMaTram() {
        return this.maTram;
    }
    
    public String getTenTram() {
        return this.tenTram;
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
}