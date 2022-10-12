package mon_java1.ASS_Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//  mã nhân viên bao gồm  AB. trong đó A là chữ cái đầu của chức vụ, B là 3 con số 
//  Ví dụ: TT562, TP135. TT là tiếp thị TP là Trưởng phòng
public class NhanVien implements SuaThongTinNhanVien {
    private String ten, maNV;
    private double luong;

    private static List<String> listMaNV = new ArrayList<>();

    public static final Scanner sc = new Scanner(System.in, "utf8");

    @Override
    public NhanVien suaThongTinNhanVien() {
        NhanVien nVien = new NhanVien();
        int chon, dem = 0;
        do {
            System.out.println("0. Trở về menu chính");
            System.out.println("1. Sửa mã nhân viên");
            System.out.println("2. Sửa tên nhân viên");
            System.out.println("3. Sửa Lương nhân viên");
            System.out.println("4. Sửa chức vụ(sửa loại nhân viên ví dụ hành chính thành tiếp thị hoặc trưởng phòng)");
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
                    int suaLoai;
                    do {
                        System.out.println("1. Hành chính -> Tiếp thị");
                        System.out.println("2. Hành chính -> Trưởng phòng");
                        System.out.println("0. Quay lại");
                        System.out.print("Mời chọn: ");
                        suaLoai = Integer.parseInt(sc.nextLine());
                        switch (suaLoai) {
                            case 0:
                                System.out.println("Bạn đã trở về mmenu chính");
                                break;
                            case 1:
                                nVien = NhanVien_Factory.getNhanVien(this, "TT");
                                dem++;
                                break;
                            case 2:
                                nVien = NhanVien_Factory.getNhanVien(this, "TP");
                                dem++;
                                break;
                            default:
                                System.out.println("vui lòng chọn 0->2!!! Chọn lại: ");
                                break;
                        }
                    } while (suaLoai != 0);
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

    public void nhap() {
        System.out.print("Nhập tên: ");
        while (!setTen(sc.nextLine()))
            ;
        System.out.print("Nhập mã nhân viên(mã nhân viên là duy nhất và đúng định dạng): ");
        while (!setMaNV(sc.nextLine()))
            ;
        System.out.print("Nhập lương: ");
        setLuong(Double.parseDouble(sc.nextLine()));
    }

    public static void tieuDe() {
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", "Tên", "Mã NV", "Lương", "Thu nhập", "Thuế TN",
                "Doanh số", "Hoa hồng", "Trách nhiệm");
    }

    public void xuat() {
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", getTen(), getMaNV(), getLuong(), getThuNhap(),
                getThueTN(), "", "", "");
    }

    public static void tieuDeHanhChinh() {
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|\n", "Tên", "Mã NV", "Lương", "Thu nhập", "Thuế TN");
    }

    public void xuatHanhChinh() {
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|\n", getTen(), getMaNV(), getLuong(), getThuNhap(),
                getThueTN());
    }

    public void suaID() {
        System.out.print("Nhập id mới: ");
        while (!setMaNV(sc.nextLine()))
            ;
    }

    public void suaTen() {
        System.out.print("Nhập tên mới: ");
        while (!setTen(sc.nextLine()))
            ;
    }

    public void sualuong() {
        System.out.print("Nhập lương mới: ");
        setLuong(Double.parseDouble(sc.nextLine()));
    }

    public double getThuNhap() {
        return getLuong();
    }

    public double getThueTN() {
        return getThuNhap() <= 9000 ? 0 : getThuNhap() <= 15000 ? getThuNhap() * 0.1 : getThuNhap() * 0.12;
    }

    public NhanVien() {
    }

    public NhanVien(String ten, String maNV, double luong) {
        this.ten = ten;
        this.maNV = maNV;
        this.luong = luong;
    }

    public String getLastName() {
        String[] lastName = getTen().split("\\s");
        return lastName[lastName.length - 1];
    }

    public String getTen() {
        return ten;
    }

    public boolean setTen(String ten) {
        if (ten.isEmpty()) {
            System.out.print("Tên không được để trống. Mời nhập lại: ");
            return false;
        } else {
            this.ten = ten.trim().replaceAll("\\s+", " ");
            return true;
        }
    }

    public String getMaNV() {
        return maNV;
    }

    public boolean setMaNV(String maNV) {
        if (!Pattern.matches("[HT][C|T|P][0-9]{3}", maNV)) {
            System.out.print("Mã nhân viên không đúng định dạng. Mời nhập lại: ");
            return false;
        }
        if (listMaNV.size() == 0) {
            this.maNV = maNV;
            listMaNV.add(maNV);
            return true;
        } else {
            boolean check = true;
            for (String i : listMaNV) {
                if (maNV.equals(i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                this.maNV = maNV;
                listMaNV.add(maNV);
                return true;
            } else {
                System.out.print("Mã nhân viên đã có mời nhập lại: ");
                return false;
            }
        }
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

}
