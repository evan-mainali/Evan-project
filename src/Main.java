
import java.io.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CurrentDate date = new CurrentDate();

        int year = date.getCurrentYear();
        int month = date.getCurrentMonth();

        Months monthcal = new Months(year,month);
        monthcal.displayMonthCalendar();
        UserInfo user = new UserInfo("Evan",10);
        System.out.println(user.askExcerciseHours());
        System.out.println(user.askSleepHours());
        System.out.println(user.storeMood());
        System.out.println(user.getapiWeather());







    }


}