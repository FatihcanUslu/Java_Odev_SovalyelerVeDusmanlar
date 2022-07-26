import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.BufferedWriter;
import java.io.FileWriter;
public class SavasMotoru {
    static int dusmansayisi;
    public static void main(String[] args) throws IOException {
        ArrayList<Sovalye> sovalyeler = new ArrayList<Sovalye>();
        Sans sans = new Sans();
        Txtoyunverisi yazici=new Txtoyunverisi();
        for (int i = 0; i < 10; i++) {
            int temp = (Math.random() <= 0.5) ? 1 : 2;
            Sovalye sovalye1 = new Sovalye("sovalye S" + (i + 1), temp);
            sovalye1.setRealid(i + 1);
            if(sovalye1.getId()==1){
                sovalye1.setSovalyetipi("guclu sovalye");
            }
            else if(sovalye1.getId()==2){
                sovalye1.setSovalyetipi("zayif sovalye");
            }
            sans.sansAta(sovalye1);
            sovalye1.setVurushakki(sovalye1.getVurushakki() + sovalye1.getSans());//sans ekleniyor
            sovalyeler.add(sovalye1);
        }
        OyunVerisi.setSovalyeler(sovalyeler);//bütün sovalyeler oyun verisi içinde parametre olarak tutulsun

        //random sovalye ekleyip aktifsovalyeler olusturma adimi
        ArrayList<Sovalye> temp1;//bütün sovalyeler
        ArrayList<Sovalye> temp2 = new ArrayList<Sovalye>();//aktif sovalyeler
        temp1 = OyunVerisi.getSovalyeler();

        for (int i = 0; i < 10; i++) {

            if (temp1.get(i).getId() == 1) {
                temp2.add(temp1.get(i));
            }
            if (temp2.size() == 2) {
                break;
            }
        }
        for (int i = 0; i < 10; i++) {

            if (temp1.get(i).getId() == 2) {
                temp2.add(temp1.get(i));
            }
            if (temp2.size() == 5) {//oyun görünümü aktifsovalyelerigoster içindeki döngü 5 eleman için çalışıyor olası 6. elemanda hata alınır
                break;
            }
        }
        OyunVerisi.setAktifsovalyeler(temp2);//aktif olan sovalyeler oyunverisine yollaniyor

        // düşman tanımlama
        ArrayList<Dusman> dusmanlar = new ArrayList<Dusman>();
        for (int i = 0; i < 10; i++) {
            int temp3 = (Math.random() <= 0.5) ? 1 : 2;
            Dusman dusman1 = new Dusman("Dusman D" + (i + 1), temp3);
            if(dusman1.getId()==1){
                dusman1.setDusmantipi("guclu dusman");
            }
            else if(dusman1.getId()==2){
                dusman1.setDusmantipi("zayif dusman");
            }
            dusman1.setRealid(i + 1);
            dusmanlar.add(dusman1);
        }
        OyunVerisi.setDusmanlar(dusmanlar);//bütün sovalyeler oyun verisi içinde parametre olarak tutulsun
        //Oyungorunumu.dusmanlarigoster();//butun düşmanları gösterir

        //random dusman ekleyip aktif dusmanlar olusturma adimi
        ArrayList<Dusman> temp4;//bütün dusmanlar
        ArrayList<Dusman> temp5 = new ArrayList<Dusman>();//aktif dusmanlar
        temp4 = OyunVerisi.getdusmanlar();

        Random rand = new Random();
        dusmansayisi = rand.nextInt((5 - 3) + 1) + 3;//3 ila 5 arasinda olusturulacak olan aktif dusman sayisi
        int aktifgucludusman = (Math.random() <= 0.5) ? 1 : 2;//aktif olan guclu dusman sayisi


        for (int i = 0; i < 10; i++) {

            if (temp4.get(i).getId() == 1) {
                temp5.add(temp4.get(i));
            }
            if (temp5.size() == aktifgucludusman) {
                break;
            }
        }

        for (int i = 0; i < 10; i++) {

            if (temp4.get(i).getId() == 2) {
                temp5.add(temp4.get(i));
            }
            if (temp5.size() == dusmansayisi) {//oyun görünümü aktifdusmanlarigoster içindeki döngü total dusman sayisi için çalışıyor olası 6. elemanda hata alınır
                break;
            }
        }
        //System.out.println(temp5.size());
        OyunVerisi.setAktifdusmanlar(temp5);//aktif olan dusmanlar oyunverisine yollaniyor
        //System.out.println("*****************************");
        //System.out.println("aktif olan dusmanlar");
        //Oyungorunumu.aktifdusmanlarigoster();
        //System.out.println("**************************************************************************************************");

        //System.out.println("aktif dusman sayisi:" + dusmansayisi);
        //System.out.println("aktifgucludusman number:" + aktifgucludusman);

        yazici.kayitverileriniyukle();//sovalyelerin ve dusmanlarin bilgilerini ayri dosyalar olarak yazar

        System.out.println("*************************************************");
        System.out.println("Oyuna hos geldiniz.");
        System.out.println("*************************************************");
        System.out.println("ANA MENU \n -gerceklestirmek istediginiz islemin satir numarasini giriniz \n \n" +
                "1. Tum sovalyeleri goster\n" +
                "2. Adi girilen sovalye bilgilerini goster\n" +
                "3. Aktif olan sovalyeleri goster\n" +
                "4. Adi girilen sovalyeyi degistir\n" +
                "5. Yardim\n" +
                "6. Oyundan cik\n" +
                "7. Oyunu baslat\n" +
                "");


        Scanner ah = new Scanner(System.in);
        while (true) {


            int istenilenislem = ah.nextInt();//1'den 7'ye kadar deger alinacak degerler

            if (istenilenislem < 0 || istenilenislem > 7) {//basit kontrol
                System.out.println("hatali sayi girdiniz deger 1 ile 7 arasinda olmalidir :)");
            }

            if (istenilenislem == 1) {//butun sovalyeleri gosterir
                Oyungorunumu.sovalyelerigoster();//girilen bütün sovalyeleri output'ta listeler

            }
            if (istenilenislem == 2) {//istenilen sovalyeyi gosterir
                System.out.println("havuzdaki sovalyelerden bilgisini gormek istediginizin numarasini giriniz:");
                int sgt = ah.nextInt();
                sgt-=1;
                Oyungorunumu.sovalyeyigoster(sovalyeler.get(sgt));//sadece secilen sovalyeyi gosterir
            }


            if (istenilenislem == 3) {//Aktif olan şövalyeleri göster sadece aktif olan sovalyeleri gosterir
                System.out.println("aktif sovalye sayisi:" + temp2.size());
                System.out.println("*****************************");
                System.out.println("aktif olan sovalyeler");
                Oyungorunumu.aktifsovalyelerigoster();
            }

            if (istenilenislem == 4) {//adi girilen sovalyeleri degistir
                System.out.println("degistirmek istediginiz sovalyeyi girin:");
                int birinci = ah.nextInt();
                System.out.println("yerine gelen yeni sovalyenizi girin:");
                int ikinci = ah.nextInt();
                birinci-=1;
                ikinci-=1;
                int tmpfdd=0;
                for(int i=0;i<temp2.size();i++){//eger destedeki kart birdaha eklenmek istiyorsa engeller
                    if(temp2.get(i)==temp1.get(ikinci)){
                        System.out.println("aktif destede olan sovalyeyi bir daha cagiramazsiniz.");
                        tmpfdd=1;
                        break;

                    }
                }
                    if(temp2.get(birinci).getId()==2 && temp1.get(ikinci).getId()==1){//guclu sayisi 2'nin ustune cikarilmaya calisilirsa;
                        System.out.println("guclu kart sayiniz en fazla 2 olabilir. Yani zayif karti birakip guclu kart alamazsiniz :D");
                        tmpfdd=1;
                    }


                if(tmpfdd==1){//kart ekleme cikarma islemlerinde sorunlu islemde dongu devam eder
                    continue;
                }
                //adı girilen şovalyeyi değiştir
                int degisen = birinci;
                int yenigelen = ikinci;
                temp2.set(degisen, temp1.get(yenigelen));
                Oyungorunumu.aktifsovalyelerigoster();

            }
            if (istenilenislem == 5) {
                System.out.println("- Guclu Dusmanlar: Yalnizca Guclu sovalyeler tarafindan yok edilebilirler.\n" +
                        "- Zayif Dusmanlar: Hem Guclu hem de Zayif sovalyeler tarafindan yok edilebilirler.\n" +
                        "hadi savasalim !!!");
            }
            if (istenilenislem == 6) {
                System.out.println("Oyundan cikiliyor...");
                System.exit(1);
            }
            if (istenilenislem == 7) {
                System.out.println("Oyun baslatiliyor...");
                System.out.println("aktif dusman sayisi:" + dusmansayisi);


            //oyun ilerleme kayit islemi
                File oyunkaydi = new File("veriler/oyunkaydi.txt");
                if(!oyunkaydi.exists()){
                    oyunkaydi.createNewFile();
                }


                FileWriter fileWriter2 = new FileWriter(oyunkaydi, false);
                BufferedWriter bWriter2 = new BufferedWriter(fileWriter2);
                bWriter2.write("oyun kayitlari: \n");


            //saldiri islemleri
            System.out.println("Saldiri basladi");
            Scanner sc = new Scanner(System.in);
            ArrayList<Sovalye> temp6 = new ArrayList<Sovalye>();
            temp6 = OyunVerisi.getAktifsovalyeler();//aktif olan sovalyeler
            ArrayList<Dusman> temp7 = new ArrayList<Dusman>();
            temp7 = OyunVerisi.getAktifdusmanlar();//aktif olan dusmanlar
            int aktifdusmansayaci = 0;//oyun sonu için kullanılacak
            int aktifsovalyesayaci = 0;//oyun sonu için kullanılacak
            while (true) {
                System.out.println("atak yapmak istediginiz elemaninizi secin:");
                int konum = sc.nextInt();
                konum -= 1;//indisleme ve kullanıcı rahatlığı için böyle yapmak daha mantıklı
                Oyungorunumu.sovalyeyigoster(temp6.get(konum));
                if (temp6.get(konum).getaktif() == true) {//sovalye aktif ise
                    if (temp6.get(konum).getVurushakki() != 0) {//eger karakterin vurus hakki hala var ise ;
                        System.out.println("atak yapmak istediginiz dusmani secin:");
                        int saldirilandusman = sc.nextInt();
                        saldirilandusman -= 1;//indisleme ve kullanıcı rahatlığı için böyle yapmak daha mantıklı

                        if (saldirilandusman > temp7.size() || saldirilandusman < 0) {//oyuncu yanlış bir düsman konumu birerse
                            System.out.println("boyle bir dusman yok bir daha dene");
                            continue;
                        }
                        if (temp6.get(konum).getSovalyetipi() == "guclu sovalye" && temp7.get(saldirilandusman).getaktif() == true) {//sovalyemiz guclu ise dusmanin tipi onemli degil sadece aktifligi onemli
                            temp6.get(konum).setVurushakki(temp6.get(konum).getVurushakki() - 1);
                            temp7.get(saldirilandusman).setAktif(false);
                            aktifdusmansayaci++;
                            System.out.println("Guclu sovalyen dusmanini zorlanmadan alt etti !");
                            bWriter2.append("Guclu sovalyen dusmanini zorlanmadan alt etti !\n");
                        } else if (temp6.get(konum).getSovalyetipi() == "guclu sovalye" && temp7.get(saldirilandusman).getaktif() == false) {//pasif dusmana birsey yapmadan gider
                            System.out.println("bu sovalyeyi zaten yendin ondan daha ne istiyorsun ?");
                        } else if (temp6.get(konum).getSovalyetipi() == "zayif sovalye" && temp7.get(saldirilandusman).getDusmantipi() == "guclu dusman") {//zayif sovalye guclu dusman ile savasirsa kaybeder
                            if (temp7.get(saldirilandusman).getaktif() == true) {//eger guclu dusman aktif ise;
                                System.out.println("guclu dusman zayif askerini yendi");
                                bWriter2.append("guclu dusman zayif askerini yendi\n");
                                temp6.get(konum).setAktif(false);
                                aktifsovalyesayaci++;
                            } else if (temp7.get(saldirilandusman).getaktif() == false) {//eger guclu dusman pasif ise ;
                                temp6.get(konum).setVurushakki(temp6.get(konum).getVurushakki() - 1);
                                System.out.println("zayif askerin guclu dusmanin lesinin yaninda zaman gecirdi. Kendisi hala iyi ama bos zaman gecirdigi icin 1 saldiri hakki kaybetti.");
                                bWriter2.append("zayif askerin guclu dusmanin lesinin yaninda zaman gecirdi. Kendisi hala iyi ama bos zaman gecirdigi icin 1 saldiri hakki kaybetti.\n");
                            }
                        } else if (temp6.get(konum).getSovalyetipi() == "zayif sovalye" && temp7.get(saldirilandusman).getDusmantipi() == "zayif dusman") {//zayif sovalye zayif dusmani yener
                            if (temp7.get(saldirilandusman).getaktif() == true) {//eger zayif dusman aktif ise ;
                                System.out.println("zayif sovalye  zayif dusmani yendi");
                                bWriter2.append("zayif sovalye  zayif dusmani yendi\n");
                                temp6.get(konum).setVurushakki(temp6.get(konum).getVurushakki() - 1);
                                temp7.get(saldirilandusman).setAktif(false);
                                aktifdusmansayaci++;
                            } else if (temp7.get(saldirilandusman).getaktif() == false) {//eger zayif dusman pasif ise ;
                                temp6.get(konum).setVurushakki(temp6.get(konum).getVurushakki() - 1);
                                System.out.println("zayif askerin zayif dusmanin lesinin yaninda zaman gecirdi. Kendisi hala iyi ama bos zaman gecirdigi icin 1 saldiri hakki kaybetti.");
                                bWriter2.append("zayif askerin zayif dusmanin lesinin yaninda zaman gecirdi. Kendisi hala iyi ama bos zaman gecirdigi icin 1 saldiri hakki kaybetti.\n");
                            }
                        }

                    }
                    if (temp6.get(konum).getVurushakki() == 0) {//karakter vurus hakkina sahip degilse ;
                        temp6.get(konum).setAktif(false);
                        aktifsovalyesayaci++;
                    }


                } else if (temp6.get(konum).getaktif() == false) {//karakter pasif ise
                    System.out.println("lutfen pasif sovalyelerinizi savastirmayin onlar da dinlenmeli");
                }
                if (aktifsovalyesayaci == temp6.size() && aktifdusmansayaci == temp7.size()) {
                    System.out.println("iki tarafta butun askerlerini kaybetti, oyun berabere.");
                    bWriter2.append("iki tarafta butun askerlerini kaybetti, oyun berabere.\n");
                    break;
                }
                if (aktifsovalyesayaci == temp6.size()) {
                    System.out.println("butun sovalyeler indirildi oyunu kaybettin.");
                    bWriter2.append("butun sovalyeler indirildi oyunu kaybettin.\n");
                    break;
                }
                if (aktifdusmansayaci == temp7.size()) {
                    System.out.println("butun dusmanlar indirildi oyunu kazandin.");
                    bWriter2.append("butun dusmanlar indirildi oyunu kazandin.\n");
                    break;
                }

            }
                bWriter2.close();
        }
    }
    }
    public static int getaktifdusmansayisi() {
        return dusmansayisi;
    }
}
