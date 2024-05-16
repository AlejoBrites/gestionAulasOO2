package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaAbm {
	private static AulaAbm instancia = null; // Patrón Singleton

	private AulaAbm() {
	}

	public static AulaAbm getInstance() {
		if (instancia == null)
			instancia = new AulaAbm();
		return instancia;
	}

	public Aula traerAula(int idAula) {
		return AulaDao.getInstance().traerAulaPorId(idAula);
	}

}
