package se.liu.jeand987.calendar;

public class SimpleDate
{
    private int year;
    private String month;
    private int day;

    public int getYear() {
	return year;
    }

    public String getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }

    public SimpleDate(final int year, final String month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    public String toString(){
	return year + "-" + Month.getMonthNumber(month)+ "-" + day;
    }

}
