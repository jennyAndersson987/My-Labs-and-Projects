package se.liu.jeand987.calendar;

import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments;

    public Cal() {
	appointments = new ArrayList<>();
    }

    public List<Appointment> getAppointments() {
	return appointments;
    }
    public void show(){
	for(Appointment appointment : appointments){
	    System.out.println(appointment);
	}
    }
    public void book(int year, String month, int day,
		     int startHour, int startMinute, int endHour,
		     int endMinute, String subject){

	if(year < 1970) {
	    throw new IllegalArgumentException("too long ago");
	}
	if ((startHour < 0 || startHour > 24) || (startMinute < 0 || startMinute > 60)){
	    throw new IllegalArgumentException("not valid time");
	}
	if ((Month.getMonthNumber(month) == -1) || (Month.getMonthDays(month) == -1)){
	    throw new IllegalArgumentException("invalid month");
	}

	SimpleDate date = new SimpleDate(year, month, day);
	TimePoint timeStart = new TimePoint(startHour, startMinute);
	TimePoint timeEnd = new TimePoint(endHour, endMinute);

	TimeSpan timeSpan = new TimeSpan(timeStart, timeEnd);
	Appointment newAppointent = new Appointment(subject, date, timeSpan);
	appointments.add(newAppointent);

    }

    public static void main(String[] args) {
	Cal calender = new Cal();
	calender.book(2024, "January", 31, 00, 59, 15, 40, "Hejsan");
	calender.book(2029, "April", 10, 20, 00, 23, 59, "tjena");

	for (Appointment i : calender.appointments){
	    System.out.println(i.toString());

	}

    }
}
