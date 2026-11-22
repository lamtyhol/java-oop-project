// XẾP HẠNG HỌC SINH
import java.util.*;
class SinhVien{
    String ten,ma,loai;
    float diem;
    int hang;
    int stt;
    public SinhVien(int ma,String ten, float diem){
        this.ten=ten;
        this.diem=diem;
        this.ma=String.format("HS%02d",ma);
        this.loai= diem<5 ? "Yeu":
                    diem<7 ? "Trung Binh" :
                    diem<9 ? "Kha" : "Gioi";
                    
    }
    public void sethang(int n){
        this.hang=n;

    }

    @Override 
    public String toString(){
        return String.format("%s %s %.1f %s %d",ma,ten,diem,loai,hang );
    }

}
public class J05054 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int t=Integer.parseInt(sc.nextLine());
        List<SinhVien> ls= new ArrayList<>();
       for(int i=1;i<=t;i++){
            
            SinhVien sv= new SinhVien(i,sc.nextLine().trim(),Float.parseFloat(sc.nextLine().trim()));
            ls.add(sv);
        }
       List<SinhVien> tp= new ArrayList<>(ls);
       tp.sort((b,a)->Float.compare(a.diem, b.diem));
       for(int i=0; i<t; i++){
        if(i>0){    
            if(tp.get(i).diem==tp.get(i-1).diem) tp.get(i).sethang(tp.get(i-1).hang); 
                                else tp.get(i).sethang(i+1);

        } else tp.get(0).sethang(1);
       }

       for(SinhVien s:ls) System.out.println(s);
        sc.close();
    }
    
}
