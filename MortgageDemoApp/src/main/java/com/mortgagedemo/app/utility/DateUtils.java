package com.mortgagedemo.app.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static String getTodaysDate() {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(todaysDate);
	}

	public static boolean isOfferDateIsBeforeSixMonths(String offerDate1) {
		boolean isOfferDateIsBeforeSixMonths = false;

		System.out.println("today : " + getTodaysDate());

		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, 6);

		Date dateAfterSixMonths = now.getTime();
		System.out.println("dateAfterSixMonths : " + formatter.format(dateAfterSixMonths));

		Date offerDate = null;
		try {
			offerDate = formatter.parse(offerDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (offerDate.before(dateAfterSixMonths)) {
			System.out.println(formatter.format(offerDate) + "isOfferDateIsBeforeSixMonths");
			isOfferDateIsBeforeSixMonths = true;
		}
		return isOfferDateIsBeforeSixMonths;
	}

	public static Date convertDateForComparison(String strDate) {
		Date offerDate = null;
		try {
			offerDate = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return offerDate;
	}

}
