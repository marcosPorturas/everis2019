package com.app.hospital.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilitario {


	public static Date getActualDate() {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = Calendar.getInstance().toString();
		Date fecha = null;
		try {

		fecha = formatoDelTexto.parse(strFecha);

		} catch (ParseException ex) {
		ex.printStackTrace();
		}
		
		return fecha;
	}
	
	
	public static String getActualTime() {
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 Date date = new Date();
		 return "".concat(dateFormat.format(date));
	}
	
}
