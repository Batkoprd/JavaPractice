package com.company.OOP_2;

public class Calendar {
   static Month currentMonth = Month.APRIL;

    public static void currentDateInfo() {
        System.out.println(currentMonth.getNumber() + " " + Month.valueOf(String.valueOf(currentMonth)));
    }



}
