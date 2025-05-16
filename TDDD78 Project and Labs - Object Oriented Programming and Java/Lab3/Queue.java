package se.liu.jeand987.Lab3;

import se.liu.jeand987.lab1.Lab2_Excercise1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue extends ListManipulator
{
    public void enqueue(Person person){
        elements.add(person);
    }
    public Person dequeue(){
        if(isEmpty()){
            return null;
        }
        return elements.remove(0);
    }
}
