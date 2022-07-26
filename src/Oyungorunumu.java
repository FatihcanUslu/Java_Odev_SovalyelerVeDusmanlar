import java.util.ArrayList;

public class Oyungorunumu {
    private static OyunVerisi oyunverisi;
    //private savasmotoru savasmotoru;
    private static ArrayList<Sovalye> temp;
    private static ArrayList<Sovalye> temp1;
    private static ArrayList<Dusman> temp2;
    private static ArrayList<Dusman> temp3;
    public Oyungorunumu(){

    }
    public void baslangicekrani(){

    }
    public void anamenuyugoster(){

    }
    public void yardim(){

    }
    public static void sovalyelerigoster(){
        //temp=oyunverisi.getSovalyeler();
        //for(int i=0;i<10;i++) {
        //    sovalyeyigoster(temp[i]);
        //}
        temp=OyunVerisi.getSovalyeler();
        for(int i=0;i<10;i++) {
            sovalyeyigoster(temp.get(i));
            System.out.println("*****************************");
        }


    }

    public static void aktifsovalyelerigoster(){
        temp1=OyunVerisi.getAktifsovalyeler();
        for(int i=0;i<5;i++) {
            sovalyeyigoster(temp1.get(i));
            System.out.println("**********************");
        }
    }
    public void menudensecimyap(){

    }
    public static void sovalyeyigoster(Sovalye s){

        System.out.println("sovalye adi:"+s.getAd());

        if(s.getId()==1){
            s.setSovalyetipi("guclu sovalye");
        }
        else if(s.getId()==2){
            s.setSovalyetipi("zayif sovalye");
        }
        System.out.println("sovalye tipi:"+s.getSovalyetipi());
        System.out.println("sovalye id:"+s.getId());
        System.out.println("sovalye vurus hakki:"+s.getVurushakki());
        System.out.println("sovalye sansini goster:"+s.getSans());

    }

    public static void dusmanlarigoster(){
        //temp=oyunverisi.getSovalyeler();
        //for(int i=0;i<10;i++) {
        //    sovalyeyigoster(temp[i]);
        //}
        temp2=OyunVerisi.getdusmanlar();
        for(int i=0;i<10;i++) {
            dusmanigoster(temp2.get(i));
        }

    }

    public static void dusmanigoster(Dusman s){

        System.out.println("dusman adi:"+s.getAd());

        if(s.getId()==1){
            s.setDusmantipi("guclu dusman");
        }
        else if(s.getId()==2){
            s.setDusmantipi("zayif dusman");
        }
        System.out.println("dusman tipi:"+s.getDusmantipi());
        System.out.println("dusman id:"+s.getId());

    }

    public static void aktifdusmanlarigoster(){
        temp3=OyunVerisi.getAktifdusmanlar();
        int aktifones=SavasMotoru.getaktifdusmansayisi();
        for(int i=0;i<aktifones;i++) {
            dusmanigoster(temp3.get(i));
            System.out.println("**********************");
        }
    }

    public void oyundurumunugoster(Dusman[] dusmanlar,Sovalye[] sovalyeler){

    }
}
