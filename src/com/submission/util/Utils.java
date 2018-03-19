package com.submission.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public static java.sql.Date getSqlTimeFrom() {
		return new java.sql.Date(new java.util.Date().getTime());
	}
	
	public static java.util.Date getTimeFromMysql(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}
	public static int calculateTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int day = 0;
		try {
			java.util.Date date= sdf.parse(time);
			java.util.Date currDate= sdf.parse(getTime());
			day=(int)(currDate.getTime()-date.getTime())/(24*60*60*1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return day;
	}
}
