package ejer1.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import config.Departamentos;
import config.Empleados;

import utils.HibernateUtils;

public class HibernateManager1 {

	SessionFactory sessionFactory = null;
	Session session = null;

	public HibernateManager1() {
		sessionFactory = HibernateUtils.getSessionFactory();

		session = sessionFactory.openSession();
	}

	public void ejer1() {
		String query = "from Empleados as e where e.departamentos.deptNo=10";
		Query<Empleados> queryResult = session.createQuery(query);

		List<Empleados> results = queryResult.list();

		for (int i = 0; i < results.size(); i++) {

			Empleados emp = results.get(i);

			System.out.println("--------- EMPLEADO " + (i + 1) + " ---------");

			System.out.println("Apellido");
			System.out.println(emp.getApellido());

			System.out.println("");
			System.out.println("Oficio");
			System.out.println(emp.getOficio());

			System.out.println("");
			System.out.println("Salario");
			System.out.println(emp.getSalario());
		}

	}

	public void ejer2() {
		String query = "from Empleados as e order by salario desc";
		Query<Empleados> queryResult = session.createQuery(query);
		queryResult.setMaxResults(1);
		Empleados empleado = queryResult.uniqueResult();

		System.out.println("Apellido");
		System.out.println(empleado.getApellido());

		System.out.println("");
		System.out.println("Salario");
		System.out.println(empleado.getSalario());

		System.out.println("");
		System.out.println("Departamento");
		System.out.println(empleado.getDepartamentos().getDnombre());
	}

	public void ejer3() {
//		Visualiza los datos del departamento Contabilidad y Investigación
		String query = "from Departamentos as d where dnombre=:dNombreCont OR dnombre=:dNombreInv";
		Query<Departamentos> queryResult = session.createQuery(query);
		queryResult.setParameter("dNombreCont", "CONTABILIDAD");
		queryResult.setParameter("dNombreInv", "INVESTIGACION");

		List<Departamentos> results = queryResult.list();

		for (int i = 0; i < results.size(); i++) {

			Departamentos departamentos = results.get(i);

			System.out.println("--------- DEPARTAMENTO " + departamentos.getDnombre() + " ---------");

			System.out.println("");
			System.out.println("LOCALIDAD");
			System.out.println(departamentos.getLoc());

			System.out.println("");
			System.out.println("NUMDEPAR");
			System.out.println(departamentos.getDeptNo());

			System.out.println("");
			System.out.println("NUMERO DE EMPLEADOS");
			System.out.println(departamentos.getEmpleadoses().size());
		}

	}

	public void ejer4() {
//		Empleados cuyo número de departamento sea de Contabilidad y el oficio DIRECTOR
		String query = "from Empleados as e where e.departamentos.dnombre=:dNombreCont AND e.oficio=:oficio";
		Query<Empleados> queryResult = session.createQuery(query);
		queryResult.setParameter("dNombreCont", "CONTABILIDAD");
		queryResult.setParameter("oficio", "DIRECTOR");

		List<Empleados> results = queryResult.list();

		for (int i = 0; i < results.size(); i++) {

			Empleados empleado = results.get(i);

			System.out.println("--------- DEPARTAMENTO " + (i + 1) + " ---------");

			System.out.println("");
			System.out.println("APELLIDO ");
			System.out.println(empleado.getApellido());

			System.out.println("");
			System.out.println("SALRIO");
			System.out.println(empleado.getSalario());
		}
	}

	public void ejer5() throws ParseException {
//		Empleados cuya fecha de alta es 1990-12-17
		String query = "from Empleados as e where e.fechaAlt=:fechaAlta";
		Query<Empleados> queryResult = session.createQuery(query);
		queryResult.setParameter("fechaAlta", (Date) new SimpleDateFormat("yyyy-MM-dd").parse("1990-12-17"));

		List<Empleados> results = queryResult.list();

		for (int i = 0; i < results.size(); i++) {

			Empleados empleado = results.get(i);

			System.out.println("--------- EMPLEADO " + (i + 1) + " ---------");

			System.out.println("");
			System.out.println("APELLIDO ");
			System.out.println(empleado.getApellido());

			System.out.println("");
			System.out.println("SALRIO");
			System.out.println(empleado.getSalario());
		}

	}

	public void ejer6() {
//		Empleados que tengan mejor sueldo y que sean del departamento Madrid.
		String query = "from Empleados as e where e.departamentos.loc=:dLocMadrid order by salario desc";
		Query<Empleados> queryResult = session.createQuery(query);
		queryResult.setMaxResults(5);
		queryResult.setParameter("dLocMadrid", "MADRID");
		List<Empleados> results = queryResult.list();

		for (int i = 0; i < results.size(); i++) {

			Empleados empleado = results.get(i);

			System.out.println("--------- EMPLEADO " + (i + 1) + " ---------");

			System.out.println("");
			System.out.println("APELLIDO ");
			System.out.println(empleado.getApellido());

			System.out.println("");
			System.out.println("SALRIO");
			System.out.println(empleado.getSalario());
		}
	}

	public void ejer7() {
//		Salario del director del empleado que más gana en comisión.
		String query = "from Empleados as e where e.dir is null order by comision desc";
		Query<Empleados> queryResult = session.createQuery(query);
		queryResult.setMaxResults(1);
		Empleados empleado = (Empleados) queryResult.uniqueResult();
		System.out.println("SALARIO ");
		System.out.println(empleado.getSalario());
	}

	public void ejer8() {
//		Fecha de alta del empleado que más salario tiene en Barcelona
		String query = "from Empleados as e where e.departamentos.loc=:dLocBarcelona order by salario desc";
		Query<Empleados> queryResult = session.createQuery(query);
		queryResult.setParameter("dLocBarcelona", "BARCELONA");
		queryResult.setMaxResults(1);
		
		Empleados empleado = (Empleados) queryResult.uniqueResult();
		System.out.println("");
		System.out.println("APELLIDO ");
		System.out.println(empleado.getApellido());
		System.out.println("");
		System.out.println("SALRIOs ");
		System.out.println(empleado.getSalario());
	}

}
