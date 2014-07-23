package ifes.poo.estados;

import ifes.poo.menu.ControleMenu;

public class Processando extends EstadoPadrao{

	public Processando(){
		setControleMenu(new ControleMenu());
		getControleMenu().setMenuAtual(getControleMenu().getMenuCliente());		
		getControleMenu().getMenuCliente().addOpcao("R E T I R A R   G O M A");
	}
	
	public String getNome(){
		return "PROCESSANDO";
	}
}
