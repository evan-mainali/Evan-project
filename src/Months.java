import java.time.DayOfWeek;
import java.time.YearMonth;
import java.time.LocalDate;
public class Months extends  CurrentDate{

    protected String[] months = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
    protected String[][] monthcalendar= new String[7][5];
    protected String[] days = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};


    private int useryear;
    private int month;
    private int indexmonth;

    Months(int year,int month){
        useryear=year;
        this.month=month;

    }

    String displayStartDay(){ // this method finds the value of the start day of January first e.g. Monday or Tuesday
            YearMonth yearmonth = YearMonth.of(useryear,month);
            LocalDate FirstDayofmonth = yearmonth.atDay(1);
            DayOfWeek startday = FirstDayofmonth.getDayOfWeek();
            return startday.toString();


    }


    String convertintoMonth(){
        String Currentmonth = "";
        indexmonth=month-1;
        for(int i =0;i<months.length;i++){
            if(i==indexmonth){
                Currentmonth=months[i]; // this part of the program converts the index year into a month;
            }
        }
        return Currentmonth;
    }

    boolean isleapyear(){


        return (useryear%4==0) && (useryear%100!=0 || useryear%400==0);


    }

    void makeMonthCalander() { // this part of the program displays the current date day and month as a whole, the final process.
            isleapyear();
            displayStartDay();


            int max=0;


            for(int i =0;i<months.length;i++){
                if((i==3 || i== 5|| i==8 || i==10) && months[i].equals(convertintoMonth()) ){
                    max=30;
                }
                else if((i== 0|| i==2|| i==4|| i==6||i==7||i==9||i==11) && months[i].equals(convertintoMonth())){
                    max=31;
                }
                else if(isleapyear() && months[i].equals(convertintoMonth())){
                    max=29;
                }
                else if(months[i].equals(convertintoMonth()) && i==1){
                    max=28;
                }

            }
        int index=0;

        for(int i =0;i< days.length;i++){
            if(days[i].equals(displayStartDay())){
                index=i; // this part stores the index of the day of the week given by displaystartdate() function so we can use it for the print
            }
        }
        for(int date =0;date<max;date++){
            System.out.println(days[(date+index)%7]+" "+(date+1)+" "+convertintoMonth()+" "+useryear);
        }
    }


    public String displayMonthCalendar(){
        return "Hello";
    }














}


