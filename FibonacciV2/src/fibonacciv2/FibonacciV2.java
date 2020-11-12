package fibonacciv2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciV2 {

    private static long start;
    private static long finish;
    private static long timeElapsed;

    public static void math(BigInteger f1, BigInteger f2, BigInteger result, BigInteger nextBestNumber) {
        boolean behindWritten, infrontWritten, compare = true, fibboInit;
        BigInteger behindValue = null;
        BigInteger infrontValue = null;
        BigInteger behindIntervall;
        BigInteger infrontIntervall;
        BigInteger[] fibboArray = new BigInteger[101];
        fibboArray[100]=nextBestNumber;

        if (nextBestNumber.compareTo(BigInteger.ZERO) == 0) {
            compare = false;
        }
        for (int x = 0; x < 100; x++) {
            f1 = BigInteger.ZERO;
            f2 = BigInteger.ONE;
            result = BigInteger.ONE;

            for (int i = 0; i < 100; i++) {

                if (compare == false) {
                    System.out.println(i + 1 + ": " + result);
                }
                fibboArray[i] = result;
                result = f1.add(f2);
                if(i==99){
                    quicksort(fibboArray, 0, 100);
                }
                if (f1.compareTo(f2) == -1) {

                    f1 = result;
                } else {

                    f2 = result;
                }

            }
        }

    }

    public static int division(BigInteger fibboArray[], final int first, final int last) {
        BigInteger pivot = fibboArray[(first + last)/2];
        int positionLeft = first;
        int positionRight = last;
        
        while (positionLeft<positionRight){
            while(fibboArray[positionLeft].compareTo(pivot)==-1){
                positionLeft++;
            }
            while (fibboArray[positionRight].compareTo(pivot)==1) {
               positionRight--;
                
            }
            if(positionLeft<positionRight){
                BigInteger tmp = fibboArray[positionLeft];
                fibboArray[positionLeft]=fibboArray[positionRight];
                fibboArray[positionLeft]= tmp;
                positionLeft++;
                positionRight--;
            }
        }
        return positionLeft;
    }
    public static void quicksort(BigInteger fibboArray[],final int first, final int last){
        int index = division(fibboArray, first, last);
        if(first < index-1) {
            quicksort(fibboArray, first, index-1);
    }
        if(index<last){
            quicksort(fibboArray, index, last);
        }
        System.out.println(index);
    }
    public static BigInteger nextBestNumber() {

        boolean inputSuccess = false;
        BigInteger nextBestNumber = null;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Wenn sie die gesammte Fibonacci Reihe ausgegeben haben wollen, drücken sie bitte F.");
        System.out.println("Wenn sie die gesammte nach der nächstgelegenen Fibonacci-Zahl suchen, drücken sie bitte N");
        String menu = userInput.nextLine();
        while (inputSuccess == false) {
            if (menu.equals("F")) {
                inputSuccess = true;
                nextBestNumber = BigInteger.ZERO;
                start = System.nanoTime();
            }
            if (menu.equals("N")) {
                System.out.println("Bitte geben sie eine Zahl ein.");
                nextBestNumber = new BigInteger(userInput.nextLine());
                start = System.nanoTime();
                inputSuccess = true;
            }
            if (inputSuccess == false) {
                System.out.println("Bitte geben sie entweder F oder N ein.");
                menu = userInput.nextLine();
            }
        }
        return nextBestNumber;
    }

    public static void main(String[] args) {

        BigInteger f1 = BigInteger.ZERO;
        BigInteger f2 = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;

        math(f1, f2, result, nextBestNumber());
        finish = System.nanoTime();
        timeElapsed = finish - start;
        double seconds = (double) timeElapsed / 1_000_000_000.0;
        double milliseconds = (double) timeElapsed / 1_000_000.0;

        System.out.println(milliseconds + " Millisekunden oder " + seconds + " Sekunden");
    }

}
