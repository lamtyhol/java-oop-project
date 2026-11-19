//SẮP XẾP ĐƠN HÀNG
import java.util.*;

class DonHang {
    String ten, ma, stt;
    long gia, soluong, giam, tt;

    public DonHang(String ten, String ma, long gia, long sl) {
        this.ten = ten;
        this.ma = ma;
        this.gia = gia;
        this.soluong = sl;
        this.stt = ma.substring(1, 4);
        this.giam = (ma.charAt(4) == '1') ? (gia * soluong / 2) : (gia * soluong * 3 / 10);
        this.tt = gia * soluong - giam;
    }

    @Override
    public String toString() {
        return ten + " " + ma + " " + stt + " " + giam + " " + tt;
    }
}

public class J05053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        List<DonHang> ls = new ArrayList<>();
        for (int i = 1; i <= t; i++) {
            sc.nextLine(); // Đọc bỏ ký tự xuống dòng thừa trước khi đọc tên
            String ten = sc.nextLine().trim();
            while (ten.isEmpty()) { // Bỏ qua nếu test có dòng trống
                ten = sc.nextLine().trim();
            }
            String ma = sc.next().trim();
            long gia = sc.nextLong();
            long sl = sc.nextLong();
            ls.add(new DonHang(ten, ma, gia, sl));
        }
        ls.sort((a, b) -> a.stt.compareTo(b.stt));
        for (DonHang k : ls) {
            System.out.println(k);
        }
        sc.close();
    }
}