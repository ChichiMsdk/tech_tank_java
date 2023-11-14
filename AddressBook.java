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
		
		int maleCount = Human.getMalesNbr(people);
		People oldest = Human.getOldest(people);
		dArgs = getOlder(dArgs);
		Answers.printAll(maleCount, oldest, ComparePplAge.getDaysOlder(),
				dArgs);
    }
	public static String[] getOlder(String[] dArgs){
		String[] older = new String[2];
		ComparePplAge.setPplCompare(dArgs);
		older = ComparePplAge.getPplNames();
		return older;
	}

	public static List<People> createPplList(String[] args, String[] dArgs) {
		FileParser.ParsePeople(args, dArgs);
		List<People> people = FileParser.getPeopleList();
		return people;
	}
}
