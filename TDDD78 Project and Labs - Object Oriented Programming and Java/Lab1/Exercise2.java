package se.liu.jeand987.lab1;

public class Exercise2
{
    private static int sumFor(int min, int max){
        int sum =0;
        for (int i = min; i < max; i++) {
            sum += i;
        }
        return sum;
    }

    private static int sumWhile(int min, int max){
        int i = min;
        int sum = 0;
        while (i < max) {
            sum += i;
            i ++;

        }
        return sum;
    }

    public static void main(String[] args) {
        final int min = 10;
        final int max = 20;
        System.out.println(sumWhile(min,max));
    }
}
