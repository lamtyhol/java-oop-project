
import java.io.*;
import java.util.*;

class SinhVien {
    String ma, hoTen, sdt, email;

    SinhVien(String ma, String hoTen, String sdt, String email) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + sdt + " " + email;
    }
}

class DeTai {
    String ma, giangVien, tenDeTai;

    DeTai(String ma, String giangVien, String tenDeTai) {
        this.ma = ma;
        this.giangVien = giangVien;
        this.tenDeTai = tenDeTai;
    }
}

class NhiemVu {
    String maSV, maDeTai;

    NhiemVu(String maSV, String maDeTai) {
        this.maSV = maSV;
        this.maDeTai = maDeTai;
    }
}

public class b4 {
    public static void main(String[] args) throws Exception {
        Scanner scSV = new Scanner(new File("SINHVIEN.in"));
        Scanner scDT = new Scanner(new File("DETAI.in"));
        Scanner scNV = new Scanner(new File("NHIEMVU.in"));

        Map<String, SinhVien> sinhViens = new HashMap<>();
        Map<String, DeTai> deTais = new HashMap<>();

        int n = Integer.parseInt(scSV.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String ma = scSV.nextLine().trim();
            String hoTen = scSV.nextLine().trim();
            String sdt = scSV.nextLine().trim();
            String email = scSV.nextLine().trim();

            sinhViens.put(ma, new SinhVien(ma, hoTen, sdt, email));
        }

        int m = Integer.parseInt(scDT.nextLine().trim());

        for (int i = 1; i <= m; i++) {
            String giangVien = scDT.nextLine().trim();
            String tenDeTai = scDT.nextLine().trim();
            String ma = String.format("DT%03d", i);

            deTais.put(ma, new DeTai(ma, giangVien, tenDeTai));
        }

        int k = Integer.parseInt(scNV.nextLine().trim());
        List<NhiemVu> nhiemVus = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] a = scNV.nextLine().trim().split("\\s+");
            nhiemVus.add(new NhiemVu(a[0], a[1]));
        }

        nhiemVus.sort((a, b) -> {
            DeTai dt1 = deTais.get(a.maDeTai);
            DeTai dt2 = deTais.get(b.maDeTai);
            int cmp = dt1.tenDeTai.compareTo(dt2.tenDeTai);
            if (cmp != 0) return cmp;
            return a.maSV.compareTo(b.maSV);
        });

        for (NhiemVu nv : nhiemVus) {
            SinhVien sv = sinhViens.get(nv.maSV);
            DeTai dt = deTais.get(nv.maDeTai);

            if (sv != null && dt != null) {
                System.out.println(sv);
                System.out.println(dt.giangVien + " " + dt.tenDeTai);
            }
        }

        scSV.close();
        scDT.close();
        scNV.close();
    }
}
