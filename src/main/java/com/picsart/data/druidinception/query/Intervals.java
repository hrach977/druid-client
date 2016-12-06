package com.picsart.data.druidinception.query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class Intervals {
   private String time;

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public static String ts(String from, String to) throws ParseException {
      final Date currentTime = new Date();

      final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy/MM/d");
      final SimpleDateFormat intervalDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssXXX");

      Date fromDate = inputDateFormat.parse(from);
      Date toDate = inputDateFormat.parse(to);
      return intervalDateFormat.format(fromDate) + "/" + intervalDateFormat.format(toDate);
   }
}
