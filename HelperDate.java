import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * {@code HelperDate} is a helper class for {@code ComparePpl} class.
 * <p> This class contains the following useful information:
 * <ul><pre>{@code getCurrentYear}</pre></ul>
 * <ul><pre>{@code getAge}</pre></ul>
 * <ul><pre>{@code getDaysOlder}</pre></ul>
 *</p>
 *
 */

public class HelperDate{

	private static long daysOlder;

	public static void setDaysOlder() {
		daysOlder = compareDays(ComparePpl.getPplCompare()[0],
				ComparePpl.getPplCompare()[1]);
	}

	private static long compareDays(People name1, People name2){
		long daysBetween = ChronoUnit.DAYS.between(
				name1.getBirthDate(), name2.getBirthDate());
		return daysBetween;
	}

	public static long getDaysOlder() {
		return daysOlder;
	}

	public static LocalDate formatDate(String birthString) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate date = null;
		try {
			date = LocalDate.parse(birthString, format);
		} catch (DateTimeParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
			System.out.println("format should be: dd/mm/yy");
			System.exit(1);
		}
		if (date.getYear() > getCurrentYear()) {
			date = date.minusYears(100);	//if birth < 1923, assume 1923
		}
		return date;
	}
	public static int getAge(LocalDate birthDate) {
		LocalDate now = LocalDate.now();
		Period period = Period.between(birthDate, now);
		return period.getYears();
	}
	public static int getCurrentYear() {
		LocalDate date = LocalDate.now();
		return date.getYear();
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
}
