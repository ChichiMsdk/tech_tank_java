import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.Period;
/**
 * {@code HelperDate} is a helper class for {@code ComparePpl} class.
 * <p> This class contains the following useful information:
 * <ul><pre>{@code getCurrentYear}</pre></ul>
 * <ul><pre>{@code getAge}</pre></ul>
 *</p>
 *
 */

public class HelperDate{

	public static long compareDays(People people1, People people2){
        return ChronoUnit.DAYS.between(
				people1.getBirthDate(), people2.getBirthDate());
	}

	public static LocalDate formatDate(String birthString) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate date;
		try {
			date = LocalDate.parse(birthString, format);
		} catch (DateTimeParseException e) {
			String msg = "Error parsing date: " + e.getMessage() + "\n"
				+ "format should be: dd/mm/yy\n" + "using default date: " +
				"01/01/23";
			ErrorHelper.flagWrng(msg, ErrorHelper.getVerbose());
			date = LocalDate.parse("01/01/23", format);
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
}
