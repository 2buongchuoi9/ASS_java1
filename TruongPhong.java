package mon_java1.ASS_Test;

public class TruongPhong extends NhanVien {
    private double trachNhiem;

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập lương trách nhiệm: ");
        setTrachNhiem(Double.parseDouble(sc.nextLine()));
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
            System.out.println("4. Sửa Lương trách nhiệm");
            System.out.println("5. Sửa chức vụ(sửa loại nhân viên ví dụ trưởng phòng thành tiếp thị)");
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
                    suaTrachNhiem();
                    break;
                case 5:
                    System.out.println("1. Trưởng phòng -> Tiếp thị");
                    System.out.println("2.  Trưởng phòng -> Hành chính");
                    System.out.println("0. Quay lại");
                    System.out.print("Mời chọn: ");
                    int suaLoai = Integer.parseInt(sc.nextLine());
                    switch (suaLoai) {
                        case 0:
                            System.out.println("bạn đã trở lại menu");
                            break;
                        case 1:
                            nVien = NhanVien_Factory.getNhanVien(this, "TT");
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
                    System.out.println("Vui lòng chọn lại 0->4");
                    break;
            }
        } while (chon != 0);
        if (dem == 0)
            return this;
        return nVien;
    }

    public void nhapRiengTruongPhong() {
        System.out.print("Nhập lương trách nhiệm: ");
        setTrachNhiem(Double.parseDouble(sc.nextLine()));
    }

    public void xuat() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", getTen(), getMaNV(), getLuong(), getThuNhap(),
        getThueTN(), "", "", getTrachNhiem());
    }

    public void xuatTruongPhong() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", getTen(), getMaNV(), getLuong(), getThuNhap(),
                getThueTN(), getTrachNhiem());
    }

    public static void tieuDeTruongPhong() {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Tên", "Mã NV", "Lương", "Thu nhập", "Thuế TN",
                "Trách nhiệm");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap() + getTrachNhiem();
    }

    public void suaTrachNhiem() {
        System.out.print("Nhập lương trách nhiệm mới: ");
        setTrachNhiem(Double.parseDouble(sc.nextLine()));
    }

    public TruongPhong() {
    }

    public TruongPhong(String ten, String maNV, double luong, double trachNhiem) {
        super(ten, maNV, luong);
        this.trachNhiem = trachNhiem;
    }

    public double getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem(double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }

}
