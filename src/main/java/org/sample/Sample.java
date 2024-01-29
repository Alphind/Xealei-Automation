package org.sample;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Sample {

	public static void main(String[] args) {
			
	System.out.println(
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
							.format(ZonedDateTime.now())
	
			);
	}
}
