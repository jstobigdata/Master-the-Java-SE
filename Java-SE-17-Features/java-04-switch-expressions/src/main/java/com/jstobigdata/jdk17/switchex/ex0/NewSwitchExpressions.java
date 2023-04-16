package com.jstobigdata.jdk17.switchex.ex0;

import java.util.Scanner;

//02 - Explain me second
public class NewSwitchExpressions {
    enum Skills{
        FRONTEND_ENGG, BACKEND_ENGG, ML_ENGG
    }

    public Skills getSkills(String progLanguage){
        Skills skill = switch (progLanguage.toLowerCase()){
            case "js", "javascript" -> Skills.FRONTEND_ENGG;
            case "java", "spring" -> Skills.BACKEND_ENGG;
            case "keras", "pytorch" -> Skills.ML_ENGG;
            default -> throw new IllegalArgumentException("Invalid input");
        };

        return skill;
    }

    //Old way of writing switch statement
    public int weekdayInIntOldWay(String day){
        switch(day.toUpperCase()){
            case "SUNDAY":
                return 1;
            case "MONDAY":
                return 2;
            default:
                return 0;
        }

    }

    //New way
    public int weekdayInInt(String day){
       return switch (day.toUpperCase()){
            case "SUNDAY", "SUN" -> 1;
            case "MONDAY", "MON" -> 2;
            case "TUESDAY", "TUE" -> 3;
            case "WEDNESDAY", "WED" -> 4;
            case "THURSDAY", "THURS" -> 5;
            case "FRIDAY", "FRI" -> 6;
            case "SATURDAY", "SAT" -> 7;
            default -> 0;

        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Example-1
        /*
        System.out.println("Which tool or Programming language you know");
        String programmingLanguage = scanner.nextLine().trim();

        if (programmingLanguage != null) {
            //TODO uncomment and see
            //System.out.println(String.format("You can apply for: %s position", new SwitchStatements().getSkills(null)));
            System.out.println(String.format("You can apply for: %s position",
                new NewSwitchExpressions().getSkills(programmingLanguage)));
        }*/

        //Example-2
        System.out.println("Enter the day in string: ");
        var day = scanner.nextLine().trim();
        System.out.println(String.format("The day in integer: %sth day in a week",
                new NewSwitchExpressions().weekdayInInt(day)));

    }
}


