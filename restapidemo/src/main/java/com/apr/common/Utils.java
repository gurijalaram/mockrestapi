package com.apr.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
    /*
        Get current date in 2021-12-03T01:19:44.856Z format. (example: 2021-12-03T01:19:44.856Z)
    */
    public static String getDateInTZFormat(){
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(new Date());
    }

        public static String getRandomNumber() {
            return String.valueOf(((int) (Math.random()*(1000 - 100))) + 100);
        }
}
