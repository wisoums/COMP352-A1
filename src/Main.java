import java.io.*;
import java.util.*;
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
            writer.println("Result of the Oddonacci multiple recursion:");
            String x="";
            long startTimeMultiple = System.nanoTime();
            for (int i=5; i<=40;i=i+5){
                x += (oddonacciMultiple(i) + "\n");
            }
            long endTimeMultiple = System.nanoTime();
            writer.println(x);
            long durationMultiple = endTimeMultiple-startTimeMultiple;
            writer.println("The run time is: " + durationMultiple/(Math.pow(10,6)) + " ms.");
            writer.close();
        }catch(IOException e){
            System.out.println("A problem occurred.");
        }
    }

    public static void main (String[]args){
        displayResultFile();
    }

}