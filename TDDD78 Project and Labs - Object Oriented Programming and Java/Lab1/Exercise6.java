package se.liu.jeand987.lab1;

public class Exercise6
{
    public static void main(String[] args) {
	System.out.println(isPrime(4));
	for (int i = 0; i <= 100; i++) {
	    if (isPrime((i))) {
		System.out.println(i);
	    }
	}
    }

    public static boolean isPrime(int number){
	for (int i = 2; i < number; i++){
	    int rest = number%i;
	    if (rest == 0) {
		return false;
	    }
	}
	return true;
    }
}
