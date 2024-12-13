package ejer2.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import config.Departamentos;
import config.Empleados;

import utils.HibernateUtils;

public class HibernateManager2 {

	SessionFactory sessionFactory = null;
	Session session = null;

	public HibernateManager2() {
		sessionFactory = HibernateUtils.getSessionFactory();

		session = sessionFactory.openSession();
	}

	public void ejer1() {
//		Insertar un nuevo departamento con nombre de INFORMÁTICA y localización de Bilbao.
		Transaction tx = session.beginTransaction();

		Departamentos departamento = new Departamentos();

		departamento.setDnombre("INFORMATICA");
		departamento.setLoc("Bilbao");
		
		session.save(departamento);

		tx.commit();
		System.out.println("Insertado con exito!");
	}

	public void ejer2() {
//		Insertar un empleado de informática que sea DIRECTOR y con salario de 2300, su fecha de incorporación la actual y tenga como una comisión de 1000.
		Transaction tx = session.beginTransaction();

		Empleados empleado = new Empleados();

		Departamentos departamento = new Departamentos();

		departamento.setDnombre("INFORMATICA");
		
		empleado.setDepartamentos(departamento);
		
		empleado.setSalario((float) 2300);
		
		session.save(empleado);

		tx.commit();
		System.out.println("Insertado con exito!");
	}

	public void ejer3() {
//		Modificar el salario de GIL a 1300 y su fecha de alta a ayer.

	}

	public void ejer4() {
//		Eliminar los empleados del departamento situado en MADRID.
	}

	public void ejer5() throws ParseException {
//		Eliminar un empleado del departamento de CONTABILIDAD cuyo salario sea el mayor de ese departamento.
	}

}
