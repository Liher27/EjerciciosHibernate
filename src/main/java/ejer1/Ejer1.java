package ejer1;

import java.text.ParseException;
import java.util.Scanner;

import ejer1.logic.HibernateManager1;

public class Ejer1 {

	public static void main(String[] args) {
		try {
			new Ejer1().startMenu();
		} catch (ParseException e) {
		}
	}

	private void startMenu() throws ParseException {
		callMenu();
		Scanner teclado = new Scanner(System.in);
		HibernateManager1 manager = new HibernateManager1();
		int opcion = 0;
		do {
			opcion = teclado.nextInt();
			if (opcion != 0) {
				switch (opcion) {
				case 1:
					manager.ejer1();
					break;
				case 2:
					manager.ejer2();
					break;
				case 3:
					manager.ejer3();
					break;
				case 4:
					manager.ejer4();
					break;
				case 5:
					manager.ejer5();
					break;
				case 6:
					manager.ejer6();
					break;
				case 7:
					manager.ejer7();
					break;
				case 8:
					manager.ejer8();
					break;
				default:
					System.out.println("ADIOS!!!");
					break;
				}
			}
		} while (opcion != 0);
		teclado.close();
	}

	private void callMenu() {
		System.out.println("ELIGE TU OPCION:");
		System.out.println("");
		System.out.println("1- Mostrar los siguientes campos de los empleados del departamento 10...");
		System.out.println("");
		System.out.println("2- Mostrar los siguientes campos del empleado con el máximo salario...");
		System.out.println("");
		System.out.println("3- Visualiza los datos del departamento Contabilidad y Investigación");
		System.out.println("");
		System.out.println("4- Empleados cuyo número de departamento sea de Contabilidad y el oficio DIRECTOR");
		System.out.println("");
		System.out.println("5- Empleados cuya fecha de alta es 1990-12-17");
		System.out.println("");
		System.out.println("6- Empleados que tengan mejor sueldo y que sean del departamento Madrid.");
		System.out.println("");
		System.out.println("7- Salario del director del empleado que más gana en comisión.");
		System.out.println("");
		System.out.println("8- Fecha de alta del empleado que más salario tiene en Barcelona.");
	}

}
