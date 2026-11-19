//TRA CỨU ĐƠN HÀNG
import java.util.*;
class DonHang{
    String ten,ma,stt;
    long gia,soluong,giam,tt;
    public DonHang(String ten,String ma, long gia, long sl){
        this.ten=ten;
        this.ma=ma;
        this.gia=gia;
        this.soluong=sl;
        this.stt=ma.substring(1,4);
        this.giam= (ma.charAt(4)=='1') ? (gia*soluong/2): gia*soluong*3/10;
        this.tt=gia*soluong-giam;
    }

    @Override 
    public String toString(){
        return ten+" "+ma+" "+stt+" "+giam+" "+tt;
    }
}
public class J05052 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = Integer.parseInt(sc.nextLine().trim());
        List<DonHang> ls = new ArrayList<>();
        for (long i = 1; i <= t; i++) {
            String ten = sc.nextLine().trim();
             String ma = sc.nextLine().trim();
            long gia=Long.parseLong(sc.nextLine().trim());
            long sl=Long.parseLong(sc.nextLine().trim());
           DonHang kh= new DonHang(ten, ma,gia,sl);
            ls.add(kh);

        }
        for (DonHang k : ls)
            System.out.println(k);
        sc.close();
    }
}
