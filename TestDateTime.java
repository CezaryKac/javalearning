package java8ocp.datatimek;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TestDateTime {


    public static void main(String[] arg) {
        LocalDate ld = LocalDate.now();

        System.out.println( "LocalDate.now()-" + ld );
        System.out.println( "LocalDate.of()-" + LocalDate.of(2016, 11,23) );
        System.out.println( "LocalDate.of()-" + LocalDate.of(2014, Month.APRIL, 4) );
        System.out.println( "ld+days-" + ld.plusDays(15).getDayOfWeek());
        System.out.println( "Month-" + ld.getMonth());

        LocalTime lt = LocalTime.now();
        System.out.println( "LocalTime.now()-" + lt );
        System.out.println( "lt+times-" + lt.plusHours(3).plusMinutes(4));
        System.out.println( "lt parse-" + LocalTime.parse("21:12:34.234"));

        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Today's date and current time is: " + currDateTime);

        LocalDateTime christmas = LocalDateTime.of(2015, 12, 25, 0, 0);
        LocalDateTime newYear = LocalDateTime.of(2016, 1, 1, 0, 0);
        System.out.println("New Year 2016 comes after Christmas 2015? "+newYear.isAfter(christmas));

        // prints the current timestamp with UTC as time zone
        Instant currTimeStamp = Instant.now();
        System.out.println("Instant timestamp is: "+ currTimeStamp);

        // prints the number of seconds as Unix timestamp from epoch time
        System.out.println("Number of seconds elapsed: " + currTimeStamp.getEpochSecond());

        // prints the Unix timestamp in milliseconds
        System.out.println("Number of milliseconds elapsed: " + currTimeStamp.toEpochMilli());

        LocalDate manufacturingDate = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate expiryDate = LocalDate.of(2018, Month.JULY, 18);
        Period expiry = Period.between(expiryDate, manufacturingDate);
        System.out.printf("Medicine will expire in: %d years, %d months, and %d days (%s)\n",
                expiry.getYears(), expiry.getMonths(), expiry.getDays(), expiry);

        LocalDateTime comingMidnight =
                LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
        LocalDateTime now = LocalDateTime.now();

        Duration between = Duration.between(now, comingMidnight);
        System.out.println(between);
        System.out.println(between.getSeconds());

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        ZoneId myZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(currentDate, currentTime, myZone);
        System.out.println(zonedDateTime);
        ZoneOffset zoneOffset = zonedDateTime.getOffset();
        System.out.println(zoneOffset);

        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("dd MMM yyyy D");
        System.out.println(customFormat.format(LocalDate.of(2016, Month.JANUARY, 01)));

    }


}
