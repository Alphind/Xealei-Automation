package org;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TB {

	public static void main(String[] args) {
		
	LocalDateTime currentDateYearMonth = LocalDateTime.now(ZoneId.of("Pacific/Tongatapu"));
	LocalDateTime plusHour = currentDateYearMonth.plusHours(1);
	DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ssa");
	String DateAsPerGiven = currentDateYearMonth.format(ofPattern).toUpperCase();
	System.out.println(DateAsPerGiven);
}
}
