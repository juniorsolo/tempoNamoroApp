package com.junior.tempodenamoro.util;

import java.time.Period;

public class ExtractTimeFromPeriod {

    public static String extract(Period period){
        StringBuilder sb= new StringBuilder();
        if (period != null){
            if(period.getYears() > 0) {
                String years = period.getYears() > 1 ? period.getYears() + " anos " : period.getYears() + " ano ";
                sb.append(years);
            }
            if (period.getMonths() > 0) {
                String months = period.getMonths() > 1 ? period.getMonths() + " meses" : period.getMonths() + " mês";
                sb.append(months);
            }

            if(period.getMonths() > 0 && period.getDays() > 0){
                sb.append(" e ");
            }

            if(period.getDays() > 0) {
                String days = period.getDays() > 1 ?  period.getDays() + " dias " :  period.getDays() + " dia";
                sb.append(days);
            }

        }

        return sb.toString();
    }
}
