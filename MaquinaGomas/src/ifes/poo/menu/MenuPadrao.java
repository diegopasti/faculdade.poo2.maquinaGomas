package ifes.poo.menu;

import ifes.poo.estados.Estado;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPadrao implements Menu{

protected ArrayList<String> opcoes;
protected Menu proximoMenu;
protected Menu menuAnterior;
protected Estado estadoMaquina;
protected String status;


	@Override
	public void exibirMenu() {
		exibirTitulo();
		exibirOpcoes();		
	}
	
	private void exibirTitulo() {
		System.out.println(" __________________________________________________________");
		System.out.printf("|%-34s  %22s|\n",status,"ESTADO: "+estadoMaquina.getNome());
		System.out.println("|                                                          |");
		System.out.println("|              M A Q U I N A   D E   G O M A S             |");
		System.out.println("|                                                          |");
		System.out.println("|__________________________________________________________|");
	}
	
	
		
	public void exibirOpcoes(){
		System.out.println("|                                                          |");
		for(int k=1;k<=opcoes.size();k++){
			System.out.printf("| "+k+" -  %-51s |\n",opcoes.get(k-1));	
		}
		System.out.println("|__________________________________________________________|");
	}
	
	
	
	@Override
	public int escolherOpcao() {
		int opt=0;
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		
		while(true){
			System.out.print("  DIGITE A OPCAO DESEJADA: ");
			opt = leitor.nextInt();
			
			if(opt>0 && opt<=opcoes.size()){
				break;				
			}
		}
		return opt;
	}

	public void limparTela() {
		for(int k=0;k<40;k++){
			System.out.println("");
		}
	}


	@Override
	public void addOpcao(String opcao) {
		opcoes.add(opcao);		
	}

	@Override
	public ArrayList<String> getOpcoes() {
		return opcoes;
	}

	@Override
	public void setEstadoMaquina(Estado e) {
		estadoMaquina = e;		
	}

	@Override
	public void setProximoMenu(Menu m) {
		proximoMenu = m;		
	}

	@Override
	public Menu getProximoMenu() {
		return proximoMenu;
	}

	@Override
	public void setMenuAnterior(Menu m) {
		menuAnterior = m;	
	}

	@Override
	public Menu getMenuAnterior() {
		return menuAnterior;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String texto) {
		status = texto;
	}

}
