package ifes.poo.estados;

import ifes.poo.menu.ControleMenu;

public class EstadoPadrao implements Estado {

	protected Estado estadoAnterior=null;
	protected Estado estadoAlternativo=null;
	protected Estado proximoEstado=null;
	protected ControleMenu controleMenu=null;
	
	
	@Override
	public void setProximoEstado(Estado e) {
		proximoEstado = e;		
	}

	@Override
	public void setEstadoAnterior(Estado e) {
		estadoAnterior = e;
	}

	@Override
	public Estado getProximoEstado() {
		return proximoEstado;
	}

	public void setControleMenu(ControleMenu controleMenu) {
		this.controleMenu = controleMenu;
	}

	@Override
	public Estado getEstadoAnterior() {
		return estadoAnterior;
	}
	
	public Estado getEstadoAlternativo(){
		return estadoAlternativo;
	}
	
	@Override
	public void setEstadoAlternativo(Estado e){
		estadoAlternativo = e;
	}

	@Override
	public ControleMenu getControleMenu() {
		return controleMenu;
	}

	@Override
	public void setEstadoMaquina(Estado e) {
		getControleMenu().setEstadoMaquina(e);		
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public void atualizarStatus(String texto) {
		getControleMenu().getMenuAtual().setStatus(texto);
	}

}
