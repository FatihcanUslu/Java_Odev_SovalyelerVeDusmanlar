import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Txtoyunverisi extends OyunVerisi{
    public void kayitverileriniyukle() throws IOException {
        File infosovalye = new File("veriler/sovalyeler.txt");
        if(!infosovalye.exists()){
            infosovalye.createNewFile();
        }


        FileWriter fileWriter = new FileWriter(infosovalye, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);

        for(int i =0;i<OyunVerisi.getSovalyeler().size();i++){
            bWriter.write(OyunVerisi.getSovalyeler().get(i).toString());
        }

        bWriter.close();


        File infodusmanlar = new File("veriler/dusmanlar.txt");
        if(!infodusmanlar.exists()){
            infodusmanlar.createNewFile();
        }


        FileWriter fileWriter1 = new FileWriter(infodusmanlar, false);
        BufferedWriter bWriter1 = new BufferedWriter(fileWriter1);

        for(int i =0;i<OyunVerisi.getdusmanlar().size();i++){
            bWriter1.write(OyunVerisi.getdusmanlar().get(i).toString());
        }

        bWriter1.close();

    }
    public void oyunverileriniyukle() throws IOException {
        File oyunkaydi = new File("veriler/oyunkaydi.txt");
        if(!oyunkaydi.exists()){
            oyunkaydi.createNewFile();
        }


        FileWriter fileWriter2 = new FileWriter(oyunkaydi, false);
        BufferedWriter bWriter2 = new BufferedWriter(fileWriter2);
        bWriter2.close();

    }

}
