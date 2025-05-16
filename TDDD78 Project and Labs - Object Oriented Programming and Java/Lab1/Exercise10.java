package se.liu.jeand987.lab1;

public class Exercise10
{
    public static void main(String[] args) {
	int number = 16777217;
	double decimal = number;
	int integerAgain = (int)decimal;
	System.out.println(number + " " + decimal + " "+ integerAgain);

	int big = 2147483647;
	int bigger = big+1;
	System.out.println(big + " " + bigger);
    }
}
