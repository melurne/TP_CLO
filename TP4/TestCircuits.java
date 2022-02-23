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

	public static void test(Circuit circ) {
		System.out.println("Nomenclature :\n");
		System.out.println(circ.nomenclature());
		
		System.out.println("Description :\n");
		circ.description();

		System.out.println("Ins :\n");
		for (Interrupteur i : circ.getIns()) {
			System.out.println(i.getId());
		}

		System.out.println("Outs :\n");
		for (Vanne v : circ.getOuts()) {
			System.out.println(v.getId());
		}

		for (Interrupteur i : circ.getIns()) {
			i.on();
		}

		circ.probe();
		System.out.println("traceEtat probed:\n");
		circ.traceEtat();

		circ.resetSondes();
		System.out.println("traceEtat probed again:\n");
		circ.traceEtat();

		circ.unprobe();
		System.out.println("traceEtat unprobed:\n");
		circ.traceEtat();

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
		
		LazySonde s1 = new LazySonde(or1, "in1");
		//Connexions
		
		or1.setIn1(s1);
		or1.setIn2(i2);
		not1.setIn(securite);
		and1.setIn1(or1);
		and1.setIn2(not1);
		vanne1.setIn(and1);

		i1.on();
		i2.off();
		securite.off();

		Circuit circuit = new Circuit("test", composants);
		//Affichage
		
		test(circuit);

		System.out.println("Au revoir!");
	}
}