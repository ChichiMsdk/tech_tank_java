import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
/**
 * {@code FileParser} is used to parse the file and create the list of people.
 * <p> Its role is to ensure that the file is read correctly and that<br>
 * it is formatted the right way which is: <br>
 * <b>"FirstName LastName", "Gender", "Date of Birth"</b></p>
 * </br>
 */

public class FileParser{

	private static List<People> people = new ArrayList<>();
	private static List<String> lines = new ArrayList<>();

	/**
	 * Gets all the lines in {@code lines} and checks the arguments passed
	 * @param args the arguments passed to the program
	 * @param dArgs the names of the people to compare
	 */
	public static void ParsePeople(String[] args, String[] dArgs){
		List<People> people = new ArrayList<>();
		try { 
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			setPeopleListAndLines(people, lines);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			System.exit(1);
		}
		if (args.length == 3){
			dArgs[0] = args[1];
			dArgs[1] = args[2];
		} else {
			System.out.println("-Not enough <names>, using default ones-");
		}
		addPeople(people);
	}

	private static void setPeopleListAndLines(List<People> people, 
			List<String> lines){
		FileParser.people = people;
		FileParser.lines = lines;
	}

	private static void addPeople(List<People> people){
		int j = 0;
			for (String line : lines) {
				String[] parts = fieldsSplit(line);
				if (parts != null){
					people.add(new People(parts[0], parts[1], parts[2]));
					Human.addPeople(people.get(j));
					j++;
				}
			}
	}
	public static String[] fieldsSplit(String lines){
		String[] parts = lines.split(",");
		if (parts.length != 3) {
			System.err.println("Error parsing line: " + lines);
			System.out.println(parts.length + " commas found, 3 expected");
			System.out.println("Skipping line...");
			return null;
		}
		return parts;
	}

	public static List<People> getPeopleList(){
		return people;
	}
}
