import java.util.*;
class MatHang{
    String ma,ten;
    long dongia,soluong;
    long chietkhau,thanhtien;
    public  MatHang(Map<String,Integer> demma, String ten, long soluong, long dongia){
        this.ten=ten;
        this.soluong=soluong;
        this.dongia=dongia;
        String[] st= ten.trim().split("\\s+");
        String ss= (""+ st[0].charAt(0)+ st[1].charAt(0)).toUpperCase();
        int stt= demma.getOrDefault(ss,0)+1;
        this.ma=String.format("%s%02d",ss,stt);
        demma.put(ss,stt);

        long ck;
        if(soluong>10) ck=5;
         else if(soluong>=8) ck=2;
         else if(soluong>=5) ck=1;
         else ck=0;
         this.chietkhau=ck*dongia*soluong/100;

         this.thanhtien=dongia*soluong-this.chietkhau;
    }
    @Override 
    public String toString(){
        return ma+" "+ten+" "+chietkhau+ " "+thanhtien;
    }

}
public class J05047 {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine().trim());
        List<MatHang> ls =new ArrayList<>();
        Map <String,Integer> demma= new HashMap<>(); 
        for(int k=1;k<=t;k++){

            MatHang mh=new MatHang(demma,sc.nextLine(),Long.parseLong(sc.nextLine().trim()),Long.parseLong(sc.nextLine().trim()));
            ls.add(mh);
        }
        ls.sort((mh1,mh2)->Long.compare(mh2.chietkhau,mh1.chietkhau));
        for(MatHang m:ls) System.out.println(m);
        sc.close();
    }
}
