import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AddressBook {

    public static void main(String[] args) {
		if (args.length < 1 || args.length > 3) {
			System.out.println("Usage: java HelloWorld <filename> <name1>"+ 
					"(<name2> names are optional)");
			return;
		}

		List<People> people = new ArrayList<>();
		try { 
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			int j=0;
			for (String line : lines) {
				String[] parts = line.split(",");
				people.add(new People(parts[0], parts[1], parts[2], people));
				Human.addPeople(people.get(j));
				j++;
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return;
		}
		String[] dArgs = {"Bill McKnight", "Paul Robinson"};
		if (args.length == 3){
			dArgs[0] = args[1];
			dArgs[1] = args[2];
		}
		int maleCount = people.get(4).getMales();
		People oldest = people.get(0);
		oldest = oldGuy(oldest, people);
		int femaleCount = people.size() - maleCount;
		Period period = Period.between(Human.getPeople(dArgs[0]).getDate(), 
				Human.getPeople(dArgs[1]).getDate());
		int oldCheck = 1;
		if (Human.getPeople(dArgs[0]).getDate().isBefore(
					Human.getPeople(dArgs[1]).getDate()))
			oldCheck = 2;
		int daysOlder = period.getDays();
		int monthsOlder = period.getMonths();
		int yearsOlder = period.getYears();
		long daysBetween = ChronoUnit.DAYS.between(
				Human.getPeople(dArgs[0]).getDate(), 
				Human.getPeople(dArgs[1]).getDate());
		printAnswers(femaleCount, maleCount, oldest, daysBetween, dArgs);
    }

	public static void printAnswers(int femaleCount, int maleCount, 
			People oldest, long daysOlder, String[] dArgs){
		System.out.println("The oldest person is " + oldest.getFullName());
		System.out.println("There are " + maleCount + " male(s) and "
				+ femaleCount + " female(s)");
		if (daysOlder > 0)
		{
			System.out.println( dArgs[0] + " is " + daysOlder + 
					" day(s) older than " + dArgs[1] );
		}
		else if ( daysOlder == 0){
			System.out.println(dArgs[0]+" and "+dArgs[0]+"are the same age");
		}
		else{
			daysOlder = daysOlder * -1;
			System.out.println( dArgs[1] + " is " + daysOlder + 
					" day(s) older than " + dArgs[0] );
		}

	}
	public static LocalDate parseDate(LocalDate date){
		if (date == null)
			return null;
		if (date.getYear() > 2023)
			date = date.minusYears(100);
		return date;
	}
	//trying to make everything in one loop
	public static People oldGuy(People oldest, List<People> people){
		for (int i = 0; i < people.size(); i++) {
			if (i > 0){
				if (people.get(i).getDate().isBefore(people.get(i-1)
							.getDate())){
					oldest = people.get(i);
				}
			}
		}
		return oldest;
	}
}
