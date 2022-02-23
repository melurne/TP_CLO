import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Circuit {
    String nom;
    List<Composant> composants = new ArrayList<Composant>();
    protected SondesTable tableSondes = new SondesTable();

    public Circuit(String nom, Composant[] cps) {
        this.nom = nom;
        this.composants.addAll(Arrays.asList(cps));
        Collections.sort(composants);
    }

    public List<String> nomenclature() {
        List<String> output = new ArrayList<String>();
        
        for (Composant c : composants) {
            output.add(c.getId());
        }

        return output;
    }

    public void description() {
        String desc = this.nom + " : ";

        for (Composant c : composants) {
            desc += c.description() + "; ";
        }

        System.out.println(desc);
    }

    public void traceEtat() {
        for (Composant comp : composants) {
			System.out.println(comp.traceEtat());
		}
    }

    public List<Interrupteur> getIns() {
        List<Interrupteur> output = new ArrayList<Interrupteur>();
        
        for (Composant c : composants) {
            if (c instanceof Interrupteur) {
                output.add((Interrupteur)c);
            }
        }
        
        return output;
    }

    public List<Vanne> getOuts() {
        List<Vanne> output = new ArrayList<Vanne>();
        
        for (Composant c : composants) {
            if (c instanceof Vanne) {
                output.add((Vanne)c);
            }
        }
        
        return output;
    }
    
    public void probe() {
        for (Composant c : composants) {
            c.probe(this.tableSondes);
        }
    }

    public void resetSondes() {
        tableSondes.resetSondes();
    }

    public void unprobe() {
        for (Composant c : composants) {
            c.unprobe(this.tableSondes);
        }
        tableSondes.clear();
    }

}
