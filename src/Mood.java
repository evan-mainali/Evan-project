import java.util.Scanner;

public class Mood extends Months{


    protected int month;
    protected int year;

    protected String[][] moodCalendar= new String[6][7];

    public Mood(int year, int month){
        super(year,month);
    }


    public String askMood(){
        System.out.print("Enter how your mood was ");

        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }













}
