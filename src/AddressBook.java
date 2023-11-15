import java.util.List;

/**
 * {@code AddressBook} is the main class of the program.
 * It is used to run the program with the {@code main} method.
 * For now the biggest flaw I could see is the {@code Human} class that should
 * probably be non-static. 
 *
 *@author <b>Moussadyk Chihab</b>
 */
public class AddressBook {

	public static String[] dArgs = { "Bill", "Paul" };
	/**
	 * The {@code main} method is used to run the program.
	 * It checks the number of arguments passed<br> to the program
	 * <pre><p>args must be 1 or 3 otherwise the program stops or uses default 
	 *String[] dArgs</p></pre>
	 */

	public static void main(String[] args) {
		runIt(args);
	}

	public static void runIt(String[] args){

		Helper.checkArgs(args);
		HumanMap humanMap = new HumanMap();
		List<People> peopleList = Helper.initListAndParsing(args,
				AddressBook.dArgs, humanMap);
		if (peopleList.isEmpty()){
			System.out.println("Error: peopleList is empty..");
			System.out.println("'Helper.initListAndParsing' might've failed.");
			ErrorHelper.getWarningCountEnd(ErrorHelper.getVerbose());
			System.exit(1);
		}
		AddressBook.dArgs = ComparePpl.getCompFullNames(AddressBook.dArgs, 
				humanMap);
		Helper.checkDargs();
		Answers.printAll(peopleList, humanMap, dArgs);
		ErrorHelper.getWarningCountEnd(ErrorHelper.getVerbose());
	}

}
