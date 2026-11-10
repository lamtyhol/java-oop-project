import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Bai03 {

    private static class SinhVien {
        String ma;
        String hoTen;
        String lop;
        String email;

        SinhVien(String ma, String hoTen, String lop, String email) {
            this.ma = ma;
            this.hoTen = chuanHoaHoTen(hoTen);
            this.lop = lop;
            this.email = email;
        }
    }

    private static class MonHoc {
        String ma;
        String ten;
        int soTinChi;

        MonHoc(String ma, String ten, int soTinChi) {
            this.ma = ma;
            this.ten = ten;
            this.soTinChi = soTinChi;
        }
    }

    private static class BangDiem {
        SinhVien sinhVien;
        MonHoc monHoc;
        String diem;

        BangDiem(SinhVien sinhVien, MonHoc monHoc, String diem) {
            this.sinhVien = sinhVien;
            this.monHoc = monHoc;
            this.diem = diem;
        }
    }

    private static String readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new EOFException("Du lieu dau vao khong du.");
        }
        return line.trim();
    }

    private static String chuanHoaHoTen(String hoTen) {
        String[] tu = hoTen.trim().toLowerCase(Locale.ROOT).split("\\s+");
        StringBuilder ketQua = new StringBuilder();
        for (String motTu : tu) {
            if (ketQua.length() > 0) {
                ketQua.append(' ');
            }
            ketQua.append(Character.toUpperCase(motTu.charAt(0)));
            ketQua.append(motTu.substring(1));
        }
        return ketQua.toString();
    }

    private static Map<String, SinhVien> docSinhVien() throws IOException {
        Map<String, SinhVien> sinhVienTheoMa = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("SINHVIEN.in"), StandardCharsets.UTF_8)) {
            int soSinhVien = Integer.parseInt(readLine(reader));
            for (int i = 0; i < soSinhVien; i++) {
                String ma = readLine(reader);
                String hoTen = readLine(reader);
                String lop = readLine(reader);
                String email = readLine(reader);
                sinhVienTheoMa.put(ma, new SinhVien(ma, hoTen, lop, email));
            }
        }
        return sinhVienTheoMa;
    }

    private static Map<String, MonHoc> docMonHoc() throws IOException {
        Map<String, MonHoc> monHocTheoMa = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("MONHOC.in"), StandardCharsets.UTF_8)) {
            int soMon = Integer.parseInt(readLine(reader));
            for (int i = 0; i < soMon; i++) {
                String ma = readLine(reader);
                String ten = readLine(reader);
                int soTinChi = Integer.parseInt(readLine(reader));
                monHocTheoMa.put(ma, new MonHoc(ma, ten, soTinChi));
            }
        }
        return monHocTheoMa;
    }

    private static List<BangDiem> docBangDiem(
            Map<String, SinhVien> sinhVienTheoMa,
            Map<String, MonHoc> monHocTheoMa,
            List<String> cacLop) throws IOException {
        List<BangDiem> bangDiem = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("BANGDIEM.in"), StandardCharsets.UTF_8)) {
            int soDong = Integer.parseInt(readLine(reader));
            for (int i = 0; i < soDong; i++) {
                String[] thongTin = readLine(reader).split("\\s+");
                if (thongTin.length != 3) {
                    throw new IOException("Moi dong bang diem phai co 3 thong tin.");
                }
                SinhVien sinhVien = sinhVienTheoMa.get(thongTin[0]);
                MonHoc monHoc = monHocTheoMa.get(thongTin[1]);
                if (sinhVien == null || monHoc == null) {
                    throw new IOException("Ma sinh vien hoac ma mon khong ton tai.");
                }
                bangDiem.add(new BangDiem(sinhVien, monHoc, thongTin[2]));
            }

            int soLop = Integer.parseInt(readLine(reader));
            for (int i = 0; i < soLop; i++) {
                cacLop.add(readLine(reader));
            }
        }
        return bangDiem;
    }

    public static void main(String[] args) throws IOException {
        Map<String, SinhVien> sinhVienTheoMa = docSinhVien();
        Map<String, MonHoc> monHocTheoMa = docMonHoc();
        List<String> cacLop = new ArrayList<>();
        List<BangDiem> bangDiem = docBangDiem(sinhVienTheoMa, monHocTheoMa, cacLop);

        bangDiem.sort(Comparator
                .comparing((BangDiem bd) -> bd.monHoc.ma)
                .thenComparing(bd -> bd.sinhVien.ma));

        StringBuilder output = new StringBuilder();
        for (String lop : cacLop) {
            output.append("BANG DIEM lop ").append(lop).append(":\n");
            for (BangDiem bd : bangDiem) {
                if (bd.sinhVien.lop.equals(lop)) {
                    output.append(bd.sinhVien.ma).append(' ')
                          .append(bd.sinhVien.hoTen).append(' ')
                          .append(bd.monHoc.ma).append(' ')
                          .append(bd.monHoc.ten).append(' ')
                          .append(bd.diem).append('\n');
                }
            }
        }
        System.out.print(output);
    }
}