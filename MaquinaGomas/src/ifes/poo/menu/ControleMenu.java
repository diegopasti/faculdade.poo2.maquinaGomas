package ifes.poo.menu;

import ifes.poo.estados.Estado;

public class ControleMenu {
	
	private Menu menuAdministrativo;
	private Menu menuEscolherMoedas;
	private Menu menuCliente;
	private Menu menuAtual;
	private Estado estadoMaquina;
	
	public Menu getMenuAdministrativo() {
		return menuAdministrativo;
	}

	public Menu getMenuEscolherMoedas() {
		return menuEscolherMoedas;
	}

	public Menu getMenuCliente() {
		return menuCliente;
	}

	public ControleMenu(){
		menuAdministrativo = new MenuAdministrativo();
		menuEscolherMoedas = new MenuEscolherMoedas();
		menuCliente = new MenuCliente();
		configurarMenus();
	}
	
	public void setEstadoMaquina(Estado e){
		estadoMaquina = e;
		menuAdministrativo.setEstadoMaquina(estadoMaquina);
		menuCliente.setEstadoMaquina(estadoMaquina);
		menuEscolherMoedas.setEstadoMaquina(estadoMaquina);
	}

	public Menu getMenuAtual(){
		return menuAtual;
	}
	
	public void setMenuAtual(Menu m){
		menuAtual = m;
	}
	
	public void configurarMenus(){
				
		menuAdministrativo.setProximoMenu(menuCliente);
		menuAdministrativo.setMenuAnterior(null);
		
		menuCliente.setProximoMenu(menuEscolherMoedas);
		menuCliente.setMenuAnterior(menuAdministrativo);
		
		menuEscolherMoedas.setProximoMenu(null);
		menuEscolherMoedas.setMenuAnterior(menuCliente);
	}
	
	public void avancarProximoMenu(){
		if(menuAtual.getProximoMenu() != null){
			menuAtual.limparTela();
			menuAtual = (MenuPadrao) menuAtual.getProximoMenu();	
		}		
	}
	
	public void voltarMenuAnterior(){
		if(menuAtual.getMenuAnterior() != null){
			menuAtual.limparTela();
			menuAtual = (MenuPadrao) menuAtual.getMenuAnterior();	
		}
	}
}
