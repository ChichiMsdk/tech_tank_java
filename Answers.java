public class Answers{

	public static void printAnswers(int femaleCount, int maleCount, 
			People oldest, long daysOlder, String[] dArgs) {
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
}
