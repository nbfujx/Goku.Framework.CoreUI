package com.goku.coreui.sys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nbfujx on 2018/1/17.
 */
public  class DateUtil {

    public static Date StrtoDate(String DateString, String format) {
        if (DateString != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date cd = null;
            try {
                cd = sdf.parse(DateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return cd;
        } else {
            return null;
        }
    }

    public static String DatetoStr(Date Date, String format) {
        if (Date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String str=sdf.format(Date);
            return str;
        } else {
            return null;
        }
    }

}
