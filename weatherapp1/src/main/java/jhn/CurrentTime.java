package jhn;
import java.util.Calendar;
public class CurrentTime {

    int currentHour;

    public CurrentTime(){
       // Date date = new Date();
        Calendar calender =  Calendar.getInstance();

        currentHour = calender.get(Calendar.HOUR_OF_DAY);
        System.out.println(currentHour);
    }       


    public int getHour(){
        return currentHour;
    }
    
}
