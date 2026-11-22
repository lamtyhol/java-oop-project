//TÍNH GIỜ CHUẨN
import java.io.File;
import java.util.*;



class GiangVien {
    String ma, ten;
    double gio;
    public GiangVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.gio=0;
    }
    public void addgio(double a){
            this.gio+=a;

    }
   @Override 
   public String toString(){
    return ten+" "+String.format("%.2f",gio);
   }
}

public class J07028 {
    public static void main(String[] args) throws Exception {
        Scanner scgv = new Scanner(new File("GIANGVIEN.in"));
        Map<String, GiangVien> mapgv = new HashMap<>();
        List<GiangVien> ls= new ArrayList<>();
        int g = Integer.parseInt(scgv.nextLine());
        while (g-- > 0) {
            String ma = scgv.next();
            String ten = scgv.nextLine().trim();
            GiangVien gv= new GiangVien(ma, ten);
            mapgv.put(ma,gv);
            ls.add(gv);
        }
        scgv.close();

        Scanner sc = new Scanner(new File("GIOCHUAN.in"));
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String magv = sc.next();
            sc.next();
            double gio = Double.parseDouble(sc.nextLine().trim());
            mapgv.get(magv).addgio(gio);

        }
        for(GiangVien x:ls) System.out.println(x);
        sc.close();

    }
}
