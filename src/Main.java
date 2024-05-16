import java.io.*;

public class Main {
    public static long oddonacciMultiple(int n){
        if(n==0){
            return 0;
        }
        else if(n==1 || n==2 || n==3){
            return 1;
        }
        else {
            return (oddonacciMultiple(n-1) + oddonacciMultiple(n-2) + oddonacciMultiple(n-3));
        }
    }
    public static void displayResultFile(){
        PrintWriter writer=null;
        try{
            writer = new PrintWriter(new FileOutputStream("OddoOut.txt"));
            writer.println("Result of the Oddonacci multiple recursion");
            writer.println();

            long startTimeMultiple=0;
            long endTimeMultiple = 0;
            long result=0;

            for (int i =5 ; i<=35 ; i+=5){
                writer.println("************************");
                writer.println("Oddonacci("+i+") :");
                startTimeMultiple = System.nanoTime();
                result=oddonacciMultiple(i);
                endTimeMultiple = System.nanoTime();
                writer.println("Result : " + result);
                writer.println("Built-in time : " +(endTimeMultiple -startTimeMultiple) + " ms");
                writer.println();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("A problem occurred.");
        }
    }

    public static void main (String[]args){
        displayResultFile();
    }

}