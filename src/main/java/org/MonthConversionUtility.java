package org;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MonthConversionUtility {

    public void convertNumericMonthToAbbreviation() {
    	
    
		LocalDate currentDate = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M");
		String formattedDate = currentDate.format(formatter);
	  System.out.println("Formatted Date" +formattedDate);
    }

    public static void main(String[] args) {
    	
    	MonthConversionUtility c = new MonthConversionUtility();
    	c.convertNumericMonthToAbbreviation();
   
    }
}

	