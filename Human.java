import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Human {

	private static Map<String, People> peopleMap = new HashMap<>();
	
	public static void addPeople(People people){
		peopleMap.put(people.getFullName(), people);
		peopleMap.put(people.getName(), people);
		peopleMap.put(people.getLastName(), people);
	}

	public static People getPeople(String name){
		People people = peopleMap.get(name);
		if (people == null){
			System.err.println("Not found, please provide (a) valid name(s)");
			System.exit(1);
		}
		return people;
	}
}
