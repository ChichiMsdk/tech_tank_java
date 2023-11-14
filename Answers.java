import java.util.List;

public class Answers{
		
	private static People oldest;

	public static void printAll(int maleCount, People oldest,
			long daysOlder, String[] dArgs) {
		String day = "days";
		System.out.println("The oldest person is " + oldest.getFullName());
		if (maleCount > 1) {
			System.out.println("There are " + maleCount + " males.");
		} else {
			System.out.println("There is " + maleCount + " male.");
		}
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

	public static People getOldest(List<People> people) {
			Answers.oldest = people.get(0);
			for (int i = 0; i < people.size(); i++) {
				if (i > 0) {
					if (Answers.oldest.getBirthDate().isAfter(people.get(i)
								.getBirthDate())) {
						Answers.oldest = people.get(i);
					}
				}
			}
			return Answers.oldest;
		}
	
	public static int getMalesNbr(List<People> people) {
		int maleCount = 0;
		for ( int i = 0; i < people.size(); i++) {
			if (people.get(i).getGenderInt() == 1) {
				maleCount++;
			}
		}
		return maleCount;
	}
}
