public class LazySonde extends Sonde {
    
    protected boolean etat;
    protected boolean set = false;

    public LazySonde(Composant comp, String port) {
        super(comp, port);
    }

    public boolean getEtat() {
        if (set == false) {
            etat = super.getEtat();
            set = true;
        }
        return etat;
    }

    public void reset() {
        set = false;
    }
}
