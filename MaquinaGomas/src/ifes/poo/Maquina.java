package ifes.poo;

import ifes.poo.estados.ControleEstado;
import ifes.poo.estados.Disponivel;
import ifes.poo.estados.Esperando;
import ifes.poo.estados.Estado;
import ifes.poo.estados.Indisponivel;
import ifes.poo.estados.Processando;
import ifes.poo.goma.Goma;
import ifes.poo.goma.GomaLaranja;
import ifes.poo.goma.GomaMenta;
import ifes.poo.goma.GomaMorango;
import ifes.poo.goma.GomaUva;
import ifes.poo.menu.ControleMenu;
import ifes.poo.moeda.CincoCentavos;
import ifes.poo.moeda.CinquentaCentavos;
import ifes.poo.moeda.DezCentavos;
import ifes.poo.moeda.Moeda;
import ifes.poo.moeda.UmReal;
import ifes.poo.moeda.VinteCincoCentavos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Maquina {
	
	public final int QUANTIDADE_MAXIMA_GOMAS=100; 
	
	private ControleEstado controleEstado;
	//private ControleMenu controleMenu;
		
	private ArrayList<Goma> gomas;
	private ArrayList<Goma> sabores;
	
	private ArrayList<Moeda> dinheiro;
	private int dinheiroTotalObtido;
	private Moeda moedaAtual;
	
	
	public Maquina(){
		
		controleEstado = new ControleEstado();
		//controleMenu = new ControleMenu();
		//controleMenu.setEstadoMaquina(controleEstado.getEstadoAtual());
		
		gomas = new ArrayList<Goma>();
		sabores = definirSabores();
		
		dinheiro = new ArrayList<Moeda>();
		dinheiroTotalObtido=0;
	}
	
	public void Iniciar() throws IOException{
		int opcao=0;
		
		while(true){
			atualizarStatus();
			controleEstado.exibirMenu();
			opcao = controleEstado.getMenuAtual().escolherOpcao();
			controleEstado.getMenuAtual().limparTela();
			
			if(getNomeEstadoAtual().equals("INDISPONIVEL")){
				if(controleEstado.getMenuAtual().toString().contains("Administrativo")){
									
					if(opcao==1) retirarMoedas(); 
					
					else if(opcao==2) reporGomas();
					
					else if(opcao==3){					
						exibirEncerramento();
						break;
					}
				}
			}
			
			else if(getNomeEstadoAtual().equals("ESPERANDO")){
				if(opcao==1) controleEstado.avancarProximoEstado();
				
				else if(opcao==2) retirarMoedas(); 
				
				else if(opcao==3) reporGomas();
				
				else if(opcao==4){					
					exibirEncerramento();
					break;
				}
			}
			
			
		}
		
		/*
		while(true){			
			
			break;
		
			
			controleMenu.getMenuAtual().exibirMenu();
			
			
			if(controleMenu.getMenuAtual().toString().contains("Administrativo")){
				
				if(opcao==1) controleMenu.avancarProximoEstado();
				
				else if(opcao==2) retirarMoedas(); 
				
				else if(opcao==3) reporGomas();
				
				else if(opcao==4){ 
					exibirEncerramento();
					break;
				}
			}
			else if(controleMenu.getMenuAtual().toString().contains("Cliente")){
				
				if(opcao==1) controleMenu.avancarProximoEstado();
				
				else if(opcao==2) puxarAlavanca(); 
				
				else if(opcao==3) ejetarGoma();
				
				else if(opcao==4) controleMenu.voltarEstadoAnterior();
			}
			
			else if(controleMenu.getMenuAtual().toString().contains("Moedas")){
				
			if (opcao==1) inserirMoeda (new UmReal());
			
			else if (opcao==2) inserirMoeda(new CinquentaCentavos());
			
			else if (opcao==3) inserirMoeda(new VinteCincoCentavos());
			
			else if (opcao==4) inserirMoeda(new DezCentavos());
			
			else if (opcao==5) inserirMoeda(new CincoCentavos());
			
			else if(opcao==6) controleMenu.voltarEstadoAnterior(); 					
			}
		}
		*/
	}
			
	public void atualizarStatus(){
		
		if(controleEstado.getMenuAtual().toString().contains("Cliente")){
			controleEstado.atualizarStatus("GOMAS: "+gomas.size());
		}
		else if(controleEstado.getMenuAtual().toString().contains("Administrativo")){
			controleEstado.atualizarStatus("DINHEIRO: R$ "+dinheiro.size()+",00      GOMAS: "+gomas.size());
		}

	}
	
	public int retirarMoedas(){
		int valor = this.dinheiro.size();
		if(valor > 0){
			this.dinheiro.removeAll(this.dinheiro);
			exibirMensagem("R$ "+valor+",00 retirados com sucesso.");
		}
		else{
			exibirMensagem("Nenhuma quantia disponivel para retirar.");
		}
		systemPause();
		return valor;
	}
	
	private ArrayList<Goma> definirSabores(){
		ArrayList<Goma> sabores;
		sabores = new ArrayList<Goma>();
		sabores.add(new GomaMorango());
		sabores.add(new GomaUva());
		sabores.add(new GomaLaranja());
		sabores.add(new GomaMenta());
		return sabores; 
	}
	
	public void reporGomas(){
		if(getNomeEstadoAtual().equals("INDISPONIVEL")){
			controleEstado.avancarProximoEstado();
		}
		else{
			// Ainda vou ver o que tem que fazer se estiver em outro estado
			System.out.println("Não estava indisponivel.. tava"+controleEstado.getEstadoAtual().toString());
		}
		
		int sabor=0;
		for(int k=gomas.size(); k < QUANTIDADE_MAXIMA_GOMAS ; k++){
			sabor = new Random().nextInt(this.sabores.size())+1;
			switch(sabor){
			case 1:
				gomas.add((GomaMorango)sabores.get(0).clone());
				break;				
			
			case 2:
				gomas.add((GomaUva)sabores.get(1).clone());
				break;
				
			case 3:
				gomas.add((GomaLaranja)sabores.get(2).clone());
				break;
			
			case 4:
				gomas.add((GomaMenta)sabores.get(3).clone());
				break;
			}
		}
	}
		
	public void inserirMoeda(Moeda m){
		moedaAtual = m;
		
		if(m.getValor()<1){
			exibirMensagem("Moeda de R$ "+m.getValor()+" foi inserida.");
			ejetarMoeda();
		}
		else{
			exibirMensagem("Moeda de R$ "+m.getValor()+",00 foi inserida.");
			controleEstado.getMenuAtual().getMenuAnterior();
		}
		
		systemPause();
		controleEstado.avancarProximoEstado();
	}
	
	public void ejetarMoeda(){
		this.moedaAtual = null;
		controleEstado.avancarEstadoAlternativo();	
	}
	
	public void ejetarGoma(){
		//controleEstado.ava
	}
	
	public void puxarAlavanca(){
		controleEstado.avancarProximoEstado();
	}
	
	public void systemPause(){		
		System.out.print("\nPressione enter para prosseguir..");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		controleEstado.getMenuAtual().limparTela();
	}
	
	public Goma escolherGoma(){
		Random gerador = new Random();
		int numeroEscolhido = gerador.nextInt(gomas.size());
		Goma gomaEscolhida = gomas.get(numeroEscolhido);
		gomas.remove(numeroEscolhido);	
		systemPause();
		return gomaEscolhida;
	}
	
	public String getNomeEstadoAtual(){
		return controleEstado.getEstadoAtual().getNome();
	}
	
	public void exibirMensagem(String msg){
		System.out.println("Maquina >>> "+msg);
	}
	
	public void exibirEncerramento(){
		controleEstado.getMenuAtual().limparTela();
		System.out.println(" _________________________________________________________");
		System.out.println("|                                                         |");
		System.out.println("|        E N C E R R A N D O   O   S I S T E M A          |");
		System.out.println("|_________________________________________________________|");		
	}	
}
