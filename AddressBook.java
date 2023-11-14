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
		String[] dArgs = {"Bill", "Paul"};
		List<People> people = createPeopleList(args, dArgs);
		int maleCount = people.get(0).getMales();
		People oldest = people.get(0);
		oldest = oldGuy(oldest, people);
		int femaleCount = people.size() - maleCount;
		long daysBetween = ChronoUnit.DAYS.between(
				Human.getPeople(dArgs[0]).getBirthDate(), 
				Human.getPeople(dArgs[1]).getBirthDate());
		printAnswers(femaleCount, maleCount, oldest, daysBetween, dArgs);
    }

	public static void printAnswers(int femaleCount, int maleCount, 
			People oldest, long daysOlder, String[] dArgs){
		System.out.println("The oldest person is " + oldest.getFullName());
		if (maleCount > 1)
			System.out.println("There are " + maleCount + " males.");
		else
			System.out.println("There is " + maleCount + " male.");

/*adding females not asked
		System.out.println("There are " + maleCount + " male(s) and "
				+ femaleCount + " female(s)"); */
		String day = "days";
		if (daysOlder > 0)
		{
			day = "day";
			System.out.println( dArgs[0] + " is " + daysOlder + " "
					+ day + " older than " + dArgs[1] );
		}
		else if ( daysOlder == 0){
			System.out.println(dArgs[0]+" and "+dArgs[1]+" are the same age");
		}
		else{
			if (daysOlder == -1)
				day = "day";
			daysOlder = daysOlder * -1;
			System.out.println( dArgs[1] + " is " + daysOlder + " "
					+ day + " older than " + dArgs[0] );
		}

	}
	public static List<People> createPeopleList(String[] args, String[] dArgs){
			FileParser.ParsePeople(args, dArgs);
			List<People> people = FileParser.getPeopleList();
			FileParser.AddPeople(people);
			return people;
	}
	public static LocalDate parseDate(LocalDate date){
		//birth date cant be after 2023 anyway.
		//years under 1900 are not taken into account
		if (date.getYear() > 2023)
			date = date.minusYears(100);
		return date;
	}
	public static People oldGuy(People oldest, List<People> people){
		for (int i = 0; i < people.size(); i++) {
			if (i > 0){
				if (oldest.getBirthDate().isAfter(people.get(i)
							.getBirthDate())){
					oldest = people.get(i);
				}
			}
		}
		return oldest;
	}
}
