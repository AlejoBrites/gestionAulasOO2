package negocio;

import dao.EdificioDao;
import datos.Edificio;

public class EdificioAbm {
	private static EdificioAbm instancia = null; // Patrón Singleton

	private EdificioAbm() {
	}

	public static EdificioAbm getInstance() {
		if (instancia == null)
			instancia = new EdificioAbm();
		return instancia;
	}

	public Edificio traerEdificioYAulas(int idEdificio) {
		return EdificioDao.getInstance().traerEdificioYAulas(idEdificio);
	}
}
