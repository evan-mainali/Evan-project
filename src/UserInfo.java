import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;



public class UserInfo extends CurrentDate {

    protected String[] moodSelect = {"HAPPY", "SAD", "ANGRY", "OK"};

    private String name;
    private int age;

    public UserInfo(String name,int age) {
        this.name=name;
        this.age=age;
    }


    private String askMood() { // part of the program asks for the mood of the user

        boolean checkInput = false;
        String mood = "";

        // Display mood options once
        Scanner input = new Scanner(System.in);

        System.out.println("Select your mood from the following: ");
        for (String i : moodSelect) {
            System.out.print(i + ", ");
        }
        System.out.println(); // Move to next line

        // Keep asking until a valid input is given
        while (!checkInput) {
            mood = input.nextLine().toUpperCase();

            for (String i : moodSelect) {
                if (mood.equals(i)) {
                    checkInput = true;
                    break; // Exit loop if valid mood is found
                }
            }

            if (!checkInput) {
                System.out.println("Invalid mood. Try again: ");
            }
        }

        return mood;

    }


    public void storeUserInfo() {// writes the private methods in a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt", true))) {
            int currentDate = getCurrentday();
            int currentYear = getCurrentYear();
            String mood = askMood();

            writer.write(currentDate + " " + currentYear + " " + mood);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public int askSleepHours(){ // asks how long you slept for, validating your hours in case of invalid data.
        int number;
        System.out.print("Enter how long you slept last night ");
        Scanner input = new Scanner(System.in);
        while (true){
            if(input.hasNext()){
                number = input.nextInt();
                break;
            }
            else{
                System.out.print("try again, invalid ");

            }

        }
        try { // this part of the program stores the sleep hours into a file
            BufferedWriter writer = new BufferedWriter(new FileWriter("SleepHours.txt",true));
            writer.write(String.valueOf(number));
            writer.newLine();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }



        return number;
    }

    public int askExcerciseHours(){
        int excerciseHour=0;

        while(true){
            System.out.print("Enter how long you have excercised for today ");
            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()){
                excerciseHour=input.nextInt();
                break;
            }

            else{
                System.out.println("Invalid data, try again");

            }

        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Excercise.txt", true)); // stores excercise hour in a file
            writer.write(String.valueOf(excerciseHour));
            writer.newLine();
            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return excerciseHour;


    }






}














