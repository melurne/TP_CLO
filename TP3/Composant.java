/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public abstract class Composant {
	
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
}