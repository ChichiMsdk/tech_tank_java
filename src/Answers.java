import java.util.List;
/**
 * The {@code Answers} class is used to print the answers to the questions
 * asked in the assignment but also recover the required values.
 * <p> This class contains the following useful methods:
 * </p>
 */
public class Answers{
		
	/**
	 * Prints the all answers to the questions asked in the assignment
	 * in a formatted way.
	 * <p> This method adapts the output displayed to the user depending
	 * on the actual values of the variables.</p>
	 * <p><b>I.e:</b> if they are the same age or dArgs[0] is > dArgs[1] etc..
	 * </p>
	 * @param maleCount the number of males in the list
	 * @param oldest the oldest person in the list
	 * @param daysOlder the number of days older between the two people
	 * @param dArgs the names of the people to compare
	 */
	public static void printAll(List<People> peopleList, HumanMap humanMap,
			String[] dArgs) {
		printMalesNbr(getMalesNbr(peopleList));
		printOldestInList(getOldestInList(peopleList));
		printOldestComp(getDaysOlder(dArgs, humanMap), dArgs);
	}

	public static People getOldestInList(List<People> peopleList) {
			People oldest = peopleList.get(0);
			if (peopleList.size() <= 0) {
				return null;
			}
			for (int i = 0; i < peopleList.size(); i++) {
				if (i > 0) {
					if (oldest.getBirthDate().isAfter(peopleList.get(i)
								.getBirthDate())) {
						oldest = peopleList.get(i);
					}
				}
			}
			return oldest;
		}
	
	public static int getMalesNbr(List<People> peopleList) {
		int maleCount = 0;
		for ( int i = 0; i < peopleList.size(); i++) {
			if (peopleList.get(i).getGenderInt() == 1) {
				maleCount++;
			}
		}
		return maleCount;
	}

	/**
	 * @param humanMap the map containing the people
	 * @param dArgs the names of the people to compare
	 * @return the number of days older between the two people
	 */

	public static long getDaysOlder(String[] dArgs, HumanMap humanMap){
		People[] people = ComparePpl.getPplCompFromStr(humanMap, dArgs);
		if (people.length != 2){
			ErrorHelper.flagError();
			return -1;
		}
		long daysOlder = HelperDate.compareDays(people[0], people[1]);
		return daysOlder;

	}

	public static void printMalesNbr(int maleCount){
		if (maleCount > 1) {
			System.out.println("There are " + maleCount + " males.");
		} else {
			System.out.println("There is " + maleCount + " male.");
		}
	}
	
	public static void printOldestInList(People oldest){
		System.out.println("The oldest person is " + oldest.getFullName());
	}

	/**
	 * Prints the oldest person between the two people passed as arguments.
	 * @param daysOlder the number of days between the two people
	 * @param dArgs the names of the people to compare
	 */

	public static void printOldestComp(long daysOlder, String[] dArgs) {
		String day = "days";
		if (daysOlder > 0) {
			day = "day";
			System.out.println( dArgs[0] + " is " + daysOlder + " " 
					+ day + " older than " + dArgs[1] );
		} else if ( daysOlder == 0) {
			System.out.println(dArgs[0]+" and "+dArgs[1]+" are the same age");
		} else {
			if (daysOlder == -1) {
				day = "day";
			}
			daysOlder = daysOlder * -1;
			System.out.println( dArgs[1] + " is " + daysOlder + " "
					+ day + " older than " + dArgs[0] );
		}
	}
}
