// File: QuanLyGameImpl.java
package quanlykhuvuichoi;

import java.util.ArrayList;
import java.util.List;

public class QuanLyGameImpl implements IQuanLyGame {
    public List<Game> danhSachGame;

    public QuanLyGameImpl() {
        this.danhSachGame = new ArrayList<>();
    }

    @Override
    public void them(Game game) {
        if (timKiemTheoTen(game.getTenGame()) != null) {
            System.out.println("tro choi  '" + game.getTenGame() + "' da ton tai");
            return;
        }
        this.danhSachGame.add(game);
        System.out.println("da them '" + game.getTenGame() + "' thanh cong");
    }

    @Override
    public void sua(String tenGameCu, Game thongTinMoi) {
        Game gameCanSua = timKiemTheoTen(tenGameCu);
        
        if (gameCanSua != null) {
            Game gameTrung = timKiemTheoTen(thongTinMoi.getTenGame());
            if (gameTrung != null && !gameTrung.getTenGame().equalsIgnoreCase(tenGameCu)) {
                System.out.println("ten tro choi '" + thongTinMoi.getTenGame() + "' da ton tai!");
                return;
            }
            
            gameCanSua.tenGame = thongTinMoi.getTenGame();
            gameCanSua.theLoai = thongTinMoi.theLoai;
            gameCanSua.doKho = thongTinMoi.doKho;
            gameCanSua.doTuoiYeuCau = thongTinMoi.doTuoiYeuCau;
            gameCanSua.giaVe = thongTinMoi.giaVe;
            
            System.out.println("Da cap nhap tro choi '" + tenGameCu + "' thanh cong");
        } else {
            System.out.println("khong tim thay'" + tenGameCu + "'.");
        }
    }

    @Override
    public void xoa(String tenGame) {
        Game gameCanXoa = timKiemTheoTen(tenGame);
        
        if (gameCanXoa != null) {
            this.danhSachGame.remove(gameCanXoa);
            System.out.println("da xoa tro choi'" + tenGame + "' thanh cong");
        } else {
            System.out.println("khongf tim thay '" + tenGame + "'.");
        }
    }

    @Override
    public Game timKiemTheoTen(String tenGame) {
        return danhSachGame.stream()
                .filter(game -> game.getTenGame().equalsIgnoreCase(tenGame))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSachGame.isEmpty()) {
            System.out.println("danh sach trong");
            return;
        }
        
        System.out.println("\n--- DANH SACH TRO CHOI (" + danhSachGame.size() + " TRO CHOI) ---");
        for (int i = 0; i < danhSachGame.size(); i++) {
            System.out.println("\ntro choi " + (i + 1) + ":");
            danhSachGame.get(i).xuat();
        }
    }

    public List<Game> getDanhSachGame() {
        return new ArrayList<>(danhSachGame);
    }
}