import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PerctageofMood extends CurrentDate{
    private String[] mood;
    private int[] dates;
    PerctageofMood(){} // separate class made to calculate the percentage
    // of the mood which I will use later on in the pie chart.

    public void calculateMoodPercentage(){
        int currentDate = getCurrentday(); // this part stores the current day
        try {
            int count =0;
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"));
            while ((line= reader.readLine())!=null){
                String[] parts= line.split(" ");
                mood[count]=parts[3];
                dates[count]=Integer.parseInt(parts[0]);
                count++;
            }



        }
        catch(IOException e){
            System.out.println("ERROR");
        }

    }

}
