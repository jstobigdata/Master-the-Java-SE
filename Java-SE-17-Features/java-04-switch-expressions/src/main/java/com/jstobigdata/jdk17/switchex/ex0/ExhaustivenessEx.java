package com.jstobigdata.jdk17.switchex.ex0;

//04 - explain me in the end
//Invalid examples
public class ExhaustivenessEx {

    public enum Day { SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }

    public static void main(String[] args) {
        Day day = Day.SUNDAY;
        int i = switch (day) {
            case MONDAY -> {
                System.out.println("Monday");
                //TODO - comment the yield and see.
                // You can not do that as each statement need to have that.
                yield 0;
                // ERROR! Block doesn't contain a yield statement
            }
            default -> 1;
        };
    }
}
