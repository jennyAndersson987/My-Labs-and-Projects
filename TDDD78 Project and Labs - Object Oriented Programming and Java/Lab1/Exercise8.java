package se.liu.jeand987.lab1;

import javax.swing.*;

public class Exercise8
{
    public static void main(String[] args) {
	while(true){
	    boolean answer1=askUser("quit?");
	    boolean answer2= askUser(("really?"));
	    if (answer1 && answer2){
		System.out.println("Quitting");
		break;
	    }
	    else{
		System.out.println("Then we will keep going");
	    }
	}
    }

    public static boolean askUser(String question) {
	return JOptionPane.showConfirmDialog(null, question, "",
					     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

	}


}
