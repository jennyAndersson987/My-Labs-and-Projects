package se.liu.jeand987.lab1;
import javax.swing.*;
public class Exercise4
{
    public static void main(String[] args){
	String input = JOptionPane.showInputDialog("Please input a value");
	int tabell = Integer.parseInt(input);
	for (int i = 0; i <=12; i++){

	    System.out.println(i+ "*"+tabell+"="+tabell * i);
	}
    }
}
