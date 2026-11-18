import java.util.*;

class NhanVien {
    String ma, ten, chuc;
    long luong, cong;

    public NhanVien(int stt, String ten, String chuc, long luong, long cong) {
        this.ma = String.format("NV%02d", stt);
        this.ten = ten;
        this.chuc = chuc;
        this.luong = luong;
        this.cong = cong;

    }

    public long getphucap() {
        switch (chuc) {
            case "GD":
                return 500;
            case "PGD":
                return 400;
            case "TP":
                return 300;
            case "KT":
                return 250;
            default:
                return 100;
        }
    }

    public long getluongching() {
        return luong * cong;

    }

    public long tamung() {

        if ((getphucap() + getluongching()) * 2 / 3 < 25000) {
            double kq = (getphucap() + getluongching()) * 2.0 / 3;
            return Math.round(kq / 1000.0) * 1000;
        }
        return 25000;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + getphucap() + " " + getluongching() + " " + tamung() + " " +
                (getluongching() + getphucap() - tamung());
    }

}

public class J05043 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int k = 1;
        while (t-- > 0) {
            NhanVien nv = new NhanVien(k, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()),
                    Integer.parseInt(sc.nextLine()));
            k++;
            System.out.println(nv);
        }

        sc.close();
    }
}