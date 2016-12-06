package com.picsart.data.druidinception.client;

import java.util.Calendar;

/**
 * Created by Avetik on 12/6/16.
 */
public class ToolsCharts {
    public String Timestamp(int from, int to) {
        Calendar rightNow = Calendar.getInstance();
        String x = "";

        if(rightNow.get(Calendar.MONTH) + 1 < 2 && rightNow.get(Calendar.DAY_OF_MONTH) - from < 0)
            x = (rightNow.get(Calendar.YEAR)-1) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - from) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";
        if(rightNow.get(Calendar.DAY_OF_MONTH) < 8 && rightNow.get(Calendar.MONTH) + 1 < 2 )
         x = (rightNow.get(Calendar.YEAR)-1) + "-" + rightNow.get(Calendar.MONTH) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - from) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";
        if(rightNow.get(Calendar.DAY_OF_MONTH) - from <= 0 ) {
            if(rightNow.get(Calendar.MONTH) +1 == 5 || rightNow.get(Calendar.MONTH) +1 == 7 || rightNow.get(Calendar.MONTH) +1 == 10 || rightNow.get(Calendar.MONTH) +1 == 12 )
                x = rightNow.get(Calendar.YEAR) + "-" + rightNow.get(Calendar.MONTH) + "-" + ((rightNow.get(Calendar.DAY_OF_MONTH) - from)+30) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";
            else if(rightNow.get(Calendar.MONTH) +1 == 1 ||rightNow.get(Calendar.MONTH) +1 == 2 || rightNow.get(Calendar.MONTH) +1 == 4 || rightNow.get(Calendar.MONTH) +1 == 6 || rightNow.get(Calendar.MONTH) +1 == 8 || rightNow.get(Calendar.MONTH) +1 == 9 || rightNow.get(Calendar.MONTH) +1 == 11)
                x = rightNow.get(Calendar.YEAR) + "-" + rightNow.get(Calendar.MONTH) + "-" + ((rightNow.get(Calendar.DAY_OF_MONTH) - from))+31 + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";
            else if(rightNow.get(Calendar.MONTH)+1 ==3) {
                if((rightNow.get(Calendar.YEAR))%4!=0)
                    x = rightNow.get(Calendar.YEAR) + "-" + rightNow.get(Calendar.MONTH) + "-" + ((rightNow.get(Calendar.DAY_OF_MONTH) - from) + 28) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";
                else
                    x = rightNow.get(Calendar.YEAR) + "-" + rightNow.get(Calendar.MONTH) + "-" + ((rightNow.get(Calendar.DAY_OF_MONTH) - from) + 29) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";
            }
        }
        else
            x = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - from) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00/" + rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + (rightNow.get(Calendar.DAY_OF_MONTH) - to) + "T" + (rightNow.get(Calendar.HOUR) - 4) + ":" + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND) + "+00:00";

        return x;
    }

}