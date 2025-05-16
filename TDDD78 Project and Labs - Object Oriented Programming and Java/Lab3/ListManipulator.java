package se.liu.jeand987.Lab3;

import se.liu.jeand987.lab1.Lab2_Excercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListManipulator
{
    public List<Lab2_Excercise1.Person> elements = new ArrayList<>();


    public void clear() {
	elements.clear();
    }

    public boolean add(final Lab2_Excercise1.Person person) {
	return elements.add(person);
    }

    public boolean remove(final Object o) {
	return elements.remove(o);
    }

    public int size() {
	return elements.size();
    }

    public boolean isEmpty() {
	return elements.isEmpty();
    }

    public boolean contains(final Object o) {
	return elements.contains(o);
    }

    public Iterator<Lab2_Excercise1.Person> iterator() {
	return elements.iterator();
    }

}
