import java.io.*;

/* --------------------------------
Names : Wissem Oumsalem (40291712)
        Soukayna Haitami (40280964)
----------------------------------*/
public class Main {
    //Multiple recursion
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

    //Linear recursion
    public static long[] oddonacciLinear(int n)
    {
        long[] A = new long[3]; //initializing returned array
        long i = 0, j = 0, k=0; //initializing variable i j k

        if (n == 3 || n == 2 || n == 1) //1st 3 positions are 1 (base case)
        {
            A[0] = 1; A[1] = 1; A[2]=1; //setting those values in the array

            return (A);	//returning the updated array
        }
        else
        {
            A = oddonacciLinear(n - 1); //recursive call
            //Keep the values of the array before they get changed
            i = A[0];
            j = A[1];
            k = A[2];

            //Update the new values
            A[0] = i + j + k;
            A[1] = i;
            A[2] = j;

            return (A);
        }
    }

    //Tail recursion
    public static long oddonacciTail(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return oddonacciTailHelper(n,1,1,1);
    }

    private static long oddonacciTailHelper(int n, long a, long b, long c) {
        if (n == 3) {
            return c;
        }
        return oddonacciTailHelper(n - 1, b, c, a + b + c);
    }

    //Results
    public static void displayResultFile(){
        PrintWriter writer=null;
        try{
            writer = new PrintWriter(new FileOutputStream("OddoOut.txt"));

            writer.println("Result of the Oddonacci multiple recursion");
            writer.println();

            long startTime =0;
            long endTime = 0;
            long result=0;

            for (int i = 5 ; i<=40 ; i+=5){
                writer.println("************************");
                writer.println("OddonacciMultiple("+i+") :");
                startTime = System.nanoTime();
                result=oddonacciMultiple(i);
                endTime = System.nanoTime();
                writer.println("Result : " + result);
                writer.println("Built-in time : " +(endTime - startTime)/Math.pow(10,6) + " ms");
                writer.println();
            }
            writer.println();
            writer.println();

            writer.println("Result of the Oddonacci linear recursion");
            writer.println();

            for (int i = 0; i < 10; i++) {
                oddonacciLinear(5);
            }

            for (int i =5 ; i<=40 ; i+=5){
                writer.println("************************");
                writer.println("OddonacciLinear("+i+") :");
                startTime = System.nanoTime();
                result=oddonacciLinear(i)[0];
                endTime = System.nanoTime();
                writer.println("Result : " + result);
                writer.println("Built-in time : " +(endTime - startTime)/Math.pow(10,6) + " ms");
                writer.println();
            }

            writer.println();
            writer.println();

            writer.println("Result of the Oddonacci Tail recursion");
            writer.println();


            for (int i =5 ; i<=40 ; i+=5){
                writer.println("************************");
                writer.println("OddonacciTail("+i+") :");
                startTime = System.nanoTime();
                result=oddonacciTail(i);
                endTime = System.nanoTime();
                writer.println("Result : " + result);
                writer.println("Built-in time : " +(endTime - startTime)/Math.pow(10,6) + " ms");
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