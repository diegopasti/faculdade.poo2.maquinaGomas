package ifes.poo.estados;

import ifes.poo.goma.Goma;

public interface Estado {
	public void proximoEstado(Estado e);
	public void selecionarGoma(Goma g);
	public void getGomaSelecionada();
	public void ajuda();
}
