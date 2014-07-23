package ifes.poo.estados;

import ifes.poo.menu.ControleMenu;

public class Disponivel extends EstadoPadrao {
	
	public Disponivel(){
		setControleMenu(new ControleMenu());
		
		getControleMenu().setMenuAtual(getControleMenu().getMenuCliente());
				
		getControleMenu().getMenuCliente().addOpcao("P U X A R   A L A V A N C A");
	
	}
	
	public String getNome(){
		return "DISPONIVEL";
	}
}
