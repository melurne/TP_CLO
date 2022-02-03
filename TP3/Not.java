/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public class Not extends Porte {
	
	protected Composant in;
	
	public void setIn(Composant comp) {
		
		in = comp;
		
	}

	public String description() {
		
		return super.description() + " in1: " + (in == null ? "not connected" : in.getId());

	}
	
	public boolean getEtat() throws NonConnectedException {
		if (in == null) {
			throw new NonConnectedException();
		}
		else {
			return !in.getEtat();
		}
	}
	
}