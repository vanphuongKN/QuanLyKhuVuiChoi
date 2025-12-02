/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhuvuichoi;

public class EWalletPayment implements Payment{
    private String maVi;
    public EWalletPayment(String maVi){
       this.maVi=maVi; 
    }
    @Override
    public boolean pay(double soTien){
        System.out.println("Thanh toan" + soTien+ "qua vi dien tu: "+maVi);
        return true;
        
    }
}
