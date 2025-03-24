import java.time.DayOfWeek;
import java.time.YearMonth;
import java.time.LocalDate;
public class Months extends  CurrentDate{

    private static final String[] DAYS = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
    private String months[]={"JANUARY","FEBUARAY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
    private int year;
    private int month;
    private String[][] monthCalendar= new String[6][7]; // Adjusted for weeks & possible extra row

    public Months(int year, int month) {
        this.year = year;
        this.month = month;
        generateMonthCalendar();
    }

    public String getMonth(){
        return months[getCurrentMonth()-1];
    }


    public String[][] generateMonthCalendar() {
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstDay = yearMonth.atDay(1);
        DayOfWeek startDay = firstDay.getDayOfWeek();


        int startIndex = startDay.getValue() % 7; // Convert Java's Monday=1 format
        int dayCounter = 1;

        for (int row = 0; row < monthCalendar.length; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0 && col < startIndex) {
                    monthCalendar[row][col] = "  "; // Empty spots before first day
                } else if (dayCounter <= daysInMonth) {
                    monthCalendar[row][col] = String.format("%2d",dayCounter++);
                } else {
                    monthCalendar[row][col] = "  "; // Empty spots after last day
                }
            }
        }
        return monthCalendar;
    }

    public void displayMonthCalendar() {
        System.out.println(getMonth()+" "+year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (String[] week : monthCalendar) {
            for (String day : week) {
                System.out.print(" "+day+" ");
            }
            System.out.println();
        }
    }
















}


