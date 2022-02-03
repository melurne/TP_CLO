/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public class Vanne extends Composant {
	
	protected Composant in;
	
	public void setIn(Composant comp) {
		
		in = comp;
		
	}

	public boolean getEtat() throws NonConnectedException {
		if (in == null) {
			throw new NonConnectedException();
		}
		else {
			return in.getEtat();
		}
	}
	
}