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
public class Lector {
	
	public static final int NOT_VALID_INPUT=-1;

	public static long checkLong(String d) {

		try {
			long ret = Long.valueOf(d);
			if (ret < 0) {
				System.err.println("Debe ser un número positivo");
				return NOT_VALID_INPUT;
			}
			return ret;
		} catch (NumberFormatException e) {
			System.err.println("La entrada debe ser un número");
		}
		return NOT_VALID_INPUT;
	}

	public static double checkDouble(String d) {
		try {
			double ret = Double.valueOf(d);
			if (ret < 0) {
				System.err.println("Debe ser un número positivo");
				return NOT_VALID_INPUT;
			}
			return ret;
		} catch (NumberFormatException e) {
			System.err.println("La entrada debe ser un número");
		}
		return NOT_VALID_INPUT;
	}

	public static Date checkDate(String d, SimpleDateFormat formatter) {
		try {
			Date date = formatter.parse(d);


			String[] dateSplit=d.split("/");
			
			int day=Integer.parseInt(dateSplit[0]);
			int month=Integer.parseInt(dateSplit[1]);
			int year=Integer.parseInt(dateSplit[2]);
			
			if(day>31 || day<1)
			{
				System.err.println("Error en el día introducido");
				return null;
			}
			
			if(month>12 || month<1)
			{
				System.err.println("Error en el mes introducido");
				return null;
			}
			
			SimpleDateFormat yearF = new SimpleDateFormat("yyyy");
			if ((year < 1900) || year > Integer.valueOf(yearF.format(new Date(System.currentTimeMillis())))) {
				System.err.println("Error en el año introducido");
				return null;
			}
			System.out.println(formatter.format(date));
			return date;

		} catch (ParseException e) {
			System.err.println("Fecha introducida incorrecta. Recuerde que el formato es estricto.");
			return null;
		}
	}
	
	public static double checkPorc(String porcentaje)
	{
		double ret=checkDouble(porcentaje);
		if(ret!=NOT_VALID_INPUT)
		{
			if(ret<=100)
			{
				return ret;
			}
			System.err.println("El porcentaje debe estar comprendido entre 0 y 100");
		}
		return NOT_VALID_INPUT;
	}

}
