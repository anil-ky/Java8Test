package com.java8.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) throws ParseException {
		String str = "programming";

		StringBuilder sb = new StringBuilder();

		for (int i=0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int indx = str.indexOf(ch, i+1);
			
			System.out.print(indx + " ");
			
			if (indx == -1) {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);
	}

}
