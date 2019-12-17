package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {
    public static int getNumberFromString(String text){
        Pattern pattern = Pattern.compile("\\d(\\w*)");
        Matcher matcher = pattern.matcher(text);
        String afterText=text;
        while (matcher.find()){
            afterText = text.substring(matcher.start(),matcher.end());
            System.out.println(text);
            break;
        }
        return Integer.parseInt(afterText);
    }

    public static double getDoubleFromString(String text){
        Pattern pattern = Pattern.compile("\\d+(\\.\\d{1,2})?");
        Matcher matcher = pattern.matcher(text);
        String afterText=text;
        while (matcher.find()){
            afterText = text.substring(matcher.start(),matcher.end());
            System.out.println(text);
            break;
        }
        return Double.parseDouble(afterText);
    }
}
