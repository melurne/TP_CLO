/**
 *
 * @author Bernard.Carre@polytech-lille.fr
 */

public class TestCircuits {
	public static void printIds(Composant[] composants) {
		for (Composant comp : composants) {
			System.out.println(comp.description());
		}
	}

	public static void traceEtats(Composant[] composants) {
		for (Composant comp : composants) {
			System.out.println(comp.traceEtat());
		}
	}

	public static void main(String[] args) {
		//Construction
		Composant[] composants = new Composant[7];
		Interrupteur i1 = new Interrupteur();
		composants[0] = i1;
		Interrupteur i2 = new Interrupteur();
		composants[1] = i2;
		Interrupteur securite = new Interrupteur();
		composants[2] = securite;
		
		Or or1 = new Or();
		composants[3] = or1;
		Not not1 = new Not();
		composants[4] = not1;
		And and1 = new And();
		composants[5] = and1;

		Vanne vanne1 = new Vanne();
		composants[6] = vanne1;
		
		//Connexions
		
		or1.setIn1(new LazySonde(or1, "in1"));
		or1.setIn2(i2);
		not1.setIn(securite);
		and1.setIn1(or1);
		and1.setIn2(not1);
		vanne1.setIn(and1);

		i1.on();
		i2.on();
		securite.off();
		
		//Affichage

		//printIds(composants);
		//try {
		traceEtats(composants);
		/*} catch (NonConnectedException e) {
			System.out.println("Au moins un composant n'est pas connecté");
		}*/

		System.out.println("Au revoir!");
	}
}