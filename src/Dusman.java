public class Dusman extends Karakterler{
    private boolean durum;
    private String dusmantipi;
    public Dusman(String ad,int id){
        super(ad,id);
    }

    public void setDusmantipi(String dusmantipi) {
        this.dusmantipi = dusmantipi;
    }

    public String getDusmantipi() {
        return dusmantipi;
    }

    @Override
    public String toString() {
        return ("dusman adi:"+getAd()+"\n"+"dusman id:"+getId()+"\n"+"dusman gercek id:"+getRealid()+"\n"+"dusman tipi:"+getDusmantipi()+"\n"+"**********************************************************************\n");
    }
}
