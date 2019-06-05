package com.app.hospital.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utilitario {
	
	
	public static String getActualTime() {
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 Date date = new Date();
		 return "".concat(dateFormat.format(date));
	}
	
}
