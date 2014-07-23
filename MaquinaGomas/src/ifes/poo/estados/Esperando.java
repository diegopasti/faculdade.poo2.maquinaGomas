package ifes.poo.estados;

import ifes.poo.menu.ControleMenu;

public class Esperando extends EstadoPadrao {
	
	public Esperando(){
		setControleMenu(new ControleMenu());
		getControleMenu().setMenuAtual(getControleMenu().getMenuAdministrativo());
		getControleMenu().getMenuAdministrativo().addOpcao("I N I C I A R   I N T E R F A C E   C L I E N T E");
		getControleMenu().getMenuAdministrativo().addOpcao("R E T I R A R   M O E D A S");
		getControleMenu().getMenuAdministrativo().addOpcao("R E P O R   D E   G O M A S");
		getControleMenu().getMenuAdministrativo().addOpcao("D E S L I G A R");		
		
		getControleMenu().getMenuCliente().addOpcao("I N S E R I R   M O E D A");
		getControleMenu().getMenuCliente().addOpcao("V O L T A R");
		
		getControleMenu().getMenuEscolherMoedas().addOpcao("R$ 1,00");
		getControleMenu().getMenuEscolherMoedas().addOpcao("R$ 0,50");
		getControleMenu().getMenuEscolherMoedas().addOpcao("R$ 0,25");
		getControleMenu().getMenuEscolherMoedas().addOpcao("R$ 0,10");
		getControleMenu().getMenuEscolherMoedas().addOpcao("R$ 0,05");
		getControleMenu().getMenuEscolherMoedas().addOpcao("C A N C E L A R");	
		
	}
	
	public String getNome(){
		return "ESPERANDO";
	}
}
