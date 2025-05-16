package se.liu.jeand987.lab1;


import java.time.LocalDate;
import java.time.Period;

public class Lab2_Excercise1
{
    public static class Person{
	private String name;
	private LocalDate birthDay;
	private int age;

	public Person(final String name, final LocalDate birthDay) {
	    this.name = name;
	    this.birthDay = birthDay;

	}
	public int getAge(){
	    LocalDate currentYear = LocalDate.now();
	    LocalDate givenYear = birthDay;
	    return Period.between(givenYear, currentYear).getYears();
	}

	@Override public String toString() {
	    return name + " " + getAge();
	}

	public static void main(String[] args) {
	    Person human = new Person("jenny", LocalDate.of(2004, 10, 12));
	    System.out.println(human.name + " " + human.birthDay);
	    System.out.println(human);
	    System.out.println(human.getAge());
	}
    }
}
