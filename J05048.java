//BẢNG THEO DÕI NHẬP XUẤT HÀNG

import java.util.*;

class MatHang{
    String ma;
    long slnhap,slxuat,dongia,tien,thue;
    public MatHang(String ma, long slnhap){
        this.ma=ma;
        this.slnhap=slnhap;
        char d= ma.charAt(0);
        char c=ma.charAt(ma.length()-1);
        if(d=='A') this.slxuat=  Math.round(1.0* slnhap*6/10);
         else this.slxuat=  Math.round(1.0* slnhap*7/10);

        if(c=='Y') this.dongia=110000;
        else this.dongia=135000;
        this.tien=this.slxuat*this.dongia;

        if(d=='A' && c=='Y') this.thue=8*this.tien/100;
         else if(d=='A' && c=='N') this.thue=11*this.tien/100;
         else if(d=='B' && c=='Y') this.thue=17*this.tien/100;
         else if(d=='B' && c=='N') this.thue=22*this.tien/100;
         
 
    }
    @Override
    public String toString(){
        return ma+" "+slnhap+" "+slxuat+" "+dongia+" "+tien+" "+thue;
    }


}

public class J05048 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
          MatHang mh= new MatHang(sc.nextLine(),Long.parseLong(sc.nextLine()));
            System.out.println(mh);
        }

        sc.close();

    }
}
