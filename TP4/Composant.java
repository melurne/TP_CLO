/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public abstract class Composant implements Comparable<Composant> {
	
	public int compareTo(Composant c) {
		return this.getId().compareTo(c.getId()) ;
	}

	public String getId() {
		return super.toString(); // class@numero renvoye par Object
	}
	
	public String description() {
		return this.getId();
	}

	public abstract boolean getEtat() throws NonConnectedException;

	public String traceEtat() {
			try {
				return description() + " Etat : " + getEtat();
			} catch (NonConnectedException e) {
				return description() + " Etat : Composant non connecté";
			}
	}


	// NUL PAS BO
	void probe(SondesTable tableSondes) {
		if (this instanceof Porte2Entrees) {
			if (((Porte2Entrees)this).in1 instanceof Interrupteur) {
				((Porte2Entrees)this).in1 = tableSondes.getSonde((Interrupteur)((Porte2Entrees)this).in1, this, "in1");
			}
			if (((Porte2Entrees)this).in2 instanceof Interrupteur) {
				((Porte2Entrees)this).in2 = tableSondes.getSonde((Interrupteur)((Porte2Entrees)this).in2, this, "in2");
			}
		}
		else if (this instanceof Not) {
			if (((Not)this).in instanceof Interrupteur) {
				((Not)this).in = tableSondes.getSonde((Interrupteur)((Not)this).in, this, "in");
			}
		}
	}

	void unprobe(SondesTable tableSondes) {
		if (this instanceof Porte2Entrees) {
			if (((Porte2Entrees)this).in1 instanceof LazySonde) {
				((Porte2Entrees)this).in1 = tableSondes.getInterrupteur((LazySonde)((Porte2Entrees)this).in1);
			}
			if (((Porte2Entrees)this).in2 instanceof LazySonde) {
				((Porte2Entrees)this).in2 = tableSondes.getInterrupteur((LazySonde)((Porte2Entrees)this).in2);
			}
		}
		else if (this instanceof Not) {
			if (((Not)this).in instanceof LazySonde) {
				((Not)this).in = tableSondes.getInterrupteur((LazySonde)((Not)this).in);
			}
		}
	}

}
