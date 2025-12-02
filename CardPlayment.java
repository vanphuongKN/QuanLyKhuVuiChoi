
package quanlykhuvuichoi;


public class CardPlayment implements Payment {
    private String soThe;
    private String ngayHetHan;
    public CardPlayment(String soThe, String ngayHetHan){
        this.soThe= soThe;
        this.ngayHetHan= ngayHetHan;
    }
    @Override
    public boolean pay(double soTien){
        System.out.println("Thanh toan" +soTien+ "bang the:"+soThe);
        return true;
    }
    
}
