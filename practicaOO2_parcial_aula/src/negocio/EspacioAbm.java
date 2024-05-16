package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioAbm {

	private static EspacioAbm instancia = null; // Patrón Singleton

	private EspacioAbm() {
	}

	public static EspacioAbm getInstance() {
		if (instancia == null)
			instancia = new EspacioAbm();
		return instancia;
	}

	public Espacio traerEspacio(LocalDate fecha, char turno, Aula aula) {
		return EspacioDao.getInstance().traerEspacio(fecha, turno, aula);
	}

	public int agregarEspacio(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {

		Espacio espacioAux = traerEspacio(fecha, turno, aula);

		if (espacioAux != null) {
			throw new Exception("ERROR: El espacio ya existe en la base de datos");
		}

		espacioAux = new Espacio(fecha, turno, aula, libre);
		return EspacioDao.getInstance().agregar(espacioAux);
	}

	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) {
		LocalDate fecha = LocalDate.of(anio, mes, 1);
		Espacio espacio = new Espacio(fecha, turno, aula, true);
		EspacioDao.getInstance().agregarEspacioMes(espacio);
	}

}
