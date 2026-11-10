import java.util.*;
class nhanvien{
  String mvn="00001";
  String hoten,gioitinh,ngaysinh,diachi,mst,date;
   nhanvien(){};
   public void nhap(Scanner sc){
    hoten=sc.nextLine();
    gioitinh=sc.nextLine();
    ngaysinh=sc.nextLine();
    diachi=sc.nextLine();
    mst=sc.nextLine();
    date=sc.nextLine();
   }

   public void in(){
        System.out.printf("%s %s %s %s %s %s %s",mvn,hoten,gioitinh,ngaysinh,diachi,mst,date);
   }

}

public class j04007{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        nhanvien nv = new nhanvien();
        nv.nhap(sc);
        nv.in();
    }
}