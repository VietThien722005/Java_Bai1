/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1_phanso;



public class Phanso_121 {
    private int tu;
    private int mau;

    // Constructor khong tham so
    public Phanso_121() {
        this.tu = 0;
        this.mau = 1;
    }

    // Constructor co tham so
    public Phanso_121(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so khong duoc bang 0!");
        }
        this.tu = tu;
        this.mau = mau;
        rutGon();
    }

    // Tim uoc chung lon nhat (iterative, an toan hon)
    private int uscln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) return 1; // truong hop hiem hoi
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // Rut gon phan so
    public void rutGon() {
        int u = uscln(tu, mau);
        if (u != 0) {
            tu /= u;
            mau /= u;
        }
        if (mau < 0) { // dam bao mau duong
            tu = -tu;
            mau = -mau;
        }
    }

    // Kiem tra toi gian
    public boolean laToiGian() {
        return uscln(tu, mau) == 1;
    }

    // Cong
    public Phanso_121 cong(Phanso_121 ps) {
        int t = this.tu * ps.mau + ps.tu * this.mau;
        int m = this.mau * ps.mau;
        return new Phanso_121(t, m);
    }

    // Tru
    public Phanso_121 tru(Phanso_121 ps) {
        int t = this.tu * ps.mau - ps.tu * this.mau;
        int m = this.mau * ps.mau;
        return new Phanso_121(t, m);
    }

    // Nhan
    public Phanso_121 nhan(Phanso_121 ps) {
        int t = this.tu * ps.tu;
        int m = this.mau * ps.mau;
        return new Phanso_121(t, m);
    }

    // Chia
    public Phanso_121 chia(Phanso_121 ps) {
        if (ps.tu == 0) {
            throw new IllegalArgumentException("Khong the chia cho phan so 0!");
        }
        int t = this.tu * ps.mau;
        int m = this.mau * ps.tu;
        return new Phanso_121(t, m);
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}
