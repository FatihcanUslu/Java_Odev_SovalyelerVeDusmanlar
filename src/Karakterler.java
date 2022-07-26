public class Karakterler {
    private String ad;
    private int id;
    private int realid;
    private boolean aktif=true;
    public Karakterler(String ad,int id){
        this.ad=ad;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public int getRealid() {
        return realid;
    }

    public void setRealid(int realid) {
        this.realid = realid;
    }

    public boolean getaktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }
}
