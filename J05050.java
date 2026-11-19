//TÍNH TIỀN ĐIỆN
import java.util.*;

class KhachHang {
    String ma, loai;
    long socu, somoi;
    long heso;
    long thanhtien, phutro, tienphaitra;

    public KhachHang(long stt, String loai, long socu, long somoi) {
        this.ma = String.format("KH%02d", stt);
        this.loai = loai;
        this.socu = socu;
        this.somoi = somoi;

        this.heso = loai.equals("KD") ? 3 : loai.equals("NN") ? 5 : loai.equals("TT") ? 4 : loai.equals("CN") ? 2 : 0;

        this.thanhtien = (somoi - socu) * heso * 550;
        this.phutro = (somoi - socu) < 50 ? 0
                : (somoi - socu) <= 100 ? Math.round(1.0 * thanhtien * 35 / 100) : thanhtien;

        this.tienphaitra = phutro + thanhtien;
    }

    @Override
    public String toString() {
        return ma + " " + heso + " " + thanhtien + " " + phutro + " " + tienphaitra;
    }

}

public class J05050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = Integer.parseInt(sc.nextLine().trim());
        List<KhachHang> ls = new ArrayList<>();
        for (long i = 1; i <= t; i++) {
            String loai = sc.nextLine();
            long scu = Long.parseLong(sc.nextLine().trim());
            long smoi = Long.parseLong(sc.nextLine().trim());
            KhachHang kh = new KhachHang(i, loai, scu, smoi);
            ls.add(kh);

        }
        for (KhachHang k : ls)
            System.out.println(k);
        sc.close();
    }
}