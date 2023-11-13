import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;

public class AddressBook {
    public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java HelloWorld <filename>");
			return;
		}
		List<People> person = new ArrayList<>();
		try { 
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			for (String line : lines) {
				String[] parts = line.split(",");
				person.add(new People(parts[0], parts[1], parts[2]));
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file: "
					+ args[0] + " " + e.getMessage());
		}
		List<DateComparison> dater = new ArrayList<>();
		int maleCount = 0;
		for (int i = 0; i < person.size(); i++) {
			person.setRealAge();	
			if (person.get(i).getMales() == 1){
				maleCount++;
			}
		}
		People oldest = person.get(0);
		for (int i = 0; i < person.size(); i++) {
			if (person.get(i).getAge().isBefore(oldest.getAge()) == 1){
				oldest = person.get(i);
			}
		}
		System.out.println("The oldest person is " + oldest.getFullName());
		System.out.println("There are " + maleCount + " male(s)");
		System.out.println(dater.get(0).getDate());
		dater.get(0).getDiff(dater.get(0).getDate(), dater.get(1).getDate());
    }
}
