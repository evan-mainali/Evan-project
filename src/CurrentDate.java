import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.DayOfWeek;


public class CurrentDate {
    private String Months[]={"JANUARY","FEBUARAY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};

    protected DayOfWeek currentday;
    protected String date;

    public CurrentDate(){
        LocalDate currentdate = LocalDate.now();
        String date = currentdate.toString();
        currentday= currentdate.getDayOfWeek();
        this.date=date;

    }
    public int getCurrentday(){ // this method displays the day like Wedneday.

        int counter =0;
        String day="";
        for(char c :date.toCharArray()){

            if(c=='-'){
                counter++;
            }
            else if(counter==2){
                day+=Character.toString(c);
            }

        }
        return Integer.parseInt(day);

    }


    public  int getCurrentMonth(){ // this method gets the current month as an integer;

        int counter=0;
        int month=0;
        for(char c:date.toCharArray()){

            if(c=='-'){ // because this API displays day, month then year as a string seperated by a dash, helps us find the month.
                counter++;
            }
            else if(counter==1){
                month+=Integer.parseInt(String.valueOf(c));
            }

        }
        return month;
    }


    public int getCurrentYear(){ // this method gets the current year as an integer
        String year="";
        int counter=0;

        for(char c:date.toCharArray()){

            if(c=='-') { // same here.
                counter++;
            }
            else if(counter==0){
                year+=Character.toString(c);
            }
        }
        return Integer.parseInt(year);

    }









}
