package com.java8.test;

//import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException, InterruptedException {
        String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        String dateNew2 = "2021-07-21T18:30:10Z";
        String dateNew = "2021-08-03T00:00:00Z";

        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATE_TIME_FORMAT);
        Date date = sdf.parse(dateNew);

        Date now = new Date();
        Instant instant = Instant.now();
        String dateNow = instant.truncatedTo(ChronoUnit.DAYS).toString();
        //Date date2 = DateUtil.getDateFromISODateTimeString(dateNow);
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(ISO_DATE_TIME_FORMAT);
        
        LocalDateTime localDateTime = LocalDateTime.parse(dateNew2, dateTimeFormatter); // DateTimeFormatter.ISO_DATE_TIME
        
        String formattedDate= dateTimeFormatter.format(localDateTime);

        System.out.println("localDate.toString() : " + localDateTime.toString());
        
        String calDate = localDateTime.truncatedTo(ChronoUnit.DAYS).toString();
        
        //String calDate = date. toInstant().truncatedTo(ChronoUnit.DAYS).toString();
        		//Calendar.getInstance().getTime().toInstant().truncatedTo(ChronoUnit.DAYS).toString();

        //String currTime = DateUtil.getCurrentTime();
        //Date dateNewDay = DateUtil.getDateFromISODateTimeString(calDate);

        //currTime = dateNewDay.toInstant().truncatedTo(ChronoUnit.DAYS).toString();

        System.out.println("calDate : " + calDate);
        //System.out.println("dateNewDay : " + dateNewDay);
        //System.out.println("Current Time : " + DateUtil.getCurrentTime());

        //Date truncatedDate = DateUtils.truncate(new Date(), Calendar.DATE);

        //System.out.println("truncatedDate : " + DateUtils.truncate(Calendar.getInstance().getTime(), Calendar.DATE));


        //Date requestDate = DateUtil.getDateFromISODateTimeString(DateUtil.getCurrentTime());
        //System.out.println("requestDate : " + requestDate);
        //System.out.println(DateUtil.getCurrentTime());
        //System.out.println(DateUtil.getCurrentDate());

        //System.out.println(date.toString());

        //System.out.println("Compare: " + date.toInstant().equals(date2.toInstant()));

        //System.out.println(DateUtil.getDateFromISODateTimeString(dateNew));
        //System.out.println(DateUtil.getCurrentTime());
        //System.out.println(DateUtil.getIsoDate(dateNew));
        //System.out.println(DateUtil.getSimpleDate(dateNew));
        //System.out.println(DateUtil.getIsoDateFromStr(dateNew));

    }
}
