package dao;

import java.time.LocalDate;

import org.hibernate.Hibernate;

import datos.Aula;
import datos.Espacio;

public class EspacioDao extends Dao<Espacio> {

	private static EspacioDao instancia = null; // Patrón Singleton: valida que no se genere mas de una instancia
	// de un elemento que nosotros no queremos

	private EspacioDao() {
	}

	public static EspacioDao getInstance() {
		if (instancia == null)
			instancia = new EspacioDao();
		return instancia;
	}

	public Espacio traerEspacio(LocalDate fecha, char turno, Aula aula) {

		Espacio objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Espacio e inner join fetch e.aula a where e.fecha=:fecha and e.turno=:turno and e.aula.idAula =:idAula ";
			objeto = (Espacio) session.createQuery(hql).setParameter("fecha", fecha).setParameter("turno", turno)
					.setParameter("idAula", aula.getIdAula()).uniqueResult();
			Hibernate.initialize(objeto.getAula().getEdificio());
		} finally {
			session.close();
		}

		return objeto;
	}

	public void agregarEspacioMes(Espacio espacio) {

		LocalDate fechaInicio = espacio.getFecha();

		for (int i = 1; i <= fechaInicio.lengthOfMonth(); i++) {
			agregar(espacio);
			LocalDate fechaActual = fechaInicio.plusDays(i);
			espacio.setFecha(fechaActual);

		}

	}

}
