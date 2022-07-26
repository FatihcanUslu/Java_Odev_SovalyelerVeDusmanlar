import java.util.ArrayList;
public class OyunVerisi {
    private static ArrayList<Sovalye> sovalyeler;
    private static ArrayList<Sovalye> aktifsovalyeler;
    private static ArrayList<Dusman> dusmanlar;
    private static ArrayList<Dusman> aktifdusmanlar;
    private ArrayList<Sans> sanslar;

    OyunVerisi(){

    }

    public static ArrayList<Sovalye> getSovalyeler() {
        return sovalyeler;
    }

    //deneme1


    public static void setSovalyeler(ArrayList<Sovalye> sovalyeler) {
        OyunVerisi.sovalyeler = sovalyeler;
    }

    public static ArrayList<Sovalye> getAktifsovalyeler() {
        return aktifsovalyeler;
    }

    public static void setAktifsovalyeler(ArrayList<Sovalye> aktifsovalyeler) {
        OyunVerisi.aktifsovalyeler = aktifsovalyeler;
    }

    public ArrayList<Dusman> getDusmanlar() {
        return dusmanlar;
    }

    public static void setDusmanlar(ArrayList<Dusman> dusmanlar) {
        OyunVerisi.dusmanlar = dusmanlar;
    }

    public static ArrayList<Dusman> getdusmanlar() {
        return dusmanlar;
    }
    public static void setAktifdusmanlar(ArrayList<Dusman> aktifdusmanlar) {
        OyunVerisi.aktifdusmanlar = aktifdusmanlar;
    }
    public static ArrayList<Dusman> getAktifdusmanlar() {
        return aktifdusmanlar;
    }


    public ArrayList<Sans> getSanslar() {
        return sanslar;
    }
    public Sovalye getsovalye(String ad){

        return null;
    }

}
