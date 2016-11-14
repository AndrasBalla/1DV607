package controller;

import java.util.Calendar;

/**
 * Created by Andras on 26/09/2016.
 */
public class ErrorHandling {

    public boolean checkName(String name){
        return name.isEmpty();
    }

    public boolean checkPnr(String inId) {
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        String controlTwo;
        int control = 0;
        int times = 2;
        if (inId.length() != 11){
            return false;
        }

        for(int i = 0; i < inId.length() - 1; i++){
            if(i != 6){
                controlTwo = "" + Integer.parseInt(inId.substring(i,i+1)) * times;
                if(times == 1){
                    times = 2;
                }else{
                    times = 1;
                }
                for(int j = 0; j < controlTwo.length(); j++){
                    control += Integer.parseInt(controlTwo.substring(j,j+1));
                }
            }
        }

        if((10 - (control % 10) != Integer.parseInt(inId.substring(10)))){
            return false;
        }else if(inId.length() == 11){
            int year = Integer.parseInt(inId.substring(0,2));
            int month = Integer.parseInt(inId.substring(2,4));
            int day = Integer.parseInt(inId.substring(4,6));
            if(inId.charAt(6) == '-'){
                return year >= currentYear - 2000 && year <= 99 && month > 0 && month <= 12 && day > 0 && day <= 30;
            }else if (inId.charAt(6) == '+'){
                return year <= currentYear - 2000 && year >= 0 && month > 0 && month <= 12 && day > 0 && day <= 30;
            }
        }else {
            return false;
        }
        return false;
        }
    }
