package se.liu.jeand987.calendar;

public class Appointment
{
    private String subject;
    private SimpleDate date;
    private TimeSpan timeSpan;

    public String getSubject() {
	return subject;
    }

    public SimpleDate getDate() {
	return date;
    }

    public TimeSpan getTimeSpan() {
	return timeSpan;
    }

    public Appointment(final String subject, final SimpleDate date, final TimeSpan timeSpan) {
	this.subject = subject;
	this.date = date;
	this.timeSpan = timeSpan;
    }
    public String toString() {
	return subject + " " + timeSpan.toString() + " " + date.toString();
    }
}
