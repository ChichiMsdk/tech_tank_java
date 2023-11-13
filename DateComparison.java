import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.time.format.ResolverStyle;
import java.time.format.DateTimeFormatterBuilder;

public class DateComparison{

	private LocalDate date;

	public DateComparison(String dateString){
		DateTimeFormatter format = new DateTimeFormatterBuilder()
			.appendPattern("dd/MM/yy")
			.toFormatter();
		try{
			date = LocalDate.parse(dateString, format);
		}
		catch (DateTimeParseException e){
			System.out.println("Error parsing date: " + e.getMessage());
			return;
		}
		date = parseDate(date);
	}
	private static LocalDate parseDate(LocalDate date){
		if (date == null)
			return null;
		if (date.getYear() > 2023)
			date = date.minusYears(100);
		return date;
	}
	public LocalDate getDate(){
		return date;
	}
	public int getDiff(LocalDate date, LocalDate date2){
		System.out.println(date.isBefore(date2));
		return(date.compareTo(date2));
	}
}
