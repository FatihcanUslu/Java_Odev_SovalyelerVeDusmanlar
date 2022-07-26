import java.util.Random;
public class Sans {
    private boolean iyisans;
    private boolean kotusans;
    private int sans;
    Random rand=new Random();
    public void sansAta(Sovalye s){
        int sans = rand.nextInt((2 - 0) + 1) + 0;
        s.setSans(sans);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
