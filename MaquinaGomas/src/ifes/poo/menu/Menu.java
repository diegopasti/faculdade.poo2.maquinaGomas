package ifes.poo.menu;

import ifes.poo.estados.Estado;

import java.util.ArrayList;

public interface Menu {

	public void exibirMenu();
		
	public int escolherOpcao();
	
	public void limparTela();
	
	public void setEstadoMaquina(Estado e);
	
	public void addOpcao(String opcao);
	
	public ArrayList<String> getOpcoes();
	
	public void setProximoMenu(Menu m);
	
	public Menu getProximoMenu();
	
	public void setMenuAnterior(Menu m);
	
	public Menu getMenuAnterior();
	
	public void setStatus(String texto);
	

}
