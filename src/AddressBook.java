import java.util.List;
import java.util.ArrayList;

/**
 * {@code AddressBook} is the main class of the program.
 * It is used to run the program with the {@code main} method.
 * For now the biggest flaw I could see is the {@code Human} class that should
 * probably be non-static. 
 *
 *@author <b>Moussadyk Chihab</b>
 */
public class AddressBook {

	/**
	 * The {@code main} method is used to run the program.
	 * It checks the number of arguments passed<br> to the program
	 * <pre><p>args must be 1 or 3 otherwise the program stops or uses default 
	 *String[] dArgs</p></pre>
	 */

    public static void main(String[] args) {
		if (args.length < 1 || args.length > 3) {
			System.out.println("Usage: java HelloWorld <filename> <name1>"+ 
					"(<name2> names are optional)");
			return;
		}
		String[] dArgs = { "Bill", "Paul" };
		HumanMap humanMap = new HumanMap();
		List<People> peopleList = Helper.initListAndParsing(args, dArgs,
				humanMap);
		if (peopleList.isEmpty()){
			System.out.println("Error: peopleList is empty..");
			System.out.println("'Helper.initListAndParsing' might've failed.");
			System.exit(1);
		}
		dArgs = ComparePpl.getCompFullNames(dArgs, humanMap);
		if ( dArgs[0] == null || dArgs[1] == null){
			dArgs[0] = "Bill";
			dArgs[1] = "Paul";
		}
		if (ErrorHelper.getErrorCheck() > 0){

		}
		Answers.printAll(peopleList, humanMap, dArgs);
    }
}
