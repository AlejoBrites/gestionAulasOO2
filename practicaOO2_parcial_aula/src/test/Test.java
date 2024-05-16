package test;

import java.time.LocalDate;

import dao.AulaDao;
import dao.EdificioDao;
import datos.Aula;
import datos.Edificio;
import negocio.AulaAbm;
import negocio.EspacioAbm;

public class Test {

	private static EdificioDao edificioDao = EdificioDao.getInstance();
	private static AulaDao aulaDao = AulaDao.getInstance();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Edificio edificio = edificioDao.traerEdificioYAulas(1);
		Aula aula = aulaDao.traerAulaPorId(5);

		System.out.println("Caso de uso 1: ");
		System.out.println(edificio);

		System.out.println("Caso de uso 2: ");
		System.out.println(aula);

		LocalDate fecha1 = LocalDate.of(2022, 5, 1);
		System.out.println("Caso de uso 3: ");
		System.out.println(EspacioAbm.getInstance().traerEspacio(fecha1, 'M', aula));

		System.out.println("Caso de uso 4: ");

		try {
			EspacioAbm.getInstance().agregarEspacio(LocalDate.of(2022, 05, 01), 'M', aula, true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("Caso de uso 5: ");
		EspacioAbm.getInstance().agregarEspacioMes(05, 2022, 'M', AulaAbm.getInstance().traerAula(3));

	}

}
