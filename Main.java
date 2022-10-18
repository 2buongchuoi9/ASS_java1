package mon_java1.ASS_Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static List<NhanVien> listNV = new ArrayList<>();

    public static void main(String[] args) {
        listNV.add(new NhanVien("Tuấn Vũ", "HC005", 8000));
        listNV.add(new TiepThi("Quốc Dũng", "TT008", 10000, 50000, 10));
        // listNV.add(new NhanVien("Xuân Hải", "HC004", 5000));
        listNV.add(new TiepThi("Xuân Hưng", "TT003", 9000, 50000, 30));
        listNV.add(new TruongPhong("Thanh Tùng", "TP080", 10000, 6000));
        listNV.add(new NhanVien("Quốc Diện", "HC002", 6000));
        listNV.add(new TruongPhong("Thành Tôn", "TP000", 20000, 900));
        listNV.add(new NhanVien("Khánh Hoàng", "HC001", 9960));
        int choose;
        do {
            menu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 0:
                    System.out.println("Bạn đã thoát chương trình!");
                    break;
                case 1:
                    nhapDuLieu();
                    break;
                case 2:
                    xuatDuLieu();
                    cho();
                    break;
                case 3:
                    timNVTheoID();
                    break;
                case 4:
                    xoaTheoID();
                    break;
                case 5:
                    suaTheoID();
                    cho();
                    break;
                case 6:
                    timTheoLuong();
                    break;
                case 7:
                    sapXepTheoTen();
                    cho();
                    break;
                case 8:
                    sapXepTheoThuNhap();
                    cho();
                    break;
                case 9:
                    top5ThuNhap();
                    cho();
                    break;
                default:
                    break;
            }
        } while (choose != 0);
    }

    static void menu() {
        System.out.println();
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                      MAIN MENU");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-45s%-45s%-45s\n", "1. Nhập thông tin nhân viên", "4. Xóa nhân viên theo mã nhân viên",
                "7. Sắp xếp nhân viên theo A->Z");
        System.out.printf("%-45s%-45s%-45s\n", "2. xuất thông tin nhân viên", "5. Cập nhật thông tin nhân viên theo mã",
                "8. Sắp xếp nhân viên theo thu nhập");
        System.out.printf("%-45s%-45s%-45s\n", "3. Tìm nhân viên theo mã nhân viên",
                "6. Tìm nhân viên theo khoảng lương",
                "9. Top 5 nhân viên có thu nhập cao nhất");
        System.out.printf("%-45s\n", "0. Thoát");
        System.out.print("\nChọn chức năng: ");
    }

    private static void cho() {
        System.out.print("Press \"ENTER\" to continue...");
        sc.nextLine();
    }

    private static void top5ThuNhap() {
        listNV.sort((o1, o2) -> Double.compare(o1.getThuNhap(), o2.getThuNhap()));
        System.out.println("Top 5 nhân viên có thu nhập cao nhất là: ");
        NhanVien.tieuDe();
        if (listNV.size() < 6) {
            listNV.forEach(i -> i.xuat());
            System.out.println("TỔNG DANH SÁCH NHÂN VIÊN CHỈ CÓ " + listNV.size());
        } else
            for (int i = listNV.size() - 5; i < listNV.size(); i++) {
                listNV.get(i).xuat();
            }
    }

    private static void sapXepTheoThuNhap() {
        listNV.sort((o1, o2) -> Double.compare(o1.getThuNhap(), o2.getThuNhap()));
        System.out.println("Danh sách nhân viên sau khi sắp xếp theo thu nhập tăng dần: ");
        NhanVien.tieuDe();
        listNV.forEach(i -> i.xuat());
    }

    private static void sapXepTheoTen() {
        listNV.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        System.out.println("Danh sách nhân viên sau sắp xếp theo tên(Tên khác với họ và tên): ");
        NhanVien.tieuDe();
        listNV.forEach(i -> i.xuat());
    }

    private static void timTheoLuong() {
        do {
            System.out.print("Nhập khoảng lương thấp nhất muốn tìm: ");
            double minLuong = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập khoảng lương lớn nhất muốn tìm: ");
            double maxLuong = Double.parseDouble(sc.nextLine());
            int dem = 0;
            for (NhanVien i : listNV) {
                if (minLuong <= i.getLuong() && maxLuong >= i.getLuong()) {
                    if (dem == 0) {
                        NhanVien.tieuDe();
                        dem++;
                    }
                    i.xuat();
                }
            }
            if (dem == 0)
                System.out.println("Không tìm thấy nhân viên nào có khoảng lương " + minLuong + "->" + maxLuong);
            System.out.print("Bạn có muốn tìm tiếp(Y/N): ");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
    }

    private static void xuatDuLieu() {
        // Mặc định sắp xếp ưu tiên: tên->Lương theo hướng giảm dần
        listNV.sort(Comparator.comparing(i -> ((NhanVien) i).getLastName())
                .thenComparingDouble(i -> ((NhanVien) i).getThuNhap()));
        int dem = 0, tong = 0, chon;
        do {
            System.out.println("1. Xuất thông tin theo chức vụ");
            System.out.println("2. Xuất toàn bộ thông tin nhân viên");
            System.out.print("Mời chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            if (chon == 1) {
                for (int i = 0; i < listNV.size(); i++) {
                    if (!(listNV.get(i) instanceof TruongPhong) && !(listNV.get(i) instanceof TiepThi)) {
                        if (dem == 0) {
                            System.out.printf("%40s\n", "NHÂN VIÊN HÀNH CHÍNH");
                            NhanVien.tieuDeHanhChinh();
                            dem++;
                        }
                        listNV.get(i).xuat();
                        tong++;
                    }
                }
                System.out.printf("\n%90s\n", "TỔNG: " + tong + " nhân viên hành chính(đơn vị ngìn vnd)");
                // System.out.println("\t\tTỔNG: " + tong + " nhân viên hành chính\n");
                tong = 0;
                dem = 0;
                for (int i = 0; i < listNV.size(); i++) {
                    if (listNV.get(i) instanceof TiepThi) {
                        if (dem == 0) {
                            System.out.printf("%35s\n", "NHÂN VIÊN TIẾP THỊ");
                            TiepThi.tieuDeTiepThi();
                            dem++;
                        }
                        ((TiepThi) listNV.get(i)).xuat();
                        tong++;
                    }
                }
                System.out.printf("\n%90s\n", "TỔNG: " + tong + " nhân viên tiếp thị(đơn vị ngìn vnd)");
                dem = 0;
                tong = 0;
                for (int i = 0; i < listNV.size(); i++) {
                    if (listNV.get(i) instanceof TruongPhong) {
                        if (dem == 0) {
                            System.out.printf("%30s\n", "NHÂN VIÊN TRƯỞNG PHÒNG");
                            TruongPhong.tieuDeTruongPhong();
                            dem++;
                        }
                        ((TruongPhong) listNV.get(i)).xuatTruongPhong();
                        tong++;
                    }
                }
                System.out.printf("\n%90s\n", "TỔNG: " + tong + " nhân viên trưởng phòng(đơn vị ngìn vnd)");
                tong = 0;
                dem = 0;
            } else if (chon == 2) {
                for (NhanVien i : listNV) {
                    if (listNV.isEmpty())
                        System.out.println("Danh sách nhân viên trống");
                    else {
                        if (dem == 0) {
                            NhanVien.tieuDe();
                            dem++;
                        }
                        i.xuat();
                        tong++;
                    }
                }
                System.out.printf("\n%90s\n", "TỔNG: " + tong + " nhân viên(đơn vị ngìn vnd)");
            } else {
                System.out.print("Vui lòng chọn 1 hoặc 2!!! chọn lại: ");
            }
        } while (chon != 1 && chon != 2);
    }

    private static void suaTheoID() {
        System.out.print("Nhập id nhân viên cần cập nhật thông tin: ");
        String suaID = sc.nextLine();
        for (int i = 0; i < listNV.size(); i++) {
            if (suaID.equals(listNV.get(i).getMaNV())) {
                System.out.println("Bạn đang sửa thông tin cho nhân viên bên dưới: ");
                NhanVien.tieuDe();
                listNV.get(i).xuat();
                listNV.add(listNV.get(i).suaThongTinNhanVien());
                listNV.remove(listNV.get(i));
                break;
            }
        }
    }

    private static void xoaTheoID() {
        do {
            int dem = 0;
            System.out.print("Nhập id nhân viên muốn xóa: ");
            String xoaID = sc.nextLine();
            for (NhanVien i : listNV) {
                if (xoaID.equals(i.getMaNV())) {
                    listNV.remove(i);
                    System.out.println("Đã xóa nhân viên bên dưới: ");
                    NhanVien.tieuDe();
                    i.xuat();
                    dem++;
                    break;
                }
            }
            if (dem == 0)
                System.out.println("Không tìm thấy id nhân viên cần xóa");
            System.out.print("Bạn có muốn xóa nhân viên tiếp không(Y/N): ");
        } while (sc.nextLine().equalsIgnoreCase("y"));
    }

    private static void timNVTheoID() {
        do {
            int dem = 0;
            System.out.print("Nhập id muốn tìm: ");
            String timId = sc.nextLine();
            for (NhanVien i : listNV) {
                if (timId.equals(i.getMaNV())) {
                    NhanVien.tieuDe();
                    i.xuat();
                    dem++;
                    break;
                }
            }
            if (dem == 0)
                System.out.println("Không tìm thấy id nhân viên");
            System.out.print("Bạn có muốn tìm tiếp không(Y/N): ");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
    }

    private static void nhapDuLieu() {
        System.out.print("Nhập Số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập nhân viên thứ " + (i + 1));
            NhanVien nv = loaiNV();
            nv.nhap();
            listNV.add(nv);
        }
    }

    private static NhanVien loaiNV() {
        int loai;
        do {
            System.out.print("chọn loại nhân viên(1/Hành chính.2/Tiếp thị.3/Trưởng phòng): ");
            loai = Integer.parseInt(sc.nextLine());
            if (loai == 1 || loai == 2 || loai == 3)
                break;
            else
                System.out.print("Vui lòng chọn 1->3: Chọn lại: ");

        } while (loai != 1 || loai != 2 || loai != 3);
        return loai == 1 ? new NhanVien() : loai == 2 ? new TiepThi() : new TruongPhong();
    }
}
