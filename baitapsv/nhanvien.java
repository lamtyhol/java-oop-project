package baitapsv;
public class nhanvien extends nguoi {
    private String maNV;
    private String ngayVaoLam;

    public nhanvien(String ten, String cccd, int tuoi,
                    String maNV, String ngayVaoLam) {

        super(ten, cccd, tuoi);

        this.maNV = maNV;
        this.ngayVaoLam = ngayVaoLam;
    }

    @Override
    public void hienThi() {
        System.out.println("=== NHAN VIEN ===");
        System.out.println("Ten: " + ten);
        System.out.println("CCCD: " + cccd);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Ma NV: " + maNV);
        System.out.println("Ngay vao lam: " + ngayVaoLam);
    }
}