//QUẢN LÝ BÁN HÀNG – 1
import java.util.*;
class KhachHang{
    String makh,ten,gioitinh,ngaysinh,diachi;

    public KhachHang(String makh, String ten, String gt,String ngay,String dc){
        this.makh=makh;
        this.ten=ten;
        this.gioitinh=gt;
        this.ngaysinh=ngay;
        this.diachi=dc;
    }


}


class MatHang{
    String mahang,ten,donvi;
    long giamua,giaban;
    
    public MatHang(  String mh,  String ten, String dv,long gmua, long gban)
        {
            this.mahang=mh; 
            this.ten= ten;
            this.donvi= dv;
            this.giamua=gmua;
            this.giaban=gban;
            }

}



class HoaDon{
    long soluong;
    String mahd;
   KhachHang kh;
   MatHang mh;

    public HoaDon(String mahd, KhachHang kh, MatHang mh,int sl){
        this.soluong=sl;
        this.mahd=mahd;
        this.kh=kh;
        this.mh=mh;
    }
    public void intt(){
        System.out.println(mahd+" "+kh.ten+" "+kh.diachi+" "
            +mh.ten+" "
            
            +soluong+" "+kh.diachi);
    }
}


public class J06005 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine().trim());
        Map<String,KhachHang> mapkh= new HashMap<>();
         Map<String,MatHang> mapmh= new HashMap<>();
        for(int i=1;i<=n;i++){
            String mkh= String.format("KH%03d",i);
            String ten= sc.nextLine();
            String gt= sc.nextLine();
            String nsinh= sc.nextLine();
            String dchi= sc.nextLine();
            KhachHang kh= new KhachHang(mkh,ten,gt,nsinh,dchi);
        mapkh.put(mkh,kh);
        }

        int m=Integer.parseInt(sc.nextLine().trim());
        for(int i=1;i<=m;i++){
             String mahang= String.format("MH%03d",i);
            String ten= sc.nextLine();
            String dv= sc.nextLine();
            long giamua =Long.parseLong(sc.nextLine().trim());
            long giaban =Long.parseLong(sc.nextLine().trim());
            MatHang mh= new MatHang(mahang,ten,dv,giamua,giaban);
            mapmh.put(mahang,mh);

        }

        int k=Integer.parseInt(sc.nextLine().trim());

        List<HoaDon> ls= new ArrayList<>();
        for(int i=1;i<=k;i++){
             String mahd= String.format("HD%03d",i);
            String mkh =sc.next();
            String mhh=sc.next();
            int slg= Integer.parseInt(sc.nextLine().trim());
            KhachHang KH= mapkh.get(mkh) ;
            MatHang MH=mapmh.get(mhh) ;
            ls.add(new HoaDon(mahd,KH,MH,slg));
          }

          for(HoaDon h:ls) h.intt();
        sc.close();
    }

}
