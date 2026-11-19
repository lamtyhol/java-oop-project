//QUẢN LÝ BÀI TẬP NHÓM – 2
import java.util.*;

class SinhVien {
    String msv, ten, sdt;
    int sonhom;
    Nhom nhom;

    public SinhVien(String msv, String ten, String sdt, int sonhom) {
        this.msv = msv;
        this.ten = ten;
        this.sdt = sdt;
        this.sonhom = sonhom;
    }

    @Override
    public String toString() {
        return msv + " " + ten + " " + sdt + " " + sonhom + " " + nhom.tenbaitap;
    }
}

class Nhom {
    int tennhom;
    String tenbaitap;
    List<SinhVien> ls = new ArrayList<>();

    public Nhom(int k) {
        this.tennhom = k;

    }

    public void addbt(String s) {
        this.tenbaitap = s;

    }

    public void addsv(SinhVien sv) {
        this.ls.add(sv);
        sv.nhom = this;
    }

}

public class J06004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = Integer.parseInt(sc.nextLine().trim());
        Map<Integer, Nhom> mapnhom = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            mapnhom.put(i, new Nhom(i));
        }

        List<SinhVien> lsv = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String msv = sc.nextLine();
            String ten = sc.nextLine();
            String sdt = sc.nextLine();
            int stt = Integer.parseInt(sc.nextLine().trim());
            SinhVien sv = new SinhVien(msv, ten, sdt, stt);
            lsv.add(sv);
            mapnhom.get(stt).addsv(sv);

        }

        for (int i = 1; i <= m; i++) {
            String tenbai = sc.nextLine();
            mapnhom.get(i).addbt(tenbai);

        }

        lsv.sort((a, b) -> a.msv.compareTo(b.msv));
        for (SinhVien SV : lsv)
            System.out.println(SV);

        sc.close();
    }
}
