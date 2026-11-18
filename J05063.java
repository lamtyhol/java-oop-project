
import java.util.*;

class DaThuc {
    int[] heso = new int[10001];

    public DaThuc() {
    };

    public DaThuc(String s) {
        String[] st = s.replaceAll("[^0-9]+", " ").trim().split("\\s+");
        for (int i = 0; i < st.length; i += 2) {
            int hs = Integer.parseInt(st[i]);
            int mu = Integer.parseInt(st[i + 1]);
            this.heso[mu] += hs;
        }
    }

    public DaThuc cong(DaThuc d) {
        DaThuc tp = new DaThuc();
        for (int i = 0; i <= 10000; i++) {
            tp.heso[i] = this.heso[i] + d.heso[i];
        }
        return tp;
    }

    @Override
    public String toString() {
        List<String> ls = new ArrayList<>();
        for (int i = 10000; i >= 0; i--) {
            if (this.heso[i] > 0) {
                ls.add(heso[i] + "*x^" + i);
            }
        }
        return String.join(" + ", ls);
    }

}

public class J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
        sc.close();
    }
}
