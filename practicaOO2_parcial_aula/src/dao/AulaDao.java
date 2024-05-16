package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Aula;

public class AulaDao extends Dao<Aula> {

	private static AulaDao instancia = null; // Patrón Singleton: valida que no se genere mas de una instancia
	// de un elemento que nosotros no queremos

	private AulaDao() {
	}

	public static AulaDao getInstance() {
		if (instancia == null)
			instancia = new AulaDao();
		return instancia;
	}

	public Aula traerAulaPorId(int idAula) throws HibernateException {
		Aula objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Aula a where a.idAula=:idAula";
			objeto = (Aula) session.createQuery(hql).setParameter("idAula", idAula).uniqueResult();
			Hibernate.initialize(objeto.getEdificio());
		} finally {
			session.close();
		}
		return objeto;
	}

}
