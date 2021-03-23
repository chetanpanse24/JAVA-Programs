package com.bbi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EpochTimeStamp {

	static List<String> formatStrings = Arrays.asList("dd/MM/yyyy", "MM/dd/yyyy", "dd-MM-yyyy", "MM-dd-yyyy",
			"dd.MM.yyyy", "MM.dd.yyyy", "ddMMyyyy", "MMddyyyy");

	static Date tryParse(String dateString) {
		System.out.println("Input : " + dateString);
		for (String formatString : formatStrings) {
			try {

				Date da = new SimpleDateFormat(formatString).parse(dateString);

				return da;

			} catch (ParseException e) {
			}
		}

		return null;
	}

	static public void epochDateConvertion(Date dd) {
		long epoch1 = dd.getTime() / 1000;
		System.out.println("Output : " + epoch1);
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String strInput = scan.next();
		;

		try {
			String str = "01-01-1970";
			Date afterDate = new SimpleDateFormat("dd-MM-yyyy").parse(str);

			LocalDate localDate = LocalDate.now().plusDays(1);
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Date todayDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

			Date d = EpochTimeStamp.tryParse(strInput);
			if (d != null && (d.after(afterDate) && d.before(todayDate))) {
				epochDateConvertion(d);
			} else {
				d = null;
				d.getDate();
			}

		} catch (Exception e) {
			System.out.println("Output : Unable to convert the provided date");
		}
	}
}
