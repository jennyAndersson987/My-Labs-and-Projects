package se.liu.jeand987.calendar;
import java.util.Map;

public class Month {
    private String month;
    private int month_num;
    private int month_len;

    public Month(final String month, final int month_num, final int month_len) {
	this.month = month;
	this.month_num = month_num;
	this.month_len = month_len;
    }

    public String getMonth() {
	return month;
    }

    public int getMonth_num() {
	return month_num;
    }

    public int getMonth_len() {
	return month_len;
    }


//Dessa variabler är showstoppers i kodgranskningen eftersom de är globala. Jag har valt att behålla dem så eftersom
//Det inte går att ha dem i konstruktorn och jag anser att detta är det mest rimliga sättet att ha dem. Här kommer de alltid initialiseras
//eftersom jag definierar dem som static, och de kommer alltid att initialiseras så fort koden körs.
//Jag hade kunnat lägga dem i en annan fil så att de inte är globala, men i uppgiften stod det att de skulle ligga i Month.
    private static final Map<String, Integer> MONTH_NAME_TO_LENGTH;
    private static final Map<String, Integer> MONTH_NAME_TO_NUMBER;

    static {
	MONTH_NAME_TO_LENGTH = Map.ofEntries(
		Map.entry("January", 31),
		Map.entry("February", 28),
		Map.entry("March", 31),
		Map.entry("April", 30),
		Map.entry("May", 31),
		Map.entry("June", 30),
		Map.entry("July", 31),
		Map.entry("August", 31),
		Map.entry("September", 30),
		Map.entry("October", 31),
		Map.entry("November", 30),
		Map.entry("December", 31)
	);
	MONTH_NAME_TO_NUMBER = Map.ofEntries(
		Map.entry("January", 1),
		Map.entry("February", 2),
		Map.entry("March", 3),
		Map.entry("April", 4),
		Map.entry("May", 5),
		Map.entry("June", 6),
		Map.entry("July", 7),
		Map.entry("August", 8),
		Map.entry("September", 9),
		Map.entry("October", 10),
		Map.entry("November", 11),
		Map.entry("December", 12)
	);
    }

    public static int getMonthNumber(String name) {
	return MONTH_NAME_TO_NUMBER.getOrDefault(name, -1);
    }

    public static int getMonthDays(String name) {
	return MONTH_NAME_TO_LENGTH.getOrDefault(name, -1);
    }

    public static void main(String[] args) {
	System.out.println(Month.getMonthNumber("January"));
    }
}
