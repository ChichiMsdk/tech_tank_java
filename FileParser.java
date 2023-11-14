import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class FileParser{

	private static List<People> people = new ArrayList<>();
	private static List<String> lines = new ArrayList<>();

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
		int j =0;
			for (String line : lines) {
				String[] parts = line.split(",");
				people.add(new People(parts[0], parts[1], parts[2]));
				Human.addPeople(people.get(j));
				j++;
			}
	}

	public static LocalDate formatDate(String birthString) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate date = null;
		try {
			date = LocalDate.parse(birthString, format);
		} catch (DateTimeParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
			System.out.println("format should be: dd/mm/yy");
			System.exit(1);
		}
		if (date.getYear() > 2023) {
			date = date.minusYears(100);	//if birth < 1923, assume 1923
		}
		return date;
	}

	public static List<People> getPeopleList(){
		return people;
	}
}
