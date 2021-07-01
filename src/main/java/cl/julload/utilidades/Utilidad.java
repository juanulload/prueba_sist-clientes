package cl.julload.utilidades;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidad {

	public void mostrarMensajes () {
		
	}
	
	public static void limpiezaPantalla() {
		System.out.println("\n \n \n \n \n \n \n \n \n \n \n Saliendo del Sistema \n");
		System.out.flush();

	}

	public static void tiempoEspera() {
		int i = 5;

		while (i >= 0) {

			System.out.println("Faltan " + i + " segundos.");
			--i;

			try {
				TimeUnit.SECONDS.sleep(1); // el "1" indica la cantidad de segundos que se modifica
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("¡Te has salvado!");
			}
		}

		System.out.println("Acaba de salir del Sistema!");
	}
	
	

	/*** Validación de RUT Chileno* algoritmo Modulo 11*/
	/**** Valida rut de la forma XXXXXXXX-X
	 */
	public static Boolean validaRut(String rut) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);
		if (matcher.matches() == false)
			return false;
		String[] stringRut = rut.split("-");
		return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
	}

	/*** Valida el dígito verificador */
	public static String dv(String rut) {
		Integer M = 0, S = 1, T = Integer.parseInt(rut);
		for (; T != 0; T = (int) Math.floor(T /= 10))
			S = (S + T % 10 * (9 - M++ % 6)) % 11;
		return (S > 0) ? String.valueOf(S - 1) : "k";
	
	}
}
