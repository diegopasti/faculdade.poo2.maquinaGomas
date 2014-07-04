package ifes.poo.estados;

import ifes.poo.menu.ControleMenu;

public interface Estado{
	public ControleMenu getControleMenu();
	public void setProximoEstado(Estado e);
	public void setEstadoAnterior(Estado e);
	public void setEstadoAlternativo(Estado e);
	public void setEstadoMaquina(Estado e);
	public Estado getProximoEstado();
	public Estado getEstadoAnterior();
	public Estado getEstadoAlternativo();
	public String getNome();
	public void atualizarStatus(String texto);

}
