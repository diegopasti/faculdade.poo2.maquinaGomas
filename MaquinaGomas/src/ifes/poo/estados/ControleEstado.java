package ifes.poo.estados;

import ifes.poo.menu.Menu;

public class ControleEstado {
	
	private Estado estadoEsperando;
	private Estado estadoDisponivel;
	private Estado estadoProcessando;
	private Estado estadoIndisponivel;
	private Estado estadoAtual;
	
	public void exibirMenu(){
		estadoAtual.getControleMenu().getMenuAtual().exibirMenu();
	}

	public ControleEstado(){
		estadoEsperando = new Esperando();
		estadoDisponivel = new Disponivel();
		estadoProcessando = new Processando();
		estadoIndisponivel = new Indisponivel();
		configurarEstados();
	}
	
	public void configurarEstados(){		
		setEstadoAtual(estadoIndisponivel);
				
		estadoIndisponivel.setProximoEstado(estadoEsperando);
		
		estadoDisponivel.setProximoEstado(estadoProcessando);
		estadoDisponivel.setEstadoAlternativo(estadoEsperando);
		
		estadoProcessando.setProximoEstado(estadoEsperando);
		estadoProcessando.setEstadoAlternativo(estadoIndisponivel);	
		
	}
	
	public void avancarProximoEstado(){
		setEstadoAtual((Estado) estadoAtual.getProximoEstado());
	}
	
	public void avancarEstadoAlternativo(){
		setEstadoAtual((Estado) estadoAtual.getEstadoAlternativo());
	}
	
	public void voltarEstadoAnterior(){
		setEstadoAtual((Estado) estadoAtual.getEstadoAnterior());
	}
	
	public Menu getMenuAtual(){
		return getEstadoAtual().getControleMenu().getMenuAtual();
	}
	
	public Estado getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(Estado e) {
		estadoAtual = e;
		estadoIndisponivel.setEstadoMaquina(estadoAtual);
		estadoDisponivel.setEstadoMaquina(estadoAtual);		
		estadoEsperando.setEstadoMaquina(estadoAtual);
		estadoProcessando.setEstadoMaquina(estadoAtual);
	}
	
	public String getNomeEstadoAtual(){
		return getEstadoAtual().getNome();
	}
	
	public void atualizarStatus(String texto){
		getEstadoAtual().atualizarStatus(texto);
	}

	

}
