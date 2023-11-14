/**
 * The {@code Human} class is used to store the {@code People} objects
 * in map. The goal is to retrieve the {@code People} object from the map
 * using the name directly.
 *
 *@author Moussadyk Chihab
 */
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
	/**
	 * Returns the {@code People} object from the map.
	 * The {@code People} object is retrieved from the map with the
	 * {@code People} object's full name, name or last name as key.
	 * @param name the name of the {@code People} object
	 * @return the {@code People} object
	 */

	public static People getPeople(String name){
		People people = peopleMap.get(name);
		if (people == null){
			System.err.println("Not found, please provide (a) valid name(s)");
			System.exit(1);
		}
		return people;
	}
	public static int getAge(String name){
		return getPeople(name).getAge();
	}
}
