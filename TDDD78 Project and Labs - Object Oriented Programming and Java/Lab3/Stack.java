package se.liu.jeand987.Lab3;

import se.liu.jeand987.lab1.Lab2_Excercise1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack extends ListManipulator
{

    public void push(Person person){
        elements.add(size(), person);
    }
    public Person pop(){
        Person person = elements.get(0);
        elements.remove(0);
        return person;
    }
}
