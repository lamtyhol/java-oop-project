package baitapsv;
public class nguoi {
    protected String ten;
    protected String cccd;
    protected int tuoi;

    public nguoi(String ten, String cccd, int tuoi) {
        this.ten = ten;
        this.cccd = cccd;
        this.tuoi = tuoi;
    }

    public void hienThi() {
        System.out.println("Ten: " + ten);
        System.out.println("CCCD: " + cccd);
        System.out.println("Tuoi: " + tuoi);
    }
}