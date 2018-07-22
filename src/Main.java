
import java.util.Scanner;


public class Main {
    private static Kart[][] kartlar=new Kart[4][4];
    
    
        
    
    
    public static void main(String[] args) {
        System.out.println("Hafıza Oyununa Hoşgeldiniz\n"
                +"Kullanım"
                +"Oyunun Görseli 4x4 bir haritadır\n"
                +"Kutucuklarda harfler saklıdır \n"
                +"Bu harfler A,B,C,D,E,F,G,H olup bunların yeri sizden bulunması istenmektedir\n"
                +"Kutucuklardaki harfi açmak için yapmanız gereken işlem örnek olarak şöyledir\n"
                +"Mesela sol üst kutucuk için 0 0 tuşlarına basmanız gerekir\n"
                +"Sonra ikinci harfi bulmak için başka bir kutucuğu seçmeniz lazım\n"
                +"Eğer harfler aynı değilse oyun sizi bulunduğunuz bölümnden bir basamak geri atmaktadır\n"
                +"İyi eylenceler..."
        
        );
        
        
        
        kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        kartlar[0][2] = new Kart('B');
        kartlar[0][3] = new Kart('F');
        kartlar[1][0] = new Kart('G');
        kartlar[1][1] = new Kart('A');
        kartlar[1][2] = new Kart('D');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('F');
        kartlar[2][1] = new Kart('C');
        kartlar[2][2] = new Kart('D');
        kartlar[2][3] = new Kart('H');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('G');
        kartlar[3][2] = new Kart('B');
        kartlar[3][3] = new Kart('C');
        
        
        while (oyunBittiMi() == false){
            
           
            
            oyunTahtasi();
            tahminEt();
            
            
        }
        
        
      
    }
    public static void tahminEt(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Birinci Tahmin (i ve j değerlerini bir boşlukla girin...):  ");
        
        int i1 =scan.nextInt();
        int j1 =scan.nextInt();
        
        kartlar [i1][j1].setTahmin(true);
        oyunTahtasi();
        
        System.out.println("İkinci Tahmin (i ve j değerlerini bir boşlukla girin...):  ");
        
        int i2 =scan.nextInt();
        int j2 =scan.nextInt();
        
        if (kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()){
            System.out.println("***********************");
            System.out.println("Doğru Tahmin.Tebrikler!");
            System.out.println("***********************");
            kartlar[i2][j2].setTahmin(true);
        }
        else{
            System.out.println("***********************");
            System.out.println("Yanlış Tahmin..");
            System.out.println("Bir basamak gerilediniz!!!");
            System.out.println("***********************");
            kartlar[i1][j1].setTahmin(false);
        }
        
    }
    public static boolean oyunBittiMi(){
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 4; j++) {
                
                if(kartlar[i][j].isTahmin()==false){
                    return false;
                    
                }
                
            }
            
        }
        return true;
    }
    
    public static void oyunTahtasi(){
        
        for (int i = 0; i < 4; i++) {
            
             System.out.println("____________________");
            
            for (int j = 0; j < 4; j++) {
                
                if(kartlar[i][j].isTahmin()){
                    
                    System.out.print(" |"+kartlar[i][j].getDeger() + "| ");
                    
                     }
                     else{
                    
                    System.out.print(" | | ");
                    
                }
                
            }
            
            System.out.println("");
            
        }
        
        System.out.println("____________________");
        
    }
    
}
