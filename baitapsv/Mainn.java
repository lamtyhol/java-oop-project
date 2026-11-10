package baitapsv;
import java.util.*;

public class Mainn {
    public static void main(String[] args) {

        ArrayList<nguoi> ds = new ArrayList<>();

        ds.add(new sinhvien(
                "Nguyen Van A",
                "001234567890",
                20,
                "B24DCCN001",
                "D24CQCN01-B"
        ));

        ds.add(new nhanvien(
                "Tran Van B",
                "001234567891",
                30,
                "NV001",
                "01/10/2026"
        ));

        for (nguoi x : ds) {
            x.hienThi();
            System.out.println();
        }
    }
}