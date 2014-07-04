package ifes.poo.estados;

import ifes.poo.menu.ControleMenu;


public class Indisponivel extends EstadoPadrao {	

	public Indisponivel(){
		setControleMenu(new ControleMenu());
		getControleMenu().getMenuAdministrativo().addOpcao("R E T I R A R   M O E D A S");
		getControleMenu().getMenuAdministrativo().addOpcao("R E P O R   D E   G O M A S");
		getControleMenu().getMenuAdministrativo().addOpcao("D E S L I G A R");
	}

	public String getNome(){
		return "INDISPONIVEL";
	}
}
