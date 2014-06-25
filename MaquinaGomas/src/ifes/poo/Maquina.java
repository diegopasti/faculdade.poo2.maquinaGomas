package ifes.poo;

import ifes.poo.estados.Disponivel;
import ifes.poo.estados.Esperando;
import ifes.poo.estados.Estado;
import ifes.poo.estados.Indisponivel;
import ifes.poo.estados.Processando;
import ifes.poo.goma.Goma;
import ifes.poo.moeda.Moeda;

import java.util.ArrayList;
import java.util.Random;

public class Maquina {
	
	private Esperando estadoEsperando;
	private Disponivel estadoDisponivel;
	private Processando estadoProcessando;
	private Indisponivel estadoIndisponivel;
	private Estado estadoAtual;
	
	private ArrayList<Goma> gomas;
	private ArrayList<Moeda> moedas;
	private Moeda moedaAtual;
	
	
	public Maquina(){
		estadoDisponivel = new Disponivel();
		estadoEsperando = new Esperando();
		estadoIndisponivel = new Indisponivel();
		estadoProcessando = new Processando();		
		this.selecionarEstado(estadoEsperando);		
	}
	
	public void inserirMoeda(Moeda m){
		moedaAtual = m;
		estadoAtual.proximoEstado((Estado)estadoDisponivel);
		
		
		if(moedaAtual.getValor()==1){
			this.estadoAtual.proximoEstado((Estado) estadoDisponivel);	
		}
		else{
			// mantem-se no mesmo estado
			System.out.println("Erro! Moeda inválida");
		}		
	}
	
	public void ejetarMoeda(){
		
	}
	
	public Goma escolherGoma(){
		Random gerador = new Random();
		int numeroEscolhido = gerador.nextInt(gomas.size());
		Goma gomaEscolhida = gomas.get(numeroEscolhido);
		gomas.remove(numeroEscolhido);		
		return gomaEscolhida;
	}
	
	public void venderGoma(){
		
	}
	
	public void ejetarGoma(){
		
	}
	
	public void puxarAlavanca(){
		//this.estadoAtual.proximoEstado();
	}
	
	public void selecionarEstado(Estado estado){
		this.estadoAtual = estado;
	}
	
}
