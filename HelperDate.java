import java.time.temporal.ChronoUnit;

public class HelperDate{

	private static long daysOlder;

	private static void setDaysOlder() {
		daysOlder = compareDays(ComparePpl.getPplCompare()[0],
				ComparePpl.getPplCompare()[1]);
	}

	private static long compareDays(People name1, People name2){
		long daysBetween = ChronoUnit.DAYS.between(
				name1.getBirthDate(), name2.getBirthDate());
		return daysBetween;
	}

	/*
	public static long getDaysBetween(String name1, String name2){
		People people1 = getPeople(name1);
		People people2 = getPeople(name2);
		long daysBetween = ChronoUnit.DAYS.between(
				people1.getBirthDate(), people2.getBirthDate());
		return daysBetween;
	}
*/
	public static long getDaysOlder() {
		setDaysOlder();
		return daysOlder;
	}
}
