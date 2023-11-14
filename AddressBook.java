import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

/**
 * {@code AddressBook} is the main class of the program.
 * It is used to run the program with the {@code main} method.
 *
 *@author <b>Moussadyk Chihab</b>
 */
public class AddressBook {

	/**
	 * The {@code main} method is used to run the program.
	 * It checks the number of arguments passed to the program
	 * <pre><p>args must be 1 or 3 otherwise the program stops or uses default 
	 * <b>string</b></p></pre>
	 * @param args the arguments passed to the program
	 */

    public static void main(String[] args) {
		if (args.length < 1 || args.length > 3) {
			System.out.println("Usage: java HelloWorld <filename> <name1>"+ 
					"(<name2> names are optional)");
			return;
		}
		String[] dArgs = { "Bill", "Paul" };
		List<People> people = Helper.initListAndParsing(args, dArgs);
		if (people.isEmpty()){
			System.out.println("Error: no one is here..");
			System.exit(1);
		}
		int maleCount = Answers.getMalesNbr(people);
		People oldest = Answers.getOldest(people);
		dArgs = ComparePpl.getFullNames(dArgs); // can change
		long daysOlder = HelperDate.getDaysOlder();
		Answers.printAll(maleCount, oldest, daysOlder, dArgs);
    }
}
