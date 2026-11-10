package baitapsv;
public class sinhvien extends nguoi {
    private String msv;
    private String lop;

    public sinhvien(String ten, String cccd, int tuoi,
                    String msv, String lop) {

        super(ten, cccd, tuoi);

        this.msv = msv;
        this.lop = lop;
    }

    @Override
    public void hienThi() {
        System.out.println("=== SINH VIEN ===");
        System.out.println("Ten: " + ten);
        System.out.println("CCCD: " + cccd);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("MSV: " + msv);
        System.out.println("Lop: " + lop);
    }
}