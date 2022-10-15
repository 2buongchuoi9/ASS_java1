package mon_java1.ASS_Test;

public class TiepThi extends NhanVien {
    private double doanhSo, hoaHong;

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập doanh số: ");
        setDoanhSo(Double.parseDouble(sc.nextLine()));

        System.out.print("Nhập phần trăm Hoa Hồng(Đơn vị % và <1 ví dụ 0.3): ");
        while (!setHoaHong(Double.parseDouble(sc.nextLine())))
            ;
    }

    @Override
    public NhanVien suaThongTinNhanVien() {
        NhanVien nVien = new NhanVien();
        int chon, dem = 0;
        do {
            System.out.println("\n0. Trở về menu chính");
            System.out.println("1. Sửa mã nhân viên");
            System.out.println("2. Sửa tên nhân viên");
            System.out.println("3. Sửa Lương nhân viên");
            System.out.println("4. Sửa doanh số");
            System.out.println("5. Sửa hoa hồng");
            System.out.println("6. Sửa chức vụ(sửa loại nhân viên ví dụ tiếp thị thành trưởng phòng)");
            System.out.print("Mời chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    System.out.println("Bạn đã trở về menu chính");
                    break;
                case 1:
                    suaID();
                    break;
                case 2:
                    suaTen();
                    break;
                case 3:
                    sualuong();
                    break;
                case 4:
                    suaDoanhSo();
                    break;
                case 5:
                    suaHoaHong();
                    break;
                case 6:
                    System.out.println("1. Tiếp thị -> Trưởng phòng");
                    System.out.println("2. Tiếp thị -> Hành chính");
                    System.out.println("0. Quay lại");
                    System.out.print("Mời chọn: ");
                    int suaLoai = Integer.parseInt(sc.nextLine());
                    switch (suaLoai) {
                        case 0:
                            System.out.println("Bạn đã trở về menu");
                            break;
                        case 1:
                            nVien = NhanVien_Factory.getNhanVien(this, "TP");
                            dem++;
                            break;
                        case 2:
                            nVien = NhanVien_Factory.getNhanVien(this, "HC");
                            dem++;
                            break;
                        default:
                            System.out.println("vui lòng chọn 0->2!!! Chọn lại: ");
                            break;
                    }
                    break;
                default:
                    System.out.println("Vui lòng chọn lại 0->5");
                    break;
            }
        } while (chon != 0);
        if (dem == 0)
            return this;
        return nVien;
    }

    public void nhapRiengTiepThi() {
        System.out.print("Nhập doanh số: ");
        setDoanhSo(Double.parseDouble(sc.nextLine()));

        System.out.print("Nhập phần trăm Hoa Hồng(Đơn vị % và <1 ví dụ 0.3): ");
        while (!setHoaHong(Double.parseDouble(sc.nextLine())))
            ;
    }

    public void xuat() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", getTen(), getMaNV(), getLuong(), getThuNhap(),
                getThueTN(), getDoanhSo(), getHoaHong(), "");
    }

    public static void tieuDeTiepThi() {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Tên", "Mã NV", "Lương", "Thu nhập", "Thuế TN",
        "Doanh số", "Hoa hồng");
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap() + getDoanhSo() * getHoaHong();
    }

    public void suaDoanhSo() {
        System.out.print("Nhập doanh số mới: ");
        setDoanhSo(Double.parseDouble(sc.nextLine()));
    }

    public void suaHoaHong() {
        System.out.print("Nhập phần trăm hoa hồng mới: ");
        while (!setHoaHong(Double.parseDouble(sc.nextLine())))
            ;
    }

    public TiepThi() {
    }

    public TiepThi(String ten, String maNV, double luong, double doanhSo, double hoaHong) {
        super(ten, maNV, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong / 100;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong / 100;
    }

    public boolean setHoaHong(double hoaHong) {
        if (hoaHong < 100) {
            this.hoaHong = hoaHong;
            return true;
        }
        System.out.print("Hoa hồng đơn vị phần trăm và phải nhỏ hơn 100. Mời nhập lại: ");
        return false;
    }
}
