package ua.daleondeveloper.sao_site.utils;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public static ArrayList<String> parseJSONRequestStringMassive(String[] arrStringToParse ){
        ArrayList<String> parsedString = new ArrayList<>();
        for(String s : arrStringToParse){
            parsedString.add(parseJSONRequestStringMassive(s));
        }


        return parsedString ;
    }
    public static ArrayList<String> parseJSONRequestStringMassive(List<String> arrStringToParse){
        return parseJSONRequestStringMassive((String[]) arrStringToParse.toArray());
    }
    public static String parseJSONRequestStringMassive(String stringToParse){
        String strOnlyLetterAndNumber = "";
        for(Character c : stringToParse.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                strOnlyLetterAndNumber += c;
            }
        }
        return strOnlyLetterAndNumber;
    }
}
