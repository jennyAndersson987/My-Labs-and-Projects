package se.liu.jeand987.lab1;

import javax.swing.*;

public class Exercise7
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


    public static void main(){
	String choice = JOptionPane.showInputDialog("Please input a function");
	final int min = 10;
	final int max = 20;
	sumSwitch(min, max, choice);
    }

    public static void sumSwitch(int min, int max, String choice) {
	switch (choice){
	    case "sumFor":
		System.out.println(sumFor(min,max));
		break;
	    case "sumWhile":
		System.out.println(sumWhile(min,max));
		break;
	    default:
		System.out.println("Wrong input");
	    }
	}
    }

