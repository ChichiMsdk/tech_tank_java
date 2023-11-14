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
		String[] dArgs = { "Bill", "Paul" }; //default names
		List<People> people = Helper.initListAndParsing(args, dArgs);
		int maleCount = Answers.getMalesNbr(people);
		People oldest = Answers.getOldest(people);
		dArgs = ComparePpl.getFullNames(dArgs);
		long daysOlder = HelperDate.getDaysOlder();
		Answers.printAll(maleCount, oldest, daysOlder, dArgs);
    }
}
