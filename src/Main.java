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
    public static int[] oddonacciLinear(int n)
    {
        int[] A = new int[3]; //initializing returned array
        int i = 0, j = 0, k=0; //initializing variable i j k

        if (n == 3 || n == 2 || n == 1) //1st 3 positions are 1 (base case)
        {
            i=1;
            j=1;
            k=1;

            A[0] = i; A[1] = j; A[2]=k; //setting those values in the array
            System.out.print(k + " " + j + " " + i + " ");

            return (A);	//returning the updated array
        }
        else
        {
            A = oddonacciLinear(n - 1); //recursive call
            i = A[0];
            j = A[1];
            k = A[2];

            System.out.print((i+j+k) + " ");

            A[0] = i + j + A[2];
            A[1] = i;
            A[2] = j;

            return (A);
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
                writer.println("OddonacciMultiple("+i+") :");
                startTimeMultiple = System.nanoTime();
                result=oddonacciMultiple(i);
                endTimeMultiple = System.nanoTime();
                writer.println("Result : " + result);
                writer.println("Built-in time : " +(endTimeMultiple -startTimeMultiple) + " ms");
                writer.println();
            }
            writer.println();
            writer.println();

            writer.println("Result of the Oddonacci linear recursion");
            writer.println();

            for (int i =5 ; i<=35 ; i+=5){
                writer.println("************************");
                writer.println("OddonacciLinear("+i+") :");
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