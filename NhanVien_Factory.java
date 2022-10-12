package mon_java1.ASS_Test;

import java.util.Scanner;

public class NhanVien_Factory {
    static Scanner sc = new Scanner(System.in);

    /**
     * @param NhanVien i
     * @param loai     (HC, TT, TP)
     * @return NhanVien
     */
    public static NhanVien getNhanVien(NhanVien i, String loai) {
        if (loai.equals("TT")) {
            if (i instanceof TiepThi)
                return i;
            TiepThi tt = new TiepThi();
            tt.nhapRiengTiepThi();
            return new TiepThi(i.getTen(), i.getMaNV(), i.getLuong(), tt.getDoanhSo(), tt.getHoaHong());
        } else if (loai.equals("TP")) {
            if (i instanceof TruongPhong)
                return i;
            TruongPhong tp = new TruongPhong();
            tp.nhapRiengTruongPhong();
            return new TruongPhong(i.getTen(), i.getMaNV(), i.getLuong(), tp.getTrachNhiem());
        } else if (loai.equals("HC")) {
            return new NhanVien(i.getTen(), i.getMaNV(), i.getLuong());
        } else
            return i;
    }
}
