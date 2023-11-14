import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public class AddressBook {

    public static void main(String[] args) {
		if (args.length < 1 || args.length > 3) {
			System.out.println("Usage: java HelloWorld <filename> <name1>"+ 
					"(<name2> names are optional)");
			return;
		}
		String[] dArgs = { "Bill", "Paul" };
		List<People> people = createPplList(args, dArgs);
		int maleCount = people.get(0).getMales();
		People oldest = oldGuy(people);
		int femaleCount = people.size() - maleCount;
		People[] pplCompare = { Human.getPeople(dArgs[0]), 
				Human.getPeople(dArgs[1]) };
		long daysOlder = Human.findDaysOlder(pplCompare[0], pplCompare[1]);
		String[] dArgs2 = { pplCompare[0].getFullName(), pplCompare[1]
				.getFullName() };
		Answers.printAnswers(femaleCount, maleCount, oldest, daysOlder, dArgs2);
    }

	public static List<People> createPplList(String[] args, String[] dArgs) {
		FileParser.ParsePeople(args, dArgs);
		List<People> people = FileParser.getPeopleList();
		FileParser.AddPeople(people);
		return people;
	}

	public static People oldGuy(List<People> people) {
		People oldest = people.get(0);
		for (int i = 0; i < people.size(); i++) {
			if (i > 0) {
				if (oldest.getBirthDate().isAfter(people.get(i)
							.getBirthDate())) {
					oldest = people.get(i);
				}
			}
		}
		return oldest;
	}
}
