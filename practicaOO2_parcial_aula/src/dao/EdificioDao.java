package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Edificio;

public class EdificioDao extends Dao<Edificio> {

	private static EdificioDao instancia = null; // Patrón Singleton: valida que no se genere mas de una instancia
	// de un elemento que nosotros no queremos

	private EdificioDao() {
	}

	public static EdificioDao getInstance() {
		if (instancia == null)
			instancia = new EdificioDao();
		return instancia;
	}

	public Edificio traerEdificioYAulas(int idEdificio) throws HibernateException {
		Edificio objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Edificio e where e.idEdificio=:idEdificio";
			objeto = (Edificio) session.createQuery(hql).setParameter("idEdificio", idEdificio).uniqueResult();
			Hibernate.initialize(objeto.getAulas());
		} finally {
			session.close();
		}
		return objeto;
	}

}
