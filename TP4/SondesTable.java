import java.util.HashMap;
import java.util.Map;

public class SondesTable {
    Map<Interrupteur, LazySonde> interrupteurToSonde = new HashMap<Interrupteur, LazySonde>();
    Map<LazySonde, Interrupteur> sondeToInterrupteur = new HashMap<LazySonde, Interrupteur>();

    Interrupteur getInterrupteur(LazySonde s) {
        return this.sondeToInterrupteur.get(s);
    }

    LazySonde getSonde(Interrupteur i, Composant cible, String entree) {
        if (this.interrupteurToSonde.get(i) == null) {
            LazySonde sonde = new LazySonde(cible, entree);
            this.interrupteurToSonde.put(i, sonde);
            this.sondeToInterrupteur.put(sonde, i);
            return sonde;
        }
        else {
            return this.interrupteurToSonde.get(i);
        }
    }

    void resetSondes() {
        for (LazySonde s : this.interrupteurToSonde.values()) {
            s.reset();
        }
    }

    void clear() {
        this.interrupteurToSonde.clear();
        this.sondeToInterrupteur.clear();
    }

}
