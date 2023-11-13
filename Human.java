import java.util.HashMap;
import java.util.Map;

public class Human {
	private static Map<String, People> peopleMap = new HashMap<>();
	
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
}
