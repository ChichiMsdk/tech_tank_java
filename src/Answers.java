import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class Answers{
		
	/**
	 * {@code printAll} answers to the questions asked in the assignment
	 * in a formatted way.
	 * <p> This method adapts the output depending on the actual values 
	 * of the variables.</p>
	 * <p><b>I.e:</b> if they are the same age or names[0] is > names[1] etc..
	 * </p>
	 */
	public static void printAll(List<People> peopleList, HumanMap humanMap,
			String[] dArgs) {
		System.out.println("\n\n");
		printMalesNbr(getMalesNbr(peopleList));
		printOldestInList(Objects.requireNonNull(getOldestInList(peopleList)));
		printOldestComp(getDaysOlder(dArgs, humanMap), dArgs);
		System.out.println("\n\n");
	}

	public static @Nullable People getOldestInList(@NotNull List<People> peopleList) {
		if (peopleList.isEmpty()){
			return null;
		}
			People oldest = peopleList.get(0);
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
	
	public static int getMalesNbr(@NotNull List<People> peopleList) {
		int maleCount = 0;
        for (People people : peopleList) {
            if (people.getGenderInt() == 1) {
                maleCount++;
            }
        }
		return maleCount;
	}

	public static long getDaysOlder(String[] names, HumanMap humanMap){
		People[] people = ComparePpl.getPplCompFromStr(humanMap, names);
		if (people == null || people.length != 2){
			ErrorHelper.flagError();
			return 0;
		}
        return HelperDate.compareDays(people[0], people[1]);

	}

	public static void printMalesNbr(int maleCount){
		if (maleCount > 1) {
			System.out.println("There are " + maleCount + " males.");
		} else {
			System.out.println("There is " + maleCount + " male.");
		}
	}
	
	public static void printOldestInList(@NotNull People oldest){
		System.out.println("The oldest person is " + oldest.getFullName());
	}

	public static void printOldestComp(long daysOlder, String[] names) {
		if (ErrorHelper.getErrorCheck() > 0) {
			ErrorHelper.resetError();
			return;
		}
		String day = "days";
		if (daysOlder > 0) {
			day = "day";
			System.out.println( names[0] + " is " + daysOlder + " " 
					+ day + " older than " + names[1] );
		} else if ( daysOlder == 0) {
			System.out.println(names[0]+" and "+names[1]+" are the same age");
		} else {
			if (daysOlder == -1) {
				day = "day";
			}
			daysOlder = daysOlder * -1;
			System.out.println( names[1] + " is " + daysOlder + " "
					+ day + " older than " + names[0] );
		}
	}
}
