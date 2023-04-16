package com.jstobigdata.jdk17.switchex.ex0;

// 03 - Explain me third
//Switch case statement with Yield.
public class WithYield {

    public Boolean isVowel(char letter){
        Boolean isVowel = switch (letter){
            case 'a', 'e', 'i', 'o', 'u':
                yield true;
            default:
                yield false;
        };

        return isVowel;
    }

    public String dayInString(int day){
            return switch (day){
                case 1:
                    yield "SUNDAY";
                case 2:
                    yield "MONDAY";
                case 3:
                    yield "TUESDAY";
                default:
                    throw new IllegalArgumentException("Invalid day");
            };
        }

    }