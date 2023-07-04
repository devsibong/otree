package com.otree.douzone.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
