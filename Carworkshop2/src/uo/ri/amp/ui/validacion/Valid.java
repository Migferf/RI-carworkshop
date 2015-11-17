package uo.ri.amp.ui.validacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Validaciones para todos los campos introducidos por el usuario que lo
 * requieran. No se valida la lógica de negocio.
 * 
 * @author Miguel Fernández Fuentes
 *
 */
public class Valid {

	public static boolean checkLong(String d) {

		try {
			double ret = Long.valueOf(d);
			if (ret < 0) {
				System.err.println("Debe ser un número positivo");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.err.println("La entrada debe ser un número");
		}
		return false;
	}

	public static boolean checkDouble(String d) {
		try {
			double ret = Double.valueOf(d);
			if (ret < 0) {
				System.err.println("Debe ser un número positivo");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.err.println("La entrada debe ser un número");
		}
		return false;
	}

	public static Date checkDate(String d, SimpleDateFormat formatter) {
		try {
			Date date = formatter.parse(d);
			System.out.println(formatter.format(date));

			SimpleDateFormat yearF = new SimpleDateFormat("yyyy");
			int year = Integer.valueOf(yearF.format(date));
			if ((year < 1900) || year > Integer.valueOf(yearF.format(new Date(System.currentTimeMillis())))) {
				System.err.println("Error en el año introducido");
				return null;
			}

			SimpleDateFormat monthF = new SimpleDateFormat("MM");
			int month = Integer.valueOf(monthF.format(date));
			if (month < 1 || month > 12) {
				System.err.println("Error en el mes introducido");
				return null;
			}

			SimpleDateFormat dayF = new SimpleDateFormat("dd");
			int day = Integer.valueOf(dayF.format(date));
			if (day < 1 || day > 31) {
				System.err.println("Error en el día introducido");
				return null;
			}

			return date;

		} catch (ParseException e) {
			System.err.println("Fecha introducida incorrecta. Recuerde que el formato es estricto.");
			return null;
		}
	}
	
	public static boolean checkPorc(String porcentaje)
	{
		if(Valid.checkDouble(porcentaje))
		{
			if(Double.valueOf(porcentaje)<=100)
			{
				return true;
			}
			System.err.println("El porcentaje debe estar comprendido entre 0 y 100");
		}
		return false;
	}

}
