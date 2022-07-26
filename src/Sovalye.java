public class Sovalye extends Karakterler{
    private boolean durum=false;
    private int vurushakki=1;
    private int sans;
    private String sovalyetipi="null";

    public Sovalye(String ad,int id){
        super(ad,id);
    }

    public int getVurushakki() {
        return vurushakki;
    }

    public int getSans() {
        return sans;
    }

    public void setSans(int sans) {
        this.sans = sans;
    }

    public void setVurushakki(int vh) {
        this.vurushakki = vh;
    }

    public void setSovalyetipi(String sovalyetipi) {
        this.sovalyetipi = sovalyetipi;
    }

    public String getSovalyetipi() {
        return sovalyetipi;
    }

    public void vur(Dusman d){

    }

    @Override
    public String toString() {
        return ("sovalye adi:"+getAd()+"\n"+"sovalye id:"+getId()+"\n"+"sovalye gercek id:"+getRealid()+"\n"+"sovalye tipi:"+getSovalyetipi()+"\n"+"sovalye sansi:"+getSans()+"\n"+"sovalye vurus hakki:"+getVurushakki()+"\n"+"**********************************************************************\n");
    }

}
