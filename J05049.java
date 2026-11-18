//LIỆT KÊ NHẬP XUẤT HÀNG THEO NHÓM

import java.util.*;

class MatHang {
    String ma;
    long nhap, xuat, gia, tien, thue;

    public MatHang(String ma, long nhap) {
        this.ma = ma;
        this.nhap = nhap;
        char d = ma.charAt(0), c = ma.charAt(ma.length() - 1);

        this.xuat = Math.round(nhap * (d == 'A' ? 0.6 : 0.7));
        this.gia = (c == 'Y') ? 110000 : 135000;
        this.tien = this.xuat * this.gia;

        int pt = (d == 'A') ? (c == 'Y' ? 8 : 11) : (c == 'Y' ? 17 : 22);
        this.thue = this.tien * pt / 100;
    }

    @Override
    public String toString() {
        return ma + " " + nhap + " " + xuat + " " + gia + " " + tien + " " + thue;
    }
}

public class J05049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<MatHang> list = new ArrayList<>();

        while (t-- > 0) {
            list.add(new MatHang(sc.nextLine(), Long.parseLong(sc.nextLine())));
        }

        char yc = sc.nextLine().charAt(0);
        list.stream()
            .filter(m -> m.ma.charAt(0) == yc)
            .sorted((a, b) -> Long.compare(b.thue, a.thue))
            .forEach(System.out::println);
          sc.close();   
    }
   
}