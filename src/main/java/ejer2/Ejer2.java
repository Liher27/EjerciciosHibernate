package ejer2;

import java.text.ParseException;
import java.util.Scanner;

import ejer2.logic.HibernateManager2;

public class Ejer2 {

	public static void main(String[] args) {
		try {
			new Ejer2().startMenu();
		} catch (ParseException e) {
		}
	}

	private void startMenu() throws ParseException {
		callMenu();
		Scanner teclado = new Scanner(System.in);
		HibernateManager2 manager = new HibernateManager2();
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
		System.out.println("1- Insertar un nuevo departamento con nombre de INFORMÁTICA y localización de Bilbao.");
		System.out.println("");
		System.out.println("2- Insertar un empleado de informática que sea DIRECTOR y con salario de 2300, su fecha de incorporación la actual y tenga como una comisión de 1000.");
		System.out.println("");
		System.out.println("3- Modificar el salario de GIL a 1300 y su fecha de alta a ayer.");
		System.out.println("");
		System.out.println("4- Eliminar los empleados del departamento situado en MADRID.");
		System.out.println("");
		System.out.println("5- Eliminar un empleado del departamento de CONTABILIDAD cuyo salario sea el mayor de ese departamento.");
	}

}
