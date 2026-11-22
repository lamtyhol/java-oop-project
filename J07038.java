//DANH SÁCH THỰC TẬP - 3
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


class SinhVien{
    String ma,ten,lop,email;

    private String chuanHoaTen(String s) {
        String[] word= s.trim().toLowerCase().split("\\s+");
        StringBuilder sb= new StringBuilder();
         for(String w: word){
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1)).append(" ");
         }
         return sb.toString().trim();
    }
    public SinhVien(String ma,String ten,String lop, String email){
        this.ma=ma;
        this.ten=chuanHoaTen(ten);
        this.lop=lop;
        this.email=email;   

    }
    @Override   
    public String toString(){
        return ma+" "+ten+" "+lop;
    }
}

class DN{
    String ma,ten;
    int slmax;
    List<SinhVien> dsach= new ArrayList<>();
    public DN(String ma, String ten, int sl){
        this.ma=ma;
        this.ten=ten;
        this.slmax=sl;
    }
   
    public void inthongtin(){
        System.out.println("DANH SACH THUC TAP TAI " + ten + ":");
        dsach.sort((a,b)->a.ma.compareTo(b.ma));
        for(int i=0; i<Math.min(slmax, dsach.size());i++){
            System.out.println(dsach.get(i));
        }
    }
}
class ThucTap{
    SinhVien sv;
    DN dn;
    public ThucTap( SinhVien sv, DN dn){
        this.sv=sv;
        this.dn=dn;
        this.dn.dsach.add(sv);

    }

}

public class J07038 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scsv=new Scanner(new File("SINHVIEN.in"));
        int n=Integer.parseInt(scsv.nextLine().trim());
        Map<String,SinhVien> mapsv =new HashMap<>();
        while(n-->0){
        String ma=scsv.nextLine();
        String ten=scsv.nextLine();
        String lop=scsv.nextLine();
        String email=scsv.nextLine();
        SinhVien sv =new SinhVien(ma, ten, lop, email); 
        mapsv.put(ma,sv);   
        }
        scsv.close();

        Scanner scdn=new Scanner(new File("DN.in"));
        int m=Integer.parseInt(scdn.nextLine().trim());
        Map<String,DN> mapdn= new HashMap<>();
        while(m-->0){
            String madn=scdn.nextLine();
            String tendn=scdn.nextLine();
            int sl=Integer.parseInt(scdn.nextLine().trim());
            DN dn= new DN(madn,tendn,sl);
            mapdn.put(madn,dn);
        }
        scdn.close();


        Scanner sctt=new Scanner(new File("THUCTAP.in"));
        int t=Integer.parseInt(sctt.nextLine().trim());
        List<ThucTap> lstt= new ArrayList<>();
        while(t-->0){
            String msv=sctt.next();
            String mdn=sctt.nextLine().trim();
            ThucTap tt= new ThucTap(mapsv.get(msv),mapdn.get(mdn));
            lstt.add(tt);
        }


        int k= Integer.parseInt(sctt.nextLine().trim());
        while(k-->0){
           mapdn.get(sctt.nextLine().trim()).inthongtin();
        }
        sctt.close();

    
 






    }
}
