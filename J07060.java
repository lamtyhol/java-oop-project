//SẮP XẾP LỊCH THI
import java.util.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class MonHoc {
    String MaMH, TenMH, Hinhthuc;

    public MonHoc(String ma, String ten, String ht) {
        this.MaMH = ma;
        this.TenMH = ten;
        this.Hinhthuc = ht;

    }

}

class CaThi {
    String MaCa, phongthi;
    LocalDateTime thoigian;
    public static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public CaThi(String ngay, String gio, String phong, String ma) {
        this.MaCa = ma;

        this.thoigian = LocalDateTime.parse(ngay + " " + gio, fmt);
        this.phongthi = phong;
    }

    public LocalDateTime gettime() {
        return thoigian;
    }

    public String getcathi() {
        return MaCa;
    }

}

class LichThi {
    CaThi ca;
    MonHoc mon;
    String nhom;
    int sl;

    public LichThi(MonHoc mon, CaThi ca, String nhom, int sl) {
        this.mon = mon;
        this.ca = ca;
        this.nhom = nhom;
        this.sl = sl;

    }

    public CaThi getcathi() {
        return ca;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d",
                ca.thoigian.format(ca.fmt),
                ca.phongthi,
                mon.TenMH,
                nhom, sl);
    }
}

public class J07060 {
    public static void main(String[] args) throws Exception {
        int t;
        Scanner scmon = new Scanner(new File("MONTHI.in"));
        t = Integer.parseInt(scmon.nextLine().trim());
        Map<String, MonHoc> mapmon = new HashMap<>();
        for (int i = 1; i <= t; i++) {
            String ma = scmon.nextLine().trim();
            String tenmon = scmon.nextLine().trim();
            String ht = scmon.nextLine().trim();
            mapmon.put(ma, new MonHoc(ma, tenmon, ht));
        }
        scmon.close();

        Scanner scca = new Scanner(new File("CATHI.in"));
        Map<String, CaThi> mapca = new HashMap<>();
        t = Integer.parseInt(scca.nextLine().trim());
        for (int i = 1; i <= t; i++) {
            String ngay = scca.nextLine().trim();
            String gio = scca.nextLine().trim();
            String phong = scca.nextLine().trim();
            String mmm = String.format("C%03d", i);
            mapca.put(mmm, new CaThi(ngay, gio, phong, mmm));
        }
        scca.close();

        Scanner sclich = new Scanner(new File("LICHTHI.in"));
        t = Integer.parseInt(sclich.nextLine().trim());
        List<LichThi> lslich = new ArrayList<>();

        for (int i = 1; i <= t; i++) {
            String maca = sclich.next();
            String mamon = sclich.next();
            String manhom = sclich.next();
            int sv = Integer.parseInt(sclich.nextLine().trim());
            MonHoc mh = mapmon.get(mamon);
            CaThi ct = mapca.get(maca);
            lslich.add(new LichThi(mh, ct, manhom, sv));

        }

        sclich.close();
        lslich.sort((a, b) -> {
            int cmp = a.getcathi().gettime().compareTo(b.getcathi().gettime());
            if (cmp != 0)
                return cmp;
            return a.getcathi().getcathi().compareTo(b.getcathi().getcathi());
        });
        for (LichThi l : lslich)
            System.out.println(l);
    }
}
