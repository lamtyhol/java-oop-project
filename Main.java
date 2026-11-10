import java.io.*;
import java.util.*;

class MonHoc {
    private String ma, ten, hinhThuc;

    public MonHoc(String ma, String ten, String hinhThuc) {
        this.ma = ma;
        this.ten = ten;
        this.hinhThuc = hinhThuc;
    }

    public String getMa() { return ma; }
    public String getTen() { return ten; }
    public String getHinhThuc() { return hinhThuc; }
}

class CaThi {
    private String ma, ngay, gio, phong;

    public CaThi(int stt, String ngay, String gio, String phong) {
        this.ma = String.format("C%03d", stt);
        this.ngay = ngay;
        this.gio = gio;
        this.phong = phong;
    }

    public String getMa() { return ma; }
    public String getNgay() { return ngay; }
    public String getGio() { return gio; }
    public String getPhong() { return phong; }

    // yyyyMMddHH:mm để so sánh theo thời gian
    public String getThoiGian() {
        String[] d = ngay.split("/");
        return d[2] + d[1] + d[0] + gio;
    }
}

class LichThi implements Comparable<LichThi> {
    private CaThi ca;
    private MonHoc mon;
    private String nhom, soSV;

    public LichThi(CaThi ca, MonHoc mon, String nhom, String soSV) {
        this.ca = ca;
        this.mon = mon;
        this.nhom = nhom;
        this.soSV = soSV;
    }

    @Override
    public int compareTo(LichThi o) {
        int c = this.ca.getThoiGian().compareTo(o.ca.getThoiGian());
        if (c != 0) return c;
        return this.ca.getMa().compareTo(o.ca.getMa());
    }

    @Override
    public String toString() {
        return ca.getNgay() + " " + ca.getGio() + " " + ca.getPhong() + " "
                + mon.getTen() + " " + nhom + " " + soSV;
    }
}

public class Main {
    static BufferedReader br;

    static String next() throws IOException {
        String s;
        while ((s = br.readLine()) != null) {
            s = s.trim();
            if (!s.isEmpty()) return s;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        // Đọc môn thi
        br = new BufferedReader(new FileReader("MONTHI.in"));
        int n = Integer.parseInt(next());
        Map<String, MonHoc> dsMon = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ma = next();
            String ten = next();
            String ht = next();
            dsMon.put(ma, new MonHoc(ma, ten, ht));
        }
        br.close();

        // Đọc ca thi
        br = new BufferedReader(new FileReader("CATHI.in"));
        int m = Integer.parseInt(next());
        Map<String, CaThi> dsCa = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            CaThi c = new CaThi(i, next(), next(), next());
            dsCa.put(c.getMa(), c);
        }
        br.close();

        // Đọc lịch thi
        br = new BufferedReader(new FileReader("LICHTHI.in"));
        int k = Integer.parseInt(next());
        List<LichThi> ds = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(next());
            CaThi ca = dsCa.get(st.nextToken());
            MonHoc mon = dsMon.get(st.nextToken());
            String nhom = st.nextToken();
            String soSV = st.nextToken();
            ds.add(new LichThi(ca, mon, nhom, soSV));
        }
        br.close();

        Collections.sort(ds);
        for (LichThi l : ds) System.out.println(l);
    }
}