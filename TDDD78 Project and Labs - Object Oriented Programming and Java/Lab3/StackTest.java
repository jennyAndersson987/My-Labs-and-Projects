package se.liu.jeand987.Lab3;

import se.liu.jeand987.lab1.Lab2_Excercise1;

import java.time.LocalDate;

public class StackTest
{
    public static void main(String[] args) {
	Stack stack = new Stack();
	stack.push(new Lab2_Excercise1.Person("Jenny", LocalDate.of(2004,10,12)));
	stack.push(new Lab2_Excercise1.Person("Yäni", LocalDate.of(2005,11,13)));
	stack.push(new Lab2_Excercise1.Person("Yänis", LocalDate.of(2020,2,1)));
	stack.push(new Lab2_Excercise1.Person("JennyPenny", LocalDate.of(2010,1,9)));
	stack.push(new Lab2_Excercise1.Person("Penny", LocalDate.of(2022,8,20)));

	while(!stack.elements.isEmpty())
	    System.out.println(stack.pop());

	System.out.println("\n");


	Queue queue = new Queue();
	queue.add(new Lab2_Excercise1.Person("Jenny", LocalDate.of(2004,10,12)));
	queue.add(new Lab2_Excercise1.Person("Yäni", LocalDate.of(2005,11,13)));
	queue.add(new Lab2_Excercise1.Person("Yänis", LocalDate.of(2020,2,1)));
	queue.add(new Lab2_Excercise1.Person("JennyPenny", LocalDate.of(2010,1,9)));
	queue.add(new Lab2_Excercise1.Person("Penny", LocalDate.of(2022,8,20)));

	while(!queue.elements.isEmpty())
	    System.out.println(queue.dequeue());
    }
}
