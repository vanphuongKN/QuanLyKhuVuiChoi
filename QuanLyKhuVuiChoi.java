// File: QuanLyKhuVuiChoi.java
package quanlykhuvuichoi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyKhuVuiChoi {
    private static Scanner scanner = new Scanner(System.in);
    private static IQuanLyGame quanLyGame = new QuanLyGameImpl();
    private static List<KhuVuc> danhSachKhuVuc = new ArrayList<>();
    private static List<LichChoi> danhSachLichChoi = new ArrayList<>();
    private static List<KhachHang> danhSachKhachHang = new ArrayList<>();
    private static List<NhanVien> danhSachNhanVien = new ArrayList<>();
    private static List<DatCho> danhSachDatCho = new ArrayList<>();

    public static void main(String[] args) {

        
        while (true) {
            System.out.println("\n========= HE THONG QUAN LY KHU VUI CHOI =========");
            System.out.println("1.Quan Ly tro choi");
            System.out.println("2.Quan Ly khu vuc");
            System.out.println("3.Quan Ly lich choi");
            System.out.println("4.Quan Ly khach hang");
            System.out.println("5.Quan Ly nhan vien");
            System.out.println("6.Dat ve va thanh toan");
            System.out.println("7.Thong ke danh thu");
            System.out.println("0.Thoat");
            System.out.print("Chon chuc nang: ");

            int luaChon;
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Hay nhap so");
                continue;
            }

            switch (luaChon) {
                case 1:
                    menuQuanLyGame();
                    break;
                case 2:
                    menuQuanLyKhuVuc();
                    break;
                case 3:
                    menuQuanLyLichChoi();
                    break;
                case 4:
                    menuQuanLyKhachHang();
                    break;
                case 5:
                    menuQuanLyNhanVien();
                    break;
                case 6:
                    menuDatVeVaThanhToan();
                    break;
                case 7:
                    thongKeDoanhThu();
                    break;
                case 0:
                    System.out.println("thanks");
                    return;
                default:
                    System.out.println("khong hop le");
            }
        }
    }



    private static void menuQuanLyGame() {
        while (true) {
            System.out.println("\n========= QUAN LY TRO CHOI =========");
            System.out.println("1.Them tro choi");
            System.out.println("2.Hien thi danh sach tro choi");
            System.out.println("3.Sua thong tin tro choi");
            System.out.println("4.xoa tro choi");
            System.out.println("5.Tim kiem tro choi");
            System.out.println("0.Quay lai");
            System.out.print("Chon: ");

            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    themGameMoi();
                    break;
                case 2:
                    quanLyGame.hienThiDanhSach();
                    break;
                case 3:
                    suaGame();
                    break;
                case 4:
                    xoaGame();
                    break;
                case 5:
                    timKiemGame();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("khong hop le");
            }
        }
    }

    private static void themGameMoi() {
        System.out.println("\n--- Them tro choi moi ---");
        System.out.println("tro choi (1: tro choi tre em, 2: tro choi nguoi lon): ");
        int loaiGame = Integer.parseInt(scanner.nextLine());
        
        Game gameMoi;
        if (loaiGame == 1) {
            gameMoi = new GameTreEm();
        } else {
            gameMoi = new GameNguoiLon();
        }
        
        gameMoi.nhap(scanner);
        quanLyGame.them(gameMoi);
    }

    private static void suaGame() {
        System.out.print("nhap ten ");
        String tenGameCu = scanner.nextLine();
        
        Game gameCu = quanLyGame.timKiemTheoTen(tenGameCu);
        if (gameCu == null) {
            System.out.println("khong tim thay");
            return;
        }

        System.out.println("chon loai tro choi (1: tro choi tre em, 2: tro choi nguoi lon): ");
        int loaiGameMoi = Integer.parseInt(scanner.nextLine());
        
        Game thongTinMoi;
        if (loaiGameMoi == 1) {
            thongTinMoi = new GameTreEm();
        } else {
            thongTinMoi = new GameNguoiLon();
        }
        
        thongTinMoi.nhap(scanner);
        quanLyGame.sua(tenGameCu, thongTinMoi);
    }

    private static void xoaGame() {
        System.out.print("nhap ten: ");
        String tenGame = scanner.nextLine();
        quanLyGame.xoa(tenGame);
    }

    private static void timKiemGame() {
        System.out.print("nhap ten: ");
        String tenGame = scanner.nextLine();
        Game game = quanLyGame.timKiemTheoTen(tenGame);
        if (game != null) {
            game.xuat();
        } else {
            System.out.println("khong tim thay!");
        }
    }

    private static void menuQuanLyKhuVuc() {
        while (true) {
            System.out.println("\n========= QUAN LY KHU VUC =========");
            System.out.println("1. Them khu vuc");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Xem chi tiet");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");

            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    themKhuVuc();
                    break;
                case 2:
                    hienThiDanhSachKhuVuc();
                    break;
                case 3:
                    xemChiTietKhuVuc();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("kh hop le");
            }
        }
    }

    private static void themKhuVuc() {
        KhuVuc khuVucMoi = new KhuVuc();
        khuVucMoi.nhap(scanner);
        danhSachKhuVuc.add(khuVucMoi);
        System.out.println("Da them!");
    }

    private static void hienThiDanhSachKhuVuc() {
        if (danhSachKhuVuc.isEmpty()) {
            System.out.println("danh sach trong");
            return;
        }
        
        System.out.println("\n--- DANH SACH KHU VUC ---");
        for (int i = 0; i < danhSachKhuVuc.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachKhuVuc.get(i).getMaKhuVuc() + " - " + 
                             danhSachKhuVuc.get(i).getTenKhuVuc() + " - " + 
                             danhSachKhuVuc.get(i).getSucChua() + " tram");
        }
    }

    private static void xemChiTietKhuVuc() {
        hienThiDanhSachKhuVuc();
        if (danhSachKhuVuc.isEmpty()) return;
        
        System.out.print("chon so thuc tu khu vuc: ");
        int stt = Integer.parseInt(scanner.nextLine()) - 1;
        if (stt >= 0 && stt < danhSachKhuVuc.size()) {
            danhSachKhuVuc.get(stt).xuat();
        } else {
            System.out.println("kh co so nay");
        }
    }

    private static void menuQuanLyLichChoi() {
        while (true) {
            System.out.println("\n========= QUAN LY LICH CHOI =========");
            System.out.println("1. Tao lich choi");
            System.out.println("2. hien thi danh sach");
            System.out.println("3. Xem chi tiet");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");

            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    taoLichChoiMoi();
                    break;
                case 2:
                    hienThiDanhSachLichChoi();
                    break;
                case 3:
                    xemChiTietLichChoi();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("khong co!");
            }
        }
    }

    private static void taoLichChoiMoi() {
        System.out.println("\n---Tao lich choi ---");
        
        // Chọn trò chơi
        quanLyGame.hienThiDanhSach();
        System.out.print("nhap ten tro choi: ");
        String tenGame = scanner.nextLine();
        Game game = quanLyGame.timKiemTheoTen(tenGame);
        if (game == null) {
            System.out.println("khong tim thay");
            return;
        }

        // Chọn khu vực
        hienThiDanhSachKhuVuc();
        if (danhSachKhuVuc.isEmpty()) return;
        
        System.out.print("chon khu vuc: ");
        int sttKhuVuc = Integer.parseInt(scanner.nextLine()) - 1;
        if (sttKhuVuc < 0 || sttKhuVuc >= danhSachKhuVuc.size()) {
            System.out.println("khong co!");
            return;
        }
        KhuVuc khuVuc = danhSachKhuVuc.get(sttKhuVuc);

        // Tạo lịch chơi
        LichChoi lichChoi = new LichChoi(game, khuVuc, LocalDateTime.now());
        lichChoi.nhap(scanner);
        danhSachLichChoi.add(lichChoi);
        System.out.println("Da tao!");
    }

    private static void hienThiDanhSachLichChoi() {
        if (danhSachLichChoi.isEmpty()) {
            System.out.println("danh sach rong!");
            return;
        }
        
        System.out.println("\n--- DANH SACH LICH CHOI ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (int i = 0; i < danhSachLichChoi.size(); i++) {
            LichChoi lc = danhSachLichChoi.get(i);
            System.out.println((i + 1) + ". " + lc.getGame().getTenGame() + " - " + 
                             lc.getKhuVuc().getTenKhuVuc() + " - " + 
                             lc.getThoiGianChoi().format(formatter));
        }
    }

    private static void xemChiTietLichChoi() {
        hienThiDanhSachLichChoi();
        if (danhSachLichChoi.isEmpty()) return;
        
        System.out.print("chon sso thu tu lich choi: ");
        int stt = Integer.parseInt(scanner.nextLine()) - 1;
        if (stt >= 0 && stt < danhSachLichChoi.size()) {
            danhSachLichChoi.get(stt).xuat();
        } else {
            System.out.println("khong hop le!");
        }
    }

    private static void menuQuanLyKhachHang() {
        while (true) {
            System.out.println("\n========= QUAN LY KHACH HANG =========");
            System.out.println("1.them khach hang");
            System.out.println("2.hien thi danh sach");
            System.out.println("3.tim kiem");
            System.out.println("4. xem lich su dat cho"); 
            System.out.println("0.quay lai");
            System.out.print("Chon: ");

            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    themKhachHang();
                    break;
                case 2:
                    hienThiDanhSachKhachHang();
                    break;
                case 3:
                    timKiemKhachHang();
                    break;
                     case 4:
                xemLichSuDatChoKhachHang();
                break;
                case 0:
                    return;
                default:
                    System.out.println("khong hop le!");
            }
        }
    }
    private static void xemLichSuDatChoKhachHang() {
    hienThiDanhSachKhachHang();
    if (danhSachKhachHang.isEmpty()) return;
    
    System.out.print("chon so thu tu khach hang: ");
    int stt = Integer.parseInt(scanner.nextLine()) - 1;
    if (stt >= 0 && stt < danhSachKhachHang.size()) {
        danhSachKhachHang.get(stt).xemLichSuDatCho();
    } else {
        System.out.println("khong hop le!");
    }
    }

    private static void themKhachHang() {
        KhachHang khachHangMoi = new KhachHang();
        khachHangMoi.nhap(scanner);
        danhSachKhachHang.add(khachHangMoi);
        System.out.println("da them!");
    }

    private static void hienThiDanhSachKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("danh sach trong");
            return;
        }
        
        System.out.println("\n--- DANH SACH KHACH HANG ---");
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachKhachHang.get(i).getTen() + " - " + 
                             danhSachKhachHang.get(i).getsoDienThoai());
        }
    }
    

    private static void timKiemKhachHang() {
        System.out.print("nhap ten hoac so dien thoai: ");
        String tuKhoa = scanner.nextLine();
        
        boolean timThay = false;
        for (KhachHang khach : danhSachKhachHang) {
            if (khach.getTen().toLowerCase().contains(tuKhoa.toLowerCase()) || 
                khach.getsoDienThoai().contains(tuKhoa)) {
                khach.xuat();
                timThay = true;
            }
        }
        
        if (!timThay) {
            System.out.println("khong tim thay");
        }
    }

    private static void menuQuanLyNhanVien() {
        while (true) {
            System.out.println("\n========= QUAN LY NHAN VIEN =========");
            System.out.println("1.them nhan vien");
            System.out.println("2.hien thi danh sach");
            System.out.println("0.quay lai");
            System.out.print("chon: ");

            int luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    themNhanVien();
                    break;
                case 2:
                    hienThiDanhSachNhanVien();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("khong hop le!");
            }
        }
    }

    private static void themNhanVien() {
        NhanVien nhanVienMoi = new NhanVien();
        nhanVienMoi.nhap(scanner);
        danhSachNhanVien.add(nhanVienMoi);
        System.out.println("da them");
    }

    private static void hienThiDanhSachNhanVien() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("danh sach trong");
            return;
        }
        
        System.out.println("\n--- DANH SACH NHAN VIEN ---");
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachNhanVien.get(i).getTen() + " - " + 
                             danhSachNhanVien.get(i).getChucVu());
        }
    }

    private static void menuDatVeVaThanhToan() {
        System.out.println("\n--- DAT VE VA THANH TOAN ---");
        
        // Chọn khách hàng
        hienThiDanhSachKhachHang();
        if (danhSachKhachHang.isEmpty()) return;
        
        System.out.print("ma khach hang: ");
        int sttKhach = Integer.parseInt(scanner.nextLine()) - 1;
        if (sttKhach < 0 || sttKhach >= danhSachKhachHang.size()) {
            System.out.println("kh hop le");
            return;
        }
        KhachHang khachHang = danhSachKhachHang.get(sttKhach);

        // Chọn lịch chơi
        hienThiDanhSachLichChoi();
        if (danhSachLichChoi.isEmpty()) return;
        
        System.out.print("chon so thu tu lich choi ");
        int sttLichChoi = Integer.parseInt(scanner.nextLine()) - 1;
        if (sttLichChoi < 0 || sttLichChoi >= danhSachLichChoi.size()) {
            System.out.println("khong hop le");
            return;
        }
        LichChoi lichChoi = danhSachLichChoi.get(sttLichChoi);

        // Chọn trạm
        KhuVuc khuVuc = lichChoi.getKhuVuc();
        System.out.println("\n--- DANH SACH TRAM KHU VUC" + khuVuc.getTenKhuVuc() + " ---");
        khuVuc.inSoDoTram();

        System.out.print("Chon ma tram (vi du: KV01-T1): ");
        String maTram = scanner.nextLine();

        TramChoi tramChon = khuVuc.timTramTheoMa(maTram);
        if (tramChon == null) {
            System.out.println("khong hop le");
            return;
        }

        if (tramChon.getTrangThai()) {
            System.out.println("tram da dat hay chon tram khac.");
            return;
        }

        // Tạo đặt chỗ
        DatCho datCho = new DatCho(khachHang, lichChoi);
        datCho.nhap(scanner);

        // Tạo vé
        VeChoi ve = new VeChoi(
            "V" + System.currentTimeMillis(),
            lichChoi.getGiaVe(),
            tramChon,
            lichChoi,
            khachHang,
            datCho
        );

        // Thêm vào danh sách
        datCho.themVe(ve);
        lichChoi.themVe(ve);
        danhSachDatCho.add(datCho);

        // Đặt trạm
        lichChoi.datTram(maTram);

        // Thanh toán
        thucHienThanhToan(datCho, datCho.getTongTien());

        // Xuất vé
        System.out.println("\n--- THONG TIN VE DAT ---");
        ve.inVe();
    }

    private static void thucHienThanhToan(DatCho datCho, double soTien) {
        System.out.println("\n--- PHUONG THUC THANH TOAN ---");
        System.out.println("1. THE");
        System.out.println("2. Vi dien tu");
        System.out.print("Chon phuong thuc khac: ");
        
        int luaChon = Integer.parseInt(scanner.nextLine());
        Payment phuongThuc;
        
        switch (luaChon) {
            case 1:
                System.out.print("nhap so the ");
                String soThe = scanner.nextLine();
                System.out.print("nhap ngay het han (MM/YY): ");
                String ngayHetHan = scanner.nextLine();
                phuongThuc = new CardPlayment(soThe, ngayHetHan);
                break;
            case 2:
                System.out.print("nhap ID vi dien tu: ");
                String maVi = scanner.nextLine();
                phuongThuc = new EWalletPayment(maVi);
                break;
            default:
                System.out.println("phuong thuc khong hop le!");
                return;
        }
        
        datCho.thucHienThanhToan(phuongThuc);
    }

    private static void thongKeDoanhThu() {
        System.out.println("\n--- THONG KE DANH THU ---");
        
        double tongDoanhThu = 0;
        int soVeDaBan = 0;
        
        for (DatCho datCho : danhSachDatCho) {
            if (datCho.isDaThanhToan()) {
                tongDoanhThu += datCho.getTongTien();
                soVeDaBan += datCho.getDanhSachVe().size();
            }
        }
        
        System.out.println("tong so ve da ban: " + soVeDaBan);
        System.out.println("tong danh thu: " + tongDoanhThu);
        System.out.println("danh thu trung binh moi ve: " + (soVeDaBan > 0 ? tongDoanhThu / soVeDaBan : 0));
        
        // Thống kê theo trò chơi
        System.out.println("\n--- DANH THU TRO CHOI ---");
        for (Game game : ((QuanLyGameImpl) quanLyGame).danhSachGame) {
            double doanhThuGame = 0;
            for (LichChoi lichChoi : danhSachLichChoi) {
                if (lichChoi.getGame() != null && lichChoi.getGame().getTenGame().equals(game.getTenGame())) {
                    doanhThuGame += lichChoi.tinhDoanhThu();
                }
            }
            System.out.println(game.getTenGame() + ": " + doanhThuGame);
        }
    }
}