import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.temporal.ChronoUnit;

public class Human {

	private static Map<String, People> peopleMap = new HashMap<>();
	private static People oldest;
	
	public static void addPeople(People people){
		peopleMap.put(people.getFullName(), people);
		peopleMap.put(people.getName(), people);
		peopleMap.put(people.getLastName(), people);
	}

	public static People getPeople(String fullName){
		People people = peopleMap.get(fullName);
		if (people == null){
			System.out.println("Not found, please provide (a) valid name(s)");
			System.exit(1);
		}
		return people;
	}

	public static long compareDays(People name1, People name2){
		long daysBetween = ChronoUnit.DAYS.between(
				name1.getBirthDate(), name2.getBirthDate());
		return daysBetween;
	}

	public static long getDaysBetween(String name1, String name2){
		People people1 = getPeople(name1);
		People people2 = getPeople(name2);
		long daysBetween = ChronoUnit.DAYS.between(
				people1.getBirthDate(), people2.getBirthDate());
		return daysBetween;
	}

	public static People getOldest(List<People> people) {
		Human.oldest = people.get(0);
		for (int i = 0; i < people.size(); i++) {
			if (i > 0) {
				if (Human.oldest.getBirthDate().isAfter(people.get(i)
							.getBirthDate())) {
					Human.oldest = people.get(i);
				}
			}
		}
		return Human.oldest;
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
