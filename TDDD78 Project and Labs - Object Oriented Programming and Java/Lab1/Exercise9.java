package se.liu.jeand987.lab1;

import javax.swing.*;

public class Exercise9
{
    public static void main(String[] args) {
	String x = JOptionPane.showInputDialog("Please input a value");
	System.out.println(findRoot(Double.parseDouble(x)));
    }

    public static double findRoot(double num) {
	double guess = num;
	for (int i = 0; i <= 10; i++) {
	    guess -= (guess*guess-num) / (2*guess);
	}
	return guess;

    }

}
