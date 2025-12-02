
package quanlykhuvuichoi;

public interface IQuanLyGame {
    void them(Game game);
    void sua(String tenGameCu, Game thongTinMoi);
    void xoa(String tenGame);
    Game timKiemTheoTen(String tenGame);
    void hienThiDanhSach();
}