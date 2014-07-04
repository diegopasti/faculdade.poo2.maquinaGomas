package ifes.poo.goma;

public class GomaMorango extends GomaAbstrata implements Goma{

	private static final String sabor = "Morango";  
	
	@Override
	public String getSabor() {
		return sabor;
	}
}
