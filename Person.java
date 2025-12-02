
package quanlykhuvuichoi;

import java.util.Scanner;

public abstract class Person {
    protected String ten;
    protected String soDienThoai;
    public Person(){
        
    }
    public Person(String ten, String soDienThoai){
        this.ten = ten;
        this.soDienThoai= soDienThoai;
        
    }
    public void nhap(Scanner scanner){
       System.out.print("nhap ten:");
       this.ten= scanner.nextLine();
       System.out.println("Nhap so dien thoai: ");
       this.soDienThoai= scanner.nextLine();
    }
    public void xuat(){
        System.out.println("Ten: " +this.ten);
        System.out.println("so dien thoai: "+this.soDienThoai);
        
    }
    public String getTen(){
        return this.ten;
    }
    public String getsoDienThoai(){
        return this.soDienThoai;
    }
}
