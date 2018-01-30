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

   public static String ts(Date from, Date to) throws ParseException {
      final Date currentTime = new Date();

      final SimpleDateFormat intervalDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssXXX");
      return intervalDateFormat.format(from) + "/" + intervalDateFormat.format(to);
   }
}