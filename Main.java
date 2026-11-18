import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class MonThi {
    private String maMon, tenMon, hinhThuc;

    public MonThi(String maMon, String tenMon, String hinhThuc) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThuc = hinhThuc;
    }

    public String getTenMon() {
        return tenMon;
    }
}

class CaThi {
    private String maCa, phongThi;
    private LocalDateTime thoiGian;
    public static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public CaThi(int stt, String ngayThi, String gioThi, String phongThi) {
        this.maCa = String.format("C%03d", stt);
        this.thoiGian = LocalDateTime.parse(ngayThi + " " + gioThi, FMT);
        this.phongThi = phongThi;
    }

    public String getMaCa() {
        return maCa;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public String getPhongThi() {
        return phongThi;
    }
}

class LichThi {
    private CaThi caThi;
    private MonThi monThi;
    private String maNhom;
    private int soSV;

    public LichThi(CaThi caThi, MonThi monThi, String maNhom, int soSV) {
        this.caThi = caThi;
        this.monThi = monThi;
        this.maNhom = maNhom;
        this.soSV = soSV;
    }

    public CaThi getCaThi() {
        return caThi;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d",
                caThi.getThoiGian().format(CaThi.FMT),
                caThi.getPhongThi(),
                monThi.getTenMon(),
                maNhom,
                soSV);
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // 1. Đọc file MONTHI.in
        Scanner scMon = new Scanner(new File("MONTHI.in"));
        int n = Integer.parseInt(scMon.nextLine().trim());
        Map<String, MonThi> mapMon = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String maMon = scMon.nextLine().trim();
            String tenMon = scMon.nextLine().trim();
            String hinhThuc = scMon.nextLine().trim();
            mapMon.put(maMon, new MonThi(maMon, tenMon, hinhThuc));
        }
        scMon.close();

        // 2. Đọc file CATHI.in
        Scanner scCa = new Scanner(new File("CATHI.in"));
        int m = Integer.parseInt(scCa.nextLine().trim());
        Map<String, CaThi> mapCa = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String ngay = scCa.nextLine().trim();
            String gio = scCa.nextLine().trim();
            String phong = scCa.nextLine().trim();
            CaThi ca = new CaThi(i, ngay, gio, phong);
            mapCa.put(ca.getMaCa(), ca);
        }
        scCa.close();

        // 3. Đọc file LICHTHI.in
        Scanner scLich = new Scanner(new File("LICHTHI.in"));
        int k = Integer.parseInt(scLich.nextLine().trim());
        List<LichThi> listLich = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String maCa = scLich.next();
            String maMon = scLich.next();
            String maNhom = scLich.next();
            int soSV = scLich.nextInt();
            listLich.add(new LichThi(mapCa.get(maCa), mapMon.get(maMon), maNhom, soSV));
        }
        scLich.close();

        // 4. Sắp xếp theo thời gian tăng dần, trùng thời gian thì mã ca tăng dần
        listLich.sort((a, b) -> {
            int cmp = a.getCaThi().getThoiGian().compareTo(b.getCaThi().getThoiGian());
            if (cmp != 0) return cmp;
            return a.getCaThi().getMaCa().compareTo(b.getCaThi().getMaCa());
        });

        // 5. Xuất kết quả
        for (LichThi lt : listLich) {
            System.out.println(lt);
        }
    }
}